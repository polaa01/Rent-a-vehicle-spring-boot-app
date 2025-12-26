package etf.ip.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import etf.ip.entity.*;
import etf.ip.model.*;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long>{
	   List<Rental> findByVehicleId(Long vehicleId);
	   
	   @Query("SELECT new etf.ip.model.RevenuePerDayDTO(" +
		       "DATE(r.startTime), SUM(r.price)) " +
		       "FROM Rental r " +
		       "WHERE FUNCTION('MONTH', r.startTime) = :month " +
		       "AND FUNCTION('YEAR', r.startTime) = :year " +
		       "GROUP BY FUNCTION('DATE', r.startTime) " +
		       "ORDER BY FUNCTION('DATE', r.startTime)")
		List<RevenuePerDayDTO> getRevenuePerDay(@Param("month") int month, @Param("year") int year);
	   
	   
	   @Query("SELECT new etf.ip.model.RevenuePerVehicleTypeDTO(TYPE(v), SUM(r.price)) " +
		       "FROM Rental r JOIN r.vehicle v " +
		       "GROUP BY TYPE(v)")
		List<RevenuePerVehicleTypeDTO> getRevenuePerVehicleType();
	   
	}

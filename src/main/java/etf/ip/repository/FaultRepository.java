package etf.ip.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import etf.ip.entity.Fault;
import etf.ip.model.FaultsPerVehicleDTO;

@Repository
public interface FaultRepository extends JpaRepository<Fault, Long>{
   List<Fault> findByVehicleId(Long vehicleId);
   
   @Query("SELECT new etf.ip.model.FaultsPerVehicleDTO(v.id, v.model, COUNT(f)) " + "FROM Fault f " + 
   "JOIN f.vehicle v " + 
   "GROUP BY v.id, v.model")
   List<FaultsPerVehicleDTO> countFaultsGroupedByVehicle();
}

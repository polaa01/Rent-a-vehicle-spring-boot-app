package etf.ip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
	 
}

package etf.ip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}

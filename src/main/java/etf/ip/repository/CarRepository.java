package etf.ip.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
   
}

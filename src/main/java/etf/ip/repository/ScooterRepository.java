package etf.ip.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.entity.*;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long>{

}

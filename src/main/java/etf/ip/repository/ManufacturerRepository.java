package etf.ip.repository;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.JpaRepository;

import etf.ip.entity.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>{
	boolean existsByName(String name);

}

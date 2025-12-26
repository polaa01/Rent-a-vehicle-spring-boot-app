package etf.ip.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import etf.ip.entity.*;
public interface PublicationRepository extends JpaRepository<Publication, Long>{

}

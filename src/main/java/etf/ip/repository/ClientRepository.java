package etf.ip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByIsBlocked(boolean isBlocked);
}

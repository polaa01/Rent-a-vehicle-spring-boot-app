package etf.ip.repository;

import etf.ip.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etf.ip.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  boolean existsByUsername (String username);
  Employee findByUsernameAndPassword(String username, String password);
}

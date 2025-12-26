package etf.ip.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.ip.entity.Employee;
import etf.ip.entity.Manufacturer;
import etf.ip.enums.EmployeeRole;
import etf.ip.model.EmployeeDTO;
import etf.ip.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	
	
	
	
	public Optional<Employee> getEmployeeById (Long id)
	{
		return employeeRepository.findById(id);
	}
	
	
	
	/*
	
	public Employee createEmployee (Employee employee)
	{
		if(employeeRepository.existsByUsername(employee.getUsername()))
		{
			throw new RuntimeException("Username already exists");
		}
		return employeeRepository.save(employee);
	}
	*/
	
	public Employee createEmployee(EmployeeDTO dto)
	{
	    if(employeeRepository.existsByUsername(dto.getUsername()))
	    {
	        throw new RuntimeException("Username already exists");
	    }

	    Employee employee = new Employee();
	    employee.setFirstName(dto.getFirstName());
	    employee.setLastName(dto.getLastName());
	    employee.setUsername(dto.getUsername());
	    employee.setPassword(dto.getPassword());

	    // Pretvori string u enum
	    employee.setEmployeeRole(EmployeeRole.valueOf(dto.getRole()));

	    return employeeRepository.save(employee);
	}
	
	
	
	public void deleteEmployee(Long id)
	{
		employeeRepository.deleteById(id);
	}
	
	
	
	public Employee updateEmployee(Long id, Employee updatedEmployee)
	{
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new 
				RuntimeException("Employee not found!"));
		
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		//employee.setUsername(updatedEmployee.getUsername());
		//employee.setPassword(updatedEmployee.getPassword());
		return employeeRepository.save(employee);
		
	}

}

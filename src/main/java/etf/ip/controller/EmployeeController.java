package etf.ip.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.service.*;
import etf.ip.entity.*;
import etf.ip.enums.*;
import etf.ip.model.*;
import etf.ip.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping
    public List<Employee> getAllEmployees()
    {
		return employeeService.getAllEmployees();
    }
	
	@GetMapping("/get")
	public List<EmployeeDTO> getAllEmployeesDTO()
	{
		  return employeeRepository.findAll().stream()
		            .map(EmployeeDTO::new)
		            .collect(Collectors.toList());
	}

	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	{
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee)
	{
		Employee employee = employeeService.updateEmployee(id, updatedEmployee);
		return ResponseEntity.ok(employee);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id)
	{
		 employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
    /*
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		Employee savedEmployee = employeeService.createEmployee(employee);
		return ResponseEntity.ok(savedEmployee);
	}
	*/
	

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO)
	{
		Employee savedEmployee = employeeService.createEmployee(employeeDTO);
		return ResponseEntity.ok(savedEmployee);
	}

}

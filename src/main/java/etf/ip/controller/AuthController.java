package etf.ip.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.model.LoginRequest;
import etf.ip.repository.EmployeeRepository;
import etf.ip.entity.*;
import java.util.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest)
	{
		Employee employee = employeeRepository.findByUsernameAndPassword(loginRequest.getUsername(),
				loginRequest.getPassword());
		if(employee==null)
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
		
		
		Map<String, Object> response = new HashMap<>();
		response.put("employee", employee);
		response.put("role", employee.getEmployeeRole().name());
		
		
		/*
		Map<String, Object> response = new HashMap<>();
		response.put("employee", employee);
		response.put("role", employee.getRoleAsString());
		*/
		return ResponseEntity.ok(response);
	}

}

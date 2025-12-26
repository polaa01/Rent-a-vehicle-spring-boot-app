package etf.ip.model;

import etf.ip.entity.Employee;

public class EmployeeDTO {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	private String username, password, firstName, lastName, role;
  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public EmployeeDTO()
	{
		
	}
	public EmployeeDTO(String username, String password, String firstName, String lastname, String role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastname;
		this.role = role;
	}
	
	
	 public EmployeeDTO(Employee employee) {
	        this.id = employee.getId();
	        this.firstName = employee.getFirstName();
	        this.lastName = employee.getLastName();
	        this.username = employee.getUsername();
	        this.role = employee.getEmployeeRole().toString(); // ili employee.getRoleAsString();
	    }

}

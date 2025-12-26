package etf.ip.entity;


import jakarta.persistence.*;
import lombok.*;
import etf.ip.enums.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public EmployeeRole getEmployeeRole() {
		return this.employeeRole;
	}

	public void setEmployeeRole(EmployeeRole employeeRole) {
		this.employeeRole = employeeRole;
	}
	
	public String getRoleAsString()
	{
		return employeeRole.toString();
	}

	private String firstName;
    private String lastName;
    private String username;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;
    
    
    
    
}

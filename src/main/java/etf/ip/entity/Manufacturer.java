package etf.ip.entity;
import jakarta.persistence.*;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String fax;
	
	@Column(nullable = false)
	private String email;
	
	

}

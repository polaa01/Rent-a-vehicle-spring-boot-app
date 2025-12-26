package etf.ip.entity;

import jakarta.persistence.*;
import java.time.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fault {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fault() {
		super();
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateReported() {
		return dateReported;
	}

	public void setDateReported(LocalDateTime dateReported) {
		this.dateReported = dateReported;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	private String description;
	private LocalDateTime dateReported;
	
	@ManyToOne
	private Vehicle vehicle;

	
	public Fault(Vehicle vehicle, String description, LocalDateTime dateReported) {
		super();
		this.description = description;
		this.vehicle = vehicle;
		this.dateReported=dateReported;
	}
	
	
	
	
      
}

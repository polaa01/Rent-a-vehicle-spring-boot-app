package etf.ip.entity;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Scooter extends Vehicle{
	
	private Integer maxSpeed;

	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}

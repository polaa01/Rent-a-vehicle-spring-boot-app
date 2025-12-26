package etf.ip.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bike extends Vehicle{
	
	@Column(nullable=false)
	private Integer autonomy;

	public Integer getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(Integer autonomy) {
		this.autonomy = autonomy;
	}

}

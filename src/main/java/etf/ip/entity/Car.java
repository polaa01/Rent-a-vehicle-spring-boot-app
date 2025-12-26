package etf.ip.entity;

//import java.util.*;


import jakarta.persistence.Entity;

import lombok.*;
import java.time.*;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car extends Vehicle{
	
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	private LocalDate purchaseDate;

}

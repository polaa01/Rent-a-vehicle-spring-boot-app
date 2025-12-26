package etf.ip.entity;

import etf.ip.model.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private LocalDateTime startTime;
	    private LocalDateTime endTime;
	    
	    private long duration;
	    
	    private Integer startPositionX;
	    private Integer startPositionY;
	    private Integer endPositionX;
	    
	    private Double price;
	    public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getStartPositionX() {
			return startPositionX;
		}

		public void setStartPositionX(Integer startPositionX) {
			this.startPositionX = startPositionX;
		}

		public Integer getStartPositionY() {
			return startPositionY;
		}

		public void setStartPositionY(Integer startPositionY) {
			this.startPositionY = startPositionY;
		}

		public Integer getEndPositionX() {
			return endPositionX;
		}

		public void setEndPositionX(Integer endPositionX) {
			this.endPositionX = endPositionX;
		}

		public Integer getEndPositionY() {
			return endPositionY;
		}

		public void setEndPositionY(Integer endPositionY) {
			this.endPositionY = endPositionY;
		}

		private Integer endPositionY;
	    
	
	    @ManyToOne
	    private Vehicle vehicle;
	    
	    @ManyToOne
	    private Client client;

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDateTime getStartTime() {
			return startTime;
		}

		public void setStartTime(LocalDateTime startTime) {
			this.startTime = startTime;
		}

		public LocalDateTime getEndTime() {
			return endTime;
		}

		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
		}

		public long getDuration() {
			return duration;
		}

		public void setDuration(long duration) {
			this.duration = duration;
		}

	

		public Vehicle getVehicle() {
			return vehicle;
		}

		public void setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}

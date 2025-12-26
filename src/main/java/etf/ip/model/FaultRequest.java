package etf.ip.model;
import java.time.*;


public class FaultRequest {
	
	private Long vehicleId;
	private String description;
	private LocalDateTime dateReported;
	
	public FaultRequest()
	{
		super();
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
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

	public FaultRequest(Long vehicleId, String description, LocalDateTime dateReported) {
		super();
		this.vehicleId = vehicleId;
		this.description = description;
		this.dateReported = dateReported;
	}
	
	
	

}

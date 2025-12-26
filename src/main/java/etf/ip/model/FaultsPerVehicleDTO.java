package etf.ip.model;

public class FaultsPerVehicleDTO {
	
	private Long vehicleId; 
	private String vehicleModel;
	private Long faultCount;
	
	public FaultsPerVehicleDTO(Long vehicleId, String vehicleModel, Long faultCount) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleModel = vehicleModel;
		this.faultCount = faultCount;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public Long getFaultCount() {
		return faultCount;
	}

	public void setFaultCount(Long faultCount) {
		this.faultCount = faultCount;
	}

	public FaultsPerVehicleDTO()
	{
		super();
	}
	
	

}

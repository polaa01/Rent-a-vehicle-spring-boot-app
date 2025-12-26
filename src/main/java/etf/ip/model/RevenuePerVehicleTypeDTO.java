package etf.ip.model;

import java.time.*;
public class RevenuePerVehicleTypeDTO {
	
	private String vehicleType;
	private Double totalRevenue;
	
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public RevenuePerVehicleTypeDTO(Class<?> vehicleClass, Double totalRevenue) {
		super();
		this.vehicleType = vehicleClass.getSimpleName();
		this.totalRevenue = totalRevenue;
	}
	
	public RevenuePerVehicleTypeDTO()
	{
		super();
	}

}

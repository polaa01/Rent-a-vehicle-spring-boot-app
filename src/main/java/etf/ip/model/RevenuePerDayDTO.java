package etf.ip.model;

import java.time.*;
import java.sql.Date;
public class RevenuePerDayDTO {
	
	private Double totalRevenue;
	private LocalDate date;
	
	public RevenuePerDayDTO(Date date, Double totalRevenue) {
		super();
		this.date = date.toLocalDate();
		this.totalRevenue = totalRevenue;
	}

	public Double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public RevenuePerDayDTO()
	{
		super();
	}

}

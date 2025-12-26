package etf.ip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.ip.entity.*;
import etf.ip.model.RevenuePerDayDTO;
import etf.ip.model.RevenuePerVehicleTypeDTO;
import etf.ip.repository.RentalRepository;

@Service
public class RentalService {
	
	@Autowired
	private RentalRepository rentalRepository;
	
	public List<Rental> getRentalsByVehicle(Long vehicleId)
	{
		return rentalRepository.findByVehicleId(vehicleId);
	}
	
	public List<Rental> getAllRentals()
    {
	   	 return rentalRepository.findAll();
	}
	
	public List<RevenuePerDayDTO> getRevenuePerDay(int month, int year)
	{
		return rentalRepository.getRevenuePerDay(month, year);
	}
	
	public List<RevenuePerVehicleTypeDTO> getRevenuePerVehicleType()
	{
		return rentalRepository.getRevenuePerVehicleType();
	}
	  
	  

}

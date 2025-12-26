package etf.ip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.entity.Bike;
import etf.ip.entity.Fault;
import etf.ip.entity.Rental;
import etf.ip.model.RevenuePerDayDTO;
import etf.ip.model.RevenuePerVehicleTypeDTO;
import etf.ip.service.RentalService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/rentals")
public class RentalController {
	
	@Autowired
	private RentalService rentalService;
	
	
	@GetMapping("/vehicle/{vehicleId}")
	public ResponseEntity<List<Rental>> getRentalsByVehicle (@PathVariable Long vehicleId)
	{
		//return ResponseEntity.ok(rentalService.getRentalsByVehicle(vehicleId));
		List<Rental> rentals = rentalService.getRentalsByVehicle(vehicleId);
	    return ResponseEntity.ok(rentals);
	}
	
	@GetMapping
	public List<Rental> getAllRentals()
	{
		return rentalService.getAllRentals();
	}
	
	
	@GetMapping("/revenue-per-day")
	public ResponseEntity<List<RevenuePerDayDTO>> getRevenuePerDay(@RequestParam int month, @RequestParam int year)
	{
		List<RevenuePerDayDTO> result = rentalService.getRevenuePerDay(month, year);
		return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/revenue-per-vehicle-type")
	public List<RevenuePerVehicleTypeDTO> getRevenuePerVehicleType()
	{
		return rentalService.getRevenuePerVehicleType();
		
	}
	
	
	
	
	
	

}

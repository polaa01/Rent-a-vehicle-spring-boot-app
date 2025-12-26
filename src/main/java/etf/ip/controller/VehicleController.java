package etf.ip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import etf.ip.entity.Vehicle;
import etf.ip.repository.VehicleRepository;
import etf.ip.service.VehicleService;

import java.io.IOException;
import java.util.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	

	@GetMapping
	public List<Vehicle> getAllVehicles()
	{
		return vehicleService.getAllVehicles();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id)
	{
		Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
		if(vehicle.isPresent())
		{
			return ResponseEntity.ok(vehicle.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	

	
	@PostMapping
	public Vehicle createVehicle(@RequestBody Vehicle vehicle)
	{
		return vehicleService.saveVehicle(vehicle);
	}
	
	
	@PutMapping("/{id}/rent-price")
	public ResponseEntity<?> updateRentPrice(@PathVariable Long id, @RequestBody int newPrice) {
		Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
		Vehicle v = null;
		if(vehicle.isPresent())
		{
			v = vehicle.get();
			v.setRentPrice(newPrice);
			vehicleRepository.save(v);
			return ResponseEntity.ok(vehicle.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping("/{vehicleType}/upload")
	public ResponseEntity<String> uploadCSV(@PathVariable String vehicleType, @RequestParam MultipartFile file) 
	{
		if(file.isEmpty())
		{
			return ResponseEntity.badRequest().body("CSV file is empty!");
		}
		
		try
		{
			switch(vehicleType.toLowerCase())
			{
			case "car":
				vehicleService.processCarCSV(file);
				break;
				
			case "bike":
				vehicleService.processBikeCSV(file);
				break;
				
			case "scooter":
				vehicleService.processScooterCSV(file);
				break;
				
			default:
                return ResponseEntity.badRequest().body("Invalid vehicle type: " + vehicleType);
			}
			
		 return ResponseEntity.ok("CSV uploaded successfully for " + vehicleType);
		}
		
		
		
		catch(IOException e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing CSV for " + vehicleType + ": " + e.getMessage());
		}
	}
	
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteVehicleById(@PathVariable Long id)
	{
		vehicleService.deleteVehicle(id);
		return ResponseEntity.noContent().build();
		
    }
	
		

}

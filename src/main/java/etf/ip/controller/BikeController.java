package etf.ip.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.entity.Bike;
import etf.ip.entity.Car;
import etf.ip.entity.Scooter;
import etf.ip.service.BikeService;
import etf.ip.service.VehicleService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/bikes")
public class BikeController {
	
	@Autowired
	private BikeService bikeService;
	
	@Autowired
	private VehicleService vehicleService;
	
	/*
	@PostMapping
	public Bike createBike(@RequestBody Bike bike)
	{
		return bikeService.saveBike(bike);
	}
	*/
	
	@PostMapping
    public ResponseEntity<Bike> createBike(@RequestBody Bike bike) {
		Bike savedBike = bikeService.saveBike(bike);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBike);
    }
	
	@GetMapping
	public List<Bike> getAllBikes()
	{
		return bikeService.getAllBikes();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Bike> getBikeById(@PathVariable Long id)
	{
		Optional<Bike> bike = bikeService.getBikeById(id);
		if(bike.isPresent())
		{
			return ResponseEntity.ok(bike.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBikeById(@PathVariable Long id)
	{
		
		/*
		bikeService.deleteById(id);
		return ResponseEntity.noContent().build();
		*/
		
		Optional<Bike> bike = bikeService.getBikeById(id);
		if(bike.isPresent())
		{
			bikeService.deleteById(id);
			vehicleService.deleteVehicle(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	

}

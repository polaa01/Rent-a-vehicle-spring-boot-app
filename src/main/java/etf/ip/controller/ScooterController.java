package etf.ip.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.entity.Bike;
import etf.ip.entity.Scooter;
import etf.ip.service.BikeService;
import etf.ip.service.ScooterService;
import etf.ip.service.VehicleService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/scooters")
public class ScooterController {
	
	@Autowired
	private ScooterService scooterService;
	private VehicleService vehicleService;
	
	/*
	@PostMapping
	public Scooter createScooter(@RequestBody Scooter scooter)
	{
		return scooterService.saveScooter(scooter);
		//Scooter savedScooter = scooterService.saveScooter(scooter);
	}
	*/
	
	@PostMapping
    public ResponseEntity<Scooter> createScooter(@RequestBody Scooter scooter) {
        Scooter savedScooter = scooterService.saveScooter(scooter);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedScooter);
    }
	
	@GetMapping
	public List<Scooter> getAllScooters()
	{
		return scooterService.getAllScooters();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Scooter> getScooterById(@PathVariable Long id)
	{
		Optional<Scooter> scooter = scooterService.getScooterById(id);
		if(scooter.isPresent())
		{
			return ResponseEntity.ok(scooter.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteScooterById(@PathVariable Long id)
	{
		/*
		scooterService.deleteById(id);
		return ResponseEntity.noContent().build();
		*/
		
		
		Optional<Scooter> scooter = scooterService.getScooterById(id);
		if(scooter.isPresent())
		{
			
			vehicleService.deleteVehicle(id);
			scooterService.deleteById(id);
			
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.noContent().build();
		
		
	}
		
		
		

}

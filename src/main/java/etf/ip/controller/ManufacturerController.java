package etf.ip.controller;
import etf.ip.entity.*;
import etf.ip.service.*;
import etf.ip.repository.*;
import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {
    
	@Autowired
	private ManufacturerService manufacturerService;
	
	@PostMapping
	public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer)
	{
		Manufacturer savedManufacturer = manufacturerService.createManufacturer(manufacturer);
		return ResponseEntity.ok(savedManufacturer);
	}
	
	@GetMapping
	public List<Manufacturer> getAllManufacturers()
	{
		return manufacturerService.getAllManufacturers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable Long id)
	{
		Optional<Manufacturer> manufacturer = manufacturerService.getManufacturerById(id);
		return manufacturer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteManufacturer(@PathVariable Long id)
	{
		manufacturerService.deleteManufacturer(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable Long id, @RequestBody Manufacturer updatedManufacturer)
	{
		Manufacturer manufacturer = manufacturerService.updateManufacturer(id, updatedManufacturer);
		
		return ResponseEntity.ok(manufacturer);
	}
	
	
}

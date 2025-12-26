package etf.ip.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.service.FaultService;
import etf.ip.entity.*;
import etf.ip.model.FaultRequest;
import etf.ip.model.FaultsPerVehicleDTO;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/faults")
public class FaultController {
    
	@Autowired
	private FaultService faultService;
	
	/*
	@PostMapping("/add")
	public ResponseEntity<Fault> addFault(@RequestParam Long vehicleId, @RequestParam String desc, @RequestParam LocalDateTime date)
	{
		Fault fault = faultService.addFault(vehicleId, desc, date);
		return ResponseEntity.ok(fault);
	}
	
	*/
	
	@PostMapping("/add")
	public ResponseEntity<Fault> addFault(@RequestBody FaultRequest request)
	{
		 Fault fault = faultService.addFault(request.getVehicleId(), request.getDescription(), request.getDateReported());
		 return ResponseEntity.ok(fault);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteFault(@PathVariable Long id)
	{
		faultService.deleteFault(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/vehicle/{vehicleId}")
	public ResponseEntity<List<Fault>> getFaultsByVehicle (@PathVariable Long vehicleId)
	{
		return ResponseEntity.ok(faultService.getFaultsByVehicle(vehicleId));
	}
	
	
	
	
	@GetMapping("/faults-grouped-by-vehicle")
	public ResponseEntity<List<FaultsPerVehicleDTO>> getFaultsGroupedByVehicle()
	{
		List<FaultsPerVehicleDTO> result = faultService.getFaultsGroupedByVehicle();
		return ResponseEntity.ok(result);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

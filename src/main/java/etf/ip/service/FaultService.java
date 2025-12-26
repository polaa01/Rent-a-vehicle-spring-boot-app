package etf.ip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.ip.entity.*;
import etf.ip.enums.VehicleStatus;
import etf.ip.model.FaultsPerVehicleDTO;
import etf.ip.repository.FaultRepository;
import etf.ip.repository.VehicleRepository;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class FaultService {
	
	@Autowired
	private FaultRepository faultRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	
	public Fault addFault(Long vehicleId, String description, LocalDateTime date)
	{
		Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> 
		new RuntimeException("Vehicle not found"));
		
		vehicle.setVehicleStatus(VehicleStatus.IN_REPAIR);
		vehicleRepository.save(vehicle);
		
		Fault fault = new Fault(vehicle, description, date);
		return faultRepository.save(fault);
	}
	
	
	public void deleteFault(Long faultId)
	{
		/*
		if(!faultRepository.existsById(faultId))
		{
			throw new RuntimeException("Fault not found");
		}
		
		faultRepository.deleteById(faultId);
		*/
		Fault fault = faultRepository.findById(faultId)
		        .orElseThrow(() -> new RuntimeException("Fault not found"));
		
		Vehicle vehicle = fault.getVehicle();
		vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
		vehicleRepository.save(vehicle);
		
		faultRepository.deleteById(faultId);
		
	}
	
	
	public List<Fault> getFaultsByVehicle(Long vehicleId)
	{
		return faultRepository.findByVehicleId(vehicleId);
	}
	
	public List<FaultsPerVehicleDTO> getFaultsGroupedByVehicle()
	{
		return faultRepository.countFaultsGroupedByVehicle();
	}
	
	

}

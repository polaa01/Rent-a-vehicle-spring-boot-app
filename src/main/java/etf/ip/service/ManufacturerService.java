package etf.ip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import etf.ip.entity.*;
import etf.ip.repository.*;
import java.util.*;

@Service
public class ManufacturerService {
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	public Manufacturer createManufacturer(Manufacturer manufacturer)
	{
		//return manufacturerRepository.save(manufacturer);
		if(manufacturerRepository.existsByName(manufacturer.getName()))
		{
			throw new RuntimeException("Manufacturer with this name already exists");
		}
		return manufacturerRepository.save(manufacturer);
	}
	
	public List<Manufacturer> getAllManufacturers()
	{
		return manufacturerRepository.findAll();
	}
	
	
	public Optional<Manufacturer> getManufacturerById (Long id)
	{
		return manufacturerRepository.findById(id);
	}
	
	public void deleteManufacturer(Long id)
	{
		manufacturerRepository.deleteById(id);
	}
	
	
	public Manufacturer updateManufacturer(Long id, Manufacturer updatedManufacturer)
	{
		Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new 
				RuntimeException("Manufacturer not found!"));
		
		
		manufacturer.setName(updatedManufacturer.getName());
		manufacturer.setCountry(updatedManufacturer.getCountry());
		manufacturer.setAddress(updatedManufacturer.getAddress());
		manufacturer.setPhone(updatedManufacturer.getPhone());
		manufacturer.setEmail(updatedManufacturer.getEmail());
		manufacturer.setFax(updatedManufacturer.getFax());
		
		
		return manufacturerRepository.save(manufacturer);
		
	}
	

}

package etf.ip.service;

import java.util.List;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.ip.additional.MapValues;
import etf.ip.entity.Bike;
import etf.ip.entity.Car;
import etf.ip.repository.BikeRepository;
import etf.ip.repository.CarRepository;
import java.util.Random.*;
@Service
public class BikeService {
	
	@Autowired
	  private BikeRepository bikeRepository;
    
    
    public Bike saveBike(Bike bike)
    {
     bike.setImage("/images/bike.jpg");
     Random r = new Random();
     int x = r.nextInt(MapValues.X_MAX);
     int y = r.nextInt(MapValues.Y_MAX);
     bike.setPositionX(x);
     bike.setPositionY(y);
   	 return bikeRepository.save(bike);
    }
    
    public List<Bike> getAllBikes()
    {
   	 return bikeRepository.findAll();
    }
    
    public Optional<Bike> getBikeById(Long id)
    {
   	 return bikeRepository.findById(id);
    }
    
    public void deleteById(Long id)
    {
    	bikeRepository.deleteById(id);
    }

}

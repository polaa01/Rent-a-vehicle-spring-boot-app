package etf.ip.service;

import etf.ip.additional.MapValues;
import etf.ip.entity.*;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.ip.entity.Bike;
import etf.ip.repository.BikeRepository;
import etf.ip.repository.ScooterRepository;

@Service
public class ScooterService {
	
	
	@Autowired
	private ScooterRepository scooterRepository;
  
  
  public Scooter saveScooter(Scooter scooter)
  {
	  scooter.setImage("/scooter/car.jpg");
      Random r = new Random();
      int x = r.nextInt(MapValues.X_MAX);
      int y = r.nextInt(MapValues.Y_MAX);
      scooter.setPositionX(x);
      scooter.setPositionY(y);
 	 return scooterRepository.save(scooter);
  }
  
  public List<Scooter> getAllScooters()
  {
 	 return scooterRepository.findAll();
  }
  
  public Optional<Scooter> getScooterById(Long id)
  {
 	 return scooterRepository.findById(id);
  }
  
  public void deleteById(Long id)
  {
	  scooterRepository.deleteById(id);
  }

}

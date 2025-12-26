package etf.ip.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import etf.ip.additional.MapValues;
import etf.ip.entity.Car;
import etf.ip.repository.CarRepository;
import java.util.*;

//import java.lang.Exception;

@Service
public class CarService {
	
     @Autowired
     private CarRepository carRepository;
     
     
     public Car saveCar(Car car)
     {
    
    	 car.setImage("/images/car.jpg");
         Random r = new Random();
         int x = r.nextInt(MapValues.X_MAX);
         int y = r.nextInt(MapValues.Y_MAX);
         car.setPositionX(x);
         car.setPositionY(y);
    	 return carRepository.save(car);
     }
     
     public List<Car> getAllCars()
     {
    	 return carRepository.findAll();
     }
     
     public Optional<Car> getCarById(Long id)
     {
    	 return carRepository.findById(id);
     }
     
     public void deleteById(Long id)
     {
    	 carRepository.deleteById(id);
     }
     
     
}

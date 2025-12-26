package etf.ip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.entity.Car;
import etf.ip.entity.Scooter;
import etf.ip.service.CarService;
import java.util.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	/*
	@PostMapping
	public Car createCar(@RequestBody Car car)
	{
		return carService.saveCar(car);
	}
	*/
	
	@PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }
	
	@GetMapping
	public List<Car> getAllCars()
	{
		return carService.getAllCars();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable Long id)
	{
		Optional<Car> car = carService.getCarById(id);
		if(car.isPresent())
		{
			return ResponseEntity.ok(car.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCarById(@PathVariable Long id)
	{
		carService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

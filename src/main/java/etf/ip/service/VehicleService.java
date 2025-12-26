package etf.ip.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import etf.ip.entity.Car;
import etf.ip.additional.MapValues;
import etf.ip.entity.Bike;
import etf.ip.entity.Scooter;
import etf.ip.entity.Manufacturer;
import etf.ip.entity.Vehicle;
import etf.ip.repository.*;


@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private BikeRepository bikeRepository;
	
	@Autowired
	private ScooterRepository scooterRepository;
	
	public List<Vehicle> getAllVehicles()
	{
		
		return vehicleRepository.findAll();
	}
	
	
	public Optional<Vehicle> getVehicleById (Long id)
	{
		return vehicleRepository.findById(id);
	}
	
	
	
	public Vehicle saveVehicle(Vehicle vehicle)
	{
		return vehicleRepository.save(vehicle);
	}

	
	
	
	public void deleteVehicle(Long id)
	{
		vehicleRepository.deleteById(id);
	}
	
	
	//auto
	private List<Car> parseCarCSV(MultipartFile file) throws IOException
	{
		
        Random r = new Random();
        int x = r.nextInt(MapValues.X_MAX);
        int y = r.nextInt(MapValues.Y_MAX);
		List<Car> cars = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream())))
		{
			String line;
			boolean firstLine = true;
			while((line = reader.readLine())!= null)
			{
				if(firstLine)
				{
					firstLine = false;
					continue;
				}
				String []data = line.split(", ");
				 if (data.length >= 7) {
	                    Car car = new Car();
	                    car.setModel(data[0]);
	                    car.setPurchasePrice(Integer.parseInt(data[1]));
	                    car.setVehicleId(data[2]);
	                    car.setStatusFromString(data[3]);
	                    car.setManufacturerFromString(data[4]);
	                    car.setDescription(data[5]);
	                    car.setPurchaseDate(LocalDate.parse(data[6]));
	                    car.setImage("/images/car.jpg");
	                    car.setPositionX(x);
	                    car.setPositionY(y);
	                    cars.add(car);
	                }
			}
		}
		return cars;
	}
	
	
	 public void processCarCSV(MultipartFile file) throws IOException {
	        List<Car> cars = parseCarCSV(file);
	        carRepository.saveAll(cars);
	    }
	 
	 
	 
	 
	 
	 //biciklo
	 private List<Bike> parseBikeCSV(MultipartFile file) throws IOException
		{
		    Random r = new Random();
	        int x = r.nextInt(MapValues.X_MAX);
	        int y = r.nextInt(MapValues.Y_MAX);
			List<Bike> bikes = new ArrayList<>();
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream())))
			{
				String line;
				boolean firstLine = true;
				while((line = reader.readLine())!= null)
				{
					if(firstLine)
					{
						firstLine = false;
						continue;
					}
					String []data = line.split(", ");
					 if (data.length >= 6) {
		                    Bike bike = new Bike();
		                    bike.setModel(data[0]);
		                    bike.setPurchasePrice(Integer.parseInt(data[1]));
		                    bike.setVehicleId(data[2]);
		                    bike.setStatusFromString(data[3]);
		                    bike.setManufacturerFromString(data[4]);
		                    bike.setAutonomy(Integer.parseInt(data[5]));
		                    bike.setImage("/images/bike.jpg");
		                    bike.setPositionX(x);
		                    bike.setPositionY(y);
		                    bikes.add(bike);
		                }
				}
			}
			return bikes;
		}
		
		
		 public void processBikeCSV(MultipartFile file) throws IOException {
		        List<Bike> bikes = parseBikeCSV(file);
		        bikeRepository.saveAll(bikes);
		    }
		 
		 
		 
		 //skuter
		 private List<Scooter> parseScooterCSV(MultipartFile file) throws IOException
			{
			    Random r = new Random();
		        int x = r.nextInt(MapValues.X_MAX);
		        int y = r.nextInt(MapValues.Y_MAX);
				List<Scooter> scooters = new ArrayList<>();
				try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream())))
				{
					String line;
					boolean firstLine = true;
					while((line = reader.readLine())!= null)
					{
						if(firstLine)
						{
							firstLine = false;
							continue;
						}
						String []data = line.split(", ");
						 if (data.length >= 6) {
			                    Scooter scooter = new Scooter();
			                    scooter.setModel(data[0]);
			                    scooter.setPurchasePrice(Integer.parseInt(data[1]));
			                    scooter.setVehicleId(data[2]);
			                    scooter.setStatusFromString(data[3]);
			                    scooter.setManufacturerFromString(data[4]);
			                    scooter.setMaxSpeed(Integer.parseInt(data[5]));
			                    scooter.setImage("/images/scooter.jpg");
			                    scooter.setPositionX(x);
			                    scooter.setPositionY(y);
			                    scooters.add(scooter);
			                }
					}
				}
				return scooters;
			}
			
			
			 public void processScooterCSV(MultipartFile file) throws IOException {
			        List<Scooter> scooters = parseScooterCSV(file);
			        scooterRepository.saveAll(scooters);
			    }
		 
	 
	 
	 
	 
    
	
	
}

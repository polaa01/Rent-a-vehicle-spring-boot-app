package etf.ip.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import etf.ip.enums.VehicleStatus;
import jakarta.persistence.*;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getManufacturerName()
	{
		return this.manufacturer.getName();
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	@Column(unique=true, nullable=false)
	private String vehicleId;
	
	@ManyToOne
	private Manufacturer manufacturer;
	
	@Enumerated(EnumType.STRING)
	private VehicleStatus vehicleStatus = VehicleStatus.AVAILABLE;
	
	private String model;
	
	@Column(nullable = true)
	private String image;
	
	@Column(nullable=false)
	private Integer purchasePrice;
	
	@OneToMany(mappedBy = "vehicle", orphanRemoval = true)
	@JsonIgnore
	private List<Fault> faults = new ArrayList<>();

	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public List<Fault> getFaults() {
		return faults;
	}
	public void setFaults(List<Fault> faults) {
		this.faults = faults;
	}
	
	
	
	@OneToMany(orphanRemoval = true)
	private List<Rental> rentals = new ArrayList<Rental>();
	
	public List<Rental> getRentals() {
		return rentals;
	}
	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}
	
	@Column(nullable = true)
	private Integer positionX;
	
	@Column(nullable = true)
	private Integer positionY;
	
	
	
	public Integer getPositionX() {
		return positionX;
	}
	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}
	public Integer getPositionY() {
		return positionY;
	}
	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}
	public void setManufacturerFromString(String manufacturerId)
	{
		this.manufacturer = new Manufacturer();
		this.manufacturer.setId(Long.parseLong(manufacturerId));
	}
	
	public void setStatusFromString(String status)
	{
		this.vehicleStatus = VehicleStatus.valueOf(status.toUpperCase());
		
	}
	
	private Integer rentPrice;
	
	
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Vehicle()
	{
		super();
	}
	
	public Vehicle(Long id)
	{
		this.id=id;
	}
	
	public Vehicle(String vId)
	{
		this.vehicleId=vId;
	}
	
	

}

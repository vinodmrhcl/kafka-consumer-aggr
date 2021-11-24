package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import demo.toll.domain.Vehicle;

public interface VehicleService {

	void create(Vehicle vehicle);

	Collection<Vehicle> getAll();

	Optional<Vehicle> getById(Long id);
	
	Optional<Vehicle> getByVehicleSeqNumber(String vehicleSeqNumber);

	void update(Vehicle vehicle);

	void deleteById(Long id);

}

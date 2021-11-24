package demo.toll.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.toll.domain.Vehicle;
import demo.toll.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleRestController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping
	public Collection<Vehicle> getAll() {
		return this.vehicleService.getAll();
	}

	@PostMapping
	public void create(@RequestBody Vehicle vehicle) {
		this.vehicleService.create(vehicle);
	}

	@GetMapping("/{id}")
	public Vehicle getById(Long id) {
		return this.vehicleService.getById(id).get();
	}
	
	@GetMapping("/{vehicleSeqNumber}")
	public Vehicle getByVehicleSeqNumber(String vehicleSeqNumber) {
		return this.vehicleService.getByVehicleSeqNumber(vehicleSeqNumber).get();
	}

	@PutMapping
	public void update(@RequestBody Vehicle vehicle) {
		this.vehicleService.update(vehicle);
	}

	@DeleteMapping
	public void delete(Long id) {
		this.vehicleService.deleteById(id);
	}

}

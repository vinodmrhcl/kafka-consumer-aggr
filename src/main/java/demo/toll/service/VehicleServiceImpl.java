package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.toll.domain.Vehicle;
import demo.toll.repo.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<Vehicle> getAll() {
		return this.vehicleRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vehicle> getByVehicleSeqNumber(String vehicleSeqNumber) {
		return this.vehicleRepository.findFirstByVehicleSeqNumber(vehicleSeqNumber);
	}

	@Override
	@Transactional
	public void create(Vehicle vehicle) {
		this.vehicleRepository.save(vehicle);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vehicle> getById(Long id) {
		return this.vehicleRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Vehicle vehicle) {
		this.vehicleRepository.save(vehicle);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		this.vehicleRepository.deleteById(id);
	}

}

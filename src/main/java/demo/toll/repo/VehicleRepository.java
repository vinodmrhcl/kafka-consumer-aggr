package demo.toll.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.toll.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	Optional<Vehicle> findFirstByVehicleSeqNumber(String vehicleSeqNumber);
}
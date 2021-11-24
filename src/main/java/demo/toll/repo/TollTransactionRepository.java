package demo.toll.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.toll.domain.TollTransaction;

public interface TollTransactionRepository extends JpaRepository<TollTransaction, Long> {

	Collection<TollTransaction> findAllByVehicleSeqNumber(String vehicleSeqNumber);
}
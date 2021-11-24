package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import demo.toll.domain.TollTransaction;

public interface TollTransactionService {

	Collection<TollTransaction> getAll();

	Collection<TollTransaction> getAllByVehicleSeqNumber(String vehicleSeqNumber);

	void create(TollTransaction transaction);

	void calculateSummary();

	Optional<TollTransaction> getById(Long id);

	void update(TollTransaction transaction);

	void deleteById(Long id);

}

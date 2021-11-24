package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import demo.toll.domain.TollTxnSummary;

public interface TollTxnSummaryService {

	Collection<TollTxnSummary> getAll();

	Collection<TollTxnSummary> getAllByVehicleSeqNumber(String vehicleSeqNumber);

	void create(TollTxnSummary txnSummary);

	Optional<TollTxnSummary> getById(Long txnSummaryId);

	void update(TollTxnSummary txnSummary);

	void deleteById(Long txnSummaryId);

}

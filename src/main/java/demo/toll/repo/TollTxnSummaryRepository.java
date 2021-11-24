package demo.toll.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.toll.domain.TollTxnSummary;

public interface TollTxnSummaryRepository extends JpaRepository<TollTxnSummary, Long> {

	Collection<TollTxnSummary> findAllByVehicleSeqNumber(String vehicleSeqNumber);
}
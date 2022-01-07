package demo.toll.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.toll.domain.TollTxnSummary;

public interface TollTxnSummaryRepository extends JpaRepository<TollTxnSummary, Long> {
}
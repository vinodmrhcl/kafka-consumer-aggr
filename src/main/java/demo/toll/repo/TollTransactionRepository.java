package demo.toll.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.toll.domain.TollTransaction;

public interface TollTransactionRepository extends JpaRepository<TollTransaction, Long> {
}
package demo.toll.repo;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

import demo.toll.domain.TollTransaction;

public interface TollTransactionRepository extends KeyValueRepository<TollTransaction, Long> {
}
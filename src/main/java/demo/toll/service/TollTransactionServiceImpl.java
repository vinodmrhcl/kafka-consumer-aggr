package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.toll.domain.TollTransaction;
import demo.toll.domain.TollTxnSummary;
import demo.toll.kafka.TollTrasactionKafkaAggregator;
import demo.toll.repo.TollTransactionRepository;
import demo.toll.util.JsonUtil;

@Service
public class TollTransactionServiceImpl implements TollTransactionService {

	@Autowired
	private TollTransactionRepository transactionRepository;

	@Autowired
	private TollTrasactionKafkaAggregator trasactionKafkaAggregator;

	@Override
	@Transactional(readOnly = true)
	public Collection<TollTransaction> getAll() {
		return this.transactionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TollTransaction> getAllByVehicleSeqNumber(String vehicleSeqNumber) {
		return this.transactionRepository.findAllByVehicleSeqNumber(vehicleSeqNumber);
	}

	@Override
	@Transactional
	public void create(TollTransaction transaction) {
		this.transactionRepository.save(transaction);
	}

	@Override
	public void calculateSummary() {

		TollTxnSummary txnSummary = new TollTxnSummary();
		txnSummary.setTxnCount(transactionRepository.count());

		String txnSummmaryJson = JsonUtil.convertObjectToJson(txnSummary);
		trasactionKafkaAggregator.send(txnSummmaryJson);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TollTransaction> getById(Long id) {
		return this.transactionRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(TollTransaction transaction) {
		this.transactionRepository.save(transaction);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		this.transactionRepository.deleteById(id);
	}

}

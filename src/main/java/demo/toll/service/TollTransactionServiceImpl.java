package demo.toll.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.toll.domain.TollTransaction;
import demo.toll.domain.TollTxnSummary;
import demo.toll.kafka.TollTransactionKafkaSender;
import demo.toll.kafka.TollTxnSummaryKafkaSender;
import demo.toll.repo.TollTransactionRepository;
import demo.toll.util.JsonUtil;

@Service
public class TollTransactionServiceImpl implements TollTransactionService {

	@Autowired
	private TollTransactionRepository transactionRepository;

	@Autowired
	private TollTransactionKafkaSender transactionKafkaSender;

	@Autowired
	private TollTxnSummaryKafkaSender txnSummaryKafkaSender;

	@Override
	@Transactional(readOnly = true)
	public List<TollTransaction> getAll(Integer page, Integer size, String orderBy) {
		if (size == null) {
			return (List<TollTransaction>) transactionRepository.findAll();
		} else {
			if (orderBy == null || orderBy.isEmpty()) {
				return transactionRepository.findAll(PageRequest.of(page, size)).getContent();
			} else {
				return transactionRepository.findAll(PageRequest.of(page, size, Sort.by(orderBy).descending())).getContent();
			}
		}
	}

	@Override
	@Transactional
	public void create(TollTransaction transaction) {
		this.transactionRepository.save(transaction);
	}

	@Override
	public void send(TollTransaction transaction) {
		String transactionJson = JsonUtil.convertObjectToJson(transaction);
		transactionKafkaSender.send(transactionJson);
	}

	@Override
	public void calculateSummary() {
		TollTxnSummary txnSummary = new TollTxnSummary();
		txnSummary.setTxnCount(transactionRepository.count());
		String txnSummmaryJson = JsonUtil.convertObjectToJson(txnSummary);
		txnSummaryKafkaSender.send(txnSummmaryJson);
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

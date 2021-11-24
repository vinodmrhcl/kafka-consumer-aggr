package demo.toll.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.toll.domain.TollTxnSummary;
import demo.toll.repo.TollTxnSummaryRepository;

@Service
public class TollTxnSummaryServiceImpl implements TollTxnSummaryService {

	@Autowired
	private TollTxnSummaryRepository txnSummaryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Collection<TollTxnSummary> getAll() {
		return this.txnSummaryRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TollTxnSummary> getAllByVehicleSeqNumber(String vehicleSeqNumber) {
		return this.txnSummaryRepository.findAllByVehicleSeqNumber(vehicleSeqNumber);
	}

	@Override
	@Transactional
	public void create(TollTxnSummary txnSummary) {
		this.txnSummaryRepository.save(txnSummary);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<TollTxnSummary> getById(Long id) {
		return this.txnSummaryRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(TollTxnSummary txnSummary) {
		this.txnSummaryRepository.save(txnSummary);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		this.txnSummaryRepository.deleteById(id);
	}

}

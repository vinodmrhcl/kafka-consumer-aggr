package demo.toll.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.toll.domain.TollTxnSummary;
import demo.toll.service.TollTxnSummaryService;

@RestController
@RequestMapping("/txnSummary")
public class TollTxnSummaryRestController {

	@Autowired
	private TollTxnSummaryService txnSummaryService;

	@GetMapping
	public Collection<TollTxnSummary> getAll() {
		return this.txnSummaryService.getAll();
	}

	@GetMapping("/vehicle/{vehicleSeqNumber}")
	public Collection<TollTxnSummary> getAllByVehicleSeqNumber(String vehicleSeqNumber) {
		return this.txnSummaryService.getAllByVehicleSeqNumber(vehicleSeqNumber);
	}

	@PostMapping
	public void create(@RequestBody TollTxnSummary txnSummary) {
		this.txnSummaryService.create(txnSummary);
	}
	
	@GetMapping("/{id}")
	public TollTxnSummary getById(Long id) {
		return this.txnSummaryService.getById(id).get();
	}

	@PutMapping
	public void update(@RequestBody TollTxnSummary txnSummary) {
		this.txnSummaryService.update(txnSummary);
	}

	@DeleteMapping
	public void delete(Long id) {
		this.txnSummaryService.deleteById(id);
	}

}

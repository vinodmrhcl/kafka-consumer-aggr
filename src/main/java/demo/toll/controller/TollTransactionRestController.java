package demo.toll.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.toll.domain.TollTransaction;
import demo.toll.service.TollTransactionService;

@RestController
@RequestMapping("/transactions")
public class TollTransactionRestController {

	@Autowired
	private TollTransactionService transactionService;

	@GetMapping
	public Collection<TollTransaction> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "orderBy", required = false) String orderBy) {
		return this.transactionService.getAll(page, size, orderBy);
	}

	@PostMapping
	public void create(@RequestBody TollTransaction transaction) {
		this.transactionService.create(transaction);
	}

	@PostMapping("/send")
	public void sendCreate(@RequestBody TollTransaction transaction) {
		this.transactionService.send(transaction);
	}

	@PostMapping("/calcSum")
	public void calculateSummary() {
		this.transactionService.calculateSummary();
	}

	@GetMapping("/{id}")
	public TollTransaction getById(@PathVariable(value = "id") Long id) {
		return this.transactionService.getById(id).get();
	}

	@PutMapping
	public void update(@RequestBody TollTransaction transaction) {
		this.transactionService.update(transaction);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.transactionService.deleteById(id);
	}

}

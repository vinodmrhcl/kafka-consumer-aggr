package demo.toll.kafka;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import demo.toll.domain.TollTransaction;
import demo.toll.service.TollTransactionService;
import demo.toll.util.JsonUtil;

@Service
public class TollTransactionKafkaReciever {

	@Autowired
	private TollTransactionService transactionService;

	@KafkaListener(groupId = "tollend", topics = "transaction.create", containerFactory = "containerFactory")
	@Transactional
	public void createTransaction(String transactionJson) {
		TollTransaction transaction = JsonUtil.convertJsonToObject(transactionJson, TollTransaction.class);
		System.out.println("Received latest transaction.create" + transaction);
		transactionService.create(transaction);
	}

}
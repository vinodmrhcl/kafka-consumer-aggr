package demo.toll.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import demo.toll.domain.TollTransaction;
import demo.toll.util.JsonUtil;

@Service
public class TollTransactionKafkaEarliestReciever {

	@KafkaListener(groupId = "tollstart", topics = "transaction.create", containerFactory = "earliestContainerFactory")
	public void createTransaction(String transactionJson) {
		TollTransaction transaction = JsonUtil.convertJsonToObject(transactionJson, TollTransaction.class);
		System.out.println("Received earliest transaction.create" + transaction);
	}

}
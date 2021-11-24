package demo.toll.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TollTrasactionKafkaAggregator {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String txnSummmaryJson) {
		kafkaTemplate.send("txnSummary.create", txnSummmaryJson);
	}
}
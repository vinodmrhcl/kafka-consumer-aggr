package demo.toll.kafka;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import demo.toll.domain.TollTxnSummary;
import demo.toll.service.TollTxnSummaryService;
import demo.toll.util.JsonUtil;

@Service
public class TollTxnSummaryKafkaReciever {
	
	@Autowired
	private TollTxnSummaryService txnSummaryService; 

	@KafkaListener(groupId = "tollstart", topics = "txnSummary.create", containerFactory="latestContainerFactory")
	@Transactional
	public void createTxnSummary(String txnSummaryJson) {
		TollTxnSummary txnSummary = JsonUtil.convertJsonToObject(txnSummaryJson, TollTxnSummary.class);
		System.out.println("Received txnSummary.create" + txnSummary);
		txnSummaryService.create(txnSummary);
	}

}
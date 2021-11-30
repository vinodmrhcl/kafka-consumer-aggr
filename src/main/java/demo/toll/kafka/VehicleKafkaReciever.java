package demo.toll.kafka;

import javax.transaction.Transactional;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class VehicleKafkaReciever {

	@KafkaListener(groupId = "toll", topics = "poc_topic")
	@Transactional
	public void recieveVehicle(String vehicleJson) {
		System.out.println("Received vehicle" + vehicleJson);
	}

}
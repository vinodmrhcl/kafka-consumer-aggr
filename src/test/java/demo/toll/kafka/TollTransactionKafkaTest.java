package demo.toll.kafka;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@DirtiesContext
@TestPropertySource("/application-test.properties")
@EmbeddedKafka(partitions = 1, //
		brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class TollTransactionKafkaTest {

	private CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	private TollTransactionKafkaSender sender;

	@SpyBean
	private TollTransactionKafkaReciever receiver;

	@Test
	public void test() throws Exception {
		sender.send("Test Message");
		latch.await(10000, TimeUnit.MILLISECONDS);
		Mockito.verify(receiver, Mockito.atLeastOnce()).createTransaction(Mockito.any());
	}
}
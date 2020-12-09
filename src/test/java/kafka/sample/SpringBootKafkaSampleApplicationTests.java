package kafka.sample;

import kafka.sample.model.Model;
import kafka.sample.service.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootKafkaSampleApplicationTests {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@Test
	void contextLoads() {
	}

	@Test
	void testProduce(){
		Model model = new Model("field_test_1", "field_test_2");
		try{
			this.kafkaProducerService.send(model);
		} catch (Error error){
			error.printStackTrace();
		}
	}

}

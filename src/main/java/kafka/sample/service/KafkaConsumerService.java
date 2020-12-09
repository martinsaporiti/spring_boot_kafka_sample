package kafka.sample.service;


import com.google.gson.Gson;
import kafka.sample.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author martinsaporiti
 */
@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    private Gson jsonConverter;

    @Autowired
    public KafkaConsumerService(Gson jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @KafkaListener(topics= {"${consumer.topics}"})
    public void getFromKafka(String modelParam){
        Model model = (Model) jsonConverter.fromJson(modelParam, Model.class);
        logger.info(String.format("Receiving message: %s", model));
    }

}

package kafka.sample.service;


import com.google.gson.Gson;
import kafka.sample.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author martinsaporiti
 */
@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson jsonConverter;

    @Value("${producer.topic}")
    private String topic;


    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    public void send(Model model){
        logger.info(String.format("Sending message: %s", model));
        ListenableFuture<SendResult<String, String>> future =
                this.kafkaTemplate.send(this.topic, this.jsonConverter.toJson(model));

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send message=[ {} ] due to : {}", model, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Sent message=[ {} ] with offset=[ {} ]", model, result.getRecordMetadata().offset());
            }
        });
    }

}

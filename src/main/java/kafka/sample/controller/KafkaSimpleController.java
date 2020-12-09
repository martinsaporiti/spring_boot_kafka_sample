package kafka.sample.controller;

import kafka.sample.model.Model;
import kafka.sample.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author martinsaporiti
 */
@RestController()
@RequestMapping("/api/kafka")
public class KafkaSimpleController {

    private KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaSimpleController(KafkaProducerService kafkaProducerService){
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping()
    public void post(@RequestBody Model model){
        this.kafkaProducerService.send(model);
    }

}

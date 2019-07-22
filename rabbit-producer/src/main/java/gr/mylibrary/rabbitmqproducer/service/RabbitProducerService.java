package gr.mylibrary.rabbitmqproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr.mylibrary.rabbitmqproducer.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${my.constant.exchange}")
	private String exchange;

	@Value("${my.constant.queue.text}")
	private String queue;

	@Value("${my.constant.routing.key.text}")
	private String keyForText;

	@Value("${my.constant.routing.key.json}")
	private String keyForJson;

	private final ObjectMapper objectMapper;

	private final RabbitTemplate rabbitTemplate;

	public RabbitProducerService(ObjectMapper objectMapper, RabbitTemplate rabbitTemplate) {
		this.objectMapper = objectMapper;
		this.rabbitTemplate = rabbitTemplate;
	}

	// 1.	Service method to produce/store text in queue

	public void rabbitProduceText(Person person){
		rabbitTemplate.convertAndSend(exchange, keyForText, person.toString());
		logger.info("message sent: " + person.toString());
	}

	// 2.	Service method to produce/store JSON string in queue
	//Objects Need to be Serialized (SimpleMessageConverter only supports String (i.e. JSON strings), byte[] and Serializable payloads)

	public void rabbitProduceJson(Person person) throws JsonProcessingException {
		String message = objectMapper.writeValueAsString(person);
		logger.info("Converted Object: " + person.toString() + "/t to: /t" + message);
		rabbitTemplate.convertAndSend(exchange, keyForJson, message);
		logger.info("message sent: " + message);
	}

}

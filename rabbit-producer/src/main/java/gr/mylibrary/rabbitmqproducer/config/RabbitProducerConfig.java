package gr.mylibrary.rabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitProducerConfig {

	//IMPORTANT NOTE: Create two queues sharing a common exchange. One for plain text messages and one for
	//JSON parsed objects.

	//Exchange is Common For All Queues

	@Value("${my.constant.exchange}")
	private String exchange;

	//-----------------Constants: Queue & Routing Key for Text------------------------//

	@Value("${my.constant.queue.text}")
	private String queueForText;

	@Value("${my.constant.routing.key.text}")
	private String keyForText;

	//-----------------Constants: Queue & Routing Key for JSON------------------------//

	@Value("${my.constant.queue.json}")
	private String queueForJson;

	@Value("${my.constant.routing.key.json}")
	private String keyForJson;

	//SET-UP EXCHANGE: Common for all queues

	@Bean
	public TopicExchange topicExchange(){
		return new TopicExchange(exchange);
	}

	//1.	SIMPLE TEXT MESSAGE CONFIGURATION

		//1a.   SET-UP QUEUE FOR SIMPLE TEXT MESSAGE
	@Bean
	public Queue queue(){
		return new Queue(queueForText, false);
	}

		//1b.   SET-UP BINDING (ROUTING KEY) FOR SIMPLE TEXT MESSAGE
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange){
		return BindingBuilder.bind(queue).to(topicExchange).with(keyForText);
	}

//=======================================================================================//
//=======================================================================================//
//=======================================================================================//

	//2.	JSON MESSAGE CONFIGURATION

		//2a.   SET-UP QUEUE FOR JSON MESSAGE
	@Bean
	public Queue queueJson(){
		return new Queue(queueForJson, false);
	}

		//2b.   SET-UP BINDING (ROUTING KEY) FOR SIMPLE JSON MESSAGE
	@Bean
	public Binding bindingJson(Queue queueJson, TopicExchange topicExchange){
		return BindingBuilder.bind(queueJson).to(topicExchange).with(keyForJson);
	}

}

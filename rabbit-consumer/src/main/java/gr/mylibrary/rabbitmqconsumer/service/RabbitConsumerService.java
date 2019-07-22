package gr.mylibrary.rabbitmqconsumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.mylibrary.rabbitmqconsumer.entity.Employee;
import gr.mylibrary.rabbitmqconsumer.model.Atomo;
import gr.mylibrary.rabbitmqconsumer.util.AgeCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class RabbitConsumerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final AgeCalculator ageCalculator = new AgeCalculator(100);

	private final ObjectMapper mapper;

	private final EmployeeService employeeService;

	public RabbitConsumerService(ObjectMapper mapper, EmployeeService employeeService) {
		this.mapper = mapper;
		this.employeeService = employeeService;
	}

	//Listening to TEXT publishing queue
	@RabbitListener(queues = "${my.constants.queue.text}")
	public void listenMsgText(String msg) throws InterruptedException {
		logger.info("new message received....");
		TimeUnit.SECONDS.sleep(2);
		logger.info("Message is the simple String: " + msg);
		logger.info(msg);
	}

	//Listening to JSON publishing queue
	@RabbitListener(queues = "${my.constants.queue}")
	public void listenMsg(String msg) throws InterruptedException, IOException {
		logger.info("new message received....");
		TimeUnit.SECONDS.sleep(2);
		logger.info("Message is the JSON String: " + msg);
		logger.info("converting json to object...");
		Atomo atomo = mapper.readValue(msg, Atomo.class);
		logger.info(atomo.toString());
		logger.info("Now....adding a random Age property for Retrieved Employee Object and saving to DB");
		int age = ageCalculator.getAge();
		logger.info("Age assigned is: " + age);
		Employee employee = new Employee(atomo.getName(), atomo.getSurname(), atomo.getSalary(), age);
		employeeService.saveEmployee(employee);
	}

}

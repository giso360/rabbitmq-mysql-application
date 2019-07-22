package gr.mylibrary.rabbitmqproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import gr.mylibrary.rabbitmqproducer.model.Person;
import gr.mylibrary.rabbitmqproducer.service.RabbitProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

	@Autowired
	private RabbitProducerService service;

	//	ENDPOINT #1: Send Simple Text
	@GetMapping("/report-text")
	public String rep(@RequestParam("name") String name,
					  @RequestParam("surname") String surname,
					  @RequestParam("salary") int salary){
		service.rabbitProduceText(new Person(name, surname, salary));
		return "OK from simple text sender";
	}

	//	ENDPOINT #2: Send Json
	@PostMapping("/report-json")
	public String repTwo(@RequestBody Person person) throws JsonProcessingException {
		service.rabbitProduceJson(person);
		return "OK from json sender";
	}

}

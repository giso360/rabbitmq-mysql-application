package gr.mylibrary.rabbitmqconsumer.service;

import gr.mylibrary.rabbitmqconsumer.entity.Employee;
import gr.mylibrary.rabbitmqconsumer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee){
		employeeRepository.save(employee);
	}

}

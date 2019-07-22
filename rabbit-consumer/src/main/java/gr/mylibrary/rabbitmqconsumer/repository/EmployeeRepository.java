package gr.mylibrary.rabbitmqconsumer.repository;

import gr.mylibrary.rabbitmqconsumer.entity.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

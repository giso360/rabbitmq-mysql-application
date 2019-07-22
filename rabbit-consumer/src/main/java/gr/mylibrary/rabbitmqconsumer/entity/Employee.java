package gr.mylibrary.rabbitmqconsumer.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int emp_id;


	@Column(name = "name")
	private String emp_name;

	@Column(name = "surname")
	private String emp_surname;

	@Column(name = "salary")
	private int salary;

	@Column(name = "age")
	private int emp_age;

	public Employee() {
	}

	public Employee(String emp_name, String emp_surname, int salary, int emp_age) {
		this.emp_name = emp_name;
		this.emp_surname = emp_surname;
		this.salary = salary;
		this.emp_age = emp_age;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_surname() {
		return emp_surname;
	}

	public void setEmp_surname(String emp_surname) {
		this.emp_surname = emp_surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getEmp_age() {
		return emp_age;
	}

	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"emp_id=" + emp_id +
				", emp_name='" + emp_name + '\'' +
				", emp_surname='" + emp_surname + '\'' +
				", salary=" + salary +
				", emp_age=" + emp_age +
				'}';
	}

}

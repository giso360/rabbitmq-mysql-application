package gr.mylibrary.rabbitmqproducer.model;

//In case of sending objects -not strings or bytes- the content needs to be serialized first; using either
//a custom serializer/deserializer (e.g. com.fasterxml.jackson.databind.ObjectMapper) OR implement Serializable
//interface on transfer object to convert to bytes

public class Person /*implements Serializable */ {

	private String name;
	private String surname;
	private int salary;

	public Person() {}

	public Person(String name, String surname, int salary) {
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", salary=" + salary +
				'}';
	}

}

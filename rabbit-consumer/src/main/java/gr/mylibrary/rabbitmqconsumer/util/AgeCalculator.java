package gr.mylibrary.rabbitmqconsumer.util;

import org.springframework.stereotype.Component;

import java.util.Random;


public class AgeCalculator {

	private int ageMax;

	public AgeCalculator() {
	}

	public AgeCalculator(int ageMax) {
		this.ageMax = ageMax;
	}

	public int getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(int ageMax) {
		this.ageMax = ageMax;
	}

	public int getAge(){
		Random random = new Random();
		int age = random.nextInt(this.ageMax);
		return age;
	}
}

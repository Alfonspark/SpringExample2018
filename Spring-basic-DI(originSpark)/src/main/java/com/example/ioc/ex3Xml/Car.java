package com.example.ioc.ex3Xml;

public class Car {
	
	private String carName;

	public Car(String carName) {
		this.carName = carName;
	}

	public String getName() {
		return this.carName;
	}

	public void setName(String carName) {
		this.carName = carName;
	}
}
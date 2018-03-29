package com.example.ioc.ex4Annotation;

//Mutable class. 상태값이 변경되는 클래스. 일반적으로 Bean에 등록하지 않고 사용한다. VO
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
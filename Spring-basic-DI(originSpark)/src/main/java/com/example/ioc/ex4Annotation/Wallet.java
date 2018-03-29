package com.example.ioc.ex4Annotation;

// Mutable class. 상태값이 변경되는 클래스. 일반적으로 Bean에 등록하지 않고 사용한다. VO
public class Wallet {
	
	private int money;
	
	public Wallet() {
		
	}

	public Wallet(int money) {
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
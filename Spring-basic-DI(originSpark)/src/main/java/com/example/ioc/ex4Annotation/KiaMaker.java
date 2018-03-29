package com.example.ioc.ex4Annotation;

import org.springframework.stereotype.Component;

@Component("kia")
public class KiaMaker implements CarMaker {

	private Wallet moneyK;

	// public KiaMaker() {
	// moneyK = new Wallet(0);
	// }
	
	public void setMoneyK(Wallet moneyK) {
		this.moneyK = moneyK;
		System.out.println("KiaMaker.setMoneyK() Called.");
	}
	
	@Override
	public Car getCar(Wallet money) {

		moneyK = new Wallet(0);

		// moneyH = money; // +28000
		moneyK.setMoney(money.getMoney()); // +28000

		System.out.println("KiaMaker.sell() : I got $" + moneyK.getMoney() + ".");

		Car car = new Car("K9 Quantum");

		System.out.println("KiaMaker.sell() : I made " + car.getName() + ".");

		System.out.println("KiaMaker.sell() : I sold $" + car.getName() + ".");

		System.out.println("KiaMaker.sell() : I earned $" + moneyK.getMoney() + ".");

		return car;
	}

}

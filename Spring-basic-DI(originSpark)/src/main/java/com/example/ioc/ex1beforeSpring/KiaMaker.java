package com.example.ioc.ex1beforeSpring;

public class KiaMaker implements CarMaker {
	
	Wallet moneyK = new Wallet(0);
	
	@Override
	public Car getCar(Wallet money) {
		
		moneyK = money; // +28000
		
		System.out.println("KiaMaker.sell() : I got $"+moneyK.getMoney()+".");
				
		Car car = new Car("K9 Quantum");
		
		System.out.println("KiaMaker.sell() : I made "+car.getName()+".");
		
		System.out.println("KiaMaker.sell() : I sold $"+car.getName()+".");
		
		System.out.println("KiaMaker.sell() : I earned $" +moneyK.getMoney()+".");
		
		return car;
	}
}

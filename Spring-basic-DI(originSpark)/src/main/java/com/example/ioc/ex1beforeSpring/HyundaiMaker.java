package com.example.ioc.ex1beforeSpring;

public class HyundaiMaker implements CarMaker {
	
	Wallet moneyH = new Wallet(0);
	
	@Override
	public Car getCar(Wallet money) {
		
		moneyH = money; // +28000
		
		System.out.println("HyundaiMaker.sell() : I got $"+moneyH.getMoney()+".");
		
		Car car = new Car("Genesis EQ900L");
		
		System.out.println("HyundaiMaker.sell() : I made "+car.getName()+".");
		
		System.out.println("HyundaiMaker.sell() : I sold $"+car.getName()+".");
		
		System.out.println("HyundaiMaker.sell() : I earned $" +moneyH.getMoney()+".");
		
		return car;
	}
}

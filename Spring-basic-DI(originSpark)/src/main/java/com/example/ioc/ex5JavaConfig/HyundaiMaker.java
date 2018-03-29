package com.example.ioc.ex5JavaConfig;

public class HyundaiMaker implements CarMaker {

	private Wallet moneyH;

	// public HyundaiMaker() {
	// moneyH= new Wallet(0);
	// }

//	public void setMoneyH(Wallet moneyH) {
//		this.moneyH = moneyH;
//		System.out.println("HyundaiMaker.setMoneyH() Called.");
//	}

	@Override
	public Car getCar(Wallet money) {
		
		moneyH= new Wallet(0);

		// moneyH = money; // +28000
		moneyH.setMoney(money.getMoney());// +28000

		System.out.println("HyundaiMaker.sell() : I got $" + moneyH.getMoney() + ".");

		Car car = new Car("Genesis EQ900L");

		System.out.println("HyundaiMaker.sell() : I made " + car.getName() + ".");

		System.out.println("HyundaiMaker.sell() : I sold $" + car.getName() + ".");

		System.out.println("HyundaiMaker.sell() : I earned $" + moneyH.getMoney() + ".");

		return car;
	}

}

package com.example.ioc.ex1beforeSpring;

public class OrderManager {
	
	private Wallet moneyO;
	
	private Wallet carPrice;
	
	private Car car;
	
	private CarMaker maker;// 공통부분을 interface로 설정.
//	private HyundaiMaker maker;
//	private KiaMaker maker;

//	public OrderManager() {
//
//		// OrderManager가 HyundaiMaker를 사용한다 -> OrderManager가 HyundaiMaker에 의존한다.
//		maker = new HyundaiMaker();
////		maker = new KiaMaker();
//		
//		moneyO = new Money(0);
//	}
	
	
	public String order(Wallet money) {
		
		moneyO = money;// +30000
				
		System.out.println("OrderManager.order() : I received $" + moneyO.getMoney() + " to the customer.");
		
		carPrice = new Wallet(28000);// 자동차 가격을 담을 지갑객체 생성.
		
		moneyO.setMoney(moneyO.getMoney()-carPrice.getMoney());// $30000-$28000=$2000
		
		System.out.println("OrderManager.order() : I paid $" + moneyO.getMoney()+" to the maker.");

		System.out.println("------------------------------------------------------------------------");
		car = maker.getCar(carPrice);// 자동차 
		System.out.println("------------------------------------------------------------------------");

		System.out.println("OrderManager.order() : I got a " + car.getName()+".");
		System.out.println("OrderManager.order() : I delevered the " + car.getName() + " directly to the customer.");
		
		System.out.println("OrderManager.order() : I earned $" +moneyO.getMoney()+".");
		return car.getName();
	}
	
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
}

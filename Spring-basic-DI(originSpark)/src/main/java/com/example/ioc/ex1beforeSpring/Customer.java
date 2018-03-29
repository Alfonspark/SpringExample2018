package com.example.ioc.ex1beforeSpring;

public class Customer {

	public static void main(String[] args) {
		
		Wallet moneyC = new Wallet(30000);
		
		System.out.println("========================================================================");
		System.out.println("Customer : I earned $" + moneyC.getMoney()+".");
		System.out.println("========================================================================");
		
		CarMaker maker = new HyundaiMaker();
//		CarMaker maker = new KiaMaker();
		
		OrderManager orderManager = new OrderManager();
		
		orderManager.setMaker(maker);
		
		String myCar = orderManager.order(moneyC);
		moneyC.setMoney(0);
		System.out.println("Customer : I have $"+moneyC.getMoney()+" in my pocket.");
		System.out.println("========================================================================");
		System.out.println("Customer : I got a new " + myCar+".");
		System.out.println("========================================================================");

	}// main()
}

/**
 * Inversion of Control 제어의 역전 Dependency Injection 의존성 주입 : 객체 간 의존관계를 객체 자신이
 * 아닌, 외부 조립기가 수행해준다는 개념. (약결합) 사용 Class A -> Interface 의존성 삽입^ ^ 구현 Spring ->
 * Concret class B (Bean 생성 Container) :객체관리용 컨테이너. XML / Annotation /
 * Java-config 이 3가지 방법을 이용하여 Bean 설정 가능.
 * 
 * 1) 인터페이스 도입. 2) 객체가 직접 언급되는(new Hyundai or new Kia ...) 방식 회피.
 * => 약결합. 수동적인 객체관리 프로그래밍 방식.
 * 어디든 연결가능한 레고블록처럼 약결합으로 유지하기 위해서는 직접객체생성(강결합)을 하지 않아야함. 공통적인 부분을 선택가능하도록 모듈화. 
 * 
 * 이때, Customer도 변화에 취약하므로, 약결합을 하고싶어진다.
 * 
 * 객체생성, 의존성(관계)주입
 * 직접 객체를 생성하려면, 실체를 언급해야하고 / 직접 대입하혀면, 실체를 판단해야한다.
 * 개발자들이 더이상 객체를 관리하고 싶어하지 않아짐에 따라,
 * 객체를 프레임워크가 위탁관리하는 업무를 맡게된다.
 * DI
 * 1) 강결합 ( 객체를 직접 가진다.)
 * 2) 인터페이스 도입 (추상화된 클래스에 의존한다)
 * 3) 외존성 주입(
 * 	  Repository의 구현체를 Singleton으로 BeanContainer에 보관하고 있다가, 
 *    Controller의 request에 따라, BeanFactory 인터페이스 구현체가 객체를 대신 생성하고, 
 *    객체간 의존성을 컨트롤러에 주입해주는 서비스를 제공해준다.)
 * 
 * 
 */
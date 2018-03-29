package com.example.ioc.ex4Annotation;

import org.springframework.stereotype.Component;

// package와 class명이 노출되기에 class를 쓸 필요 없고, @ tag붙은 class의 이름이 곧 id가 되기에 저 태그가 곧 Bean 설정과 같은 효과!
// 유의할 것은, id는 className그대로가 아니라, 앞글자를 소문자로 바꾼 클래스명이 된다는 것***
// id를 지정하고 싶다면, @Component("hyundai")라 해보자. ""안의 value는 곧 beanId가 된다

/**
 * @author spark
 * @Type HyundaiMaker
 * <bean id="hyundai" class="com.example.ioc.ex4Annotation">에 대응하는 설정.
 * 즉, bean을 만드는 것과 같다.
 */
@Component
public class HyundaiMaker implements CarMaker {

	private Wallet moneyH;
	
	public HyundaiMaker() {
	}

	public void setMoneyH(Wallet moneyH) {
		this.moneyH = moneyH;
		System.out.println("HyundaiMaker.setMoneyH() Called.");
	}

	@Override
	public Car getCar(Wallet money) {

		moneyH = new Wallet(0);

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

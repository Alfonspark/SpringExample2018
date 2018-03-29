package com.example.ioc.ex4Annotation;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author alfons
 * class의 용도를 구분하기 쉽게 하기 위해 @Component에서 확장된 주석인 @Service를 사용해보자.
 */
@Service("orderManager")
public class OrderManager {

	
	
	/** 처리순서 3번, Field Variable
	 *  maker를 hyunda
	 *  CarMaker interface에 들어갈 브랜드를 현대로 지목하는 대목. 여기서 hyundai라는 id는 HyundaiMaker bean의 id와 같다. 
	 *  즉, @Component("hyundai")를 받아들이도록(주입되도록) 설정한 것.
	 */
	@Inject
	@Named("hyundaiMaker")
	private CarMaker maker;// 공통부분을 interface로 설정.

	private Wallet moneyO, carPrice;
	private Car car;
	
	// private HyundaiMaker maker;
	// private KiaMaker maker;
	
	// public OrderManager() {
	//
	// // **OrderManager가 HyundaiMaker를 사용한다 -> OrderManager가 HyundaiMaker에 의존한다.
	// maker = new HyundaiMaker();
	//// maker = new KiaMaker();
	//
	// moneyO = new Wallet(0);
	// }

	/** 처리순서 1번, Construtor-argument, OrderManager(CarMaker maker)
	 *  resourceType(;CarMaker, 자료형)으로 bean를 찾아서 Constructor의 parameter에 주입하도록 설정해주는 Annotation. 
	 *  생성자 파라미터에 \@Qualifier("carmaker를 implements하는 class ID")를 붙여야만 ?가 헷갈리지 않고 \@Autowired할 수 있다.
	 *  -> 즉, \@Qualifier는 한정자(;제한자) 역할을 한다.
	 * @param maker
	 */
	@Autowired
	public OrderManager(@Qualifier("hyundaiMaker")CarMaker maker) {
		this.maker = maker;
		System.out.println("OrderManager(CarMaker maker) : Constructor Called.");
	}
	
	/** 처리순서 1.5번. void initA()
	 * Init Method. Constructor 이후에 호출된다.
	 * Post- : -후에
	 * Pre- : -전에
	 */
	@PostConstruct
	public void initA() {
		System.out.println("OrderManager.initA() : init() Called.");
	}
	
	/** 처리순서 2번. Setter setMaker(CarMaker maker)
	 * Type과 Field, Class만 Target으로 잡혀있으며, Constructor에는 사용불가.
	 * name="kia" -> kia가 id인 bean을 찾아서, setter의 parameter에 주입하도록 설정해주는 Annotation. 
	 * @param maker
	 */
	@Resource(name="kia")
	public void setMaker(CarMaker maker) { // Setter Method
		this.maker = maker;
		System.out.println("OrderManager.setMaker(CarMaker maker) : Setter Called.");
	}
	
	/** 
	 * String order(Wallet money)
	 * @param Wallet money
	 * @return car.getName() String
	 */
	public String order(Wallet money) {

		moneyO = new Wallet(0);

		// moneyO = money;// +30000
		moneyO.setMoney(money.getMoney());// +30000

		System.out.println("OrderManager.order() : I received $" + moneyO.getMoney() + " to the customer.");

		carPrice = new Wallet(28000);// 자동차 가격을 담을 지갑객체 생성.

		moneyO.setMoney(moneyO.getMoney() - carPrice.getMoney());// $30000-$28000=$2000

		System.out.println("OrderManager.order() : I paid $" + carPrice.getMoney() + " to the maker.");

		System.out.println("------------------------------------------------------------------------");
		car = maker.getCar(carPrice);// 자동차
		System.out.println("------------------------------------------------------------------------");

		System.out.println("OrderManager.order() : I got a " + car.getName() + ".");
		System.out.println("OrderManager.order() : I delevered the " + car.getName() + " directly to the customer.");

		System.out.println("OrderManager.order() : I earned $" + moneyO.getMoney() + ".");
		return car.getName();
	}

}

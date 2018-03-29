package com.example.ioc.ex5JavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration// 설정파일 역할의 Class임을 알려줌
@Component("carConfig")// bean을 만드는 것과 같다.
public class CarConfig {
	
	@Bean(name="hyundai")
	public CarMaker hyundaiMaker() {
		CarMaker maker = new HyundaiMaker();
		System.out.println("CarConfig : new HyundaiMaker() : Constructor Called");
		return maker;
	}
	
	@Bean
	public CarMaker kiaMaker() {
		CarMaker maker = new KiaMaker();
		System.out.println("CarConfig : new KiaMaker() : Constructor Called");
		System.out.println("Singleton(Kia):"+maker);
		return maker;
	}
	
	@Bean(initMethod="initA")// @PostConstruct annotation을 해당 Method에 설정하여 사용해도 좋다.
	public OrderManager orderManager() {
		// Constructor-arg를 멤버변수에 담았다.
		OrderManager orderManager= new OrderManager(kiaMaker());// kiaMaker를 쓰기로 했음을 알 수 있다.
		System.out.println("Singleton(Kia):"+kiaMaker());
		System.out.println("CarConfig : new OrderManager(kiaMaker) : Constructor-arg Called.");
		return orderManager;
	}
	
	
}//

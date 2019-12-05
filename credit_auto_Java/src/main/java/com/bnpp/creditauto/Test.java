package com.bnpp.creditauto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.service.RateService;

@Configuration
@ComponentScan//("com.bnpp.creditauto")
public class Test {

	public static void main(String[] args) {

		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(Test.class)) {
			RateService rateService = context.getBean(RateService.class);

			System.out.println("Test getDecisionRate");

			System.out.println("cat=A; vehiclePrice=5000; duration=24");
			System.out.println("résultat attendu : T1");
			System.out.println(rateService.getDecisionRate(Category.A, 5000, 24));
		}
	}

}

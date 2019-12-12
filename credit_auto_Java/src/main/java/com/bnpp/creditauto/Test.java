package com.bnpp.creditauto;

import java.sql.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Client;
import com.bnpp.creditauto.service.ClientService;
import com.bnpp.creditauto.service.RateService;

//@Configuration
//@ComponentScan//("com.bnpp.creditauto")
public class Test {

	public static void main(String[] args) {

		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(Test.class)) {
			
			System.out.println("Creation d'un client");
			ClientService cs = context.getBean(ClientService.class);
			cs.deleteAll();
			Date d = new Date(System.currentTimeMillis());
			Client client = new Client("test","test",d,"phonenum","adresse",123456789L);
			cs.save(client);
			System.out.println(cs.findAll());

			System.out.println("Test getDecisionRate");
			RateService rateService = context.getBean(RateService.class);
			System.out.println("Find all :");
			System.out.println(rateService.findAll());
			System.out.println("cat=A; vehiclePrice=5000; duration=24");
			System.out.println("résultat attendu : T1");
			Category a = new Category("A");
			a.setId(1L);
			System.out.println(rateService.getDecisionRate(a, 5000, 24).getRateAmount());
			Double resultRate;
			Integer loanDuration = 24;
			Long loanAmount = 10000L;
			Double result;
			Double mtnMensu;
			Double mtnTotal;
			
			
			
			
			resultRate = (rateService.getDecisionRate(a, 5000, 24).getRateAmount());
			System.out.println(resultRate);
			result = resultRate / 100;
			result ++;
			result = Math.pow(result, loanDuration);
			System.out.println(result);
			mtnMensu = (loanAmount*(resultRate/100)*result)/(result - 1);
			System.out.println("Montant Mensuel : " + mtnMensu + " €");
			mtnTotal = mtnMensu * loanDuration;
			System.out.println("Montant Total : " + mtnTotal + " €");
		}
	}
			
			
}

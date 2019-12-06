package com.bnpp.creditauto;

import java.sql.Date;

import org.apache.catalina.webresources.Cache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Client;
import com.bnpp.creditauto.service.ClientService;
import com.bnpp.creditauto.service.RateService;

@Configuration
@ComponentScan//("com.bnpp.creditauto")
public class App {

	public static void main(String[] args) {

		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class)) {
			
			System.out.println("Creation d'un client");
			ClientService cs = context.getBean(ClientService.class);
			Date d = new Date(System.currentTimeMillis());
			Client client = new Client("test","test",d,"phonenum","adresse",123456789L);
			cs.save(client);
			System.out.println(cs.findAll());
		}
	}

}
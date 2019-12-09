package com.bnpp.creditauto;

import java.sql.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Client;
import com.bnpp.creditauto.model.Contract;
import com.bnpp.creditauto.service.ClientService;
import com.bnpp.creditauto.service.ContractService;

@ComponentScan//("com.bnpp.creditauto")
public class App {

	public static void main(String[] args) {

		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class)) {
			
			ContractService cts = context.getBean(ContractService.class);
			System.out.println("suppression du contenu de la table contract");
			cts.deleteAll();
			ClientService cls = context.getBean(ClientService.class);
			System.out.println("Suppression du contenu de la table client");
			cls.deleteAll();
			
			System.out.println("Creation d'un client");
			Date d = new Date(System.currentTimeMillis());
			Client client = new Client("coucou","test",d,"phonenum","adresse",123456789L);
			cls.save(client);
			System.out.println(cls.findAll());
			
			Category category = new Category("A");
			category.setId(1L);
			
			System.out.println("Creation d'un contrat");
			Contract contract = new Contract(9000L,8000L,24,0.65,true,d,client,category);
			cts.save(contract);
			System.out.println(cts.findAll());
		}
	}

}

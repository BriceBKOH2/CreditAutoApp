package com.bnpp.creditauto;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import com.bnpp.creditauto.model.Client;
import com.bnpp.creditauto.service.ClientService;

@ComponentScan
public class App {

	public static void main(String[] args) {

		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class)) {
			
			ClientService cs = context.getBean(ClientService.class);
//			cs.deleteAll();
			System.out.println("Creation d'un client");

			LocalDate ld = LocalDate.of(1989, 11, 02);
			Date birth = Date.valueOf(ld);
			// Création client Jordi
			Client jordi = new Client("Jordi","Mage", birth,"phonenum","adresse 1", 123456789L);
			cs.save(jordi);
			// Création client David
			Client david = new Client("David","Duveau", birth,"phonenum","adresse 2", 123456789L);
			cs.save(david);
			
			System.out.println(cs.findAll());
			
			
			// Test Client research method by firstname and lastname
//			try {
//				List<Client> clients = cs.findByNames("Jordi", "Mage");
//				
//				for (Client client2 : clients) {
//					System.out.println(client2.getFirstName() + " ");
//				}
//			} catch (ClientNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}

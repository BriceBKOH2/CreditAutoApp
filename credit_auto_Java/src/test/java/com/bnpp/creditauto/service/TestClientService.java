package com.bnpp.creditauto.service;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bnpp.creditauto.App;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@Transactional
public class TestClientService {

	@Autowired
	ClientService clientService;
	
//	@Test
//	public void testFindByNames() throws ClientNotFoundException {
//		System.out.println("Test findByNames");
//		System.out.println("résultat attendu : Jordi Mage");
//
//		List<Client> exceptedResult = new ArrayList<Client>();
//		LocalDate ld = LocalDate.of(1989, 11, 02);
//		Date birth = Date.valueOf(ld);
//		Client jordi = new Client(11L,"Jordi","Mage", birth,"phonenum","adresse 1", 123456789L);
//		
//		exceptedResult.add(jordi);
//		
//		List<Client> result = clientService.findByNames("Jordi", "Mage");
//		
//		Assert.assertEquals(exceptedResult, result);
//	}
	
}

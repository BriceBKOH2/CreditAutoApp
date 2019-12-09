package com.bnpp.creditauto.service;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bnpp.creditauto.App;
import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.Rate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@Transactional
public class TestRateService {
	
	@Autowired
	RateService rateService;
	
	private static Category a, b;
	
	@BeforeClass
	public static void init() {		
		a = new Category("A");
		a.setId(1L);
		b = new Category("B");
		b.setId(2L);
	}
	
	/*       Test de RateService::getDecisionRate      */
	// //////////// Tests sur catégorie A //////////// //

	@Test
	public void testGetDecisionRate_A_5000_T1() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=A; vehiclePrice=5000; duration=24");
		System.out.println("résultat attendu : T1");
		
		Rate result = rateService.getDecisionRate(a, 5000, 24);
		
		Assert.assertEquals("T1", result.getName());
	}
	
	@Test
	public void testGetDecisionRate_A_5000_T2() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=5000; duration=36");
		System.out.println("résultat attendu : T2");
		
		Rate result = rateService.getDecisionRate(a, 5000, 36);
		System.out.println(result);
		
		Assert.assertEquals("T2", result.getName());
	}
	
	@Test
	public void testGetDecisionRate_A_12000_T2() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=12000; duration=24");
		System.out.println("résultat attendu : T2");
		
		Rate result = rateService.getDecisionRate(a, 12000, 24);
		System.out.println(result);
		
		Assert.assertEquals("T2", result.getName());
	}
	
	@Test
	public void testGetDecisionRate_A_12000_T3() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=12000; duration=36");
		System.out.println("résultat attendu : T3");
		
		Rate result = rateService.getDecisionRate(a, 12000, 36);
		System.out.println(result);
		
		Assert.assertEquals("T3", result.getName());
	}
	
	// //////////// Tests sur catégorie B //////////// //
	
	@Test
	public void testGetDecisionRate_B_7000_T3() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=7000; duration=16");
		System.out.println("résultat attendu : T3");
		
		Rate result = rateService.getDecisionRate(b, 7000, 16);
		System.out.println(result);
		
		Assert.assertEquals("T3", result.getName());
	}
	
	@Test
	public void testGetDecisionRate_B_7000_T4() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=7000; duration=24");
		System.out.println("résultat attendu : T4");
		
		Rate result = rateService.getDecisionRate(b, 7000, 24);
		System.out.println(result);
		
		Assert.assertEquals("T4", result.getName());
	}
	
	@Test
	public void testGetDecisionRate_B_7000_T5() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=7000; duration=42");
		System.out.println("résultat attendu : T5");
		
		Rate result = rateService.getDecisionRate(b, 7000, 42);
		System.out.println(result);
		
		Assert.assertEquals("T5", result.getName());
	}
	
	@Test
	public void testGetDecisionRate_B_15001_T5() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=15001; duration=18");
		System.out.println("résultat attendu : T5");
		
		Rate result = rateService.getDecisionRate(b, 15001, 18);
		System.out.println(result);
		
		Assert.assertEquals("T5", result.getName());
	}
	
	@Test
	public void testGetDecisionRate_B_15001_T6() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=15001; duration=36");
		System.out.println("résultat attendu : T6");
		
		Rate result = rateService.getDecisionRate(b, 15001, 36);
		System.out.println(result);
		
		Assert.assertEquals("T6", result.getName());
	}
	
	@Test
	public void testGetDecisionRate_B_25001_T6() {
		System.out.println("Test getDecisionRate");
		System.out.println("cat=B; vehiclePrice=25001; duration=36");
		System.out.println("résultat attendu : T6");
		
		Rate result = rateService.getDecisionRate(b, 25001, 36);
		System.out.println(result);
		
		Assert.assertEquals("T6", result.getName());
	}
	
	
}

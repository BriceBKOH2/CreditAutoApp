package com.bnpp.creditauto.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpp.creditauto.model.Category;
import com.bnpp.creditauto.model.DecisionTable;
import com.bnpp.creditauto.model.Rate;
import com.bnpp.creditauto.service.CategoryService;
import com.bnpp.creditauto.service.ClientService;
import com.bnpp.creditauto.service.DecisionTableService;
import com.bnpp.creditauto.service.RateService;

/**
 * Add some data to the database so that it can be operational for basic
 * features. Need to run only one time.
 * Delete all and then adds default Categories, Rates and DecisionTable entries.
 * 
 * @author Jordi
 *
 */
@Service
public class DBData {

	@Autowired
	private CategoryService categSvc;
	@Autowired
	private RateService rateSvc;
	@Autowired
	private DecisionTableService dtSvc;
	@Autowired
	private ClientService cliSvc;
	
	private static Category[] categs = new Category[6];
	private static Rate[] rates = new Rate[6];
	private static DecisionTable[] dTables = new DecisionTable[10];
	
	public void init() {
		
//		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class)) {
//			CategoryService categSvc = context.getBean(CategoryService.class);
//			RateService rateSvc = context.getBean(RateService.class);
//			DecisionTableService dtSvc = context.getBean(DecisionTableService.class);
//			ClientService cliSvc = context.getBean(ClientService.class);
//			deleteAll(cliSvc, categSvc, rateSvc, dtSvc);
//		}
		deleteAll(cliSvc, categSvc, rateSvc, dtSvc);
		createCateg(categSvc);
		createRates(rateSvc);
		createDecisions(dtSvc);
	}

	private static void deleteAll(ClientService cliSvc, CategoryService categSvc, RateService rateSvc, DecisionTableService dtSvc) {
		cliSvc.deleteAll();
		dtSvc.deleteAll();
		rateSvc.deleteAll();
		categSvc.deleteAll();
	}

	private static void createDecisions(DecisionTableService dtSvc) {
		// Order of parameters : Category, Rate, Max Amount, Min Amount, Max Duration, Min Duration
		// Cat A :
		dTables[0] = new DecisionTable(categs[0], rates[0], 9999L, 5000L, 30L, 1L);
		dTables[1] = new DecisionTable(categs[0], rates[1], 9999L, 5000L, 48L, 31L);
		dTables[2] = new DecisionTable(categs[0], rates[1], 14999L, 10000L, 24L, 1L);
		dTables[3] = new DecisionTable(categs[0], rates[2], 14999L, 10000L, 48L, 25L);
		
		// Cat B
		dTables[4] = new DecisionTable(categs[1], rates[2], 14999L, 5000L, 18L, 1L);
		dTables[5] = new DecisionTable(categs[1], rates[3], 14999L, 5000L, 36L, 19L);
		dTables[6] = new DecisionTable(categs[1], rates[4], 14999L, 5000L, 48L, 37L);
		dTables[7] = new DecisionTable(categs[1], rates[4], 25000L, 15000L, 24L, 1L);
		dTables[8] = new DecisionTable(categs[1], rates[5], 25000L, 15000L, 48L, 25L);
		dTables[9] = new DecisionTable(categs[1], rates[5], 50000L, 25001L, 48L, 25L);
		
		for (DecisionTable dt : dTables) {
			dtSvc.save(dt);
		}
	}

	private static void createRates(RateService rateSvc) {
		for (int i = 0; i < rates.length; i++) {
			rates[i] = new Rate();
			rates[i].setName("T" + (i+1));
		}
		rates[0].setRateAmount(0.65);
		rates[1].setRateAmount(0.34);
		rates[2].setRateAmount(0.45);
		rates[3].setRateAmount(0.21);
		rates[4].setRateAmount(0.44);
		rates[5].setRateAmount(0.74);
		
		for (Rate r : rates) {
			rateSvc.save(r);
		}
	}

	private static void createCateg(CategoryService categSvc) {
		char name = 'A';
		for (int i = 0; i < categs.length; i++) {
			categs[i] = new Category();
			categs[i].setName(String.valueOf(name++));
			categSvc.save(categs[i]);
		}
	}
}

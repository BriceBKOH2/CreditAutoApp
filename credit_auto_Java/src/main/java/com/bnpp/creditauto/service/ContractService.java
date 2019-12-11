package com.bnpp.creditauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpp.creditauto.dao.ContractDao;
import com.bnpp.creditauto.exception.ContractNotFoundException;
import com.bnpp.creditauto.exception.RateNotFoundException;
import com.bnpp.creditauto.model.Contract;

@Service
public class ContractService {
	@Autowired
	ContractDao contractDao;

	@Autowired
	RateService rateSvc;

	public void save(Contract contract) {
		contractDao.persist(contract);
		contract.setIsActive(true);
	}
	
	public Contract findById(Long id) {
		return contractDao.findById(id);
	}

	@Transactional(rollbackFor = ContractNotFoundException.class)
	public void update(Contract... contracts) throws ContractNotFoundException {
		for (Contract contract : contracts) {
			contractDao.update(contract);
		}
	}

	@Transactional(rollbackFor = ContractNotFoundException.class)
	public void update(List<Contract> contracts) throws ContractNotFoundException {
		for (Contract contract : contracts) {
			contractDao.update(contract);
		}
	}

	@Transactional(rollbackFor = ContractNotFoundException.class)
	public void delete(Contract contract) throws ContractNotFoundException {
		contractDao.delete(contract);
	}

	@Transactional
	public void deleteAll() {
		contractDao.deleteAll();
	}

	@Transactional
	public List<Contract> findAll() {
		return contractDao.findAll();
	}

	/**
	 * Modify the Contract c. Calls the decision algorithm to set the correct Rate Amount,
	 * and calculate the field amountDue. The contract in parameter needs to have its loanAmount
	 * loanDuration, vehicleCategory and vehiclePrice correctly set.
	 * 
	 * @param c The contract to be modified.
	 * @throws RateNotFoundException 
	 */
	public void contractSimulator(Contract c) throws RateNotFoundException {
		
		c.setRate(rateSvc.getDecisionRate(
				c.getVehicleCategory(),
				c.getVehiclePrice(),
				c.getLoanDuration()).getRateAmount());
		
		if (c.getRate() == null) {
			throw new RateNotFoundException("Rate amount cannot be decided with current contract parameters:\n"
					+ "[category=" + c.getVehicleCategory()
					+ " vehiclePrice=" + c.getVehiclePrice()
					+ " loanDuration=" + c.getLoanDuration() + "]");
		}
		
		// Calculations
		double monthlyAmount, totalAmount;
		double result = c.getRate() / 100;
		result++;
		result = Math.pow(result, c.getLoanDuration());
		System.out.println(result);
		
		monthlyAmount = (c.getLoanAmount() * (c.getRate() / 100) * result) / (result - 1);
		System.out.println("Montant Mensuel : " + monthlyAmount + " €");
		totalAmount = monthlyAmount * c.getLoanDuration();
		System.out.println("Montant Total : " + totalAmount + " €");

		c.setAmountDue(Double.valueOf(totalAmount).longValue());
	}
}

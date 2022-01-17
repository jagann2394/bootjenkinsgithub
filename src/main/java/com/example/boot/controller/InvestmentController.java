package com.example.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.pojo.Investment;
import com.example.boot.service.InvestmentService;

/**
 * Controller class for Investment
 * @author jn.chakravarthy
 *
 */
@RestController
public class InvestmentController {
	
	@Autowired
	private InvestmentService investmentService;
	
	/**
	 *
	 * @param investmentType
	 * @return Returns a list of investments whose investment type matches input parameter
	 */
	@GetMapping(value = "/investmentType/{investmentType}")
	public List<Investment> getInvestmentByType(@PathVariable("investmentType") String investmentType){
		return investmentService.getInvestmentByType(investmentType);
	}
	
	/**
	 * 
	 * @param principle
	 * @return Returns a list of investments whose principle is greater than or equal to input parameter
	 */
	@GetMapping(value = "/principle/{principle}")
	public List<Investment> getInvestmentByPrinciple(@PathVariable("principle") int principle){
		return investmentService.getInvestmentByPrinciple(principle);
	}
	
	/**
	 * Creates a new investment in the database
	 * @param investment
	 * @return
	 */
	@PostMapping(value = "/logInvestment")
	public Investment logInvestment(@RequestBody Investment investment) {
		return investmentService.logInvestment(investment);
	}
	
	/**
	 * Updates a row in the investment table
	 * @param investment
	 * @return
	 */
	@PutMapping(value = "/updateInvestment")
	public Investment updateInvestment(@RequestBody Investment investment) {
		return investmentService.updateInvestment(investment);
	}
	
	/**
	 * Deletes an investment
	 * @param investmentId
	 * @return
	 */
	@DeleteMapping(value ="/deleteInvestment/{investmentId}")
	public String deleteInvestment(@PathVariable("investmentId") int investmentId) {
		return investmentService.deleteInvestment(investmentId);
	}
	
	

}

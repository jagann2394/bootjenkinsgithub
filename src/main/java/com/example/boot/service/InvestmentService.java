package com.example.boot.service;

import java.util.List;

import com.example.boot.pojo.Investment;

public interface InvestmentService {

	List<Investment> getInvestmentByType(String investmentByType);
	
	List<Investment> getInvestmentByPrinciple(int principle);
	
	Investment logInvestment(Investment investment);
	
	String deleteInvestment(int investmentId);
	
	Investment updateInvestment(Investment investment);

}

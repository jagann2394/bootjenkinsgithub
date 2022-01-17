package com.example.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Investment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int investmentId;
	private String investmentType;
	private int principle;
	private double interestRate;

	public int getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(int investmentId) {
		this.investmentId = investmentId;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	public int getPrinciple() {
		return principle;
	}

	public void setPrinciple(int principle) {
		this.principle = principle;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}

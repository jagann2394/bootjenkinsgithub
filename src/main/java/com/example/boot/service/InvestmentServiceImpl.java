package com.example.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.dao.InvestmentRepository;
import com.example.boot.pojo.Investment;

@Service
public class InvestmentServiceImpl implements InvestmentService {

	@Autowired
	private InvestmentRepository investmentRepository;

	@Override
	public Investment logInvestment(Investment investment) {
		com.example.boot.model.Investment entity = new com.example.boot.model.Investment();
		entity.setInvestmentType(investment.getInvestmentType());
		entity.setPrinciple(investment.getPrinciple());
		entity.setInterestRate(investment.getInterestRate());
		investmentRepository.save(entity);
		investment.setInvestmentId(entity.getInvestmentId());
		return investment;
	}

	@Override
	public List<Investment> getInvestmentByType(String investmentByType) {
		List<com.example.boot.model.Investment> investments = investmentRepository
				.findByInvestmentType(investmentByType);
		List<Investment> list = new ArrayList<Investment>();

		for (com.example.boot.model.Investment investment : investments) {
			Investment investment2 = new Investment();
			investment2.setInterestRate(investment.getInterestRate());
			investment2.setInvestmentId(investment.getInvestmentId());
			investment2.setInvestmentType(investment.getInvestmentType());
			investment2.setPrinciple(investment.getPrinciple());
			list.add(investment2);
		}

		return list;
	}

	@Override
	public List<Investment> getInvestmentByPrinciple(int principle) {
		List<com.example.boot.model.Investment> investments = investmentRepository.getInvestmentByPrinciple(principle);
		List<Investment> list = new ArrayList<Investment>();
		for (com.example.boot.model.Investment investment : investments) {
			Investment investment2 = new Investment();
			investment2.setInterestRate(investment.getInterestRate());
			investment2.setInvestmentId(investment.getInvestmentId());
			investment2.setInvestmentType(investment.getInvestmentType());
			investment2.setPrinciple(investment.getPrinciple());
			list.add(investment2);
		}

		return list;
	}

	@Override
	public String deleteInvestment(int investmentId) {
		Optional<com.example.boot.model.Investment> investment = investmentRepository.findById(investmentId);
		if (investment.isPresent()) {
			investmentRepository.delete(investment.get());
			return "Investment with investmentId " + investmentId + " Deleted";
		}
		return "Cannot find Investment with investmentId " + investmentId;
	}

	@Transactional
	@Override
	public Investment updateInvestment(Investment investment) {

		com.example.boot.model.Investment investmentEntity = investmentRepository.getById(investment.getInvestmentId());
		investmentEntity.setInvestmentType(investment.getInvestmentType());
		investmentEntity.setPrinciple(investment.getPrinciple());
		investmentEntity.setInterestRate(investment.getInterestRate());

		return investment;
	}
}

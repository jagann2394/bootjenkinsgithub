package com.example.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.boot.model.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Integer> {

	List<Investment> findByInvestmentType(String investmentType);

	@Query(value = "SELECT * FROM Investment i WHERE i.principle >= :principle", nativeQuery = true)
	List<Investment> getInvestmentByPrinciple(@Param("principle") int principle);

}

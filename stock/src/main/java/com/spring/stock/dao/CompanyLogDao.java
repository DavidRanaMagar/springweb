package com.spring.stock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.stock.entity.CompanyLog;

public interface CompanyLogDao extends JpaRepository<CompanyLog,Integer> {
	public CompanyLog findByCodeAndTime(String code,String time);
	public List<CompanyLog> findByCode(String code);
        public CompanyLog findFirstByOrderByIdDesc();
}

package com.spring.stock.services;

import java.util.List;

import com.spring.stock.entity.CompanyLog;

public interface CompanyLogService {
public void create(CompanyLog companyLog);
public void update(CompanyLog companyLog);
public void delete(CompanyLog companyLog);
public CompanyLog getByDate(String code,String time);
public List<CompanyLog> getAll(String code);
public double getLastestCloseRate();
public double getLastestMarketCap();
public int getLastestMarketVolume();
public double getLastestCurrentRate();
public int getLastestVolumeBought();
}

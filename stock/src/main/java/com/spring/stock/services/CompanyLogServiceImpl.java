package com.spring.stock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.stock.dao.CompanyLogDao;
import com.spring.stock.entity.CompanyLog;
@Service
public class CompanyLogServiceImpl implements CompanyLogService {
	private CompanyLogDao companyLogDao;
	
	@Autowired
	public CompanyLogServiceImpl(CompanyLogDao companyLogDao) {
		super();
		this.companyLogDao = companyLogDao;
	}

	@Override
	public void create(CompanyLog companyLog) {
		companyLogDao.save(companyLog);
	}

	@Override
	public void update(CompanyLog companyLog) {
		companyLogDao.save(companyLog);
	}

	@Override
	public void delete(CompanyLog companyLog) {
		companyLogDao.delete(companyLog);
		
	}

	@Override
	public CompanyLog getByDate(String code, String time) {
		CompanyLog companyLog = (CompanyLog) companyLogDao.findByCodeAndTime(code, time);
		return companyLog;
		
	}

	@Override
	public List<CompanyLog> getAll(String code) {
		List<CompanyLog> companyLogList = companyLogDao.findByCode(code);
		return companyLogList;
	}

    @Override
    public double getLastestCloseRate() {
        CompanyLog companyLog = companyLogDao.findFirstByOrderByIdDesc();
        return companyLog.getLastClose();
    }

    @Override
    public double getLastestMarketCap() {
        CompanyLog companyLog = companyLogDao.findFirstByOrderByIdDesc();
        return companyLog.getMarketCap();
        }

    @Override
    public int getLastestMarketVolume() {
        CompanyLog companyLog = companyLogDao.findFirstByOrderByIdDesc();
        return companyLog.getMarketVolume();
    }

    @Override
    public double getLastestCurrentRate() {
        CompanyLog companyLog = companyLogDao.findFirstByOrderByIdDesc();
        return companyLog.getRate();
    }

    @Override
    public int getLastestVolumeBought() {
        CompanyLog companyLog = companyLogDao.findFirstByOrderByIdDesc();
        return companyLog.getVolumeBought();
    }


}

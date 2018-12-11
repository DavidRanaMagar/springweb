
package com.spring.stock.services;

import com.spring.stock.dao.BuyersTableDao;
import com.spring.stock.entity.BuyersTable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyersTableServiceImpl implements BuyersTableService {
    private BuyersTableDao buyersTableDao;
    @Autowired
    public BuyersTableServiceImpl(BuyersTableDao buyersTableDao) {
        this.buyersTableDao = buyersTableDao;
    }
    

    @Override
    public void create(BuyersTable buyer) {
        buyersTableDao.save(buyer);
    }

    @Override
    public void delete(BuyersTable buyer) {
        buyersTableDao.delete(buyer);
    }

    @Override
    public void update(BuyersTable buyer) {
        buyersTableDao.save(buyer);
    }

    @Override
    public List<BuyersTable> getByUserEmail(String userEmail) {
        List<BuyersTable> buyersList = buyersTableDao.findByUserEmail(userEmail);
        return buyersList;
    }

    @Override
    public List<BuyersTable> getAll() {
        List<BuyersTable> buyersList = buyersTableDao.findAll();
        return buyersList;
    }

    @Override
    public List<BuyersTable> getByStatus(boolean status) {
        List<BuyersTable> buyersList = buyersTableDao.findByStatus(status);
        return buyersList;
    }

    @Override
    public BuyersTable getById(int id) {
        return buyersTableDao.findById(id);
    }

    @Override
    public List<BuyersTable> getByUserEmailAndStatus(String userEmail, boolean status) {
        List<BuyersTable> buyersList = buyersTableDao.findByUserEmailAndStatus(userEmail,status);
        return buyersList;
    }
    
}

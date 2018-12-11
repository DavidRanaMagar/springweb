package com.spring.stock.services;

import com.spring.stock.entity.BuyersTable;
import java.util.List;

public interface BuyersTableService {
    public void create(BuyersTable buyer);
    public void delete(BuyersTable buyer);
    public void update(BuyersTable buyer);
    public BuyersTable getById(int id);
    public  List<BuyersTable> getByUserEmail(String userEmail);
    public  List<BuyersTable> getByUserEmailAndStatus(String userEmail, boolean status); 
    public  List<BuyersTable> getAll();
    public  List<BuyersTable> getByStatus(boolean status);
}

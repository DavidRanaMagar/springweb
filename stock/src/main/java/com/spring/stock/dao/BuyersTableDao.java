
package com.spring.stock.dao;

import com.spring.stock.entity.BuyersTable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BuyersTableDao extends JpaRepository<BuyersTable,Integer> {
    public List<BuyersTable> findByUserEmail(String userEmail);
    public List<BuyersTable> findByStatus(boolean status);
    public List<BuyersTable> findByUserEmailAndStatus(String userEmail,boolean status);
    public BuyersTable findById(int id);
}

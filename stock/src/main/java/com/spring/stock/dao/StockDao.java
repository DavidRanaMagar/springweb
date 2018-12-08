
package com.spring.stock.dao;

import com.spring.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDao extends JpaRepository<Stock,Integer>{

    public Stock findByCode(String code);
    public Stock findByName(String name);
}

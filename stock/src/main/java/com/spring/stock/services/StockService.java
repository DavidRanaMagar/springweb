
package com.spring.stock.services;

import com.spring.stock.entity.Stock;
import java.util.List;

public interface StockService {
    public List<Stock> getAll();
    public Stock getByCode(String code);
    public Stock getByName(String name);
    public void setBid(String code,double rate,int volume);
    public void setAsk(String code,double rate,int volume);
    public void setPreviousClose(String code,double rate);
    public void setOpenRate(String code,double rate);
    public void setCurrentRate(String code,double rate);
    public void setNewStock(Stock stock);
    public void delete(String code,String name);
}

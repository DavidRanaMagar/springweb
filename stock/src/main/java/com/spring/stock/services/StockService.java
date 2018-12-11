
package com.spring.stock.services;

import com.spring.stock.entity.Stock;
import java.util.List;
import java.util.Set;

public interface StockService {
    public List<Stock> getAll();
    public Stock getByCode(String code);
    public Stock getByName(String name);
    public List<Stock> getByCode(Set<String> code);
    public void setBid(String code,double rate,int volume);
    public void setAsk(String code,double rate,int volume);
    public void setPreviousClose(String code,double rate);
    public void setOpenRate(String code,double rate);
    public void setCurrentRate(String code,double rate);
    public void setMarketVolume(String code,int marketVolume);
    public void setMarketCap(String code,double marketCap);
    public void setNewStock(Stock stock);
    public void delete(String code,String name);
}

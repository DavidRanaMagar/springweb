
package com.spring.stock.services;

import com.spring.stock.dao.StockDao;
import com.spring.stock.entity.Stock;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{
    private StockDao stockDao;

    public StockServiceImpl(StockDao stockDao) {
        this.stockDao = stockDao;
    }
  
    @Override
    public void setNewStock(Stock stock){
        stockDao.save(stock);
    }
    
    @Override
    public List<Stock> getAll() {
        return stockDao.findAll();
    }
    
    @Override
    public Stock getByCode(String code) {
        return stockDao.findByCode(code);
    }

    @Override
    public Stock getByName(String name) {
        return stockDao.findByCode(name);
    }

    @Override
    public void setBid(String code,double rate, int volume) {
        Stock stock = stockDao.findByCode(code);
        stock.setBidPrice(rate);
        stock.setBidVolume(volume);
        stockDao.save(stock);
    }

    @Override
    public void setAsk(String code,double rate, int volume) {
        Stock stock = stockDao.findByCode(code);
        stock.setAskPrice(rate);
        stock.setAskVolume(volume);
        stockDao.save(stock);
    }

    @Override
    public void setPreviousClose(String code,double rate) {
        Stock stock = stockDao.findByCode(code);
        stock.setPreviousClose(rate);
        stockDao.save(stock);
    }

    @Override
    public void setOpenRate(String code,double rate) {
        Stock stock = stockDao.findByCode(code);
        stock.setTodayOpen(rate);
        stockDao.save(stock);
    }

    @Override
    public void setCurrentRate(String code,double rate) {
        Stock stock = stockDao.findByCode(code);
        stock.setCurrentRate(rate);
        stockDao.save(stock);
    }
    
    @Override
    public void delete(String code,String name){
        Stock stock1 = stockDao.findByCode(code);
        Stock stock2 = stockDao.findByName(name);
        if(stock1.equals(stock2)){
            stockDao.delete(stock1);
    }
    }
    
}

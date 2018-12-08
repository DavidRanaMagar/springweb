
package com.spring.stock.controller;

import com.spring.stock.entity.Stock;
import com.spring.stock.services.RolesService;
import com.spring.stock.services.StockService;
import com.spring.stock.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class Controlled {
    
    private StockService stockImp;
    @Autowired
    public Controlled(StockService stockImp, UsersService userService, RolesService roleService) {
        this.stockImp = stockImp;
    }
    
    
    @RequestMapping(value="/createStock")
    public String create(){
        return "insert";
    }
    @RequestMapping(value="/insertStock")
    public String insertStock(@RequestParam("companyName") String companyName,
    @RequestParam("companyCode") String companyCode,@RequestParam("currentRate") String currentRate,
    @RequestParam("previousClose") String previousClose,@RequestParam("todayOpen") String todayOpen,
    @RequestParam("bidPrice") String bidPrice,@RequestParam("bidVolume") String bidVolume,
    @RequestParam("askPrice") String askPrice,@RequestParam("askVolume") String askVolume,ModelMap m){
        Stock stock = new Stock(companyName,companyCode,Double.valueOf(previousClose),Double.valueOf(todayOpen),Double.valueOf(currentRate),
                Double.valueOf(bidPrice),Integer.valueOf(bidVolume),Double.valueOf(askPrice),Integer.valueOf(askVolume));
        stockImp.setNewStock(stock);
       return "home";
    }
    @RequestMapping(value="/bid")
    public String bid(){
        return "bid";
    }
    @RequestMapping(value="/setBid")
    public String setBid(@RequestParam("companyCode") String companyCode,@RequestParam("bidPrice") String bidPrice,@RequestParam("bidVolume") String bidVolume){
        stockImp.setBid(companyCode, Double.valueOf(bidPrice), Integer.valueOf(bidVolume));
        return "home";
    }
    @RequestMapping(value="/ask")
    public String ask(){
        return "ask";
    }
    @RequestMapping(value="/setAsk")
    public String setAsk(@RequestParam("companyCode") String companyCode,@RequestParam("askPrice") String askPrice,@RequestParam("askVolume") String askVolume){
        stockImp.setAsk(companyCode, Double.valueOf(askPrice), Integer.valueOf(askVolume));
        return "home";
    }
    @RequestMapping(value="/close")
    public String close(){
        return "prevclose";
    }
    @RequestMapping(value="/setPreviousClose")
    public String setPreviousClose(@RequestParam("companyCode") String companyCode,@RequestParam("previousClose") String previousClose){
        stockImp.setPreviousClose(companyCode, Double.valueOf(previousClose));
        return "home";
    }
    @RequestMapping(value="/setOpen")
    public String open(){
        return "open";
    }
    @RequestMapping(value="/setTodayOpen")
    public String setTodayOpen(@RequestParam("companyCode") String companyCode,@RequestParam("todayOpen") String todayOpen){
        stockImp.setOpenRate(companyCode, Double.valueOf(todayOpen));
        return "home";
    }
    @RequestMapping(value="/todayRate")
    public String todayRate(){
        return "current";
    }
    @RequestMapping(value="/setTodayRate")
    public String setTodayRate(@RequestParam("companyCode") String companyCode,@RequestParam("currentRate") String currentRate){       
        stockImp.setCurrentRate(companyCode, Double.valueOf(currentRate));
        return "home";
    }
    @RequestMapping(value="/delete")
    public String delete(){
        return "delete";
    }
    @RequestMapping(value="/deleteStock")
    public String deleteStock(@RequestParam("companyCode") String companyCode,@RequestParam("companyName") String companyName){
        stockImp.delete(companyCode, companyName);
        return "home";
    }
    
    
}


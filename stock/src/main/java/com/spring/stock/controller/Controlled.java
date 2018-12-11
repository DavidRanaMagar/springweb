
package com.spring.stock.controller;

import com.spring.stock.entity.BuyersTable;
import com.spring.stock.entity.CompanyLog;
import com.spring.stock.entity.Stock;
import com.spring.stock.services.BuyersTableService;
import com.spring.stock.services.CompanyLogService;
import com.spring.stock.services.StockService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class Controlled {
    
    private StockService stockService;
    private CompanyLogService companyServiceLog;
    private BuyersTableService buyersTableService;
    @Autowired
    public Controlled(StockService stockImp, CompanyLogService companyServiceLog,BuyersTableService buyersTableService) {
        this.stockService = stockImp;
        this.companyServiceLog = companyServiceLog;
        this.buyersTableService = buyersTableService;
        
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
    @RequestParam("askPrice") String askPrice,@RequestParam("askVolume") String askVolume,
    @RequestParam("marketVolume") String marketVolume, @RequestParam("marketCap") String marketCap,ModelMap m){
        
        CompanyLog c = new CompanyLog(companyCode,time(),Double.valueOf(currentRate),Double.valueOf(previousClose),
                Double.valueOf(marketCap),0,Integer.valueOf(marketVolume));
        companyServiceLog.create(c);
        Stock stock = new Stock(companyName,companyCode,Double.valueOf(previousClose),Double.valueOf(todayOpen),
                Double.valueOf(currentRate),Double.valueOf(bidPrice),Integer.valueOf(bidVolume),
                Double.valueOf(askPrice),Integer.valueOf(askVolume),Integer.valueOf(marketVolume),Double.valueOf(marketCap));
        stockService.setNewStock(stock);
       return "home";
    }
    @RequestMapping(value="/bid")
    public String bid(){
        return "bid";
    }
    @RequestMapping(value="/setBid")
    public String setBid(@RequestParam("companyCode") String companyCode,@RequestParam("bidPrice") String bidPrice,
            @RequestParam("bidVolume") String bidVolume){
        stockService.setBid(companyCode, Double.valueOf(bidPrice), Integer.valueOf(bidVolume));
        return "home";
    }
    @RequestMapping(value="/ask")
    public String ask(){
        return "ask";
    }
    @RequestMapping(value="/setAsk")
    public String setAsk(@RequestParam("companyCode") String companyCode,@RequestParam("askPrice") String askPrice,
            @RequestParam("askVolume") String askVolume){
        stockService.setAsk(companyCode, Double.valueOf(askPrice), Integer.valueOf(askVolume));
        return "home";
    }
    @RequestMapping(value="/close")
    public String close(){
        return "prevclose";
    }
    @RequestMapping(value="/setPreviousClose")
    public String setPreviousClose(@RequestParam("companyCode") String companyCode,
            @RequestParam("previousClose") String previousClose){
        stockService.setPreviousClose(companyCode, Double.valueOf(previousClose));
        CompanyLog companyLog = new CompanyLog(companyCode,time(),companyServiceLog.getLastestCurrentRate(),
                Double.valueOf(previousClose),companyServiceLog.getLastestMarketCap(),
                companyServiceLog.getLastestVolumeBought(),companyServiceLog.getLastestMarketVolume());
        companyServiceLog.create(companyLog);
        return "home";
    }
    @RequestMapping(value="/setOpen")
    public String open(){
        return "open";
    }
    @RequestMapping(value="/setTodayOpen")
    public String setTodayOpen(@RequestParam("companyCode") String companyCode,
            @RequestParam("todayOpen") String todayOpen){
        stockService.setOpenRate(companyCode, Double.valueOf(todayOpen));
        CompanyLog companyLog = new CompanyLog(companyCode,time(),Double.valueOf(todayOpen),
                companyServiceLog.getLastestCloseRate(),companyServiceLog.getLastestMarketCap(),
                companyServiceLog.getLastestVolumeBought(),companyServiceLog.getLastestMarketVolume());
        companyServiceLog.create(companyLog);
        return "home";
    }
    @RequestMapping(value="/todayRate")
    public String todayRate(){
        return "current";
    }
    @RequestMapping(value="/setTodayRate")
    public String setTodayRate(@RequestParam("companyCode") String companyCode,@RequestParam("currentRate") String currentRate){       
        stockService.setCurrentRate(companyCode, Double.valueOf(currentRate));
        CompanyLog companyLog = new CompanyLog(companyCode,time(),Double.valueOf(currentRate),
                companyServiceLog.getLastestCloseRate(),companyServiceLog.getLastestMarketCap(),
                companyServiceLog.getLastestVolumeBought(),companyServiceLog.getLastestMarketVolume());
        companyServiceLog.create(companyLog);
        return "home";
    }
    @RequestMapping(value="/marketVolume")
    public String marketVolume(){
        return "marketVolume";
    }   
    @RequestMapping(value="/setMarketVolume")
    public String setmarketVolume(@RequestParam("companyCode") String companyCode,
            @RequestParam("marketVolume") String marketVolume){
        stockService.setMarketVolume(companyCode,Integer.valueOf(marketVolume));
        CompanyLog companyLog = new CompanyLog(companyCode,time(),companyServiceLog.getLastestCurrentRate(),
                companyServiceLog.getLastestCloseRate(),companyServiceLog.getLastestMarketCap(),
                companyServiceLog.getLastestVolumeBought(),Integer.valueOf("marketVolume"));
        companyServiceLog.create(companyLog);
        return "home";
    } 
    @RequestMapping(value="/marketCap")
    public String marketCap(){
        return "marketCap";
    }   
    @RequestMapping(value="/setMarketCap")
    public String setmarketCap(@RequestParam("companyCode") String companyCode,
            @RequestParam("marketCap") String marketCap){
        stockService.setMarketCap(companyCode,Double.valueOf(marketCap));
        CompanyLog companyLog = new CompanyLog(companyCode,time(),companyServiceLog.getLastestCurrentRate(),
                companyServiceLog.getLastestCloseRate(),Double.valueOf(marketCap),
                companyServiceLog.getLastestVolumeBought(),companyServiceLog.getLastestMarketVolume());
        companyServiceLog.create(companyLog);
        return "home";
    } 
    @RequestMapping(value="/delete")
    public String delete(){
        return "delete";
    }
    @RequestMapping(value="/deleteStock")
    public String deleteStock(@RequestParam("companyCode") String companyCode,@RequestParam("companyName") String companyName){
        stockService.delete(companyCode, companyName);
        CompanyLog companyLog = new CompanyLog(companyCode,time(),0,0,0,0,0);
        companyServiceLog.create(companyLog);
        return "home";
    }
    @RequestMapping(value="/buyStock")
    public String buyStock(){
        return "buyStock";
    }
    @RequestMapping(value="/buy")
    public String buy(@RequestParam("companyCode") String companyCode,@RequestParam("rate") String rate,
        @RequestParam("lastClose") String lastClose,@RequestParam("marketCap") String marketCap,
        @RequestParam("volumeBought") String volumeBought,@RequestParam("marketVolume") String marketVolume){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = sdfDate.format(date);
        companyServiceLog.create(new CompanyLog(companyCode,time,Double.valueOf(rate),
                Double.valueOf(lastClose),Double.valueOf(marketCap),Integer.valueOf(volumeBought),Integer.valueOf(marketVolume)));
        return "home";
    }
    @RequestMapping(value="/confirmSell")
    public String comfirmSell(ModelMap m){
        List<BuyersTable> buyersList = buyersTableService.getByStatus(false);
        m.addAttribute("buyersList", buyersList);
        return "confirmStockSell";
    }
    @RequestMapping(value="/confirmSellStock")
    public String confirmSellStock(@RequestParam("id") String id){
        BuyersTable buyT = buyersTableService.getById(Integer.valueOf(id));
        buyT.setStatus(true);
        buyersTableService.update(buyT);
        CompanyLog companyLog =  new CompanyLog(buyT.getStockCode(),time(),buyT.getBoughtPrice(),
                companyServiceLog.getLastestCurrentRate(),companyServiceLog.getLastestMarketCap(),
                buyT.getStockVolume(),companyServiceLog.getLastestMarketVolume());
        companyServiceLog.create(companyLog);
        Stock stock = stockService.getByCode(buyT.getStockCode());
        stock.setCurrentRate(buyT.getBoughtPrice());
        return "home";
    }
    
    public String time(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return sdfDate.format(date);}
}


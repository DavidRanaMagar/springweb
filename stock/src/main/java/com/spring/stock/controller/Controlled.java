
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
    
    @RequestMapping(value="/adminhome")
    public String adminHome(){
        return "adminHome";
    }
    @RequestMapping(value="/createStock")
    public String create(){
        return "insert";
    }
    @RequestMapping(value="/insertStock", method=RequestMethod.POST)
    public String insertStock(@RequestParam("companyName") String companyName,
    @RequestParam("companyCode") String companyCode,@RequestParam("currentRate") String currentRate,
    @RequestParam("previousClose") String previousClose,@RequestParam("todayOpen") String todayOpen,
    @RequestParam("bidPrice") String bidPrice,@RequestParam("bidVolume") String bidVolume,
    @RequestParam("askPrice") String askPrice,@RequestParam("askVolume") String askVolume,
    @RequestParam("marketVolume") String marketVolume, @RequestParam("marketCap") String marketCap,ModelMap m){
        try{
            CompanyLog c = new CompanyLog(companyCode.toUpperCase(),time(),Double.valueOf(currentRate),Double.valueOf(previousClose),
                Double.valueOf(marketCap),0,Integer.valueOf(marketVolume));
            companyServiceLog.create(c);
            Stock stock = new Stock(companyName,companyCode.toUpperCase(),Double.valueOf(previousClose),Double.valueOf(todayOpen),
                Double.valueOf(currentRate),Double.valueOf(bidPrice),Integer.valueOf(bidVolume),
                Double.valueOf(askPrice),Integer.valueOf(askVolume),Integer.valueOf(marketVolume),Double.valueOf(marketCap));
            stockService.setNewStock(stock);
            return "home";
        }catch( Exception e){
            return "insert";
        }
    }
    @RequestMapping(value="/bid")
    public String bid(){
        return "bid";
    }
    @RequestMapping(value="/setBid", method=RequestMethod.POST)
    public String setBid(@RequestParam("companyCode") String companyCode,@RequestParam("bidPrice") String bidPrice,
            @RequestParam("bidVolume") String bidVolume){
        try{
            stockService.setBid(companyCode.toUpperCase(), Double.valueOf(bidPrice), Integer.valueOf(bidVolume));
            return "home";
        }catch(Exception e){
            return "bid";
        }
    }
    @RequestMapping(value="/ask")
    public String ask(){
        return "ask";
    }
    @RequestMapping(value="/setAsk", method=RequestMethod.POST)
    public String setAsk(@RequestParam("companyCode") String companyCode,@RequestParam("askPrice") String askPrice,
            @RequestParam("askVolume") String askVolume){
        try{
            stockService.setAsk(companyCode.toUpperCase(), Double.valueOf(askPrice), Integer.valueOf(askVolume));
            return "home";
        }catch(Exception e){
            return "ask";
        }
    }
    @RequestMapping(value="/close")
    public String close(){
        return "prevclose";
    }
    @RequestMapping(value="/setPreviousClose", method=RequestMethod.POST)
    public String setPreviousClose(@RequestParam("companyCode") String companyCode,
            @RequestParam("previousClose") String previousClose){
        try{
            stockService.setPreviousClose(companyCode.toUpperCase(), Double.valueOf(previousClose));
            CompanyLog companyLog = new CompanyLog(companyCode.toUpperCase(),time(),companyServiceLog.getLastestCurrentRate(),
                Double.valueOf(previousClose),companyServiceLog.getLastestMarketCap(),
                companyServiceLog.getLastestVolumeBought(),companyServiceLog.getLastestMarketVolume());
            companyServiceLog.create(companyLog);
        return "home";
        }catch(Exception e){
            return "prevclose";
        }
    }
    @RequestMapping(value="/setOpen")
    public String open(){
        return "open";
    }
    @RequestMapping(value="/setTodayOpen", method=RequestMethod.POST)
    public String setTodayOpen(@RequestParam("companyCode") String companyCode,
            @RequestParam("todayOpen") String todayOpen){
        try{
            stockService.setOpenRate(companyCode.toUpperCase(), Double.valueOf(todayOpen));
            CompanyLog companyLog = new CompanyLog(companyCode.toUpperCase(),time(),Double.valueOf(todayOpen),
                companyServiceLog.getLastestCloseRate(),companyServiceLog.getLastestMarketCap(),
                companyServiceLog.getLastestVolumeBought(),companyServiceLog.getLastestMarketVolume());
            companyServiceLog.create(companyLog);
            return "home";
        }catch(Exception e){
            return "open";
        }
    }
    @RequestMapping(value="/todayRate")
    public String todayRate(){
        return "current";
    }
    @RequestMapping(value="/setTodayRate", method=RequestMethod.POST)
    public String setTodayRate(@RequestParam("companyCode") String companyCode,@RequestParam("currentRate") String currentRate){
        try{
            stockService.setCurrentRate(companyCode.toUpperCase(), Double.valueOf(currentRate));
            CompanyLog companyLog = new CompanyLog(companyCode.toUpperCase(),time(),Double.valueOf(currentRate),
                companyServiceLog.getLastestCloseRate(),companyServiceLog.getLastestMarketCap(),
                companyServiceLog.getLastestVolumeBought(),companyServiceLog.getLastestMarketVolume());
            companyServiceLog.create(companyLog);
            return "home";
        }catch(Exception e){
            return "current";
        }
    }
    @RequestMapping(value="/marketVolume")
    public String marketVolume(){
        return "marketVolume";
    }   
    @RequestMapping(value="/setMarketVolume", method=RequestMethod.POST)
    public String setmarketVolume(@RequestParam("companyCode") String companyCode,
            @RequestParam("marketVolume") String marketVolume){
        try{
            stockService.setMarketVolume(companyCode.toUpperCase(),Integer.valueOf(marketVolume));
            CompanyLog companyLog = new CompanyLog(companyCode.toUpperCase(),time(),companyServiceLog.getLastestCurrentRate(),
                companyServiceLog.getLastestCloseRate(),companyServiceLog.getLastestMarketCap(),
                companyServiceLog.getLastestVolumeBought(),Integer.valueOf("marketVolume"));
            companyServiceLog.create(companyLog);
            return "home";
        }catch(Exception e){
            return "marketVolume";
        }
    } 
    @RequestMapping(value="/marketCap")
    public String marketCap(){
        return "marketCap";
    }   
    @RequestMapping(value="/setMarketCap", method=RequestMethod.POST)
    public String setmarketCap(@RequestParam("companyCode") String companyCode,
            @RequestParam("marketCap") String marketCap){
        try{
            stockService.setMarketCap(companyCode.toUpperCase(),Double.valueOf(marketCap));
            CompanyLog companyLog = new CompanyLog(companyCode.toUpperCase(),time(),companyServiceLog.getLastestCurrentRate(),
                companyServiceLog.getLastestCloseRate(),Double.valueOf(marketCap),
                companyServiceLog.getLastestVolumeBought(),companyServiceLog.getLastestMarketVolume());
            companyServiceLog.create(companyLog);
            return "home";
        }catch(Exception e){
            return "marketCap";
        }
    } 
    @RequestMapping(value="/delete")
    public String delete(){
        return "delete";
    }
    @RequestMapping(value="/deleteStock", method=RequestMethod.POST)
    public String deleteStock(@RequestParam("companyCode") String companyCode,@RequestParam("companyName") String companyName){
        try{
            stockService.delete(companyCode.toUpperCase(), companyName);
            CompanyLog companyLog = new CompanyLog(companyCode.toUpperCase(),time(),0,0,0,0,0);
            companyServiceLog.create(companyLog);
            return "home";
        }catch(Exception e){
            return "delete";
        }
    }
    @RequestMapping(value="/buyStock")
    public String buyStock(){
        return "buyStock";
    }
    @RequestMapping(value="/buy", method=RequestMethod.POST)
    public String buy(@RequestParam("companyCode") String companyCode,@RequestParam("rate") String rate,
        @RequestParam("lastClose") String lastClose,@RequestParam("marketCap") String marketCap,
        @RequestParam("volumeBought") String volumeBought,@RequestParam("marketVolume") String marketVolume){
        try{
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String time = sdfDate.format(date);
            companyServiceLog.create(new CompanyLog(companyCode.toUpperCase(),time,Double.valueOf(rate),
                Double.valueOf(lastClose),Double.valueOf(marketCap),Integer.valueOf(volumeBought),Integer.valueOf(marketVolume)));
            return "home";
        }catch(Exception e){
            return "buyStock";
        }
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
        return "confirmSell";
    }
    
    public String time(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return sdfDate.format(date);}
}


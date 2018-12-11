
package com.spring.stock.controller;

import com.spring.stock.entity.BuyersTable;
import com.spring.stock.entity.Roles;
import com.spring.stock.entity.Stock;
import com.spring.stock.entity.UserInfo;
import com.spring.stock.entity.Users;
import com.spring.stock.services.BuyersTableService;
import com.spring.stock.services.RolesService;
import com.spring.stock.services.StockService;
import com.spring.stock.services.UserInfoService;
import com.spring.stock.services.UsersService;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PagesController {
    
    private StockService stockImp;
    private UsersService userService;
    private RolesService roleService;
    private UserInfoService userInfoService;
    private BuyersTableService buyerService;
    @Autowired
    public PagesController(StockService stockImp, UsersService userService, RolesService roleService,
            UserInfoService userInfoService,BuyersTableService buyerService) {
        this.stockImp = stockImp;
        this.userService = userService;
        this.roleService = roleService;
        this.userInfoService = userInfoService;
        this.buyerService = buyerService;
    }
    
    @RequestMapping(value="/")
    public String home(){
        return "home";
    }
    @RequestMapping(value="/getByName")
    public String stockByName(@RequestParam("companyName") String name, ModelMap m){
        Stock stock = stockImp.getByName(name);
        m.addAttribute("stock", stock);
        return "stock";
    }
    @RequestMapping(value="/getByCode")
    public String stockByCode(@RequestParam("companyCode") String code, ModelMap m){
        Stock stock = stockImp.getByCode(code);
        m.addAttribute("stock", stock);
        return "stock";
    }
    @RequestMapping(value="/showAll")
    public String showAll(ModelMap m){
        
        List<Stock> stockList = stockImp.getAll();
        m.addAttribute("stockList",stockList );
        return "showall";
    }
    @RequestMapping("/loginPage")
    public String login(){
        return "login";
    }
    @RequestMapping("/loginUser")
    public String createUser(@RequestParam("email") String email,@RequestParam("password") String password,
            @RequestParam("address") String address,@RequestParam("age") String age,
            @RequestParam("contactNo") String contactNo,@RequestParam("name") String name){
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        String epassword = pe.encode(password);
        Set<Roles> roles = new HashSet<Roles>();
        roles.add(roleService.getById(2));
        UserInfo uInfo= new UserInfo(email,name,address,Integer.valueOf(age),contactNo);
        Users user = new Users(email,epassword,roles);
        userInfoService.create(uInfo);
        userService.create(user);
        return "home";
    }
    @RequestMapping("/userDelete")
    public String delete(){
        return "userDelete";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("email") String email, @RequestParam("password") String password){
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        String epassword = pe.encode(password);
        userService.delete(email,epassword);
        return "home";
    }
    @RequestMapping("/userStock")
    public String userStock(ModelMap m, Principal principal){
        String userName = principal.getName();
        List<BuyersTable> buyerList = buyerService.getByUserEmailAndStatus(userName,true);
        Set codes = new HashSet();
        for(BuyersTable var: buyerList){
            codes.add(var.getStockCode());
        }
        List<Stock> stockList = stockImp.getByCode(codes);
        m.addAttribute("buyerList", buyerList);
        m.addAttribute("stockList", stockList);
        return "userStock";
    }
    @RequestMapping("/userBuyStock")
    public String userBuyStock(){
        return "userBuyStock";
    }
    @RequestMapping("/userStockBought")
    public String userStockBought(@RequestParam("userEmail") String userEmail,
            @RequestParam("companyCode") String companyCode, @RequestParam("boughtPrice") String boughtPrice,
            @RequestParam("stockVolume") String stockVolume){
        Stock stock = stockImp.getByCode(companyCode);
        Users user = userService.getByEmail(userEmail);
        if (stock.equals(null)||user.equals(null)){
         System.out.println("error");   
           
        }else{
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String time = sdfDate.format(date);
            BuyersTable buyer=new BuyersTable(userEmail,companyCode,Double.valueOf(boughtPrice),Integer.valueOf(stockVolume),time,false);
            buyerService.create(buyer);
        }
        return "home";
    }
    
}

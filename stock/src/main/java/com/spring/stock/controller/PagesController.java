
package com.spring.stock.controller;

import com.spring.stock.entity.Roles;
import com.spring.stock.entity.Stock;
import com.spring.stock.entity.Users;
import com.spring.stock.services.RolesService;
import com.spring.stock.services.StockService;
import com.spring.stock.services.UsersService;
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
    @Autowired
    public PagesController(StockService stockImp, UsersService userService, RolesService roleService) {
        this.stockImp = stockImp;
        this.userService = userService;
        this.roleService = roleService;
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
    @RequestMapping("/loign")
    public String login(){
        return "login";
    }
    @RequestMapping("/loginUser")
    public String createUser(@RequestParam("email") String email,@RequestParam("password") String password){
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        String epassword = pe.encode(password);
        Set<Roles> roles = new HashSet<Roles>();
        roles.add(roleService.getById(2));
        Users user = new Users(email,epassword,roles);
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

}

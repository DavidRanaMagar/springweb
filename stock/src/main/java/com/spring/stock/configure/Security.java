
package com.spring.stock.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class Security extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService udi;
    
    @Autowired 
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
        auth.userDetailsService(udi).passwordEncoder(pw);
    }
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/","/getByName","/getByCode","/showAll","/loignPage","/loginUser","/assets/**")
            .permitAll()
            .antMatchers("/userDelete","/deleteUser","/userStockBought","/userBuyStock","/userStock").hasAnyRole("ADMIN","USER")
            .antMatchers("/createStock","/insertStock","/bid"
            ,"/setBid","/ask","/setAsk","/close","/setPreviousClose"
            ,"/setOpen","/setTodayOpen","/todayRate","/setTodayRate",
            "/marketVolume","/setMarketVolume","/marketCap","/setMarketCap",
            "/delete","/deleteStock","/buyStock","/buy","/confirmSell","/confirmSellStock").hasAnyRole("ADMIN")
               .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
        
    }
   
}

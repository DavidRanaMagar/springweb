
package com.spring.stock.controller;

import java.security.Principal;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
    public final String path = "/error"; 

    @Override
    public String getErrorPath() {
        return path;
    }
    @RequestMapping(value=path)
    public String errorHandle(HttpServletRequest request, Principal principal){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status!=null){
            return "errorpage";
        }else{
            return "/";
        }  
    }
    
}

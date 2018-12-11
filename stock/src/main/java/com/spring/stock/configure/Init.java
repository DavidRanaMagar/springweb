
package com.spring.stock.configure;

import com.spring.stock.entity.Roles;
import com.spring.stock.entity.Users;
import com.spring.stock.services.RolesService;
import com.spring.stock.services.UsersService;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Init{
    private UsersService userService;
    private RolesService roleService;
    
    @Autowired
    public Init(UsersService userService, RolesService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    
    @PostConstruct
    public void user(){
        Users user = userService.getByEmail("Admin");
        if (user.equals(null)){
            BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
            String epassword = pe.encode("root");
            Set<Roles> roles = new HashSet<Roles>();
            roles.add(roleService.getById(1));
            roles.add(roleService.getById(2));
            Users userA = new Users("Admin",epassword,roles);
            userService.create(userA);
        }else{
            System.out.println("error");
        }
    }
}

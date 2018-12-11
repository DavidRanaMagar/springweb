
package com.spring.stock.services;

import com.spring.stock.dao.UsersDao;
import com.spring.stock.entity.UserDetailsImpl;
import com.spring.stock.entity.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService, UserDetailsService {
    
    private UsersDao userDao;

    @Autowired
    public UsersServiceImpl(UsersDao userDao) {
        this.userDao = userDao;
    }
    
    
    @Override
    public List<Users> findAll() {
        List<Users> userList = userDao.findAll();
        return userList;
    }

    @Override
    public Users getById(int id) {
        Users user = userDao.findById(id);  
        return user;
    }

    @Override
    public void delete(String username, String password) {
        Users user = userDao.findByEmail(username);
        if(user.equals(null)){
            throw new UsernameNotFoundException(username+"not found");
        }
        if (user.getPassword().equals(password)){
            userDao.delete(user);
        }
        
    }

    @Override
    public void create(Users user) {
        userDao.save(user);
        
    }

    @Override
    public void update(Users user) {
        userDao.save(user);
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.findByEmail(username);
        if (user.equals(null)){
            throw new UsernameNotFoundException(username+"not found");
        }
        return new UserDetailsImpl(user);
    }

    @Override
    public Users getByEmail(String email) {
        Users user = userDao.findByEmail(email);
        return user;
    }
    
    
}

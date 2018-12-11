
package com.spring.stock.services;

import com.spring.stock.entity.Users;
import java.util.List;


public interface UsersService {
    public List<Users> findAll();
    public Users getById(int id);
    public void delete(String username, String password);
    public void create(Users user);
    public void update(Users user);
    public Users getByEmail(String email);
    
}

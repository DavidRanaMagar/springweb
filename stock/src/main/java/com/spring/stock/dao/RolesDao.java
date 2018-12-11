
package com.spring.stock.dao;

import com.spring.stock.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesDao extends JpaRepository<Roles,Integer>{
    public Roles findById(int id);
    public void save(String role);
    
}

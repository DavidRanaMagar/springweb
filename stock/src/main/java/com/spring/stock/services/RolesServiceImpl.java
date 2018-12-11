
package com.spring.stock.services;

import com.spring.stock.dao.RolesDao;
import com.spring.stock.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService{

    private RolesDao rolesDao;
    @Autowired
    public RolesServiceImpl(RolesDao rolesDao) {
        this.rolesDao = rolesDao;
    }
    
    @Override
    public Roles getById(int id) {
        Roles role= rolesDao.findById(id);
        return role;
    }

    @Override
    public void save(String role) {
        rolesDao.save(role);
    }
    
}

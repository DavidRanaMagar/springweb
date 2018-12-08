/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.stock.dao;

import com.spring.stock.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author GOAT
 */
public interface RolesDao extends JpaRepository<Roles,Integer>{
    public Roles findById(int id);
    
}

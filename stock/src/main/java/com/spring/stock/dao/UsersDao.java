/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.stock.dao;

import com.spring.stock.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author GOAT
 */
public interface UsersDao extends JpaRepository<Users, Integer> {

    public Users findByEmail(String username);
    public Users findById(int id);
}

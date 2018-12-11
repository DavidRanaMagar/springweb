
package com.spring.stock.dao;

import com.spring.stock.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users, Integer> {

    public Users findByEmail(String username);
    public Users findById(int id);
}

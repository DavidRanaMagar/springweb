package com.spring.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.stock.entity.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo,Integer> {
 public UserInfo findById(int id);
}

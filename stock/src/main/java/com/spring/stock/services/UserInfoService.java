package com.spring.stock.services;

import java.util.List;

import com.spring.stock.entity.UserInfo;


public interface UserInfoService {
 public void create(UserInfo userInfo);
 public void update(UserInfo userInfo);
 public void delete(UserInfo userInfo);
 public List<UserInfo> getAll();
 public UserInfo getById(int id);
}

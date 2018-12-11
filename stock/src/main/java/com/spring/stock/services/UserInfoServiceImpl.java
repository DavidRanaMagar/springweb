package com.spring.stock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.stock.dao.UserInfoDao;
import com.spring.stock.entity.UserInfo;
@Service
public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDao userInfoDao;
	@Autowired
	public UserInfoServiceImpl(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void create(UserInfo userInfo) {
		userInfoDao.save(userInfo);

	}

	@Override
	public void update(UserInfo userInfo) {
		userInfoDao.save(userInfo);

	}

	@Override
	public void delete(UserInfo userInfo) {
		userInfoDao.delete(userInfo);

	}

	@Override
	public List<UserInfo> getAll() {
		List<UserInfo> userInfoList = userInfoDao.findAll();
		return userInfoList;
	}

	@Override
	public UserInfo getById(int id) {
		UserInfo userInfo = userInfoDao.findById(id);
		return userInfo;
	}

}

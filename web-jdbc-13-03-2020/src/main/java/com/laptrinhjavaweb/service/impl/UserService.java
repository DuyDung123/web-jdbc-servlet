package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDAO;
	
	@Inject
	private IRoleDAO roleDAO;
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		RoleModel roleModel = roleDAO.findOneByCode("USER");
		userModel.setStatus(1);
		userModel.setRoleId(roleModel.getId());
		Long newId = userDAO.save(userModel);
		return userDAO.findOne(newId);
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		return userDAO.findAll(pageble);
	}

}

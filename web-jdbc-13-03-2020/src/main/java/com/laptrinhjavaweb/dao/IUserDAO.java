package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	UserModel findOne(Long id);
	Long save(UserModel userModel);
}

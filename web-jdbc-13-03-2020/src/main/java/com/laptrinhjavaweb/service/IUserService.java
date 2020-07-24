package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	UserModel save(UserModel userModel);
	List<UserModel> findAll(Pageble pageble);
}

package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("select * from user as u");
		sql.append(" inner join role as r on r.id = u.roleid");
		sql.append(" where username = ? and password = ? and status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("insert into user(username,password,fullname,status, roleid)");
		sql.append(" values(?, ?, ?, ?, ?)");
		return insert(sql.toString(), userModel.getUserName(), userModel.getPassword(), userModel.getFullName(),
				userModel.getStatus(), userModel.getRoleId());
	}

	@Override
	public UserModel findOne(Long id) {
		String sql="select * from user where id = ?";
		List<UserModel> news = query(sql, new UserMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

}

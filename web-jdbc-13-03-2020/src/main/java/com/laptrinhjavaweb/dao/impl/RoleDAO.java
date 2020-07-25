package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.mapper.RoleMapper;
import com.laptrinhjavaweb.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{

	@Override
	public RoleModel findOneByCode(String code) {
		String sql="SELECT * FROM role where code= ?";
		List<RoleModel> roleModel = query(sql,new RoleMapper(), code);
		return roleModel.isEmpty() ? null : roleModel.get(0);
	}

	@Override
	public List<RoleModel> findAll() {
		String sql="SELECT * FROM role";
		return query(sql, new RoleMapper());
	}

}

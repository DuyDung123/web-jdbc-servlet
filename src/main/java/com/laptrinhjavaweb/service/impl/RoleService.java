package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.service.IRoleService;

public class RoleService implements IRoleService {

	@Inject
	IRoleDAO roleDao;
	
	@Override
	public List<RoleModel> findAll() {
		return roleDao.findAll();
	}

}

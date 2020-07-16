package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.RoleModel;

public interface IRoleDAO {
	RoleModel findOneByCode(String code);
}

package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

import com.laptrinhjavaweb.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel> {

	@Override
	public RoleModel mapRow(ResultSet resultSet) {
		try {
			RoleModel roles = new RoleModel();
			roles.setId(resultSet.getLong("id"));
			roles.setName(resultSet.getString("name"));
			roles.setName(resultSet.getString("code"));
			roles.setCreatedDate(resultSet.getTimestamp("createddate"));
			roles.setCreatedBy(resultSet.getString("createdby"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				roles.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				roles.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return roles;
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

}

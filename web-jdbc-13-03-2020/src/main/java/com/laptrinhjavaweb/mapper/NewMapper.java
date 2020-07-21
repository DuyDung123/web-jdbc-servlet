package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel news = new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setView(resultSet.getLong("view"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			try {
				CategoryModel category = new CategoryModel();
				category.setId(resultSet.getLong("id"));
				if (resultSet.getString("code") != null) {
					category.setCode(resultSet.getString("code"));
				}
				if (resultSet.getString("name") != null) {
					category.setName(resultSet.getString("name"));
				}
				news.setCategory(category);
			} catch (Exception e) {
				System.out.println(e.getMessage()+"new mapper");
			}
			return news;
		} catch (SQLException e) {
			return null;
		}
	}

}

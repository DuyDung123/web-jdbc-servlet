package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICommentDAO;
import com.laptrinhjavaweb.model.CommentModel;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO {

	@Override
	public void delete(long id) {
		String sql = "delete from comment where new_id = ?";
		update(sql, id);
	}

}

package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {
	NewModel findOne(long id);
	List<NewModel> findByCategoryId( Long categoryId);
	List<NewModel> findThreeItems( CategoryModel categoryModel);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> finldAll(Pageble pageble);
	List<NewModel> finldAll();
	int getTotalItem();
}

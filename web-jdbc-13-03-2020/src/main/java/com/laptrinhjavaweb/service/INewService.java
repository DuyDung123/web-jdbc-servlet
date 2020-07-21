package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewService {
	
	List<NewModel> findByCategoryId(Long categoryId); //seclect
	public List<NewModel> findThreeItems(CategoryModel categoryModel);
	NewModel save(NewModel newModel); // save bài viết bào database
	NewModel update(NewModel updateNew);
	void delete(Long[] ids );
	List<NewModel> findAll(Pageble pageble);
	List<NewModel> finldAll();
	int getTotalItem();
	NewModel findOne(long id);
	NewModel findOneAndUpdateView(long id);
}

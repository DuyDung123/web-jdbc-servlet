package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewServive implements INewService{
	
	@Inject
	private INewDAO newDao;
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {

		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDao.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel olNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(olNew.getCreatedDate());
		updateNew.setCreatedBy(olNew.getCreatedBy());
		updateNew.setView(olNew.getView());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDao.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id: ids) {
			//del comment trước(khóa ngoại là new_id)
			//sau đó mới del được news
			newDao.delete(id);
		}
		
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDao.finldAll(pageble);
	}
	
	@Override
	public List<NewModel> finldAll() {
		return newDao.finldAll();
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}

	@Override
	public NewModel findOneAndUpdateView(long id) {
		NewModel olNew = newDao.findOne(id);
		olNew.setView(olNew.getView()+1);
		CategoryModel categoryModel = categoryDao.findOne(olNew.getCategoryId());
		olNew.setCategoryCode(categoryModel.getCode());
		newDao.update(olNew);
		return olNew;
	}
}

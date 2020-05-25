package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 8863195775975450179L;

	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryModel categoryModel = FormUtil.toModel(CategoryModel.class, request);
		String view = "";
		if(categoryModel.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(categoryModel.getPage(), categoryModel.getMaxPageItem(),
					new Sorter(categoryModel.getSortName(), categoryModel.getSortBy()));
			categoryModel.setListResult(categoryService.findAllAndSort(pageble));
			categoryModel.setTotalItem(categoryService.getTotalItem());
			categoryModel.setTotalPage((int) Math.ceil((double) categoryModel.getTotalItem() / categoryModel.getMaxPageItem()));
			view = "/views/admin/category/list.jsp";
		}else if(categoryModel.getType().equals(SystemConstant.EDIT)) {
			if(categoryModel.getId() != null) {
				categoryModel = categoryService.findOne(categoryModel.getId());
			}
			view = "/views/admin/category/edit.jsp";
		}
		request.setAttribute("categories", categoryModel);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}

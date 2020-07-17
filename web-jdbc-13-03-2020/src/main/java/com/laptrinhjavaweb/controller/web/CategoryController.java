package com.laptrinhjavaweb.controller.web;

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
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.impl.NewServive;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/category" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 2134891590604947983L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private NewServive newService;

//	@Inject
//	private NewModel newModel;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewModel newModel = FormUtil.toModel(NewModel.class, request);
		String category = request.getParameter("category");
		String view = "";
		if (category != null) {
			CategoryModel categoryModel = categoryService.findOneByCode(category);
			newModel.setListResult(newService.findByCategoryId(categoryModel.getId()));
			request.setAttribute("categoryTabBar", categoryModel);
			view = "views/web/category.jsp";
		} else {
			if (newModel.getId() != null) {
				newModel = newService.findOne(newModel.getId());
				request.setAttribute("categoryTabBar", categoryService.findOne(newModel.getCategoryId()));
				view = "/views/web/new-detail.jsp";
			}
		}
		request.setAttribute("categories", categoryService.findAll());
		request.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}

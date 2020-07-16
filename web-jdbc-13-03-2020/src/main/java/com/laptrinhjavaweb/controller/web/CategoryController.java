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

@WebServlet(urlPatterns = { "/category" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 2134891590604947983L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private NewServive newService;
	
	@Inject
	private NewModel newModel;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
//		CategoryModel categoryModel = categoryService.findOneByCode(category);
		newModel.setListResult(newService.finldAll());
		req.setAttribute("categoryTabBar", category);
		req.setAttribute("categories", categoryService.findAll());
		req.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/web/category.jsp");
		dispatcher.forward(req, resp);
	}
}

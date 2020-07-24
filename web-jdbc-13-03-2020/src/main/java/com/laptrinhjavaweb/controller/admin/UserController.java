package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 2627812500482784082L;
	
	@Inject
	IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel userModel = FormUtil.toModel(UserModel.class, request);
		String view = "";
		if(userModel.getType() != null && userModel.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(userModel.getPage(),userModel.getMaxPageItem(),
					new Sorter(userModel.getSortName(), userModel.getSortBy()));
			userModel.setListResult(userService.findAll(pageble));
		}
	}
}

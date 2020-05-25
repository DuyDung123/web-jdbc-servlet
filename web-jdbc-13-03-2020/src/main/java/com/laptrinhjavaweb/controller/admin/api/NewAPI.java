package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.SessionUtil;
import com.laptrinhjavaweb.utils.httpUtil;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet{
	
	@Inject
	private INewService newService;
	private static final long serialVersionUID = -915988021506484384L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel newModel = httpUtil.of(request.getReader()).toModel(NewModel.class);//httpUtil.of(request.getReader()).toModel(NewModel.class) hỗ trợ pase json sang cái newmodel
		newModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		newModel = newService.save(newModel);
		mapper.writeValue(response.getOutputStream(), newModel); // phản hồi lại cho clent một chuỗi json
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel updateNew = httpUtil.of(request.getReader()).toModel(NewModel.class);
		updateNew.setModifiedBy((((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName()));
		updateNew = newService.update(updateNew);
		mapper.writeValue(response.getOutputStream(), updateNew); // phản hồi lại cho clent một chuỗi json
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel newModel = httpUtil.of(request.getReader()).toModel(NewModel.class);
		newService.delete(newModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}"); // phản hồi lại cho clent một chuỗi json
	}
}

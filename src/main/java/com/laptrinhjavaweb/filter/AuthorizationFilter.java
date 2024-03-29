package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	// để sử dụng được cái class bộ lọc này thì cần phải khai báo nó trong web-INF/web.xml
	//sử dụng cơ chế servletmapping là cơ chế gọi controler của servlet
	
	 private ServletContext context;

	    @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	        this.context = filterConfig.getServletContext();
	    }

	    @Override
	    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	        HttpServletRequest request = (HttpServletRequest) servletRequest;
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        String url = request.getRequestURI();
	        if (url.startsWith("/web-jdbc-13-03-2020/admin")) {
	        	// nếu phải là url trang admin thì phải kiểm tra xem đã đang nhập chưa
	            UserModel model = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
	            if (model != null) {
	                if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
	                    filterChain.doFilter(servletRequest, servletResponse);
	                } else if (model.getRole().getCode().equals(SystemConstant.USER)) {
	                    response.sendRedirect(request.getContextPath()+("/dang-nhap?action=login&message=not_permission&alert=danger"));
	                }
	            } else {
	                response.sendRedirect(request.getContextPath()+("/dang-nhap?action=login&message=not_login&alert=danger"));
	            }
	        } else {
	            filterChain.doFilter(servletRequest, servletResponse); // k phải link trang admin thì cho qua
	        }
	    }

	    @Override
	    public void destroy() {
			 
	    }
}
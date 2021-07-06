package com.laptrinhjavaweb.controller.admin;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/admin-new/UploadFileServlet" })
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class UploadFileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		List<String> namefile = new ArrayList<String>();
	    
	    ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		
		for (Part part : request.getParts()) {
			part.write(contextPath+"\\common\\file\\" + part.getSubmittedFileName());
			namefile.add("\\common\\file\\" + part.getSubmittedFileName());
	    }
		
	    response.getWriter().println("The file uploaded sucessfully.");
	    
	    for(String str : namefile) {
	    	 response.getWriter().println(getBaseUrl(request)+str);
	    }
	    
	}
	
	
	public static String getBaseUrl(HttpServletRequest request) {
	    String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	  }
	
	
	public static void saveFileUpload(HttpServletRequest request) {
		
		ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> multifile = fileUpload.parseRequest(request);
			for(FileItem item : multifile) {
				item.write(new File("D:\\chorme\\"+ item.getName()));
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

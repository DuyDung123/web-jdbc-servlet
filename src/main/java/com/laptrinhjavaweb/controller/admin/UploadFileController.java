package com.laptrinhjavaweb.controller.admin;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
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
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

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
	
	
	@Inject private INewService newServive;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		
		String path = contextPath +"\\common\\file\\";
		String fileName = "demo-apache-apoi-word";
		
		NewModel newModel = newServive.findOne(35);
		WriteFileDocx writeFileDocx = new WriteFileDocx();
		
		writeFileDocx.writeLineText(newModel.getTitle());
		writeFileDocx.writeLineText(newModel.getCategoryCode());
		writeFileDocx.writeLineText(newModel.getThumbnail());
		writeFileDocx.writeLineText(newModel.getShortDescription());
		writeFileDocx.writeLineText(newModel.getContent());
			
		
		
//		writeFileDocx.writeLineText("Paragraph 1: stackjava.com");
//		writeFileDocx.writeLineText("Paragraph 2: demo read/write file MS-Word");
		writeFileDocx.addPage();
		writeFileDocx.writeLineText("ssssssssssssssss");
		writeFileDocx.writeFile(path,fileName);
		String result = writeFileDocx.close();
		response.getWriter().println(result);
		response.getWriter().println(getBaseUrl(request)+"\\common\\file\\"+fileName+".docx");
	}
	
	
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
	
	
	private class WriteFileDocx{
		
		XWPFDocument document = null;
		FileOutputStream out = null;
		 
		public WriteFileDocx() {
			document = new XWPFDocument(); 
		}
		
		public void writeLineText(String text) {
			XWPFParagraph paragraph1 = document.createParagraph();
			XWPFRun run = paragraph1.createRun();
		    run.setText(text);
		}
		
		public void writeFile(String path, String namefile){
			try {
				out = new FileOutputStream(new File(path + namefile + ".docx"));
				document.write(out);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void fontText() {
			XWPFParagraph paragraph1 = document.createParagraph();
			XWPFRun run = paragraph1.createRun();
		    run.setFontFamily("Times New Roman");
		}
		
		public void addPage() {
			XWPFParagraph paragraph1 = document.createParagraph();
			XWPFRun run = paragraph1.createRun();
		    run.addBreak(BreakType.PAGE);
		}
		
		public String close() {
			try {
				out.close();
			    document.close();
			    return "successully";
			} catch (IOException e) {
				e.printStackTrace();
				return "fail";
			}
		}
	}


}

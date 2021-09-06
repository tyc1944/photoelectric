package com.electric.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet("/UploadProductServlet")
public class UploadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		SmartUpload su = new SmartUpload();//实例化对象
		su.initialize(this.getServletConfig(), request, response);//初始化
		String fileName="";
		try {
			su.upload();
			Files files = su.getFiles();//获取所有文件域上传的文件
			File file=files.getFile(0);//因为只有一个图片文件
			if(!file.isMissing()){
				//给上传的文件取新名字，防止图片名称相同而产生的文件覆盖问题
				fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"_"+new Random().nextInt(99999999)+"."+file.getFileExt();
	
				file.saveAs("images/picImages/"+fileName,File.SAVEAS_VIRTUAL);//把上传的文件保存到服务器上
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		out.print("{\r\n" + 
				"  \"code\": 0 \r\n" + 
				"  ,\"msg\": \"图片上传成功\" \r\n" + 
				"  ,\"data\": {\r\n" + 
				"    \"src\": \""+fileName+"\"\r\n" + 
				"  }\r\n" + 
				"}");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

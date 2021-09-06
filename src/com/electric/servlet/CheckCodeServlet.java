package com.electric.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int width = 100,height = 50;
        //1. 创建一个对象，在内存中生成图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2. 美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();   //画笔对象
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);

        //2.2 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        //2.3 生成随机字符
        String checkCodeTarget="";
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random ran = new Random();
        for (int i = 1; i <= 4 ; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(ch+"",width/5*i,height/2);
            checkCodeTarget+=ch;
        }

        //2.4 画干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //3.把验证码储存到session中
        request.getSession().setAttribute("checkcode", checkCodeTarget);//把验证码储存到会话session中
        
        //4. 将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

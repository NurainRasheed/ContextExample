package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */

public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			ServletContext context=getServletContext();
			Enumeration<String> en=context.getInitParameterNames();
			String str=" ";
			while(en.hasMoreElements()) {
				str=en.nextElement();
			pw.print("<br>"+context.getInitParameter(str));
			}
		
			context.setAttribute("company", "FULL");
			pw.println("<a href='next'><br/>visit next page</a>");
			pw.close();
		}catch(Exception e) {
		System.out.println(e);
		}
	}
}

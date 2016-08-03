package com.code.knight.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.knight.dto.User;
import com.code.knight.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Handle Login Hit", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		 
		String userName = request.getParameter("Username");
		String userPwd = request.getParameter("Password");
		
	     LoginService loginService = new LoginService();
	     boolean result = loginService.authencateUser(userName, userPwd);
	     User user = loginService.getUserByUserId(userName);
	     if(result == true){
	    	 String name = user.getUserName();
	    	 String userLoginMessge = "Welcome "+name;
			 request.setAttribute("name", userLoginMessge);
			 request.getRequestDispatcher("index.jsp").forward(request,response);
	     }
	     else{
	         response.sendRedirect("error.jsp");
	     }
	
	}

}

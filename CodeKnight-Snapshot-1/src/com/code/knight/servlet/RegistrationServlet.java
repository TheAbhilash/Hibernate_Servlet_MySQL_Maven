package com.code.knight.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.knight.dto.User;
import com.code.knight.service.RegisterService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		 
		String userName = request.getParameter("Username");
		String userPwd_1 = request.getParameter("Password_1");
		String userPwd_2 = request.getParameter("Password_2");
		
		if(userPwd_1.equals(userPwd_2)){
			User user = new User();
			user.setUserName(userName);
			user.setPassword(userPwd_2);
			userPwd_1 = null;			
			RegisterService registerService = new RegisterService();
	        boolean result = registerService.register(user);
	        String message = "User Has Been Successfully Registered.";
		    request.setAttribute("message", message);
		    request.getRequestDispatcher("index.jsp").forward(request,response);
	         
		}else{
			 //communicating a simple String message.
		    String message = "PASSWORD doesn't Match.";
		    request.setAttribute("message", message);
		    request.getRequestDispatcher("index.jsp").forward(request,response);
		}
			

	}

}

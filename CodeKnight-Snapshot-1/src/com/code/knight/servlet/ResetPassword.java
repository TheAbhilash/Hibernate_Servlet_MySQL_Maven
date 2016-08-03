package com.code.knight.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.knight.dto.User;
import com.code.knight.service.ResetPasswordService;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String userName = request.getParameter("Username");
		
		ResetPasswordService resetPassword = new ResetPasswordService();
		User user = resetPassword.getUserByUserId(userName);
		
		boolean isUserAvailable = resetPassword.isUserExists(user);
		
		if(isUserAvailable == true ){
			 String userLoginMessge = "User "+user.getUserName()+" is available.";
			 request.setAttribute("name", userLoginMessge);
			 request.getRequestDispatcher("forgotpass.jsp").forward(request,response);
		}
	}

}

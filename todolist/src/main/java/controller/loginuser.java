package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import dto.user;

@WebServlet("/login")
public class loginuser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		dao dao=new dao();
		
		try {
			user u=dao.findByEmail(email);
			if(u!=null) {
				//verify the password
				if(u.getUserpassword().equals(password)) {
					//login success
					req.setAttribute("user", u);
					req.getRequestDispatcher("home.jsp").include(req, resp);
				}
				else {
					//password is wrong
				req.setAttribute("message"," password wrong");
					req.getRequestDispatcher("login.jsp").include(req, resp);
				}
			}
			else {
				//email is wrong
				req.setAttribute("message", "email wrong ");
				req.getRequestDispatcher("login.jsp").include(req, resp);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.dao;
import dto.user;

@WebServlet("/saveuser")
@MultipartConfig(maxFileSize = 10*1024*1024)
public class saveuser extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		
		Part imgpart=req.getPart("image");
		byte[] image=imgpart.getInputStream().readAllBytes();
		
		user u=new user(id, name, email, contact, password, image);
		
		dao dao=new dao();
		
			try {
				int res = dao.Saveuser(u);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
		
	}
}

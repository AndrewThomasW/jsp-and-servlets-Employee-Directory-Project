package andrew.thomas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import andrew.thomas.dao.LoginDaoImpl;
import andrew.thomas.entity.Login;

public class LoginServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Login log = new Login();
		log.setEmail(email);
		log.setPassword(password);
		
		LoginDaoImpl  logDao  = new LoginDaoImpl();
		
		if(logDao.authenticate(log)) {
			resp.sendRedirect("EmployeeServletController?action=LIST");
		}else {
			resp.sendRedirect("index.jsp");
		}
		
	}
}

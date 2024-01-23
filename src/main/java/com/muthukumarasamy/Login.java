package com.muthukumarasamy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muthukumarasamy.User.User;
import com.muthukumarasamy.repository.Repository;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("Password");

		System.out.println(email + "  " + password);
		User user = Repository.getInstance().checkuser(email);
		System.out.println(user);
		if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {

			response.sendRedirect("Login.html?loginMessage=Login Successfull");
		} else
			response.sendRedirect("Login.html?loginMessage=Invalid username or Password");

	}

}

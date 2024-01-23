package com.muthukumarasamy;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muthukumarasamy.User.User;
import com.muthukumarasamy.repository.Repository;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("newUsername");
		String email = request.getParameter("email");
		String password = request.getParameter("Npassword");

		try {
			int r = Repository.getInstance().AddUser(new User(username, password, email));
			if (r == 1) {
				response.sendRedirect("Signup.html?signupMessage=Sign up Successfull");

			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			response.sendRedirect("Signup.html?signupMessage=User Already Exits");

		}

	}

}

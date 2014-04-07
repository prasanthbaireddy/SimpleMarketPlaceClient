package edu.sjsu.cmpe273;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MarketServiceProxy proxy = new MarketServiceProxy();
		proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/MarketService?wsdl");
		boolean status= proxy.signUp(firstName, lastName, email, password);
		
		if(status)
		{
			System.out.println("SignUp Successful....Please login to Continue");
			response.sendRedirect("login.jsp");
			request.getSession().setAttribute("error","SignUp Successful....Please login to Continue");
		}
		else
		{
			System.out.println("SignUp Failed...");	
			request.getSession().setAttribute("error","SignUp Failed");
			response.sendRedirect("signup.jsp");
		}
	}

}

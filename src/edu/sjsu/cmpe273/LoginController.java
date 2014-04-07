package edu.sjsu.cmpe273;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("email");
		String password = request.getParameter("password");

		try 
		{
			MarketServiceProxy proxy = new MarketServiceProxy();
			proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/MarketService?wsdl");
			String queryString = proxy.loginAuthenticate(userName, password);

			if(queryString.startsWith("$"))
			{
				String delims = "[$]";
				String [] userdetails = queryString.split(delims);

				System.out.println(userdetails[0]);
				System.out.println(userdetails[1]);
				System.out.println(userdetails[2]);
				System.out.println(userdetails[3]);

				request.getSession().setAttribute("user", userdetails[1] + "," + userdetails[2]);
				request.getSession().setAttribute("logintime", userdetails[4]);
				request.getSession().setAttribute("email",userdetails[3]);

				String products = proxy.getAdvertisements();
				//products.replace("{", " ");
				String pDelims = "[}]";
				String commaDelim = "{,}";
				String [] delimProducts = products.split(pDelims);
				String [] productsArray = new String[delimProducts.length];

				for (int i = 0; i < delimProducts.length; i++) 
				{
					productsArray[i] = delimProducts[i];
				}
				request.getSession().setAttribute("products",productsArray);

				String purchases = proxy.getPurchasedItems(userdetails[3]);
				System.out.println(purchases);
				//System.out.println(purchases);
				String purchaseDelim = "[$]";
				String [] purProducts = purchases.split(purchaseDelim);

				if(purProducts.length > 0)
				{
					String [] ids = purProducts[1].split(",");
					String [] quantities = purProducts[2].split(",");

					HashMap<String, String> purchaseMap = new HashMap<String,String>();

					for (int i = 0; i < ids.length; i++) 
					{

						purchaseMap.put(proxy.getProductName(Integer.parseInt(ids[i])), quantities[i]);
					}


					request.getSession().setAttribute("purchasedProducts", purchaseMap);

				}
				response.sendRedirect("home.jsp");
			}
			else
			{
				request.getSession().setAttribute("error","Invalid user Id / Password");
				response.sendRedirect("login.jsp");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
}

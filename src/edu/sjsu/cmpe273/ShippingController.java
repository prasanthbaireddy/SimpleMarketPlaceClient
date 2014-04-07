package edu.sjsu.cmpe273;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShippingController
 */
@WebServlet("/ship")
public class ShippingController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String creditCard = request.getParameter("cardno");
		if(creditCard.length() != 16)
		{
			request.getSession().setAttribute("creditcarderror", "Invalid Credit Card.It should be 16 Digits");
			response.sendRedirect("checkout.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			HashMap<String, ArrayList<String>> cartMap = new HashMap<String, ArrayList<String>>();
			cartMap = (HashMap<String, ArrayList<String>>) session.getAttribute("cartlist");

			for (String key : cartMap.keySet()) 
			{
				ArrayList<String> list = cartMap.get(key);

				MarketServiceProxy proxy = new MarketServiceProxy();
				proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/MarketService?wsdl");
				proxy.updateProductQuantity( Integer.parseInt(list.get(2)), Integer.parseInt(key));
				proxy.updatePurchase(Integer.parseInt(key),  Integer.parseInt(list.get(2)), session.getAttribute("email").toString());
				
			}

			cartMap.clear();
			response.sendRedirect("ship.jsp");
			
			//TODO add separate tables for sold and purchased items

		}
	}

}

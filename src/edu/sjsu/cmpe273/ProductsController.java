package edu.sjsu.cmpe273;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductsController
 */
@WebServlet("/addtocart")
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//ArrayList<String> cartList = null;
		HashMap<String, ArrayList<String>> cartMap = null;
		
		try 
		{
			HttpSession session = request.getSession();
			ArrayList<String> product = new ArrayList<String>();
			product.add(request.getParameter("pname"));
			product.add(request.getParameter("pdescription"));
			product.add(request.getParameter("squant"));
			//String cartProducts = request.getParameter("id") +"," + request.getParameter("pname") +"," + request.getParameter("pdescription") +"," + request.getParameter("squant");
			
			if(session.getAttribute("cartlist") == null)
			{
				cartMap = new HashMap<String, ArrayList<String>>();
				session.setAttribute("cartlist", cartMap);
			}
			
			cartMap = (HashMap<String, ArrayList<String>>) session.getAttribute("cartlist");
			cartMap.put(request.getParameter("id"), product);
			/*if(request.getSession().getAttribute("cartList") == null)
			{
			System.out.println(cartProducts);
				cartList = new ArrayList<String>();
				cartList.add(cartProducts);
				request.getSession().setAttribute("cartList", cartList);
			}
			
			((ArrayList<String>) request.getSession().getAttribute("cartList")).add(cartProducts);*/
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("addstatus", request.getParameter("pname") + " Added to Cart");
		response.sendRedirect("purchase.jsp");
	}
}

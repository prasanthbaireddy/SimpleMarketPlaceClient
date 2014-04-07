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
 * Servlet implementation class PurchaseController
 */
@WebServlet("/updatecart")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String act = request.getParameter("act");
		if(act.equals("shop"))
		{
			response.sendRedirect("purchase.jsp");
		}
		else if(act.equals("checkout"))
		{
			response.sendRedirect("checkout.jsp");
		}
		else if(act.equals("remove"))
		{
			HashMap<String, ArrayList<String>> cartMap = new HashMap<String, ArrayList<String>>();
			cartMap = (HashMap<String, ArrayList<String>>) session.getAttribute("cartlist");
			cartMap.remove(request.getParameter("id"));
			response.sendRedirect("cart.jsp");
		}
		else if(act.equalsIgnoreCase("update"))
		{
			String id = request.getParameter("id");
			String quant = request.getParameter("quant");
			HashMap<String, ArrayList<String>> cartMap = new HashMap<String, ArrayList<String>>();
			cartMap = (HashMap<String, ArrayList<String>>) session.getAttribute("cartlist");
			ArrayList<String> list = cartMap.get(id);
			list.set(2, quant);
			cartMap.remove(id);
			cartMap.put(id, list);
			response.sendRedirect("cart.jsp");
		}
	}
}

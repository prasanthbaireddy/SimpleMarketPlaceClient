package edu.sjsu.cmpe273;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AdvertiseController
 */
@WebServlet("/advertise")
public class AdvertiseController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String productName = request.getParameter("pname");
		String productDescr = request.getParameter("pdesc");
		String sellerInfo = request.getParameter("sinfo");
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Double price = Double.parseDouble( request.getParameter("price"));
		String adStatus;
		
		MarketServiceProxy proxy = new MarketServiceProxy();
		proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/MarketService?wsdl");
		adStatus = proxy.postAdvertisement(productName, productDescr, sellerInfo, quantity, price,request.getSession().getAttribute("email").toString());
		request.getSession().setAttribute("status", adStatus);
		
		response.sendRedirect("advertise.jsp");
		
	}

}

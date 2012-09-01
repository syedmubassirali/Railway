package com.renintech.railway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renintech.railway.util.ConnectionUtility;

/**
 * Servlet implementation class TrainDetails
 */
public class Fare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action.equals("ticketFare"))
			ticketFare(request,response);
		
	}
	protected void ticketFare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String ticketFare=null;
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	 String source=request.getParameter("source");
	 System.out.println("source is"+source);
	 
	 String destination=request.getParameter("destination");
	 System.out.println("dest is"+destination);
	
	System.out.println("*******connection ctreated**********");
	//ArrayList<HashMap<String,String>> tf=new ArrayList<HashMap<String, String>>();
 	try
	{

	
	String q="select tiketfare from route_train where routeid in(select routeid from route where source='"+source.trim()+"' and destination='"+destination.trim()+"')";
	System.out.println("*********retreving required data*****************");
	System.out.println(q);
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
    System.out.println("resultset");
    
    if(resultset.next())
    {
    	System.out.println("in result set");
  
     ticketFare=resultset.getString(1);
    	System.out.println("*****************retrived details********************");
    	System.out.println("fare"+ticketFare);
    	request.setAttribute("tfare",ticketFare);
    	System.out.println("*******navigating to prompt fare page*********");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("promptFare.jsp");
    	dispatcher.forward(request,response);
    	
    }
    
    else
    {
    	 String message="sorry no train available";
    	request.setAttribute("message",message);
    	System.out.println("*******navigating to  fare error page*********");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("FareError.jsp");
    	dispatcher.forward(request,response);
    }
	
	}
	catch(Exception e)
	{
	e.printStackTrace(); 
	}

}
}
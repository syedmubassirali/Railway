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
 * Servlet implementation class Ticket
 */
public class Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ticket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("bookTicket"))
			bookTicket(request,response);
		
	}

	private void bookTicket(HttpServletRequest request,
			HttpServletResponse response) 
	{
		 Connection con=null;
		 con=ConnectionUtility.getConnection();
		 String userid=request.getParameter("userid");
		 System.out.println("userid is"+userid); 
		 String source=request.getParameter("source");
		 System.out.println("source is"+source);
		 String date=request.getParameter("date");
		 System.out.println("day is"+date);
		 String month=request.getParameter("month");
		 System.out.println("day is"+month);
		 String passengers=request.getParameter("passengers");
		 System.out.println("no. of passengers are"+passengers);
		 String destination=request.getParameter("destination");
		 System.out.println("dest is"+destination);
		 System.out.println("*******connection ctreated**********");
	 	try
		{
        String q="insert into ticket values (nextval('tktid'), nextval('pnr'), '"+source+"', '"+destination+"', "+passengers+", '"+date+"-"+month+"-12', "+userid+");";
		System.out.println("*********retreving required data*****************");
		System.out.println(q);
		PreparedStatement statement=con.prepareStatement(q);
		ResultSet rs=statement.executeQuery();
	    System.out.println("resultset");
	    
	    if(rs.next())
	    {
	    	System.out.println("*******navigating to booking jsp page*********");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("booking.jsp");
	    	dispatcher.forward(request,response);
	    	
	    }
		}
	 	catch(Exception e)
		{
		e.printStackTrace(); 
		}
	}
}
	    
	  
		
	



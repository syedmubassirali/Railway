package com.renintech.railway;
import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renintech.railway.util.ConnectionUtility;

public class TicketCancellation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		if(action.equals("cancelTicket"))
		{
			cancelTicket(request,response);
			
		}
	
	}
	protected void cancelTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		Connection con=null;
		con=ConnectionUtility.getConnection();
	
	 	try
		{
	 		
		 	System.out.println("*****************retreiving required  data*****************");
			String ticketId=request.getParameter("ticketid");
			String q="update status set statusName='cancelled' where tktid='"+ticketId+"'";
			System.out.println(q);
			Statement statement=con.createStatement();
		    int n=statement.executeUpdate(q);
   
		    if(n>0)
		    {
		    	System.out.println("sucessfully cancelled");
		    	RequestDispatcher dispatcher=request.getRequestDispatcher("Cancel.jsp");
		    	dispatcher.forward(request,response);				
		    }
		    else
			{
				System.out.println("invalid ticket id");
				String message="invalid ticket number";
				RequestDispatcher dispatcher2=request.getRequestDispatcher("Ticketerror.jsp");
				request.setAttribute("message",message);
				dispatcher2.forward(request,response);
			}
	    }
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
	}
	
}

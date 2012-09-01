package com.renintech.railway;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renintech.railway.util.ConnectionUtility;

public class TicketStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String action=request.getParameter("action");
	if(action.equals("ticketStatus"))
	{
		ticketStatus(request,response);
		
	}
	
	}
	protected void ticketStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{
System.out.println("*****************retreiving required  data*****************");
	String ticketId=request.getParameter("ticketid");
	String q="select statusName from status where tktid='"+ticketId+"'";
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
   
    if(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String statusName=resultset.getString(1);
    map.put("statusName",statusName);
    	tr.add(map);
    	System.out.println("retrived details");
    	request.setAttribute("status",tr);
    	System.out.println("********************navigating to another page***************");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("Status.jsp");
    	dispatcher.forward(request,response);
    	
    }
    else
    {
    	System.out.println("navigating to status error page");
    	String message="invalid ticket id";
    	request.setAttribute("message",message);
    	RequestDispatcher dispatcher=request.getRequestDispatcher("StatusError.jsp");
    	dispatcher.forward(request,response);
    	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	

}
	
}

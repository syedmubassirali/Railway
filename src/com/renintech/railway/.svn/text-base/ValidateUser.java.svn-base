package com.renintech.railway;
import java.sql.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renintech.railway.util.ConnectionUtility;

public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String action=request.getParameter("action");
	if(action.equals("validateUser"))
	{
		validateUser(request,response);
		
	}
	}
	protected void validateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
 	try
	{
System.out.println("*****************retreiving required  data*****************");
	String userid=request.getParameter("userid");
	String q="select *  from tuser where userid='"+userid+"'";
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
   
    if(resultset.next())
    {
    	System.out.println("valid");
    	request.setAttribute("userid", userid);
    	System.out.println("********************navigating to another page***************");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("passenger.jsp");
    	dispatcher.forward(request,response);
    }
    else
    {
    	System.out.println("not valid");
    	String message="invalid user id";
    	request.setAttribute("message",message);
    	RequestDispatcher dispatcher=request.getRequestDispatcher("userError.jsp");
    	dispatcher.forward(request,response);
    	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
}	
}

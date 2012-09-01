package com.renintech.railway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renintech.railway.util.ConnectionUtility;

/**
 * Servlet implementation class TrainDetails
 */
public class RouteFare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action=request.getParameter("action");
		if(action.equals("route"))
			route(request,response);
		
	}
	protected void route(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	 
	System.out.println("*******connection ctreated**********");
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{

	
	String q="select routeid,source,destination from route";
	System.out.println("*********retreving required data*****************");
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
    
    while(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	 String routeId=resultset.getString(1);
    	String source=resultset.getString(2);
    	String destination=resultset.getString(3);
    	map.put("source",source);
    	map.put("destination", destination);
    	map.put("routeId",routeId);
    	tr.add(map);
    	
    	
    }
   
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	System.out.println("*****************retrived details********************");
	request.setAttribute("route",tr);
	System.out.println("*******navigating to fare page*********");
	RequestDispatcher dispatcher=request.getRequestDispatcher("Fare.jsp");
	dispatcher.forward(request,response);

	
}
}
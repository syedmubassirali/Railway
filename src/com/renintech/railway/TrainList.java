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

public class TrainList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String action=request.getParameter("action");
	if(action.equals("trainName"))
	{
		trainName(request,response);
		
	}
	else if(action.equals("trainRoute"))
	{
		trainRoute(request,response);
	}
	}
	protected void trainName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{
System.out.println("*****************retreiving required  data*****************");
	
	String q="select * from train";
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
   
    while(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String trainName=resultset.getString(1);
    	String trainNumber=resultset.getString(2);
    	map.put("trainNumber",trainName);
    	map.put("trainName", trainNumber);
    	tr.add(map);
    	System.out.println("retrived details");
    	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	request.setAttribute("traindetails",tr);
	System.out.println("********************navigating to another page***************");
	RequestDispatcher dispatcher=request.getRequestDispatcher("Trains.jsp");
	dispatcher.forward(request,response);

}
	protected void trainRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	 String routeId=request.getParameter("train");
	 String sname=request.getParameter("train");
	System.out.println("*******connection ctreated**********");
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{

	
	String q="select name from train where tnum in (select tnum from route_train where routeid in(select routeid from route where source='"+sname+"' ))";
	System.out.println("*********retreving required data*****************");
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
    
    while(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String trainName=resultset.getString(1);
    	map.put("trainName",trainName);
    	map.put("routeId",routeId);
    	tr.add(map);
    	System.out.println("*****************retrived details********************");
    	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	request.setAttribute("routedetails",tr);
	System.out.println("*******navigating to another page*********");
	RequestDispatcher dispatcher=request.getRequestDispatcher("Route.jsp");
	dispatcher.forward(request,response);

}
	protected void trainClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	 String routeId=request.getParameter("train");
	 String sname=request.getParameter("train");
	System.out.println("*******connection ctreated**********");
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{

	
	String q="select name from train where tnum in (select tnum from route_train where routeid in(select routeid from route where source='"+sname+"' ))";
	System.out.println("*********retreving required data*****************");
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
    
    while(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String trainName=resultset.getString(1);
    	map.put("trainName",trainName);
    	map.put("routeId",routeId);
    	tr.add(map);
    	System.out.println("*****************retrived details********************");
    	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	request.setAttribute("routedetails",tr);
	System.out.println("*******navigating to another page*********");
	RequestDispatcher dispatcher=request.getRequestDispatcher("Route.jsp");
	dispatcher.forward(request,response);

}
	protected void trainPlatform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	 String routeId=request.getParameter("train");
	 String tname=request.getParameter("train");
	System.out.println("*******connection ctreated**********");
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{

	
	String q="select name from train where tnum in (select tnum from route_train where routeid in(select routeid from route where source='"+tname+"' ))";
	System.out.println("*********retreving required data*****************");
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
    
    while(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String trainName=resultset.getString(1);
    	map.put("trainName",trainName);
    	map.put("routeId",routeId);
    	tr.add(map);
    	System.out.println("*****************retrived details********************");
    	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	request.setAttribute("routedetails",tr);
	System.out.println("*******navigating to another page*********");
	RequestDispatcher dispatcher=request.getRequestDispatcher("Route.jsp");
	dispatcher.forward(request,response);

}
}

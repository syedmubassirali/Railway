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

public class TrainNames extends HttpServlet {
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
	}
	protected void trainName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{
System.out.println("*****************retreiving required  data*****************");
	
	String q="select name from train";
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
   
    while(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String trainName=resultset.getString(1);
  
    	map.put("name",trainName);
    	tr.add(map);
    	System.out.println("retrived details");
    	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	request.setAttribute("trainnames",tr);
	System.out.println("********************navigating to another page***************");
	RequestDispatcher dispatcher=request.getRequestDispatcher("selectTrain.jsp");
	dispatcher.forward(request,response);

}

}


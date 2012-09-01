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

public class TrainNamesAndDay extends HttpServlet {
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
	ArrayList<HashMap<String,String>> tr1=new ArrayList<HashMap<String, String>>();
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
    	String trainNum=resultset.getString(2);
    	map.put("trainName",trainName);
    	map.put("trainNum",trainNum);
    	tr.add(map);
    	System.out.println("retrived details");
    	
    }
    
    String q1="select stname from station";
	PreparedStatement statement1=con.prepareStatement(q1);
    ResultSet resultset1=statement1.executeQuery();
   
    while(resultset1.next())
    {
    	 HashMap<String,String> map1=new HashMap<String, String>();
    	String stationName=resultset1.getString(1);
    	
    	map1.put("stationName",stationName);
    	tr1.add(map1);
    	System.out.println("retrived details");
    }	
	
	request.setAttribute("trainnames",tr);
	request.setAttribute("stationName", tr1);
	System.out.println("********************navigating to select train day page***************");
	RequestDispatcher dispatcher=request.getRequestDispatcher("selectTrainDay.jsp");
	dispatcher.forward(request,response);
	}
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
}

}


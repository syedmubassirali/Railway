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
public class Timings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");
		if(action.equals("trainTimings"))
			trainTimings(request,response);
		
	}

	protected void trainTimings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	 String trainName=request.getParameter("train");
	 System.out.println("trai name is"+trainName);
	 String day=request.getParameter("day");
	 System.out.println("day is"+day);
	 String Sname=request.getParameter("sname");
	System.out.println("*******connection ctreated**********");
	ArrayList<HashMap<String,String>> tf=new ArrayList<HashMap<String, String>>();
 	try
	{

	
	String q="select arrivaltime,departuretime from Tschedules where day='"+day.trim()+"' and staid in(select staid from station where stname='"+Sname.trim()+"' and tnum in (select tnum from train where Name='"+trainName.trim()+"'))";
	System.out.println("*********retreving required data*****************");
	System.out.println(q);
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
    
    if(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String arrivalTime=resultset.getString(1);
    	String  departureTime=resultset.getString(2);
    	map.put("arrivalTime",arrivalTime);
    	map.put("departureTime",departureTime);
    	map.put("trainName", trainName);
    	tf.add(map);
    	System.out.println("*****************retrived details********************");
    	request.setAttribute("timings",tf);
    	System.out.println("*******navigating to another page*********");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("promptTimings.jsp");
    	dispatcher.forward(request,response);
    	
    }
    else
    {
    	String message="no train is available";
    	request.setAttribute("message",message);
    	System.out.println("*******navigating to timings error page*********");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("TimingsError.jsp");
    	dispatcher.forward(request,response);	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	
}
}
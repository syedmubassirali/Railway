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
public class TrainDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainDetails() {
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
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action.equals("sourceList"))
		{
			sourceList(request,response);
		}
	}
	protected void sourceList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int count=0;
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	 String source=request.getParameter("source");
	 String destination=request.getParameter("destination");
	System.out.println("*******connection ctreated**********");
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{

	
	String q="select name from train where tnum in (select tnum from route_train where routeid in(select routeid from route where source='"+source.trim()+"' and destination='"+destination.trim()+"'))";
	System.out.println("*********retreving required data*****************");
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
    while(resultset.next())
    {
    	count++;
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String trainName=resultset.getString(1);
    	map.put("trainName",trainName);
    	tr.add(map);
    	request.setAttribute("traindetaillist",tr);
    	System.out.println("*******navigating to train say details jsp page*********");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("trainsayDe.jsp");
    	dispatcher.forward(request,response);
    }
    if(count==0)
    {
    	String message="no trains available in this route";
    	request.setAttribute("message", message);
    	System.out.println("*******navigating to RouteError jsp page*********");
    	RequestDispatcher dispatcher=request.getRequestDispatcher("RouteError.jsp");
    	dispatcher.forward(request,response);
    }
    
    }

	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	
	
}
}

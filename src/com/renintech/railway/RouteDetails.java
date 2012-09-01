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
public class RouteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action.equals("selectRoute")){
			selectRoute(request,response);
		}
	
		}
	protected void selectRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
	 con=ConnectionUtility.getConnection();
	 
	System.out.println("*******connection ctreated**********");
	ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
 	try
	{

	
	String q="select source,destination from  route";
	System.out.println("*********retreving source and destination****************");
	PreparedStatement statement=con.prepareStatement(q);
    ResultSet resultset=statement.executeQuery();
    
    while(resultset.next())
    {
    	 HashMap<String,String> map=new HashMap<String, String>();
    	String source=resultset.getString(1);
    	String destination=resultset.getString(2);
    	map.put("source",source);
    	map.put("destination",destination);
    	tr.add(map);
    	System.out.println("*****************retrived details********************");
    	
    }
    }
	catch(Exception e)
	{
	e.printStackTrace(); 
	}
	request.setAttribute("route",tr);
	System.out.println("*******navigating to sourceDestination page*********");
	RequestDispatcher dispatcher=request.getRequestDispatcher("SourceDest.jsp");
	dispatcher.forward(request,response);

}
	
}

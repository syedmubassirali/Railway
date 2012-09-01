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
 * Servlet implementation class Ticket
 */
public class GivePnr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		String action=request.getParameter("action");
		if(action.equals("givetkt"))
		{
			givetkt(request, response);
		}		
	}

	private void givetkt(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 Connection con=null;
		 con=ConnectionUtility.getConnection();
		 ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
		 try
		{	
        String q="select max(tktid),max(pnr) from ticket";
		System.out.println(q);
		System.out.println("*********retreving required data*****************");
		PreparedStatement statement=con.prepareStatement(q);
	    ResultSet resultset=statement.executeQuery();
	    while(resultset.next())
	    {
	    	HashMap<String,String> map=new HashMap<String, String>();
	    	 String tktid=resultset.getString(1);
	    	String pnr=resultset.getString(2);
	    	map.put("tktid",tktid);
	    	map.put("pnr", pnr);
	    	tr.add(map);
	    }
		}
	 	catch(Exception e)
		{
		e.printStackTrace(); 
		}
	 	System.out.println("*****************retrived details********************");
		request.setAttribute("tkt",tr);
		System.out.println("*******navigating to tktpnr page*********");
		RequestDispatcher dispatcher=request.getRequestDispatcher("tktpnr.jsp");
		dispatcher.forward(request,response);
	}
}

	    
	  
		
	



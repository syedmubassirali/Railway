package com.renintech.railway;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renintech.railway.util.ConnectionUtility;

public class TrainPlatform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String action=request.getParameter("action");
	if(action.equals("platform"))
	{
		platform(request,response);
		
	}
	
	}
	protected void platform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
		con=ConnectionUtility.getConnection();
	
		//ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
		//HashMap<String,String> maps=new HashMap<String, String>();
		String platform=null;
	 	try
		{
		 	System.out.println("*****************retreiving required  data*****************");
			String trainName=request.getParameter("train");
			System.out.println("train name"+trainName);
			String q="select pnum from Tschedules where tnum = (select tnum from Train where name='"+trainName.trim()+"')";
			System.out.println(q);
			PreparedStatement statement=con.prepareStatement(q);
		    ResultSet resultset=statement.executeQuery();
		    if(resultset.next())
		    {
		    	System.out.println("got platform");
		    	platform=resultset.getString(1);
		    	
		     	//maps.put("platform",platform);
		     	//tr.add(map);
		     	System.out.println("retrived details"+platform);
		     	request.setAttribute("platforms",platform);
				System.out.println("********************navigating to platform page***************");
				RequestDispatcher dispatcher=request.getRequestDispatcher("Platform.jsp");
				dispatcher.forward(request,response);
		    	
		    }
		    else
		    {
		    	String message="train not available";
		    	request.setAttribute("message",message);
				System.out.println("********************navigating to platform  error page***************");
				RequestDispatcher dispatcher=request.getRequestDispatcher("PlatformError.jsp");
				dispatcher.forward(request,response);
		    	
		    }
	    }
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		

}
	
}

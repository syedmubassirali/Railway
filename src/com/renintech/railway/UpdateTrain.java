package com.renintech.railway;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renintech.railway.util.ConnectionUtility;


public class UpdateTrain extends HttpServlet {
	String finalDate;
	 String arrivalTime;
	
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
	/*	if(action.equals("UpdateTrain"))
		{
			UpdateTrain(request,response);
			
		}*/
		 if(action.equals("milliTime"))
		{
			 milliTime(request,response);
			
		}
	}
	
	/*protected void UpdateTrain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String arrivaltime,departuretime;
		Connection con=null;
		con=ConnectionUtility.getConnection();
		
		ArrayList<HashMap<String,String>> tr=new ArrayList<HashMap<String, String>>();
	 	try
		{
	        System.out.println("*****************updating data*****************");
		    String q="select arrivaltime,departuretime from tschedules where tnum=1111";
		    Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery(q);
		    if(rs.next())
		    {
		    	arrivaltime=rs.getString(1);
		    	departuretime=rs.getString(2);
		   
		    }
		    System.out.println("*****************updated data*****************");
		String q1="update tschedules set arrivaltime='17:50:00',departuretime='17:20:00 ' where tnum=1111";
			Statement statement=con.createStatement();
		    int n=statement.executeUpdate(q1);
		    if(n>0)
		    {
		    	milliTime(request,response);
		    }
		    else
		    {
		    	System.out.println("no train found");
		    }

		}
		 	catch(Exception e)
			{
			e.printStackTrace(); 
			}		
		   
    }
*/
   protected void milliTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
	   Timer timer = new Timer();

	     System.out.println("*******forward to the getDetails method*******");
	    
	     final ArrayList list =getDetails();
	     System.out.println("in the date and time details");
	    
	      Object o = list.get(0);
	    final  String st=o.toString();
	      System.out.println("date**********************: "+st);
	      
	      
	      
	      Object o1=  list.get(1);
	      String st1=o1.toString();
	      System.out.println("time*********************:  "+st1);
	    //  SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
  	      //System.out.println("entering into run method");	     
	      System.out.println("before run method"); 
	      timer.schedule(new TimerTask(){
	      
	     public void run(){
	     
	     System.out.println("in run method");
	     CallConnect cc=new CallConnect();
	     String dest="sip:user@192.168.1.252";
	     System.out.println("call connect");
	     String u="http://localhost:9999/ccxml.start?tokenid=ccxml10&dest="+dest+"&arrivalTime="+arrivalTime;
	     try {
			cc.getConnection(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println("This line is printed only once.");
	     }
	     },Long.parseLong(finalDate));
	     

	     System.out.println("after run method");
	}

   private ArrayList getDetails() 
   {
       //List list = new ArrayList();
       //ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
       ArrayList list=new ArrayList();
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       
       try 
       {
           System.out.println("******in try block*****");
           connection = ConnectionUtility.getConnection();
           String query = "select Tdate,arrivaltime from Tschedules where tnum=1111";
           preparedStatement = connection.prepareStatement(query);
           System.out.println(query);
           resultSet = preparedStatement.executeQuery();
           if (resultSet.next())
           {
               System.out.println("********in if block*****");
               java.sql.Date sDate = resultSet.getDate(1);
               System.out.println(sDate);
           
                arrivalTime=resultSet.getString(2);
               System.out.println(arrivalTime);
             
             
               
               
               
               String[] temp,temp1;
               String time=null;
               String delimiter = ":";
               String delimiter2 = " ";
               temp = arrivalTime.split(delimiter);
               System.out.println(temp);
               int i = 0;
               for( i =0; i < temp.length ; i++)
               {
                  System.out.println("temp:"+temp[i]);
                   time=temp[0];
                   System.out.println(time);
               }
               time=temp[0];
               long min=Long.parseLong(time);
               System.out.println(min);
               long minvalue=min * 60;
               long sec=minvalue * 60;
               long milli=sec * 1000;
               System.out.println("hr time is:"+milli);
               System.out.println("temp:"+temp[1]);
                   time=temp[1];
                   System.out.println(time);
              
               long minvalue1=Long.parseLong(time);
               long sec1=minvalue1 * 60;
               long milli1=sec1 * 1000;
               System.out.println("min time is:"+milli1);
               time=temp[2];
               long minvalue2=Long.parseLong(time);
               long milli2=minvalue2 * 1000;
               System.out.println("sec time is:"+milli2);
               
               
               
               long hours=milli+milli1+milli2;
               System.out.println("adding milli:"+hours);
               
                list.add(sDate);
               System.out.println("after calculation date....................................................................."+sDate);
              System.out.println("arrival date is :"+sDate.getTime());
               
               list.add(arrivalTime);
               System.out.println("after calculation time.............................................."+arrivalTime);
               String inter=""+sDate.getTime();
            
              
               long interDate=Long.parseLong(inter);
               long datehrs=interDate+hours;
               System.out.println("date+hours is:"+datehrs);
              
              
              Date d=new Date();
           //    String longdate=""+d.getTime();
               System.out.println("present date is :"+d.getTime());
               
               
               long finaldate1=datehrs-d.getTime();   
               
               finalDate=""+finaldate1;
              System.out.println("final date is :"+finalDate);
           }
       }
       

       catch (Exception e) 
       {
           e.printStackTrace();
       }
       return list;
       
   }

	
}


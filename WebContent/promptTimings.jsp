<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList timings=(ArrayList)request.getAttribute("timings");
System.out.println("in array list");

%>
<form>
<field name="timings">
<prompt>train timings are
<%for(Object object:timings)
{
	System.out.println("in loop");
	HashMap map=(HashMap)object;
	String arrivalTime=(String)map.get("arrivalTime");
	System.out.println("arrival time is"+arrivalTime);
	String departureTime=(String)map.get("departureTime");
	System.out.println("departureTime is"+departureTime);
	String trainName=(String)map.get("trainName");
	System.out.println("trainName is"+trainName);
	%>
	 <say-as interpret-as="vxml:time"><%=arrivalTime %></say-as><break time="500"/> 
	 	 <say-as interpret-as="vxml:time"><%=departureTime %></say-as><break time="500"/> 


	
<%}%>If you have some more questions say yes otherwise say no
</prompt>
<grammar root="name">
				<rule id="name">
					<one-of>
						<item>yes</item>
						<item>no</item>
					</one-of>
				</rule>
			</grammar>
			</field>
		
				
			
			
<block>
	<if cond="timings=='yes'">
		<submit next="Welcome.jsp"/>
	<elseif cond="timings=='no'"/>
		<prompt>thank you </prompt>
	</if>
</block>
</form>
</vxml>

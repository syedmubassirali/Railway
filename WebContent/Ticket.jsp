<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
	
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList ticket=(ArrayList)request.getAttribute("route");
String npassengers=request.getParameter("npassengers");%>
<form>
<field name="userid" type="digits">
				<prompt bargein="false">please enter your user i d </prompt>
</field>
<field name="source">
          <prompt>please say the place from where you start....
          <%for(Object object:ticket)
                {
	            HashMap map=(HashMap)object;
	            String source=(String)map.get("source");
	            %>
	            <%=source %>
	      <%}%>
          </prompt>
<grammar root="name">
	<rule id="name">
		<one-of>
			<%for(Object object:ticket)
				{
					HashMap map=(HashMap)object;
					String source=(String)map.get("source");
			%>
					<item><%=source %><tag> <![CDATA[  <%=source%> ]]>  </tag></item>
	
					<%}%>
		</one-of>
	</rule>
</grammar>
</field>
<field name="destination">
	<prompt>please say the place  you want to reach....
	<%for(Object object:ticket)
		{	
			HashMap map=(HashMap)object;
			String destination=(String)map.get("destination");
			%>
		<%=destination %>
	<%}%>
</prompt>
<grammar root="name">
				<rule id="name">
					<one-of>
						<%for(Object object:ticket)
							{
								HashMap map=(HashMap)object;
								String destination=(String)map.get("destination");
					%>
						<item><%=destination %><tag> <![CDATA[  <%=destination%> ]]>  </tag></item>
	
			<%}%>
					</one-of>
				</rule>
			</grammar>
</field>
<field name="month">
				<prompt>please select the month....
			january,february,march,april,may,june,july,august,september,october,november,december

</prompt>
<grammar root="month">
				<rule id="month">
					<one-of>
			
						<item>jan</item>		
						<item>feb</item>
						<item>mar</item>
						<item>apr</item>
						<item>may</item>
						<item>jun</item>
						<item>jul</item>
						<item>aug</item>
						<item>sep</item>
						<item>oct</item>
						<item>nov</item>
						<item>dec</item>
					</one-of>
				</rule>
	
			</grammar>
</field>
<field name="date" type="digits">
				<prompt bargein="false">please enter the date of travelling </prompt>
</field>	
<field name="passengers" type="digits">
				<prompt bargein="false">please enter number of passengers </prompt>
</field>
<field name="selection">
			<prompt>if your booking is confirmed say yes otherwise say no<break time="500"/>
			</prompt>
			<grammar root="option">
				<rule id="option">
					<one-of>		
						<item>yes</item>
						<item>no</item>
					</one-of>	
				</rule>
			</grammar>
		</field>
		<block>
			<if cond="selection=='yes'">
				<submit next="TicketBooked?action=bookTicket" method="post"/> 
			<elseif cond="selection=='no'"/>
				 <submit next="TicketBooking1?action=route" method="post"/>
		</if>
		</block>
</form>
</vxml>
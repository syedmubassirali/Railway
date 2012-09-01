<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList traindetails=(ArrayList)request.getAttribute("route");%>
<form>
<field name="source">
<prompt>please say the place from where you start....
<%for(Object object:traindetails)
{
	HashMap map=(HashMap)object;
	String source=(String)map.get("source");
	String routeId=(String)map.get("routeId");
	%>
	<%=source %>
	
<%}%>
</prompt>
<grammar root="name">
	<rule id="name">
		<one-of>
			<%for(Object object:traindetails)
				{
					HashMap map=(HashMap)object;
					String source=(String)map.get("source");
					String routeId=(String)map.get("routeId");
			%>
					<item><%=source %><tag> <![CDATA[  <%=source%> ]]>  </tag></item>
	
					<%}%>
		</one-of>
	</rule>
</grammar>
</field>
<field name="destination">
<prompt>please say the place  you want to reach....
<%for(Object object:traindetails)
{
	HashMap map=(HashMap)object;
	String destination=(String)map.get("destination");
	String routeId=(String)map.get("routeId");
	%>
	<%=destination %>
	
<%}%>
</prompt>
<grammar root="name">
				<rule id="name">
					<one-of>
						<%for(Object object:traindetails)
							{
								HashMap map=(HashMap)object;
								String destination=(String)map.get("destination");
								String routeId=(String)map.get("routeId");
					%>
						<item><%=destination %><tag> <![CDATA[  <%=destination%> ]]>  </tag></item>
	
			<%}%>
					</one-of>
				</rule>
			</grammar>
</field>		
<block>
<submit next="TrainDetails?action=sourceList"/>
</block>
</form>
</vxml>
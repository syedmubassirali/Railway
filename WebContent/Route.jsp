<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList routedetails=(ArrayList)request.getAttribute("routedetails");%>
<form>
<field name="train">
<prompt bargin="false">train details depending on given route
<%for(Object object:routedetails)
{
	HashMap map=(HashMap)object;
	String trainName=(String)map.get("trainName");
	%>
	<%=trainName %>
	
<%}%>
</prompt>
<grammar root="name">
				<rule id="name">
					<one-of>
						<%for(Object object:routedetails)
{
	HashMap map=(HashMap)object;
	String trainName=(String)map.get("trainName");
	String routeId=(String)map.get("routeId");
	%>
	<item><%=trainName %><tag> <![CDATA[  <train="<%=routeId%>"  ]]>  </tag></item>
	
<%}%>
					</one-of>
				</rule>
			</grammar>
			</field>
<block>
<submit next="Welcome.jsp"/>
</block>
</form>
</vxml>

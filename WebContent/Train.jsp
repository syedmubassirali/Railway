<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList traindetails=(ArrayList)request.getAttribute("traindetails");%>
<form>
<field name="train">
<prompt>train details
<%for(Object object:traindetails)
{
	HashMap map=(HashMap)object;
	String trainNumber=(String)map.get("trainNumber");
	String trainName=(String)map.get("trainName");
	%>
	<%=trainName %>
	
<%}%>
</prompt>
<grammar root="name">
				<rule id="name">
					<one-of>
						<%for(Object object:traindetails)
{
	HashMap map=(HashMap)object;
	String trainNumber=(String)map.get("trainNumber");
	String trainName=(String)map.get("trainName");
	%>
	<item><%=trainName %><tag> <![CDATA[  <train="<%=trainNumber%>"  ]]>  </tag></item>
	
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

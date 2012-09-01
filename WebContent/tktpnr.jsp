<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList tktpnr=(ArrayList)request.getAttribute("tkt");%>
<form>
<field name="tktid">
<prompt>your ticket id is....<break time="500"/>
<%for(Object object:tktpnr)
{
	HashMap map=(HashMap)object;
	String tktid=(String)map.get("tktid");
	%>
	<say-as interpret-as="vxml:digits"><%=tktid %></say-as><break time="500"/>
	
<%}%> your call is transfering to operator
</prompt>
<grammar root="name">
	<rule id="name">
		<one-of>
			<%for(Object object:tktpnr)
				{
					HashMap map=(HashMap)object;
					String tktid=(String)map.get("tktid");
			%>
					<item><%=tktid %><tag> <![CDATA[  <%=tktid%> ]]>  </tag></item>
					<%}%>
		</one-of>
	</rule>
</grammar>
</field>

<block>
		<submit next="calloperator.jsp"/>
</block>
</form>
</vxml>
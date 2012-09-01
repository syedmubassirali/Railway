<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% String tfare=(String)request.getAttribute("tfare");
  System.out.println("fare"+tfare);
%>
<form>
	<field name="fare">
		<prompt>fare of the ticket is
				<%=Integer.parseInt(tfare)%> <break time="500"/>
	If you have some more questions say yes otherwise say no
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
	<if cond="fare=='yes'">
		<submit next="Welcome.jsp"/>
	<elseif cond="fare=='no'"/>
		<prompt>thank you </prompt>
	</if>
</block>
</form>
</vxml>

<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% String platforms=(String)request.getAttribute("platforms");
	System.out.println("plat form: "+platforms);
%>
<form>
	<field name="train">
		<prompt bargein="false">
			platform number of the selected train is <%=Integer.parseInt(platforms)%> 
			<break time="500" />
			If you have some more questions say yes otherwise say no
		</prompt>
		<grammar root="name">
			<rule id="name">
				<one-of>
					<item>yes</item>
					<item>no</item>
				</one-of>
			</rule>
		</grammar>
		<no-match>
			<prompt>please select the correct train name</prompt>
		</no-match>
		<no-input>
			<prompt>no input received</prompt>
		</no-input>
	
	</field>
				
				
	<block>
		<if cond="train=='yes'">
			<submit next="Welcome.jsp"/>
		<elseif cond="train=='no'"/>
			<prompt>thank you </prompt>
		</if>
	</block>
</form>
</vxml>
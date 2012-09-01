<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList status=(ArrayList)request.getAttribute("status");%>
<form>
<field name="selection">
<prompt bargein="false">status of your ticket is
<%for(Object object:status)
{
	HashMap map=(HashMap)object;
	String statusName=(String)map.get("statusName");
	%>
	<%=statusName %>
	<prompt>If you have some more questions say yes otherwise say no</prompt>
	
<%}%>
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
<if cond="selection=='yes'">
<submit next="Welcome.jsp"/>
<elseif cond="selection=='no'"/>
<prompt>thank you </prompt>
</if>

<no-match><prompt>please enter correct ticket id</prompt></no-match>
			<no-input><prompt>you have not entered your ticket id please enter</prompt></no-input>
</block>
</form>
</vxml>

<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList traindetails=(ArrayList)request.getAttribute("traindetaillist");%>
<form>
	<field name="selection1">
	<prompt>train details depending on the given route
<%for(Object object:traindetails)
{
	HashMap map=(HashMap)object;
	String trainName=(String)map.get("trainName");
	%>
	<%=trainName %>
	
<%}%><break time="500"/>
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
			</field>

<block>
<if cond="selection1=='yes'">
    	<submit next="Welcome.jsp"/>
<elseif cond="selection1=='no'"/>
		<prompt>thank you </prompt>
</if>
</block>
</form>
</vxml>

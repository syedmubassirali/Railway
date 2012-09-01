<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>

<% ArrayList trainnames=(ArrayList)request.getAttribute("trainnames");%>
<form>
<field name="train">
	<prompt>please select the train name....
		<%for(Object object:trainnames)
		  {
			HashMap map=(HashMap)object;
			String name=(String)map.get("name");
			%>
			<%=name %>
			
		<%}%>
	</prompt>
	<grammar root="tname">
				<rule id="tname">
					<one-of>
						<%
							String name=null;
							for(Object object:trainnames)
							{
								HashMap map=(HashMap)object;
								name=(String)map.get("name");
						%>
								<item><%=name%><tag> <![CDATA[  <%=name%> ]]>  </tag></item>
	
						<%}%>
					</one-of>
				</rule>
	</grammar>
</field>
<block>
<submit next="TrainPlatform?action=platform"/>
</block>

</form>

</vxml>

<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<%@ page import= "java.util.ArrayList"%>
<%@ page import="java.util.HashMap" %>
<% ArrayList trainnames=(ArrayList)request.getAttribute("trainnames");
ArrayList stationnames=(ArrayList)request.getAttribute("stationName");
System.out.println("in arraylist");
%>
<form>
<field name="train">
	<prompt>please select the train name....
		<%for(Object object:trainnames)
		  {
			HashMap map=(HashMap)object;
			String trainName=(String)map.get("trainName");
			System.out.println("train name is:"+trainName);
			String trainNum=(String)map.get("trainNum");
			System.out.println("train num:"+trainNum);
			%>
			<%=trainName %>
			
		<%}%>
	</prompt>
	<grammar root="tname">
				<rule id="tname">
					<one-of>
						<%
							
							for(Object object:trainnames)
							{
								HashMap map=(HashMap)object;
								String trainName=(String)map.get("trainName");
								String trainNum=(String)map.get("trainNum");
						%>
								<item><%=trainName%><tag> <![CDATA[  <%=trainName%> ]]>  </tag></item>
	
							<%}%>
					</one-of>
				</rule>
	</grammar>
</field>
<field name="day">
<prompt>please select the day....
sunday,monday,tuesday,wednusday,thursday,friday,saturday
</prompt>
<grammar root="day">
				<rule id="day">
					<one-of>
			
						<item>sunday</item>		
						<item>monday</item>
						<item>tuesday</item>
						<item>wednusday</item>
						<item>thursday</item>
						<item>friday</item>
						<item>saturday</item>
					</one-of>
				</rule>
	
			</grammar>
</field>
<field name="sname">
	<prompt>please select the station name....
		<%for(Object object:stationnames)
		  {
			HashMap map=(HashMap)object;
			String stationName=(String)map.get("stationName");
			System.out.println("train name is:"+stationName);
		
			%>
			<%=stationName %>
			
		<%}%>
	</prompt>
	<grammar root="tname">
				<rule id="tname">
					<one-of>
						<%
							
							for(Object object:stationnames)
							{
								HashMap map=(HashMap)object;
								String stationName=(String)map.get("stationName");
								
						%>
								<item><%=stationName%><tag> <![CDATA[  <%=stationName%> ]]>  </tag></item>
	
							<%}%>
					</one-of>
				</rule>
	</grammar>
</field>
<block>
<submit next="Timings?action=trainTimings"/>
</block>
</form>
</vxml>

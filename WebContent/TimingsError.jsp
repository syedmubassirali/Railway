<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
	<form>
		<% String message=(String)request.getAttribute("message");%>
		<%System.out.println("from  timings error:"+message);%>
		<block>
			<prompt> <%=message%> <break time="500"/>
					
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
	<if cond="timings=='yes'">
		<submit next="Welcome.jsp"/>
	<elseif cond="timings=='no'"/>
		<prompt>thank you </prompt>
	</if>
</block>
</form>
</vxml>
						
<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
	<form>
		<% String arrivalTime=(String)request.getAttribute("arrivalTime");%>
		<%System.out.println("from ticketerror:"+arrivalTime);%>
		<block>
			<prompt> <%=arrivalTime%> <break time="500"/>
					your train is delayed by half and hour
					<break time="1000"/>
			</prompt>
		</block>
		<block>
			<submit next="Statusp.jsp"/>
		</block>
	</form>
	
</vxml>
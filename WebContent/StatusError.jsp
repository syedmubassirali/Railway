<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
	<form>
		<% String message=(String)request.getAttribute("message");%>
		<%System.out.println("from ticketerror:"+message);%>
		<block>
			<prompt> <%=message%> <break time="500"/>
					please enter correct ticket number
					<break time="1000"/>
			</prompt>
		</block>
		<block>
			<submit next="Statusp.jsp"/>
		</block>
	</form>
	
</vxml>
<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
	<form>
		<% String message=(String)request.getAttribute("message");%>
		<%System.out.println("from fareerror:"+message);%>
		<block>
			<prompt> <%=message%> <break time="500"/>
					Thank you	  
			</prompt>
		</block>
	</form>
	
</vxml>
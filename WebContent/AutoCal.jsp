<?xml version="1.0" encoding="UTF-8"?>
<ccxml version="1.0" xmlns:voxeo="http://community.voxeo.com/xmlns/ccxml">
<%@page import="java.util.HashMap"%>
<%
System.out.println("in pob.jsp");

String MobileNo = request.getParameter("MobileNo");
String arrivalTime = request.getParameter("arrivalTime");
System.out.println("mobile : "+MobileNo);
%>
 <var name="state0" expr="'init'"/>

  <eventhandler statevariable="state0">

    <transition state="'init'" event="ccxml.loaded">
      <assign name="state0" expr="'dialing'"/>
      <createcall dest="'<%=MobileNo%>'"/>
    </transition>

     <transition state="'dialing'" event="connection.CONNECTION_CONNECTED">
         <assign name="state0" expr="'connected'"/>
      <dialogstart src="Welcome.jsp" />   
    </transition>
   
  
    <transition state="'dialing'" event="connection.CONNECTION_FAILED">
      <log expr="'Failed making outbound call'"/>
      <exit/>
    </transition>
   
    <transition state="'connected'" event="dialog.exit">
      <log expr="'Thats all for now folks.'"/>     
      </transition>
 
    <transition event="call.CALL_INVALID" name="evt">
              <voxeo:sendemail to="'yourEmail@there.com'"
                        from="'myApp@here.com'"
                        type="'debug'"
                        body=" 'call.CALL_INVALID detected ! ' "/>
      <exit/>
    </transition>

    <transition event="error.*" name="evt">
      <log expr="'an error has occurred (' + evt.error + ')'"/>
              <voxeo:sendemail to="'yourEmail@there.com'"
                        from="'myApp@here.com'"
                        type="'debug'"
                        body=" 'generic error detected ! ' "/>
      <exit/>
    </transition>

 </eventhandler>
    </ccxml>
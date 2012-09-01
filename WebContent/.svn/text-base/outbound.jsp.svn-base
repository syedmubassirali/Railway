<?xml version="1.0" encoding="UTF-8"?>
<ccxml version="1.0" xmlns:voxeo="http://community.voxeo.com/xmlns/ccxml">
<% String dest = request.getParameter("dest"); 
String arrivalTime = request.getParameter("arrivalTime"); 
	System.out.println("*****"+dest);
	System.out.println("*****"+arrivalTime);
	request.setAttribute("arrivalTime",arrivalTime);
%>
 <var name="state0" expr="'init'"/>

  <eventhandler statevariable="state0">

    <transition state="'init'" event="ccxml.loaded">
      <assign name="state0" expr="'dialing'"/>
      <createcall dest="'<%=dest%>'"/>
    </transition>




    <transition state="'dialing'" event="connection.CONNECTION_CONNECTED">
         <assign name="state0" expr="'connected'"/>
      <dialogstart src="'Arrival.jsp'" />    
    </transition>
//DIALOGSTART SRC CAN BE ANOTHER JSP WHERE VXML PROMPTING CAN HAPPEN


    
	
	<transition state="'dialing'" event="connection.CONNECTION_FAILED">
      <log expr="'Failed making outbound call'"/>
      <exit/>
    </transition>
//WE CAN CALL ANOTHER JSP TO STORE STATUS IN DATABASE ETC.....
	


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
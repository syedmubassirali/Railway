<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
	<form>
		<block>
			<prompt>Welcome to railway reservation
			</prompt>
			</block>
		<field name="selection">
			<prompt bargein="false"><break time="500"/>
		    please select from the list<break time="500"/>
	        train details<break time="500"/>
			ticket status<break time="500"/>
			cancel ticket<break time="500"/>
	        fare<break time="500"/>
            platform<break time="500"/>
		    timings<break time="500"/>
		    ticket booking<break time="500"/>
		    </prompt>
			<grammar root="name">
				<rule id="name">
					<one-of>
						<item>train details</item>
						<item>ticket status</item>
						<item>cancel ticket</item>
						<item>fare</item>
						<item>platform</item>
						<item>timings</item>
						<item>ticket booking</item>
					</one-of>
				</rule>
			</grammar>
		</field>
<block>
	<if cond="selection=='train details'">
		<submit next="RouteDetails?action=selectRoute" method="post"/>
	<elseif cond="selection=='ticket status'"/>
		<submit next="Statusp.jsp"/>
	<elseif cond="selection=='cancel ticket'"/>
		<submit next="Cancelp.jsp"/>
	<elseif cond="selection=='fare'"/>
		<submit next="RouteFare?action=route" method="post"/>
	<elseif cond="selection=='platform'"/>
		<submit next="TrainNames?action=trainName" method="post"/>
	<elseif cond="selection=='timings'"/>
		<submit next="TrainNamesAndDay?action=trainName" method="post"/>
		<elseif cond="selection=='ticket booking'"/>
		<submit next="TicketBooking1?action=route" method="post"/>
	</if>
</block>	
	</form>
</vxml>
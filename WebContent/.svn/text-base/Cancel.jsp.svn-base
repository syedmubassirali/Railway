<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
	<form>
		<field name="selection">
			<prompt>your ticket has been cancelled successfully<break time="500"/>
				If you have some more questions say yes otherwise say no</prompt>
			<grammar root="option">
				<rule id="option">
					<one-of>		
						<item>yes</item>
						<item>no</item>
					</one-of>	
				</rule>
			</grammar>
		</field>
		<block>
			<if cond="selection=='yes'">
				<submit next="Welcome.jsp"/>
			<elseif cond="selection=='no'"/>
				<prompt>thank you </prompt>
		</if>
		</block>
	</form>
</vxml>

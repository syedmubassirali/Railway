<?xml version="1.0" encoding="UTF-8"?>


<vxml version="2.1">
	<form>
		<field name="npassengers" type="digits">
				<prompt bargein="false">please enter number of passengers</prompt>
		</field>
		<block>
			<submit next="BookTicket?action=select"/>
		</block>
	</form>
</vxml>
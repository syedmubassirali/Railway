<?xml version="1.0" encoding="UTF-8"?>

<vxml version="2.1">
	<form>
		<field name="ticketid" type="digits">
				<prompt bargein="false">please enter your ticket i d </prompt>
		</field>
		<block>
			<submit next="TicketCancellation?action=cancelTicket"/>
		</block>
	</form>
</vxml>
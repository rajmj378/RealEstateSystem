<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.realstate.doa.TranscationDAO"%>
<%@page import="com.realstate.actions.transactions.ATransaction"%>
<%@page import="com.realstate.actions.PropertyUtil"%>
<%@page import="com.realstate.person.Person"%>
<%@page import="com.realstate.property.Apartment"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.realstate.property.Property"%>
<%@page import="java.util.List"%>
<html>
<body>
<h2>
		Hello 
		<span style="color: blue;"><%=((Person) session.getAttribute("user")).getName()%>  !!!!</span></h2>
		
	<h3>Following are the Latest Transcations in this system.</h3>
	<table cellpadding="3px" cellspacing="4px" style="width: 70%; text-align: center;">
		<tr>
			<th>S.N</th>
			<th>Owner Name</th>
			<th>Client Name</th>
			<th>Propery Address</th>
			<th>Type Of Transcation</th>
			<th>Transcation Date</th>
		</tr>
		<%
			List<ATransaction> trans = new TranscationDAO().getAllTranscations();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			for (ATransaction t : trans) {
				int i =1;
		%>

		<tr>
			<td><%=i %></td>
			<td><%=t.getOwner().getName()%></td>
			<td><%=t.getClient().getName()%></td>
			<td><%=t.getProperty().getAddress()%></td>
			<td><%=t.getType()%> </td>
			<td><%=simpleDateFormat.format(t.getTransactionDate())%></td>
			
		</tr>
		<%
		i++;
			}
		%>
	</table>
	<div style="height: 50px;width: 100%;border: solid; margin-top: 50px;">
	Note: Once you Buy or Rent a property, you cannot cancel the bookings.
	</div>
</body>
</html>

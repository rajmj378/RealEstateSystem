<%@page import="com.realstate.person.Person"%>
<%@page import="com.realstate.property.Apartment"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@page import="com.realstate.actions.ProperyUtil"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.realstate.property.Property"%>
<%@page import="java.util.List"%>
<html>
<body>
	<h2>
		Hello Client
		<%=((Person)session.getAttribute("user")).getName()%></h2>
	<table>
		<tr>
			<td>name</td>
			<td>type</td>
			<td>price</td>
			<td>Buy/rent</td>
		</tr>
		<%
			List<Property> properties = new ProperyUtil().getAllProperties();
			for (Property p : properties) {
		%>

		<tr>
		
			<td><%=p.getPrice()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getPrice()%></td>
			<td>
				<%
					out.println("<a href='goToDetails?id=" + p.getId() + "&user="
								+ ((Person)session.getAttribute("user")).getName()+ "'>rent</a>");
				
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>

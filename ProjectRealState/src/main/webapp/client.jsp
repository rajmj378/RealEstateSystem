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
		Hello Client
		<%=((Person) session.getAttribute("user")).getName()%></h2>
	<table>
		<tr>
			<td>name</td>
			<td>type</td>
			<td>price</td>
			<td>Buy/rent</td>
		</tr>
		<%
			List<Property> properties = new PropertyUtil().getAllProperties();
			for (Property p : properties) {
		%>

		<tr>

			<td><%=p.getId()%></td>
			<td><%=p.getPropertyType()%></td>
			<td><%=p.getPrice()%></td>
			<td>		
			<%out.println("<a href='propertyDetail.jsp?id=" + p.getId() + "'>rent</a>");%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>

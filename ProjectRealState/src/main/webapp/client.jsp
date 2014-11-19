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
		
	<h3>Following are the list of properties you can buy or rent.</h3>
	<table cellpadding="3px" cellspacing="4px" style="width: 50%; text-align: center;">
		<tr>
			<th>Name</th>
			<th>Type</th>
			<th>Price</th>
			<th>Buy/Rent</th>
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
	<div style="height: 50px;width: 100%;border: solid; margin-top: 50px;">
	Note: Once you Buy or Rent a property, you cannot cancel the bookings.
	</div>
</body>
</html>

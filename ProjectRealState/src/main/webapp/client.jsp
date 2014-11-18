<%@page import="java.util.LinkedList"%>
<%@page import="com.realstate.property.Property"%>
<%@page import="java.util.List"%>
<html>
<body>
	<h2>
		Hello Client
		<%=request.getAttribute("user")%></h2>
	<table>
		<%
			List<Property> properties = ;
			for (Property p : properties) {
		%>

		<tr>
			<td>{p.getName()}</td>
			<td>{p.getType()}</td>
			<td>p.getPrice</td>
			<td><a href="buy?clientId='<%%>>'"></a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>

<%@page import="com.realstate.actions.PropertyUtil"%>
<%@page import="com.realstate.actions.ViewService"%>
<%@page import="com.realstate.view.View"%>
<%@page import="com.realstate.property.*"%>
<%@page import="java.util.List"%>
<%@page import="com.realstate.person.Person"%>
<html>
<head></head>
<body>
	<div>
		<h2></h2>
		<%
			int propertyId = Integer.parseInt(request.getParameter("id"));
			Property property = new PropertyUtil()
					.getPropertyFromId(propertyId);
			if (property != null) {
		%>
		<div>
			<h2>The detail of the property you wish to order:</h2>
		</div>
		<table cellpadding="5px" cellspacing="2px">
			<tr>
				<td>Property Type</td>
				<td><%=property.getPropertyType()%></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><%=property.getAddress()%></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><%=property.getPrice()%></td>
			</tr>
		</table>

		<%
			if (new PropertyUtil().getPropertyFromId(propertyId)
						.getPropertyType().equals("apt")) {
		%>
		<form action="rent.jsp" method="post">
			<input type="hidden" value=<%=propertyId%> name="id">
			<input type="submit" value="Rent">
		</form>
		<%
			} else {
		%>
		<form action="buy.jsp" method="post">
			<input type="hidden" value=<%=propertyId%> name="id">
			<input type="submit" value="Buy">
		</form>

		<%
			}
			}
		%>
	</div>
	<div style="margin-top: 100px;">
		<h2>
			Comments
			<h2>
				<%
					List<View> viewList = new ViewService()
							.getViewForProperty(propertyId);
					if (viewList != null) {
				%>
				<table cellspacing="5px" cellpadding="5px ">
					<%
						for (View v : viewList) {
					%>
					<tr>
						<td><%=v.getClient().getName()%></td>
						<td><%=v.getComment()%></td>
					</tr>
					<%
						}
					%>
				</table>
				<%
					}
				%>

				<form action="viewServlet" method="post">
					<table cellpadding="5px">
						<tr>
							<td><%=((Person) request.getSession().getAttribute("user"))
					.getName()%></td>
							<td><Textarea cols="100" rows="6" name="comment"> </Textarea></td>
						</tr>
					</table>
					<input name="id" type="hidden"
						value="<%=request.getParameter("id")%>" /> <input type="submit"
						value="Comment">
				</form>
				</table>
	</div>

</body>
</html>
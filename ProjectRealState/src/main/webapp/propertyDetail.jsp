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
	int propertyId=Integer.parseInt(request.getParameter("id"));
	Property property=new PropertyUtil().getPropertyFromId(propertyId);
	if(property!=null) {	
%>
		<table>
			<tr>
				<td>Property Type</td>
				<td><%= property.getPropertyType() %></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><%= property.getAddress() %></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><%= property.getPrice() %></td>
			</tr>
		</table>
		<form action="login" method="post">
			<input type="submit" value="Buy">
		</form>
		<%} %>
	</div>
	<h2>Comments<h2>
<%
	List<View> viewList=new ViewService().getViewForProperty(propertyId);
	if(viewList!=null) {
%>
			<table>
				<% for(View v : viewList){ %>
				<tr>
					<td><%= v.getClient().getName() %></td>
					<td><%= v.getComment() %></td>
				</tr>
				<% }%>
			</table>
			<%}%>

			<table>
				<tr>
					<td><%=((Person)request.getSession().getAttribute("user")).getName()%>
					</td>
					<td><Textarea> </Textarea></td>
				</tr>
			</table>
			<form action="viewServlet" method="post">
				<input type="submit" value="Comment">
			</form>
</body>
</html>
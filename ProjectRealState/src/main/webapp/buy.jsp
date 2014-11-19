<%@page import="com.realstate.actions.PropertyUtil"%>
<%@page import="com.realstate.actions.ViewService"%>
<%@page import="com.realstate.view.View"%>
<%@page import="com.realstate.property.*"%>
<%@page import="java.util.List"%>
<%@page import="com.realstate.person.Person"%>
<html>
<head></head>
<body>
<div style="margin-top: 100px;">
	<h2>Buy Property?<h2>
	<form action="buy" method="post">
			
			<h3>Lease Terms</h3>
			<p>Copyright 2004 The Apache Software Foundation

  					Licensed under the Apache License, Version 2.0 (the "License");
  					you may not use this file except in compliance with the License.
  					You may obtain a copy of the License at

      				http://www.apache.org/licenses/LICENSE-2.0

  					Unless required by applicable law or agreed to in writing, software
  					distributed under the License is distributed on an "AS IS" BASIS,
  					WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  					See the License for the specific language governing permissions and
  					limitations under the License.
  			</p>	
  			<input TYPE="radio" name="leaseSigned" VALUE="1"> I Agree the terms and Conditions of Lease.
  			<input TYPE="radio" name="leaseSigned" VALUE="0"> I Do Not Agree the terms and Conditions of Lease.
  			
  				<BR>	
				<input name="id" type="hidden" value="<%=request.getParameter("id")%>"/>
				<input type="submit" value="Buy">				
	</form>
</div>

</body>
</html>
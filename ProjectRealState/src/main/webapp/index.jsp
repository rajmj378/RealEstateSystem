<html>
<body>
<div style="margin-left: 30%;margin-top: 10%">
<h2>Real State Login System</h2>

<form action="login" method="post">

<table>
<tr>
	<td>Please enter your username</td> 		
	<td><input type="text" name="un"/></tr>
</tr>		
<tr>	
			<td>Please enter your password</td>
			<td><input type="password" name="pw"/></td>
</tr>
			<td>Please select type</td>
			<td><input type="radio" name="rad" value="client" checked="checked"/> Client
			<input type="radio" name="rad" value="employee"/> Employee
			<input type="radio" name="rad" value="admin"/> Admin 
			</td>
			<tr>
			<td></td><td><input type="submit" value="submit"></td>
</table>			
		</form>
</div>
</body>
</html>

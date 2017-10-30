<%@ page language="java" import="org.json.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Details</title>
</head>
<body>
	<h3 align="center">Account Details</h3>
   <table border="2" bgcolor="#efe6aa" cellpadding="10" style="margin: 0px auto;">
   		<thead>
   			<tr>
   				<th> Name</th>
   				<th>Twitter Handle</th>
   				<th>Total Friends</th>
   				<th>Total Followers</th>
   			</tr>
   		</thead>
		<%
		String credentialsStr = request.getAttribute("credentials").toString();
		JSONObject credentials = new JSONObject(credentialsStr);
		%>
		<tbody>
			<tr>
				<td>
				<%=credentials.getString("name")%>
				</td>
				<td> 
				<%=credentials.getString("screen_name")%>
				</td>
				<td> 
				<%=credentials.getInt("friends_count")%>
				</td>
				<td> 
				<%=credentials.getInt("followers_count")%>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
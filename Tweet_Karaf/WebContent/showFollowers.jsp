<%@ page language="java" import="org.json.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Followers List</title>
</head>
<body>
	<h3 align="center">List of Followers</h3>
	<table border="2" bgcolor="#efe6aa" cellpadding="10" style="margin: 0px auto;">
			<tr>
				<th>Name</th>
				<th>User Name</th>
			</tr>
		<tbody>
	<%
		Object respBody = null;
		String usersStr = null;
		JSONArray users = null;
		if (request.getAttribute("followers") != null) {
			respBody = request.getAttribute("followers");
		} else if (request.getAttribute("friends") != null) {
			respBody = request.getAttribute("friends");
		}
		usersStr = respBody.toString();
		users = new JSONArray(new JSONObject(usersStr).getJSONArray("users").toString());
		for (int i = 0; i < users.length(); i++)
		{
			%><tr>
				<td> 
				<%=users.getJSONObject(i).getString("name")%>
				</td>
				<td>
				<%=users.getJSONObject(i).getString("screen_name")%>
				</td>
			 </tr>
	   <%}
	%>
	</tbody>
	</table>
</body>
</html>
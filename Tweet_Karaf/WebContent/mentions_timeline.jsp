<%@ page language="java" import="org.json.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Timeline Tweets</title>
</head>
<body>
	<h4>Twwets Categorised By Users</h4>
	<table border="2" bgcolor="#efe6aa" cellpadding="10" style="margin: 0px auto;">
		<thead>
   			<tr>
   				<th>Timestamp</th>
   				<th>Created By</th>
   				<th>Tweets</th>
   			</tr>
   		</thead>
   		<tbody>

	<%
	String tweetsStr = request.getAttribute("mentionTimeline").toString();
	JSONArray tweets = new JSONArray(tweetsStr);
	JSONObject tweet;
		for (int i = 0; i < tweets.length(); i++)
		{
			tweet = tweets.getJSONObject(i);
			%><tr>
				<td>
				<%=tweet.getString("created_at")%>
				</td>
				<td>
				<%=tweet.getJSONObject("user").getString("screen_name")%>
				</td>
				<td>
				<%=tweets.getJSONObject(i).getString("text")%>
				</td>
			</tr>
		<%}
	%>
	</tbody>
	</table>
</body>
</html>
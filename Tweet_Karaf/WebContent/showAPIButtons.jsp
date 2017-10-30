<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>

<div style="background:url(homepage.gif);width:1400px;height:670px;color:black;font-size:18px;border:1px outset #ccc;padding:5px;">

	<h1 align="center" style="color:blue;">Twitter API</h1>
	<form id="sa1" action="MainServlet" method="GET">
		<input type="hidden" name="oauth_verifier" id="oauth_verifier" value="<%=request.getParameter("oauth_verifier")%>" />
		<input type="hidden" name="oauth_token" id="oauth_token" value="<%=request.getParameter("oauth_token")%>" />
	</form>
	<form id="sa2" action="MainServlet" method="POST">
		<input type="hidden" name="oauth_verifier" id="oauth_verifier" value="<%=request.getParameter("oauth_verifier")%>" />
		<input type="hidden" name="oauth_token" id="oauth_token" value="<%=request.getParameter("oauth_token")%>" />
	</form>
	
	<table border="2" bgcolor="gray" cellpadding="10" style="margin: 0px auto;">
    <tr><td><input type="submit" form="sa1" class="btn" name="mentionTimeline" value="Mention Timeline" /></td>
    <td><input type="submit" form="sa1" class="btn" name="getFollowers" value="Followers" /></td></tr>
    <tr><td><input type="submit" form="sa1" class="btn" name="reTweet" value="Re tweets" /></td>
    <td><input type="submit" form="sa1" class="btn" name="verifyCredentials" value="Credential Verification"/></td></tr>
    <tr><td><input type="submit" form="sa1" class="btn" name="searchTweets" value="Search Tweets"/></td>
    <td><input type="submit" form="sa1" class="btn" name="favoriteTweets" value="Favorite Tweets"/></td></tr>
    <tr><td><input type="submit" form="sa1" class="btn" name="timelineTweets" value="Timeline Tweets"/></td>
    
    <td><input form="sa2" type="submit" class="btn" name="tweet" value="Post a tweet"/></td></tr>
    
</table>
	
	</div>
</body>
</html>
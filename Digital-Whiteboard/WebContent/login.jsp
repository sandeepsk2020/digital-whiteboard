<%@page import="de.htwg.digitalwhiteboard.session.SessionHandler"%>
<%@page import="de.htwg.digitalwhiteboard.session.ISession"%>
<%@page import="de.htwg.digitalwhiteboard.util.Constants" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>
<%@page import="java.util.Map.Entry" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Digital Whiteboard Login</title>
</head>
<body>

	<H1>Welcome to the Digital Whiteboard</H1>

	<p>Please login as presenter or join an existing session as anonymous viewer.</p>

	<hr />

	<h2>Presenter Login</h2>
	<form method="post">
	
	Username: <input type="text" name="<% out.print(Constants.PRESENTER_USERNAME);%>" />
	<br />
	Password: <input type="password" name="<% out.print(Constants.PRESENTER_PASSWORD);%>" />
	<br/>

	<input type="submit" value="Login" />
	
	</form>

	<hr />

	<h2>Anonymous Login</h2>
	<form method="post">
	
		<p>Choose an active session to join:</p>
		
		<table border="1">
		
		<tr>
			<th></th>
			<th>Session ID</th>
			<th>Presenter</th>
		</tr>
		
			<%
			
			Set<Entry<Integer, ISession>> activeSessions = SessionHandler.getInstance().getActiveSessions().entrySet();
			
			for(Map.Entry<Integer, ISession> entry : activeSessions) {
				int key = entry.getKey();
				
				out.println("<tr><td><input type=\"radio\" name=\"" + Constants.ANON_LOGIN_NAME + "\" value=\"" + key + "\" />" +
				"</td><td>" + key + "</td><td>" + entry.getValue().getUser().getUserName() + "</td></tr>");
			}
			
					
			%>
			
		</table>
		
		
	<p>
	<input type="submit" value="Login" />
	</p>
	
	</form>
	

</body>
</html>
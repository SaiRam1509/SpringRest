<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log-In</title>
<link rel="stylesheet" type="text/css" href="/css/login.css" />
<link rel="shortcut icon" type="image/png" href="/images/favicon.png">
</head>
<body>
<form action="logincheck" method="post">
${msg} <br><br>
<p>${specifictime}</p>
  <p> ${currenttimestamp} </p>
<h3>USER ID</h3>  <br><br>
<input type="text" name="username" placeholder="Enter user name"></input><br><br>
<h3>PASSWORD</h3> <br><br>
<input type="password" name="password" placeholder="Enter password"></input><br><br>
<table>
<tr>
<td><center><button type="submit" name="login">Login</button></center></td>
<td><a href ="register"><center><button id="register" type="button">Register</button></center></a></td>
</tr>

</table>
</form>
</body>
</html>
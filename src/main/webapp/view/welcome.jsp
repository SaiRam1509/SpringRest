<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopable</title>
<link rel="stylesheet" type="text/css" href="/css/welcome.css" />
<link rel="shortcut icon" type="image/png" href="/images/favicon.png">
</head>
<body>


<div class="heading">

<div class="wrap">
<nav>
<div class="logo"><img src="/images/logo.png" width="100" height="100"></div>
<ul>
<li><a href="shopping">Shop</a></li>
<li><a href="logout">Logout</a></li>
</ul>
</nav>
</div>
</div>


<div class ="desc"><h2>Welcome ${uname}</h2><br><br>Scan and go
<h3>
Shop smarter. All you have to do is scan and bag the items as you shop,<br> 
using the handset provided, or the Scan and Go MobileApp and breeze<br>
through the dedicated card checkouts.
</h3>
<br><br>
<br><br><br>

<h4><center>Our Products</center></h4>
<table class="content-table">
<tr>

<th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>PRICE</th>
<th>IN STOCK</th>

</tr>

<c:forEach items="${plist}" var="p">
<tr>
<td style="text-align:center"><c:out value="${p.productid}"/></td>
<td style="text-align:center"><c:out value="${p.productname}"/></td>
<td style="text-align:center"><c:out value="${p.price}"/></td>
<td style="text-align:center"><c:out value="${p.availstock}"/></td>
</tr>
</c:forEach>

</table>

</body>
</html>
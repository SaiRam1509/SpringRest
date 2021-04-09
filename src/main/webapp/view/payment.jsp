<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link rel="stylesheet" type="text/css" href="/css/payment.css" />
<link rel="shortcut icon" type="image/png" href="/images/favicon.png">
</head>
<body>

<center>Your Order</center>
<table class="content-table">

<tr>

<th>PRODUCT ID</th>
<th>PRODUCT NAME</th>
<th>QUANTITY</th>
<th>NET PRICE</th>
<th></th>

</tr>

<c:forEach items="${ulist}" var="u">

<tr>
<td style="text-align:center"><c:out value="${u.productid}"/></td>
<td style="text-align:center"><c:out value="${u.productname}"/></td>
<td style="text-align:center"><c:out value="${u.quantity}"/></td>
<td style="text-align:center"><c:out value="${u.batchtotal}"/></td>
<td><button id="${u.productid}" onClick="delet(this.id)">Delete</button></td>
</tr>

</c:forEach>
</table><br>
<center>TOTAL PRICE:${carttotal}</center> <br><br>
<center>WALLET MONEY:${wallet}</center><br>
<center>${nomoney}</center>
<center>${noitem}</center><br>

<center><a href="shopping"><button type ="button" >Menu</button></a>


<a href="success"><button type="button" >Pay</button></a></center>
<script>

function delet(cid){	
	 
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    
	    }
	  };
	  xhttp.open("GET", "/deleteproduct?cid="+cid, true);
	  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  
	  xhttp.send();
	}


</script>

</body>
</html>
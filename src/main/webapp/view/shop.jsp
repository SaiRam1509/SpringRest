<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lets's Shop</title>
<link rel="stylesheet" type="text/css" href="/css/shop.css" />
<link rel="shortcut icon" type="image/png" href="/images/favicon.png">

</head>
<body>


<form action="add" method="post">
<div class="product">Choose Your Product</div><br>
Enter Product Id<br><br>
<input type="text" name="productid"/><br><br>
Enter Quantity<br><br>
<input type="text" name="quantity"/><br><br>
<button class="add" type="submit" name="Add">Add</button><br><br>
</form><br><br>
<center><h5>${msg}</h5></center>

<div class="yourcart">
<center><h3>YOUR CART</h3></center></div>
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
<div><h3>TOTAL PRICE:${carttotal}</h3></div> <br><br>
<center><a href ="checkout"><div></div><button   class="checkout" >Checkout</button></div></a></center>


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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home page</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.login-form {
    width: 340px;
    margin: 50px auto;
}

 

.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}

 

.login-form h2 {
    margin: 0 0 15px;
}

 

.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}

 

.btn {
    font-size: 15px;
    font-weight: bold;
}

 

.error {
    color: red;
}

 

.msgdisp {
    color: red;
}

 

body {
    font-family: Arial;
    font-size: 17px;
    padding: 8px;
}

 

* {
    box-sizing: border-box;
}

 

.mi:hover {
    color: red;
}

 

@media ( min-width : 900px) {
    .desktop {
        display: block;
    }
}

 

.row {
    display: -ms-flexbox; /* IE10 */
    display: flex;
    -ms-flex-wrap: wrap; /* IE10 */
    flex-wrap: wrap;
    margin: 0 -16px;
}

 

.col-25 {
    -ms-flex: 25%; /* IE10 */
    flex: 25%;
}

 

.col-50 {
    -ms-flex: 50%; /* IE10 */
    flex: 50%;
}

 

.col-75 {
    -ms-flex: 75%; /* IE10 */
    flex: 75%;
}

 

.col-25, .col-50, .col-75 {
    padding: 0 16px;
}

 

.container {
    background-color: #f2f2f2;
    padding: 5px 20px 15px 20px;
    border: 1px solid lightgrey;
    border-radius: 3px;
}

 

input[type=text] {
    width: 100%;
    margin-bottom: 20px;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 3px;
}

 

label {
    margin-bottom: 10px;
    display: block;
}

 

.icon-container {
    margin-bottom: 20px;
    padding: 7px 0;
    font-size: 24px;
}

 

.btn {
    background-color: #4CAF50;
    color: white;
    padding: 12px;
    margin: 10px 0;
    border: none;
    width: 100%;
    border-radius: 3px;
    cursor: pointer;
    font-size: 17px;
}

 

.btn:hover {
    background-color: #45a049;
}

 

a {
    color: #2196F3;
}

 

hr {
    border: 1px solid lightgrey;
}

 

span.price {
    float: right;
    color: grey;
}

 

.col-25 {
    margin-bottom: 20px;
}

 

.con {
    position: relative;
    font-family: Arial;
}

 

.text-block {
    position: absolute;
    top: 150px;
    left: 50px;
    color: white;
}

 

.input-container {
    position: absolute;
    display: flex;
    width: 100%;
    top: 210px;
    left: 50px;
    margin-bottom: 15px;
}

 

.input-field {
    width: 100%;
    padding: 10px;
    outline: none;
}

 

.input-field:focus {
    border: 2px solid dodgerblue;
}

 

@media ( min-width : 900px) {
    .desktop {
        display: block;
    }
}

 

.error {
    color: red;
}

 

.cc1{

 

position: relative;
left: 560px;

 

}

 

</style>
</head>
<body style="background-color:#FFCBA4;">
    <form method="get">
        <div class="desktop">
            <nav class="navbar navbar-expand-lg navbar-dark"
                style="background-color: #ff3300;">
            </nav>
        </div>

 

    </form>
    <div class="login-form">
        <form action="/login" method="get" modelAttribute="loginvalid">
            <p>${msg }</p>
        <p>${specifictime}</p>
        <p> ${currenttimestamp} </p>
        <p>${duration}</p>
            <div class="form-group">
                
                <h3><a href="login.jsp"></a></h3> 
                
            </div>
            <div class="form-group">
            <a href="/login">
                <button type="button" class="btn btn-primary btn-block" >Login</button></a>
            </div>
            <div class="form-group">
                <a href="/register">
                    <button type="button" class="btn btn-primary btn-block">Register</button>
                </a>
            </div>
        
        </form>

 

    </div>
</body>
</html>
 
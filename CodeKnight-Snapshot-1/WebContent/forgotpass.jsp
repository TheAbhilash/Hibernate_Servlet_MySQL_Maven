<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.code.knight.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
    <title>Code Knight SNAPSHOT</title>
    
    
    <link rel="stylesheet" href="css/reset.css">

    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <link rel="stylesheet" href="css/style.css">

    
    
    
  </head>

  <body>

    
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Code Knight Login Form</h1>
</div>

<div class="after-error">
  <h3>${name}</h3>
</div>

<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Reset Your Password<div class="close"></div></h1>
    <form action="ResetPassword">
      <div class="input-container">
        <input type="text" id="Username" required="required" name="Username"/>
        <label for="Username">Username</label>
        <div class="bar"></div>
      </div>
      <div class="button-container" >
        <button><span>Go</span></button>
      </div>
      <div class="footer"><a href="index.jsp">Return to login page</a></div>
    </form>
  </div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
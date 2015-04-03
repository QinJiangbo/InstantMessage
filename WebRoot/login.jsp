<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<base href="<%=basePath%>">

<title>RR Chat Login</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="Style/bootstrap.css">
<link rel="stylesheet" href="Style/bootstrap-theme.css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="Style/jquery-2.0.2.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="Style/bootstrap.js"></script>
<link rel="shortcut icon" href="Images/favicon.ico">

<style type="text/css">
.myfont {
	font-family: cursive; /*fantasy,Myriad Pro; */
	font-size: 100px;
	color: #0055ff
}
</style>
</head>

<body>
	<div class="myfont" style="margin-top:140px;margin-left:385px;">
		<span>RR Chat Login</span>
	</div>
	<div style="margin-top:50px;margin-left:440px;width:560px">
		<form class="form-horizontal" name="form" action="loginAction.do" method="post">
			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">User</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputName"
						style="width:300px;float:left" placeholder="User ID" name="uid">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword"
						style="width:300px" placeholder="Password" name="pwd">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success" style="width:300px">Sign in</button> 
			</div>
		</form>
	</div>
	<div style="margin-top:75px;margin-left:0px">
		<span style="font-size:20px;font-family:Georgia;color:black">
			©Copyright 2014 By QinJiangbo All rights reserved </span>
	</div>
</body>
</html>

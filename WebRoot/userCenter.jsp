<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<title>RR Chat System</title>
<link rel="stylesheet" href="Style/bootstrap.min.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<link rel="shortcut icon" href="Images/favicon.ico">
<script type="text/javascript" src="Style/jquery-2.0.2.js"></script>
<script type="text/javascript" src="Style/bootstrap.min.js"></script>
<script type="text/javascript" src="Style/scripts.js"></script>

<style type="text/css">
.mystyle {
	font-family: Myriad Pro;
	font-size: 30px;
	font-color: black;
	padding-left: 60px;
}

.mytextarea {
	width: 400px;
	height: 50px;
	font-family: cursive;
	font-size: 30px;
}

.myMessageStyle {
	margin-left: 0px;
	border: 2px solid purple;
	margin-top: 10px;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div
					style="font-family:cursive;font-size:100px;margin-left:260px;color:#0055ff">RR
					Chat User</div>
				<hr style="border: 1.5px solid purple;margin-top:30px" />

				<div style="font-family:Myriad Pro;font-size:36px;text-align:center">
					Welcome ${userType } <span style="font-family:cursive;color:purple">${nickName
						}</span> !
				</div>

				<div class="myMessageStyle">
					<c:forEach items="${messageReplyList }" var="row">
						<div>
							<div class="mystyle">
								<strong>Time:</strong> ${row.senddatetime }
							</div>
							<div class="mystyle">
								<strong>Content:</strong> ${row.messageContent }
							</div>
							<c:set var="reply" value="${row.replyContent }" />
							<c:choose>
								<c:when test="${empty reply}">
									<div class="mystyle" style="margin-right:20px">
										<strong>Reply:</strong> <span style="color:red">The
											administrator doesn't reply!</span>
									</div>
								</c:when>
								<c:otherwise>
									<div class="mystyle">
										<strong>Reply:</strong> ${row.replyContent }
									</div>
								</c:otherwise>
							</c:choose>
							<hr style="border: 1.5px solid purple;margin-top:15px" />
							</div>
					</c:forEach>
					<div class="mystyle" style="float:left;margin-right:20px">
						<strong>Ask:</strong>
					</div>
					<div class="mystyle" style="margin-top:10px">
						<form class="form-horizontal" action="messageAction!askQuestion.do?uid=${uid}" method="post">
							<div class="form-group">
								<textarea class="form-control" id="inputText" name="message"
									style="width:900px;height:150px;font-family:cursive;font-size:30px;color:black;"></textarea>
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-success"
										style="width:120px;float:right;margin-top:10px;margin-right:20px">Submit</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top:60px;margin-left:450px">
		<span style="font-size:20px;font-family:Georgia;color:black">
			©Copyright 2014 By QinJiangbo All rights reserved </span>
	</div>
</body>
</html>

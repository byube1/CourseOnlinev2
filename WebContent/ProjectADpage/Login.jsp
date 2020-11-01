<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./mySource.css">
<link rel="stylesheet" href="./CSS/stylelogin.min.css">
<title>Admin Login</title>
</head>

<body>
	<div class="background-form">
		<div class="progressTop"></div>
		<div class="LoginForm">
			<form action="../LoginServlet" method="POST" id="Form1">
			<%--Code java --%>
			<p style="text-align: center; color: red;"><%=(session.getAttribute("Error")==null)?"":session.getAttribute("Error")%></p>
			<%--Code java --%>
				<h3>ADMIN</h3>
				<div class="inputField">
					<input type="text" id="Email" class="box" required="required"
						name="email"> <label for="Email">Email</label>
				</div>
				<div class="inputField">
					<input type="password" id="pass" class="box" required="required"
						name="pass"> <label for="Email">Password</label>
				</div>
				<div class="btn-box">
					<button type="submit" id="Next1" class="Button_1">Login</button>
				</div>
			</form>
		</div>
		<div class="progressBottom"></div>
	</div>
</body>
<%--Code java --%>
<%session.removeValue("Error"); %>
<%--Code java --%>
</html>
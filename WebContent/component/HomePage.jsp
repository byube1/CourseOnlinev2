<%-- 
    Document   : HomePage
    Created on : Oct 24, 2020, 6:23:18 PM
    Author     : WIN 10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<title>Home Page</title>
<%@include file="header.jsp"%>
<link href="css1/styleB.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<header class="container">
		<a class="navbar-brand mx-4" href="#"> <img
			src="../img1/logo123.png" /></a>
		<div style="float: right;">
			<span class="pr-3" style="font-size: 22px">Hello,
				${User.getName()}</span>
				
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
             <i class="fas fa-book-reader"></i>
           </button>
           
           
			<button type="button" class="btn btn-danger" value="Logout">
				<a href="../LogoutServlet">LOGOUT</a>
			</button>
		</div>
	</header>
	<%@include file="Carousel.jsp"%>
	<%@include file="HotCourse.jsp"%>
	<%@include file="Course.jsp"%>
	<%@include file="footer.jsp"%>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Your course</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      <table class="table table-sm bg-light ">
                                <thead>
                                  <tr>
                                    <th scope="col">Status</th>
                                    <th scope="col">Course Name</th>
                                    <th scope="col">Date</th>
                                   
                                  </tr>
                                </thead>
                                <tbody>
                                
                              <c:forEach var="Course" items="${CourseOfUser}">
                             
                                  <tr>
                                    <th scope="row" style="color: green;">Active</th>
                                    <td>${Course.getNameCourse()}</td>
                                    <td>${Course.getDateBuy()}</td>                                                                
                                  </tr>   
                                  </c:forEach>                         
                                </tbody>                                                               
                              </table>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
	
</body>
</html>

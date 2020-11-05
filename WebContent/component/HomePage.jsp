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
        <title>Home Page</title>
        <%@include file="header.jsp" %>
        <link href="../css1/styleB.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="Navbar.jsp" %>
        <%@include file="Carousel.jsp" %>
        <%@include file="HotCourse.jsp" %>
        <%@include file="Course.jsp" %>
        <%@include file="Cart.jsp" %>
        <%@include file="footer.jsp" %>

    </body>
</html>

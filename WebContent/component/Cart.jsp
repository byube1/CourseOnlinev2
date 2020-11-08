<%-- 
    Document   : Cart
    Created on : Nov 5, 2020, 1:41:58 PM
    Author     : WIN 10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            body{
                background-image: url("https://thietbiketnoi.com/wp-content/uploads/2020/01/tong-hop-hinh-nen-background-vector-designer-dep-do-phan-giai-fhd-2k-4k-moi-nhat-4.jpg");
                width: 100%;
                background-repeat: no-repeat;
                height: 100%
            }
            .table{
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="container YourCartShopping" >
            <h1 style="text-align: center; margin: 50px 0px;color: white">Your Shopping Cart</h1>
            <table class="table table-bordered table-dark table-striped">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Photo</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Sub Total</th>
                        <th>Option</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="total" value="0"></c:set>
                    <c:forEach var="item" items="${sessionScope.cart}">
                        <c:set var="total" value="${total + item.course.coursePrice * item.quantity}"></c:set>
                            <tr>
                                <td>${item.course.courseID }</td>
                            <td>${item.course.courseName }</td>
                            <td><img class="fluid" src="${item.course.img } " alt="" /></td>
                            <td>${item.course.coursePrice }</td>
                            <td>${item.quantity }</td>
                            <td>${item.course.coursePrice * item.quantity }</td>
                            <td align="center">
                                <button type="button" class="btn btn-danger">
                                    <a style="text-decoration: none;color: white"
                                       href="${pageContext.request.contextPath }/CartServlet?action=remove&id=${item.course.courseID }"
                                       onclick="return confirm('Are you sure?')">Remove</a>
                                </button>
                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
                <tr>
                    <td colspan="2"  >
                        <button 
                            type="button" class="btn btn-primary">
                            <a style="text-decoration: none;color: white"
                               href="component/HomePage.jsp">Buy More</a>
                        </button>
                    </td>
                    <td colspan="3" align="right">Total</td>
                    <td>${total }</td>
                    <td colspan="5" align="center">
                        <button type="button" class="btn btn-success">
                           <a style="text-decoration: none;color: white"
                               href="./AcceptCartServlet">Accept</a>
                        </button>
                    </td>
                </tr>
            </table>

        </div>

    </body>
</html>

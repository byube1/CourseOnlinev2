<header class="container">
    <a class="navbar-brand mx-4" href="#">
        <img src="../img1/logo123.png" /></a>
    <div style="float: right;">
        <span class="pr-3" style="font-size: 22px">Hello, ${User.getName()}</span>
        <button type="button" class="btn btn-danger" value="Logout" >
            <a href="../SignIn_SignUp.jsp">LOGOUT</a>
            <%
                session.removeAttribute("User");
            %>
        </button>

    </div>
</header>

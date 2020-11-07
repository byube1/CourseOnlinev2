<%-- 
    Document   : SignIn_SignUp
    Created on : Oct 18, 2020, 10:18:49 PM
    Author     : WIN 10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <script
            src="https://kit.fontawesome.com/64d58efce2.js"
            crossorigin="anonymous"
        ></script>
        <link href="css1/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="container sign-up-mode">
            <div class="forms-container">
                <div class="signin-signup">
                
                
                     <form action="../SignInServlet" class="sign-in-form" method="POST">
                        <h2 class="title">Sign in</h2>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="email" placeholder="Email" name="emailUser" required />
                        </div>
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input type="password" placeholder="Password" name="passUser" required/>
                        </div>
                        <p style="text-align: center; color: red;">
                            <%=(session.getAttribute("Error") == null) ? "" : session.getAttribute("Error")%>
                        </p>
                        <input type="submit" value="Login" class="btn solid"  />
                    </form>
                    <%session.removeValue("Error");%>
                    

                    <form action="../SignUpServlet" class="sign-up-form" method="POST">
                     
                        <h2 class="title">Sign up</h2>

                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="email" placeholder="Email" name="emailUser" required/>
                             <p style="text-align: center; color: red;">
                            <%=(session.getAttribute("Error") == null) ? "" : session.getAttribute("Error")%>
                        </p>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input type="password" placeholder="Password" name="passUser" required/>
                        </div>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="text" placeholder="Username"  name="nameUser" required/>
                        </div>
                        <p style="text-align: center; color: red;">
                            <%=(session.getAttribute("Errors") == null) ? "" : session.getAttribute("Errors")%>
                        </p>
                        <input type="submit" class="btn" value="Sign up" />
                    </form>
                     <%session.removeValue("Error");%>
                    
                   
                    
                    
                </div>
            </div>

            <div class="panels-container">
                <div class="panel left-panel">
                    <div class="content">
                        <h3>New here ?</h3>
                        <p>
                            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Debitis,
                            ex ratione. Aliquid!
                        </p>
                        <button class="btn transparent" id="sign-up-btn">
                            Sign up
                        </button>
                    </div>
                    <img src="#" class="image" alt="" />
                </div>
                <div class="panel right-panel">
                    <div class="content">
                        <h3>One of us ?</h3>
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum
                            laboriosam ad deleniti.
                        </p>
                        <button class="btn transparent" id="sign-in-btn">
                            Sign in
                        </button>
                    </div>
                    <img src="#" class="image" alt="" />
                </div>
            </div>
        </div>
        <script src="js1/main.js" type="text/javascript"></script>
    </body>
</html>

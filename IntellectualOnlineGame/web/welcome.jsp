<%-- 
    Document   : example
    Created on : Jan 19, 2014, 8:54:59 PM
    Author     : memmedimanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
    <head>
        <title>NHN</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="b-css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <div id="container" style="width:1366px;height:100%;"> 
            <div id="header" style="background-color:#3f9fd9; height:30%;" >


                <h1> Welcome to our website </h1>
            </div>
        </div>


        <div id="container" style="width:1366px;height:100%;"> 
            <div id="sign_in" style="height:668px;margin-left: 450px;">	

                <div class="container">

                    <form class="form-signin"  action="login" method="post">
                        <h2 class="form-signin-heading"> Daxil olun</h2>
                        <input type="text" class="form-control" placeholder="username" name="username" id="username" required autofocus><br/>
                        <input type="password" class="form-control" placeholder="password" name="password" id="password" required>
                        <label class="checkbox">
                            <input type="checkbox" value="remember-me"> Yadda saxla
                        </label>
                        <label >
                          <a href="register.jsp"> Qeydiyyatdan keç </a>
                        </label>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Daxil ol</button><br/>

                        <jsp:include page="common/fblike.jsp"/>
                    </form>

                </div> 
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="b-js/bootstrap.min.js"></script>
    </body>
</html>

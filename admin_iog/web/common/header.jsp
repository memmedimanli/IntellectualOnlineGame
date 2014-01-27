<%-- 
    Document   : header
    Created on : Jan 13, 2014, 3:01:15 AM
    Author     : memmedimanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- topbar starts -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="index.jsp"> <img alt="Charisma Logo" src="img/logo20.png" /> <span>Admin Panel</span></a>

           

            <!-- user dropdown starts -->
            <div class="btn-group pull-right" >
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-user"></i><span class="hidden-phone"> admin</span>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="profile.jsp">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="welcome.jsp">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

           
        </div>
    </div>
</div>
<!-- topbar ends 
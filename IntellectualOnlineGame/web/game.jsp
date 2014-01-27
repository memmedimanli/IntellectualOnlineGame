<%-- 
    Document   : game
    Created on : Jan 8, 2014, 3:32:28 AM
    Author     : memmedimanli
--%>

<%@page import="net.iog.database.SqlQuery"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>

        <jsp:include page="common/meta.jsp"/>
        <jsp:include page="common/style.jsp"/>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/jquery.countdown.css"> 
        <script type="text/javascript" src="js/jquery.plugin.js"></script> 
        <script type="text/javascript" src="js/jquery.countdown.js"></script>

    </head>

    <body>
        <jsp:include page="common/header.jsp"/>
        <div class="container-fluid">
            <div class="row-fluid">

                <jsp:include page="common/menu.jsp"/>

                <jsp:include page="common/nonscript.jsp"/>

                <div id="content" class="span10">
                    <!-- content starts -->




                    <div class="row-fluid sortable">
                        <div class="box span12">
                            <div class="box-header well" data-original-title>
                            </div>

                            <div class="box-content">
                                <form class="form-horizontal">
                                    <fieldset>
                                     <%--    <div id="countdown">
                                        <script>
                                            $("#countdown").countdown({until: getTime() + 120});
                                        </script>
                                        </div> 
                                       <%
                                            Class.forName("com.mysql.jdbc.Driver");
                                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_nhn", "root", "100105018");

                                            PreparedStatement ps = connection.prepareStatement(SqlQuery.CHOOSE_QUESTION);
                                            ResultSet rs = ps.executeQuery();
                                            int i = 1;
                                            while (rs.next()) {
                                        %>

                                        <h2> <%= i%> . <%= rs.getString("content")%> <br/> </h2>

                                        <%
                                                i++;
                                            }
                                        %>  --%>

                                        <div class="control-group">
                                            <label class="control-label" for="typeahead"></label>
                                            <div class="controls">
                                                <input type="text" class="span6 typeahead" id="answer"  placeholder="Cavabınızı daxil edin..." name="answer" data-provide="typeahead" data-items="4">

                                            </div>
                                        </div>

                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Cavabla</button>

                                        </div>


                                    </fieldset>
                                </form>   

                            </div>
                        </div><!--/span-->

                    </div><!--/row-->




                    <!-- content ends -->
                </div><!--/#content.span10-->
            </div><!--/fluid-row-->

            <hr>

            <div class="modal hide fade" id="myModal">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary">Save changes</a>
                </div>
            </div>

            <jsp:include page="common/footer.jsp"/>

        </div><!--/.fluid-container-->
        <jsp:include page="common/javascript.jsp"/>


    </body>
</html>


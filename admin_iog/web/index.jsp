<%-- 
    Document   : index
    Created on : Jan 11, 2014, 8:54:38 PM
    Author     : memmedimanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>

        <jsp:include page="common/meta.jsp" /> 
        <jsp:include page="common/style.jsp"/>
    </head>

    <body>

        <jsp:include page="common/header.jsp"/>

        <div class="container-fluid">
            <div class="row-fluid">

                <jsp:include page="common/menu.jsp"/>

                <jsp:include page="common/nonscript.jsp"/>


                
                    <!-- content ends -->
                </div><!--/#content.span10-->
            </div><!--/fluid-row-->

            <hr>

            <jsp:include page="common/footer.jsp"/>

        </div><!--/.fluid-container-->

        <jsp:include page="common/javascript.jsp"/>

    </body>
</html>


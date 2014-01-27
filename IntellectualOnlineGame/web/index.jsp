<%-- 
    Document   : index
    Created on : Dec 1, 2013, 12:42:13 AM
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


                <div id="content" class="span10">
                    <!-- content starts -->


                   
                   

                    <div class="row-fluid">
                        <div class="box span12">
                            <div class="box-header well">
                                <h2><i class="icon-info-sign"></i> Məlumat </h2>
                                
                            </div>
                            <div class="box-content">
                                <h3>Nə? Harada? Nə zaman? <small> yarışması hər yaşdan insanları düşünməyə vadar edən bir intelektual yarışmadır.</small></h3>
                                <p>Siz bizim site`a daxil olaraq həm komanda yaradıb, dostlarınızı dəvət edib komanda halında yarışmalarda iştirak edə bilərsiz, həm də ki fərdi olaraq öz məntiqinizi və dünya 
                                    görüşünüzü yoxlaya və artıra bilərsiniz. Həmçinin <a href="forum.jsp">Forum</a> bölümünə də daxil olub öz sualınızı verə bilər və ya mövcud suallara cavab verə bilərsiz.</p>
                                <p> Hər cür məsləhət və iradlarınızı <a href="contact.jsp"> Əlaqə </a> bölümündən bizə çatdıra bilərsiniz. </p>

                                
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>

                    <!-- content ends -->
                </div><!--/#content.span10-->
            </div><!--/fluid-row-->

            <hr>

            <jsp:include page="common/footer.jsp"/>

        </div><!--/.fluid-container-->

        <jsp:include page="common/javascript.jsp"/>

    </body>
</html>


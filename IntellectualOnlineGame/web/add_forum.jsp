<%-- 
    Document   : add_forum
    Created on : Jan 7, 2014, 12:25:23 AM
    Author     : memmedimanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>

        <jsp:include page="common/meta.jsp"/>
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




                    <div class="row-fluid sortable">
                        <div class="box span12">
                            <div class="box-header well" data-original-title>


                            </div>
                            <div class="box-content">
                                 <form class="form-horizontal" method="POST" action="fs?action=forum">
                                    <fieldset>
                                       
                                      
                                        <div class="control-group">
                                            <label class="control-label" for="typeahead"> <b>Başlıq : </b> </label>
                                            <div class="controls">
                                                <input type="text" class="span6 typeahead" id="subject"  name="subject" data-provide="typeahead" data-items="4" >
                                                
                                            </div>
                                        </div>



                                        <div class="control-group">
                                            <label class="control-label" for="textarea2"> <b>Sualinizi daxil edin : </b> </label>
                                            <div class="controls">
                                                <br/> <textarea class="cleditor" id="content" name="content" rows="3"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Yayımla</button>
                                            <button type="reset" class="btn">Imtina et</button>
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

           

            <jsp:include page="common/footer.jsp"/>

        </div><!--/.fluid-container-->
        <jsp:include page="common/javascript.jsp"/>


    </body>
</html>

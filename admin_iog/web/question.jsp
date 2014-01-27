<%-- 
    Document   : question
    Created on : Jan 13, 2014, 3:30:50 AM
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
                                <form class="form-horizontal" method="POST" action="qs?action=question">
                                    <fieldset>






                                        <div class="control-group">
                                            <label class="control-label" for="textarea2"> <b>Suali daxil et : </b> </label>
                                            <div class="controls">
                                                <br/> <textarea class="cleditor" id="content" name="content" rows="3"></textarea>
                                            </div>
                                          
                                        </div>

                                        

                                        <div class="control-group">
                                            <label class="control-label" for="typeahead"> <b>Cavab : </b> </label>
                                            <div class="controls">
                                                <input type="text" class="span6 typeahead" id="answer"  name="answer" data-provide="typeahead" data-items="4" >

                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label" for="typeahead"> <b> Müəllif : </b> </label>
                                            <div class="controls">
                                                <input type="text" class="span6 typeahead" id="author"  name="author" data-provide="typeahead" data-items="4" >

                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label" for="typeahead"> <b> Şərh : </b> </label>
                                            <div class="controls">
                                                <input type="text" class="span6 typeahead" id="comment"  name="comment" data-provide="typeahead" data-items="4" >

                                            </div>
                                        </div>
                                        
                                         <div class="control-group">
                                            <label class="control-label" for="typeahead"> <b> Oyun nömrəsi : </b> </label>
                                            <div class="controls">
                                                <input type="text" class="span6 typeahead" id="game_id"  name="game_id" data-provide="typeahead" data-items="4" >

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



        </div><!--/.fluid-container-->
        <jsp:include page="common/javascript.jsp"/>


    </body>
</html>


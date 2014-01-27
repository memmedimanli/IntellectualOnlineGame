<%-- 
    Document   : invite
    Created on : Jan 3, 2014, 11:53:31 PM
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





                    <div class="row-fluid sortable">
                        <div class="box span12">

                            <div class="box-content">
                                <form class="form-horizontal" action="invite" method="post">
                                    <fieldset>
                                        <legend>Dostlarını dəvət et.</legend>
                                        <div class="control-group">
                                            <label class="control-label" for="typeahead"></label>
                                            <div class="controls">
                                                
                                                <div class="control-group">
							  <label class="control-label" for="typeahead"></label>
							  <div class="controls">
								<input type="text" class="span6 typeahead" id="email" name="email" placeholder="Dəvət etmək istədiyin şəxsin e-mail adresin daxil et..." data-provide="typeahead" data-items="4" >
								
							  </div>
							</div>
                                                
                                                 <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">daxil et</button>

                                        </div>
                                              
                                              <p> Tezliklə əlavə ediləcək...</p>

                                            </div>
                                        </div>




                                        <div class="form-actions">


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

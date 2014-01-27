<%-- 
    Document   : fbLogin
    Created on : Jan 10, 2014, 8:11:05 PM
    Author     : memmedimanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">  
<body>  
  
    <script src="http://static.ak.connect.facebook.com/js/api_lib/v0.4/XdCommReceiver.js"  
        type="text/javascript"></script>  
    <script src="http://static.ak.connect.facebook.com/js/api_lib/v0.4/FeatureLoader.js.php"  
    type="text/javascript"></script> 
    
    <fb:login-button onlogin="alert('Authenticated!');"></fb:login-button>  
    
    <script type="text/javascript">  
    FB.init("YOUR_API_KEY_HERE", "xd_receiver.htm");  
</script> 
  
</body>  
</html> 
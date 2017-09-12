<%@ page language="java" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <script type='text/javascript' src='/dwr/engine.js'></script>  
    <script type='text/javascript' src='/dwr/util.js'></script>  
    <script type='text/javascript' src='/dwr/interface/DWRHelper.js'></script>  
  </head>  
     
  <!-- 通过 dwr.engine.setActiveReverseAjax(true); 启动该页面的Reverse Ajax功能  -->  
  <body onload="dwr.engine.setActiveReverseAjax(true);sendMessage();">  
    <p>输入信息: <input id="text" onkeypress="dwr.util.onReturn(event, sendMessage)" />    
    <input type="button" value="Send" onclick="sendMessage()" /></p>  
  
    <script type="text/javascript">  
        function sendMessage() {   
            DWRHelper.addMessage(document.getElementById("text").value);   
        }   
        function clientFunction(data){
        	alert(data);
        	document.getElementById("messages").value =data;
        }
    </script>  
       
    <hr/>  
    <select id="messages"></select>  
       
  </body>  
</html>  
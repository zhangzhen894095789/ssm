<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery/jquery-3.2.1.js" type="text/javascript"></script>
<!-- <script src="js/jquery/jquery.ext.js" type="text/javascript"></script>-->
<script src="js/jquery/jquery-form.js" type="text/javascript"></script> 
</head>
<body>

<form action="" method="post" id="jvForm" enctype="multipart/form-data">
        <input type="text" name="name"/>
        <input type="file" name="pic" id="pic"/>
        <input type="submit" value="提交"/>
</form>
<script>
 $(function(){
          var options = {
              url : "upload/uploadPic.do",
              dataType : "json",
              type : "post",
              success : function(data){
                  alert(2);
              }
          };
          $("#pic").change(function(){
              alert(1);
             $("#jvForm").ajaxSubmit(options)
          });
      });
</script
</body>
</html>
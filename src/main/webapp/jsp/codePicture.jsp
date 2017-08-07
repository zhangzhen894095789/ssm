<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图片验证码 测试页面</title>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
</head>
<body>
<h2>图片验证码</h2>
<img alt="验证码" src="../kaptcha/getKaptcha" id="kaptchaImage">
<script type="text/javascript">  
    $(function() {  
        $('#kaptchaImage').click(function() {$(this).attr('src','../kaptcha/getKaptcha?' + Math.floor(Math.random() * 100))});  
    });  
</script>  
<br /><small>看不清，点击换一张</small>  
</body>
</html>
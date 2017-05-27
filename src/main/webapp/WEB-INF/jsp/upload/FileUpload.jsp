<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax实现异步上传文件</title>
<script src="js/jquery/jquery-3.2.1.js" type="text/javascript"></script>
<!-- <script src="js/jquery/jquery.ext.js" type="text/javascript"></script>-->
<script src="js/jquery/jquery-form.js" type="text/javascript"></script> 
</head>
<body>

<form action="" method="post" id="jvForm" enctype="multipart/form-data">
        <input type="text" name="name"/>
        <input type="file" name="pic" id="pic" onchange="fileChange(this);"/>
        <input type="submit" value="提交"/>
</form>
<script>
	 function fileChange(image){
		 
		 var size = image.files[0].size;
		 //alert(Math.ceil(size /1024) + "kb");
		 var filesize = Math.ceil(size /1024 /1024);
		 alert(document.getElementById("pic").files[0].size);
		 //jquery 没有这种方式
		 alert($("#pic"));
	 }
	 
	//getFormData()的实现很简单：获取表单中的所有数据
	 var form = $("#jvForm");
		function getFormData(form){
		    var data = form.serialize();
		    data = decodeURI(data);
		    var arr = data.split('&');
		    var item,key,value,newData={};
		    for(var i=0;i<arr.length;i++){
		        item = arr[i].split('=');
		        key = item[0];
		        value = item[1];
		        if(key.indexOf('[]')!=-1){
		            key = key.replace('[]','');
		            if(!newData[key]){
		                newData[key] = [];
		            }
		            newData[key].push(value);
		        }else{
		            newData[key] = value;
		        }
		    }
		    return newData;
		}
 //$(function(){
 //   var options = {
    //    url : "upload/uploadPic.do",
     //   dataType : "json",
     //   type : "post",
      //  success : function(data){
       //     alert(2);
  //      }
 //   };
 //   $("#pic").change(function(){
   //     alert(1);
  //     $("#jvForm").ajaxSubmit(options)
  //  });
//  }); 
 
</script
</body>
</html>
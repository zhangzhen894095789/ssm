<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首次环境搭建</title>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/interface/dwrPush.js'></script>
<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<script>

$(document).ready(function(){
    alert('can get here!');
    // 页面加载的时候进行反转的激活
    dwr.engine.setActiveReverseAjax(true) ;
    //设置在页面关闭时，通知服务端销毁会话
    dwr.engine.setNotifyServerOnPageLoad(true);

	//dwr.engine.setAsync(true);
    // 点击页面按钮的时候触发的方法
    $("#button").click(function(){
        // 此类即为根据java文件生成的js文件
        var data = document.getElementById("data").value;
//        dwrPush.Send(data);
//        dwrPush.onPageLoad("admin");
        dwrPush.sendMessageAuto("admins","admins 验证通过！");
    });
});


//////////////////////////////////////用于后台调取的函数
var arr = new Array();

function callback(msg){
   // alert(msg);
    console.log(msg)
    arr.push(msg);
    $("#ul").html($("#ul").html()+"<br />"+msg);
    $("#msg").html("<option >"+arr+"</option> <br/>");
}
</script>
</head>
<body>
<ul id="ul">

</ul>

<br/>
<hr>
<input type="text" id="data" name='data' />&nbsp;&nbsp;&nbsp;&nbsp;
<input type='button' id="button" value="publish">
<div align="right">
    消息列表
    <select id="msg" style="width: 35%;">

    </select>
</div>
</body>
</html>
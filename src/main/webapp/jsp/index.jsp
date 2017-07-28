<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bootstrap 实例 - 模态框（Modal）插件</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/viewer.min.css">
<script src="js/viewer.min.js"></script>
</head>
<body>

	<h2>创建模态框（Modal）</h2>
	<!-- 按钮触发模态框 -->
<!-- 	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">开始演示模态框</button> -->
	<a data-toggle="modal" data-target="#myModal">开始演示模态框</a>
	<!-- 模态框（Modal） -->
	<div  class="modal" id="myModal"  >
	
				<div class="modal-body" align="center" style="padding: 0px">
					<ul id="dowebok">
					<img data-original="img/tibet-1.jpg"
							src="img/tibet-1.jpg" alt="点击图片可以" />
					</ul>
				</div>
			
	</div>

	<script type="text/javascript">
		/* var viewer = new Viewer(document.getElementById('dowebok'), {
			url : 'data-original'
		}); */
	
		/* 
		$('#myModal').on('show.bs.modal', function () {
			  //当模态框 打开前 执行一些动作...
			  alert("模态框打开之前");
			})
			
				$('#myModal').on('hide.bs.modal', function () {
			  //当模态框 打开前 执行一些动作...
			  alert("模态框关闭前");
			}) */
	</script>
</body>
</html>
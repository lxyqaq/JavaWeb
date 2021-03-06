<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSP - Hello World</title>
	</head>
	<body>

		<div>

			<%--  这里表单表示的意思:以post方式提交表单，提交到我们的login请求  --%>

			<form action="${pageContext.request.contextPath}/login" method="post">

				用户名:<input type="text" name="username"><br>
				密码:<input type="password" name="password"><br>
				爱好:<input type="checkbox" name="hobby" value="打球">打球
				<input type="checkbox" name="hobby" value="唱歌">唱歌
				<input type="checkbox" name="hobby" value="看电影">看电影
				<input type="checkbox" name="hobby" value="喝酒">喝酒<br>
				<input type="submit">

			</form>

		</div>

	</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSP - Hello World</title>
	</head>
	<body>
		<h1>hello</h1>

		<%--  这里提交的路径，需要寻找到项目的路径  --%>
		<%--  ${pageContext.request.contextPath}代表当前的项目  --%>
		<form action="${pageContext.request.contextPath}/login" method="post">
			用户名:<input type="text" name="username"><br>
			密码:<input type="password" name="password"><br>
			<input type="submit">
		</form>

	</body>
</html>
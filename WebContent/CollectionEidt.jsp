<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CollectionServlet?action=update" method="post">
	
        <input type="hidden" value="${CollectionBean.id }" name="id">
		<table border="0">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${CollectionBean.name }">
			</tr>
			<tr>
				<td>Url:</td>
				<td><input type="text" name="url" value="${CollectionBean.url }">
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="更新"></td>
			</tr>

		</table>

	</form>
	<hr>

	
	
</body>
</html>
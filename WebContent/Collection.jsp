<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="CollectionServlet" method="post">

		<table border="0">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name">
			</tr>
			<tr>
				<td>Url:</td>
				<td><input type="text" name="url" value="http://">
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="save"></td>
			</tr>

		</table>

	</form>
	<hr>
	
	<c:forEach var="s" items="${cl }">
	 ${s.id }
	 ${s.name }
	 <a href="${s.url }">${s.url }</a>
	 
	 <br>
	</c:forEach>
	
</body>
</html>
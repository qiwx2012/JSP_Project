<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<title>Insert title here</title>

<script type="text/javascript" charset="utf-8">
    
    function del(){
    	if(confirm("确定要删除么？")){
    		var f=document.forms[1];
    	    f.action="CollectionServlet?action=delete";
    	    f.submit();
    	}else{
    		return;
    		
    	}
    	
    }

</script>
</head>
<body>
	<form action="CollectionServlet?action=save" method="post">

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
					value="保存"></td>
			</tr>

		</table>

	</form>
	<hr>
	<!-- 一个页面可以多个表单，但是表单只能并列不能嵌套 -->
	
	<form action="" method="post">
	
	<c:forEach var="s" items="${cl }">
	 ${s.id }
	 ${s.name }
	 <a href="${s.url }">${s.url }</a>
	 <a href="CollectionServlet?action=get&id=${s.id }">编辑</a>
	 
	 <input type="checkbox" name="ids" value="${s.id }">
	 <br>
	</c:forEach>
	
	<input type="button" value="删除" onclick="del()">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%

        pageContext.setAttribute("newLine", "\n");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/add" method="post">
		<input type="hidden" name="a" value="add">
		<table border=1 width=500>
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="contents" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>
	
	<c:set var='count' value='${fn:length(list) }' />	
				<c:forEach items='${list }' var='vo' varStatus='status'>
		<table width=510 border=1>
	
			<tr>
				<td>[${count-status.index }]</td>
				<td>${vo.name }</td>
				<td>${vo.regDate }</td>
				<td><a href="${pageContext.request.contextPath }/deleteform${vo.no }">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4>${fn:replace(vo.contents, newLine,'<br/>') }</td>
			</tr>
		</table>
	
	</c:forEach>
</body>
</html>
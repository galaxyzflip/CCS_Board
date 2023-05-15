<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form action="/boardInsertPro" method="post">
			<table class="">
				<tr>
					
					<td>
						제목
					</td>
					
					<td>
						${detail.title }
					</td>
				</tr>
				
				<tr>
					<td>
						내용
					</td>
					
					<td>
						${detail.content }
					</td>
				</tr>
	
			</table>
			
		</form>
	</div>
	
	<div>
		<div>연관게시물</div>
	
		<c:forEach items="${relatedBoardLists }" var="related">
			<div>
				<a href="/detail/${related.id }">
					${related.id } ${related.title } ${related.content } ${related.regDate }
				</a>
			</div>				
				
		</c:forEach>
	</div>
	
	<div>
		<a href="/list">목록으로</a>
	</div>
	
	
	<script type="text/javascript" src="/resources/script/script.js"></script>
</body>
</html>
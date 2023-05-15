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
						<label>제목</label>
					</td>
					
					<td>
						<input type="text" name="title"/>
					</td>
				</tr>
				
				<tr>
					<td>
						<label>내용</label>
					</td>
					
					<td>
						<textarea name="content"></textarea>
					</td>
				</tr>
	
			</table>
			<button id="insertBtn">게시글 등록하기</button>
		</form>
	</div>
	
	
	<script type="text/javascript" src="/resources/script/script.js"></script>
</body>
</html>
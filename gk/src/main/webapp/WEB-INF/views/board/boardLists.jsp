<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.boardTable{
		border : 1px solid black;
		width : 80%;
		border-style:solid;
		
	} 
	
	.boardTable td{
		
		border : 1px black;
		border-style:solid;
	} 
	
	.boardTitle{
		width:65%;
	}
	
	.boardDate{
		width:10%;
	}
	
	.boardID{
		width:5%;
	}

</style>
</head>
<body>

	<div>
		<button id="newArticleBtn">게시글 입력</button>
	</div>

	<div>
		<table class="boardTable">
			<thead>
				<tr>
					<td class="boardID">ID</td>
					<td class="boardTitle">제목</td>
					<td class="boardDate">날짜</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${boardLists }" var="board">
					<tr>
						<td>${board.id}</td>
						<td>
							<a href="/detail/${board.id }">${board.title }</a>
						</td>
						
						<td>${board.regDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	<script type="text/javascript" src="/resources/script/script.js"></script>
</body>
</html>
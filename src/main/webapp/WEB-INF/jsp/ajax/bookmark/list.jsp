<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
		<h2>즐겨 찾기 목록</h2>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bookmark" items="${bookmarkList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${bookmark.name }</td>
					<td>${bookmark.url }</td>
					<td>
						<button type="button" data-bookmark-id="${bookmark.id }" class="btn btn-danger btn-sm delete-btn">삭제</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>	
	
	
	<script>
		$(document).ready(function() {
			
			// data 속성..!! delete 버튼 아이디로 처리하면 id 중복되서 안됨!!
			$(".delete-btn").on("click", function() {
				// 삭제 api 호출
				// 삭제 대상이 되는 행의 버튼 태그 객체
				let id = $(this).data("bookmark-id");
				// alert(id);
				
				$.ajax({
					type:"get"
					, url:"/ajax/bookmark/delete"
					, data:{"id":id}
					, success:function(data) {
						// {"result":"success"}
						// {"result":"fail"}
						if(data.result == "success") {
							// 새로고침
							location.reload();
						} else {
							alert("삭제 실패");
						}
					
					}
					, error:function() {
						alert("삭제 에러");
					}
				});				
				
				
			});
			
			
			
			
		});
	
	</script>
</body>
</html>
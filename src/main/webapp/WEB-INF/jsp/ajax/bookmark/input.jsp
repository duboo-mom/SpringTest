<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 입력</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h2>즐겨 찾기 추가하기</h2>
		<label class="mt-3">제목</label>
		<input type="text" class="form-control" id="nameInput">
		<label class="mt-3">주소</label>
		<input type="text" class="form-control" id="urlInput">
		<button type="button" class="btn btn-success btn-block mt-3" id="addBtn">추가</button>
	</div>


	<script>
		$(document).ready(function() {
			
			$("#addBtn").on("click", function() {
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				if(name == "") {
					alert("제목을 입력하세요");
					return;
				}
				
				if(url == "") {
					alert("주소를 입력하세요");
					return;
				}
				
				if(!url.startsWith("https") || !url.startsWith("https")) {
					alert("올바른 주소 입력하세요");
					return;
				}
				
				$.ajax({
					
					type:"post"
					, url:"/ajax/bookmark/add"
					, data:{"name":name, "url":url}
					, success:function(data) {
						if(data.result = "success") {
							location.href="/ajax/bookmark/list";
						} else {
							alert("추가 실패");
						}
					}
					, error:function() {
						alert("추가 에러");
					}
										
				});
								
			});
			
			
		});
		
	</script>

</body>
</html>
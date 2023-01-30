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
		<div class="d-flex">
			<input type="text" class="form-control col-10" id="urlInput">
			<button type="button" class="btn btn-info ml-3 col-1" id="duplicateBtn">중복확인</button>		
		</div>
		<div class="text-danger small d-none" id="duplicatedId">중복된 url 입니다.</div>
		<div class="small text-info d-none" id="availableId">사용 가능한 url 입니다.</div>
		
		<button type="button" class="btn btn-success btn-block mt-3" id="addBtn">추가</button>
	</div>


	<script>
		$(document).ready(function() {
			
			var isChecked = false;
			var isDuplicateUrl = false;
			
			$("#duplicateBtn").on("click", function() {
				let url = $("#urlInput").val();
				
				if(url == "") {
					alert("url을 입력하세요");
					return;
				}
				
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소 형식이 잘못되었습니다");
					return;
				}
				
				
				$.ajax({
					type:"post"
					, url:"/ajax/bookmark/is_duplicate"
					, data:{"url":url}
					, success:function(data){
						
						isChecked = true;
						
						if(data.is_duplicate){
							//중복
							$("#availableId").addClass("d-none");
							$("#duplicatedId").removeClass("d-none");
							isDuplicateUrl = true;
						} else{
							// 중복아님
							$("#duplicatedId").addClass("d-none");
							$("#availableId").removeClass("d-none");
							isDuplicateUrl = false;
						}
					}
					, error:function(){
						alert("중복확인 에러");
					}
				});
				
			});
			
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
				
				// http로 시작하지 않고 https로 시작하지 않으면
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
				//if(!(url.startsWith("http://") || startsWith("https://"))) {
					alert("주소 형식이 잘못되었습니다");
					return;
				}
				
				// url 중복체크 여부
				if(!isChecked) {
					alert("url 중복체크 해주세요");
					return;
				}
				
				// 중복여부에 따라 저장 안되게
				// 근데 다시 수정하면? -- 이걸 아직 못했어....
				if(isDuplicateUrl) {
					alert("중복되지 않은 url 입력하세요");
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
        
        <section class="contents d-flex justify-content-center align-items-center">
            
            <div class="login-box my-5 text-center">
            <h1>Marondalgram</h1>
                <form id="loginFrom">
                
                	<input type="text" placeholder="Username" class="form-control mt-4" id="idInput">
                	<input type="password" placeholder="password" class="form-control mt-2" id="passwordInput">
               		<button type="submit" class="btn btn-info btn-block mt-5" id="loginBtn">로그인</button>
                
                </form>
                
               	<div>비밀번호를 잊으셨나요? 
                <a href="/user/join-view" class="mt-5">회원가입</a>
                </div>
            </div>
        </section>
        <hr>
        <c:import url="/WEB-INF/jsp/include/footer.jsp" />
    
    </div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script> 
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script>

	$(document).ready(function() {
		// $("#loginBtn").on("click", function() {
		$("#loginFrom").on("submit", function(e) {
			// 이벤트 고유의 기능을 취소한다.
			e.preventDefault();
			
			let id = $("#idInput").val();
			let password = $("#passwordInput").val();
			
			if(id == "") {
				alert("아이디를 입력하세요");
				return;
			}
			
			if(password == "") {
				alert("비밀번호를 입력하세요");
				return;
			}
			
			// .ajax로 값 전달
			$.ajax({
				type:"post"
				, url:"/user/login"
				, data:{"loginId":id, "password":password}
				, success:function(data) {
					if(data.result == "success") {
						location.href= "/timeline-view";
					} else {
						alert("아이디와 비빌번호를 확인하세요");
					}
				}
				, error:function() {
					alert("로그인 에러");
				}
			});
		});
	});

	</script>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JinsReview</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	a{
		text-decoration: none;
	}
	
	.text-center label{
		padding : 10px;
	}
</style>
</head>
<body>

	<div class="container">
		<div class="text-center">
			<h1>
				<a href="../">JinsReview</a>
			</h1>
		</div>

	<div class="row">
	<div class="col-md-2"></div>
		<div class="col-md-8">
				<form class="form" action="loginPost" method="post">
					<div class="form-group">
						<label for="uid">아이디</label> <input
							class="form-control  form-control-lg" id="uid" type="text"
							name="uid" placeholder="아이디">
					</div>
					<div class="form-group">
						<label for="upw">비밀번호</label> <input
							class="form-control  form-control-lg" type="password" id="upw"
							name="upw" placeholder="비밀번호">
					</div>
					<div class="form-check">
						<label class="form-check-label"> 
						<input type="checkbox" name="useCookie"
							class="form-check-input">로그인 상태 유지
						</label>
					</div>
					<div class="form-group">
						<input class="btn btn-primary btn-block" type="submit" value="로그인">
					</div>
				</form>
			</div>
		</div>
		<hr>
			<div class="text-center">
			<br>
			<label><a href="join">회원가입</a></label>
			<label>
			<span id="idSelect" class="p-3 my-3 border-right border-left"><a href="join">아이디 찾기</a></span>
			</label>
			<label><a href="join">비밀번호 찾기</a></label>
			</div>
		
	</div>
</body>
</html>
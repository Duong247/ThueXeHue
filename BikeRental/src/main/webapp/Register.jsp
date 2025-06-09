<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/styles/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/3ecdd9878f.js" crossorigin="anonymous"></script>
    <title>Đăng ký</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
  	<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
	  <script>
		  $( function() {
		    $( "#datepicker" ).datepicker();
		  } );
		  </script>
</head>
<body>
<%@include file="_HeaderOnly.jsp" %>
	<div class="container" style="margin-top: 110px; max-width: 500px">
		<div class="form-login-container register-form-container">
	        <div class="logo-login-form logo-register-form text-center">
	            <img src="./assets/img/icon2.png" alt="" class="logo-login" style="width: 80px">
	            <h5>Chào mừng đến với HueBikeRent</h5>
	        </div>
	        <form action="Register" method="post">
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Họ và tên</label>
	                <input type="text" class="form-control" name="fullname" id="firstName" value="${fullname }">
	                <span style="color:red;">${nameErr}</span>
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Số điện thoại</label>
	                <input type="tel" class="form-control" name="phone" id="phone" value="${phone }">
	                <span style="color:red;">${phoneErr}</span>
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Ngày sinh</label>
	                <input type="text" class="form-control" name="birthday" id="datepicker" value="${birthday }">
	                <span style="color:red;">${bdErr}</span>
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Địa chỉ</label>
	                <input type="tex" class="form-control" name="address" value="${address}">
	                <span style="color:red;">${addressErr}</span>
	                
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
	                <input type="text" class="form-control" name="password" id="password" value="${password}">
	                <span style="color:red;">${pwErr}</span>
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Nhập lại mật khẩu</label>
	                <input type="text" class="form-control" name="repeatPassword" id="repeatPassword" value="${repeatPassword}">
	                <span style="color:red;">${rppwErr}</span>
	            </div>
	            <button type="submit" class="btn btn-primary" name="act"  style="width: 100%;    background-color: #3454cf;" Value="submit">Đăng ký</button>
	          </form>
	    </div>
	</div>

<%@include file="_Footer.jsp" %>

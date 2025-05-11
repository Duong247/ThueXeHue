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
</head>
<body>
<%@include file="_HeaderOnly.jsp" %>
	<div class="container" style="margin-top: 110px; max-width: 500px">
		<div class="form-login-container register-form-container">
	        <div class="logo-login-form logo-register-form text-center">
	            <img src="./assets/img/icon2.png" alt="" class="logo-login" style="width: 80px">
	            
	            <h5>Chào mừng đến với HueBikeRent</h5>
	        </div>
	        <form>
	            <div class="mb-3">
	                <label for="exampleInputEmail1" class="form-label">Email</label>
	                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">First name</label>
	                <input type="text" class="form-control" name="firstName" id="firstName">
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Last name</label>
	                <input type="text" class="form-control" name="firstName" id="lastName">
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Phone</label>
	                <input type="tel" class="form-control" id="phone">
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Password</label>
	                <input type="text" class="form-control" id="password">
	            </div>
	            <div class="mb-3">
	                <label for="exampleInputPassword1" class="form-label">Repeat Password</label>
	                <input type="text" class="form-control" id="repeatPassword">
	            </div>
	            
	            <button type="submit" class="btn btn-primary" style="width: 100%;">Đăng nhập</button>
	          </form>
	    </div>
	</div>

<%@include file="_Footer.jsp" %>

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
    <title>Thông tin cá nhân</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
  	<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
	  <script>
		  $( function() {
		    $( "#datepicker" ).datepicker();
		  } );
		  </script>
		  
		  <style>
  .avatar-wrapper {
    position: relative;
    width: 160px;
    height: 160px;
    margin: 20px auto;
    cursor: pointer;
  }

  .avatar-wrapper img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 50%;
    border: 3px solid #ccc;
  }

  .avatar-wrapper:hover .overlay {
    opacity: 1;
  }

  .overlay {
    position: absolute;
    width: 100%;
    height: 100%;
    border-radius: 50%;
    background: rgba(0, 0, 0, 0.4);
    top: 0;
    left: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    opacity: 0;
    transition: 0.3s;
    color: #fff;
    font-size: 20px;
  }

  input[type="file"] {
    display: none;
  }
</style>
</head>
<body>
<%@include file="_HeaderOnly.jsp" %>
	<div class="container" style="margin-top: 110px; max-width: 700px">
		<div class="form-login-container register-form-container">
	        <div class="logo-login-form logo-register-form text-center">
	            <img src="./assets/img/icon2.png" alt="" class="logo-login" style="width: 80px">
	            <h5>Thông tin cá nhân</h5>
	        </div>
		    <form action=ChangeInfoSubmit method="post" enctype="multipart/form-data">
		    	<input hidden name="userid" value="5">
	        	<div class="row">
		        	<div class="col-4 text-center">
		                <div class="form-group text-center">
							  <div class="avatar-wrapper" onclick="document.getElementById('image').click()">
							    <img id="Photo"
							      src="${user == null || user.getPhoto() == null ? 'assets/img/avaUsers/noava.jpg' : user.getPhoto()}"
							      alt="Avatar" />
							    <div class="overlay">📷 Đổi ảnh</div>
							  </div>
							
							  <input type="hidden" name="displayPhoto" value="${user != null ? user.getPhoto() : ''}" />
							  <input type="file" class="fileToUpload" id="image" name="fileToUpload" accept="image/*"
							    onchange="document.getElementById('Photo').src = window.URL.createObjectURL(this.files[0])" />
							</div> 
		        	</div>
		        	<div class="col-8">
		        		<div class="mb-3">
		                <label for="exampleInputPassword1" class="form-label">Họ và tên</label>
		                <input type="text" class="form-control" name="fullname" id="firstName" value="${user.getUserName() }">
		                <span style="color:red;">${nameErr}</span>
			            </div>
			            <div class="mb-3">
			                <label for="exampleInputPassword1" class="form-label">Số điện thoại</label>
			                <input type="tel" disabled="disabled"	 class="form-control" name="phone" id="phone" value="${user.getPhone()}" >
			                <span style="color:red;">${phoneErr}</span>
			            </div>
			            <div class="mb-3">
			                <label for="exampleInputPassword1" class="form-label">Ngày sinh</label>
			                <input type="text" class="form-control" name="birthday" id="datepicker" value="${user.getDateOfBirth() }">
			                <span style="color:red;">${bdErr}</span>
			            </div>
			            <div class="mb-3">
			                <label for="exampleInputPassword1" class="form-label">Địa chỉ</label>
			                <input type="tex" class="form-control" name="address" value="${user.getAddress()}">
			                <span style="color:red;">${addressErr}</span>
			                
			            </div>
			            <div class="text-end">
							<button type="submit" class="btn btn-primary" name="act" Value="update" style="width: 120px;" >Lưu thay đổi</button>
			            </div>
	        		</div>
		        </div>
   		      </form>
	        <hr>
	        <div class="row">
	        	<div class="col-4">
	        		<strong>Thay đổi mật khẩu</strong>
	        		<div ${errStr==nul||errStr==""?'hidden':''} class="alert alert-danger" role="alert">
					  	<i class="fa-solid fa-triangle-exclamation" style="padding-right:5px"></i>${errStr}
					</div>
	        	</div>
	        	<div class="col-8">
	        		<form action="ChangeInfoController" method="post">
	        			<div class="mb-3">
			                <label for="exampleInputPassword1" class="form-label">Mật khẩu cũ</label>
			                <input type="text" class="form-control" name="oldPassword" id="oldPassword" value="${oldPass}">
			                <span style="color:red;">${pwErr}</span>
			            </div>
	        			<div class="mb-3">
			                <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
			                <input type="password" class="form-control" name="newpassword" id="password" value="${newPass}">
			                <span style="color:red;">${pwErr}</span>
			            </div>
			            <div class="mb-3">
			                <label for="exampleInputPassword1" class="form-label">Nhập lại mật khẩu</label>
			                <input type="password" class="form-control" name="repeatPassword" id="repeatPassword" value="${repeatPass}">
			                <span style="color:red;">${rppwErr}</span>
			            </div>
			            <div class="text-end">
							<button type="submit" class="btn btn-primary" name="act"  style="width: 120px;" Value="changePass">Đổi mật khẩu</button>
			            </div>
	        		</form>
	        	
	        	</div>
	        </div>

	    </div>
	</div>

<%@include file="_Footer.jsp" %>
	
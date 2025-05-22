<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
        <div class="container">
          <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid d-flex justify-content-between align-items-center">
              
              <!-- Logo -->
              <a class="navbar-brand" href="Home">
                <img src="./assets/img/headerImgNoBg.png" alt="" style="display: block;width: 85px;">
              </a>

              <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
          
              <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                <ul class="navbar-nav mb-2 mb-lg-0">
                  <li class="nav-item nav-item-header">
                    <a class="nav-link " aria-current="page" href="BikeControler">Thuê Xe</a>
                  </li>
                  <li ${currentUserInf==null?'hidden':'' } class="nav-item nav-item-header dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                      aria-expanded="false">
                      Blog
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#">Action</a></li>
                      <li><a class="dropdown-item" href="#">Another action</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                  </li>
                  <li ${currentUserInf==null?'hidden':'' } class="nav-item nav-item-header">
                    <a class="nav-link" href="Order"><i class="fa-solid fa-cart-shopping"></i>Giỏ hàng</a>
                  </li>
                  <li ${currentUserInf!=null?'hidden':'' }  class="nav-item nav-item-header">
                    <a class="nav-link" href="Login">Đăng nhập/Đăng ký</a>
                  </li>

                  <!-- <li class="nav-item nav-item-header"> -->
                    <div ${currentUserInf==null?'hidden':'' } class="dropdown-center">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                      aria-expanded="false">
                      <img src="${currentUserInf.getPhoto()!=null?currentUserInf.getPhoto():'assets/img/avaUsers/noava.jpg' }" class=" mini-ava" style="display: inline-block;">
                    </a>
                      <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="ChangeInfoController">Thông tin cá nhân</a></li>
                        <li><a class="dropdown-item" href="OwnerManagerment" ${currentUserInf==null||currentUserInf.getRole()==1?'hidden':'' }>Quản lý</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="Logout">Đăng xuất</a></li>
                      </ul>
                    </div>
                    
                  <!-- </li> -->
                </ul>
              </div>
          
            </div>
        </nav>
   	</div>
  </div>
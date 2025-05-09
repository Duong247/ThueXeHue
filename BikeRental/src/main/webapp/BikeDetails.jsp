<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="_Header.jsp"%>
<div class="container bike-detail-container" style="margin-top: 130px;">
    <div class="row align-items-start g-4">
        <div class="col-md-5 col-12">
            <div class="slider-cover">
                <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner w-100">
                      <div class="carousel-item active">
                          <img src="./assets/img/sh.png" class="d-block w-100" alt="..." style="height: 500px; object-fit: contain; border-radius: 8px;">
                      </div>
                      <div class="carousel-item w-100">
                          <img src="./assets/img/logo.png" class="d-block w-100" alt="..." style="height: 500px; object-fit: contain;border-radius: 8px; " >
                      </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Next</span>
                    </button>
                  </div>
            </div>
        </div>
        <div class="col-md-7 col-12 p-3">
            <h3>Xe sh 150CC</h3>
            <h1 style="color: #f00;">đ 100.000/ ngày</h1>
            <p><b>Màu xe: </b>Đen</p>
            <p> <b>Phân khối:</b> 150CC</p>
            <p><b>Biển số:</b>75AF-01100</p>
            <button class="btn btn-primary">Đặt xe</button>
        </div>
    </div> 
</div>
<div class="container bike-detail-container p-3" style="margin-top:10px">
	<p style="font-weight: 600">THÔNG TIN CHỦ XE</p>
	<div class="shop-info" style="display: flex; align-items: flex-start;">

		<img src="assets/img/daiNoi.jpg" style="width:79px;height:79px;object-fit:cover; border-radius:50%;">
	
		<ul>
			<li><p>Trần Văn A</p> </li>
			<li><p><span>Số điện thoại:</span>  0767002698</p></li>
			<li><p><span>Địa chỉ:</span>  77 Nguyễn Huệ</p></li>
			<li><p><span>Địa chỉ email:</span>  21t1020328@husc.edu.vn</p></li>

			
		</ul>
	</div>
</div>

<div class="container bike-detail-container p-3" style="margin-top:10px">
	<p style="font-weight: 600">NHỮNG LOẠI XE TƯƠNG TỰ</p>
	<div class="row align-items-start g-2">
            <div class="col-md-3 col-6" >
              <div class="card" style="width: 100%;">
                  <img src="./assets/img/sh.png" class="card-img-top" alt="...">
                  <div class="card-body text-left">
                    <div class="bike-status-group">
                      <p class="bike-status-available">Sẵn sàng</p>
                    </div>
                    <h5 class="card-title">Xe SH</h5>
                    <p class="card-text">Xe SH đời mới đã đổ 2 lít xăng aloaloalao</p>
                    <div class="cover-rating">
                      <p><i class="fa-solid fa-star" style="padding: 3px;"></i>5.0</p>
                    </div>
                    <p style="line-height: 14px; color: #024bb3;"><i class="fa-solid fa-location-dot"></i> An Hòa</p>
                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i>  100.000 vnd/ngày</p>
                    <a href="./bikeDetail.html" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
                  </div>
                </div>
            </div>
            <div class="col-md-3 col-6" >
              <div class="card" style="width: 100%;">
                  <img src="./assets/img/sh.png" class="card-img-top" alt="...">
                  <div class="card-body text-left">
                    <div class="bike-status-group">
                      <p class="bike-status-unavailable">Chưa sẵn sàng</p>
                    </div>
                    <h5 class="card-title">Xe SH</h5>
                    <p class="card-text">Xe SH đời mới đã đổ 2 lít xăng aloaloalao</p>
                    <div class="cover-rating">
                      <p><i class="fa-solid fa-star" style="padding: 3px;"></i>5.0</p>
                    </div>
                    <p style="line-height: 14px; color: #024bb3;"><i class="fa-solid fa-location-dot"></i> An Hòa</p>
                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i>  100.000 vnd/ngày</p>
                    <a href="./bikeDetail.html" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
                  </div>
                </div>
            </div>
            <div class="col-md-3 col-6" >
              <div class="card" style="width: 100%;">
                  <img src="./assets/img/sh.png" class="card-img-top" alt="...">
                  <div class="card-body text-left">
                    <div class="bike-status-group">
                      <p class="bike-status-available">Sẵn sàng</p>
                    </div>
                    <h5 class="card-title">Xe SH</h5>
                    <p class="card-text">Xe SH đời mới đã đổ 2 lít xăng aloaloalao</p>
                    <div class="cover-rating">
                      <p><i class="fa-solid fa-star" style="padding: 3px;"></i>5.0</p>
                    </div>
                    <p style="line-height: 14px; color: #024bb3;"><i class="fa-solid fa-location-dot"></i> An Hòa</p>
                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i>  100.000 vnd/ngày</p>
                    <a href="./bikeDetail.html" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
                  </div>
                </div>
            </div>
            <div class="col-md-3 col-6" >
              <div class="card" style="width: 100%;">
                  <img src="./assets/img/sh.png" class="card-img-top" alt="...">
                  <div class="card-body text-left">
                    <div class="bike-status-group">
                      <p class="bike-status-unavailable">Chưa sẵn sàng</p>
                    </div>
                    <h5 class="card-title">Xe SH</h5>
                    <p class="card-text">Xe SH đời mới đã đổ 2 lít xăng aloaloalao</p>
                    <div class="cover-rating">
                      <p><i class="fa-solid fa-star" style="padding: 3px;"></i>5.0</p>
                    </div>
                    <p style="line-height: 14px; color: #024bb3;"><i class="fa-solid fa-location-dot"></i> An Hòa</p>
                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i>  100.000 vnd/ngày</p>
                    <a href="./bikeDetail.html" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
                  </div>
                </div>
            </div>
            <div class="col-md-3 col-6" >
              <div class="card" style="width: 100%;">
                  <img src="./assets/img/sh.png" class="card-img-top" alt="...">
                  <div class="card-body text-left">
                    <div class="bike-status-group">
                      <p class="bike-status-available">Sẵn sàng</p>
                    </div>
                    <h5 class="card-title">Xe SH</h5>
                    <p class="card-text">Xe SH đời mới đã đổ 2 lít xăng aloaloalao</p>
                    <div class="cover-rating">
                      <p><i class="fa-solid fa-star" style="padding: 3px;"></i>5.0</p>
                    </div>
                    <p style="line-height: 14px; color: #024bb3;"><i class="fa-solid fa-location-dot"></i> An Hòa</p>
                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i>  100.000 vnd/ngày</p>
                    <a href="./bikeDetail.html" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
                  </div>
                </div>
            </div>
            <div class="col-md-3 col-6" >
              <div class="card" style="width: 100%;">
                  <img src="./assets/img/sh.png" class="card-img-top" alt="...">
                  <div class="card-body text-left">
                    <div class="bike-status-group">
                      <p class="bike-status-unavailable">Chưa sẵn sàng</p>
                    </div>
                    <h5 class="card-title">Xe SH</h5>
                    <p class="card-text">Xe SH đời mới đã đổ 2 lít xăng aloaloalao</p>
                    <div class="cover-rating">
                      <p><i class="fa-solid fa-star" style="padding: 3px;"></i>5.0</p>
                    </div>
                    <p style="line-height: 14px; color: #024bb3;"><i class="fa-solid fa-location-dot"></i> An Hòa</p>
                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i>  100.000 vnd/ngày</p>
                    <a href="./bikeDetail.html" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
                  </div>
                </div>
            </div>
          </div>
          <div class="text-center mt-3 mb-3">
          	<a href="#">Xem thêm...</a>
          </div>
</div>


<%@include file="_Footer.jsp"%>
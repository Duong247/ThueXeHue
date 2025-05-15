<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="_Header.jsp"%>

<div id="slider">
        <div id="carouselExampleDark" class="carousel carousel-dark slide">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active" data-bs-interval="10000">
                <img src="./assets/img/Slider1.webp" class="d-block w-100 slider-img" alt="...">
                <div class="carousel-caption d-none d-md-block" style="color: #fff;">
                  <h5>First slide label</h5>
                  <p>Some representative placeholder content for the first slide.</p>
                </div>
              </div>
              <div class="carousel-item" data-bs-interval="2000" >
                <img src="./assets/img/HoKheNgang.jpg" class="d-block w-100 slider-img" alt="...">
                <div class="carousel-caption d-none d-md-block" style="color: #fff;">
                  <h5>Second slide label</h5>
                  <p>Some representative placeholder content for the second slide.</p>
                </div>
              </div>
              <div class="carousel-item">
                <img src="./assets/img/slidercopy.jpg" class="d-block w-100 slider-img" alt="...">
                <div class="carousel-caption d-none d-md-block" style="color: #fff;">
                  <h5>Third slide label</h5>
                  <p>Some representative placeholder content for the third slide.</p>
                </div>
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next" style="color: #fff;">
              <span class="carousel-control-next-icon" aria-hidden="true" ></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
    </div>
    <div id="main-content">
      <div class="head-content">
        <h3>HueBikeRent</h3>
        <p>Thuê xe dễ dàng, trải nghiệm Huế trọn vẹn!</p>
      </div>
      <div class="container">
        <form class="search-bike" action="" method="">
          <div class="row align-items-start g-2">
            <div class="district col-2">
              <select class="form-select" aria-label="Default select example">
                <option selected>Chọn khu vực</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
              </select>
            </div>
            <div class="district col-2">
              <select class="form-select" aria-label="Default select example">
                <option selected>Chọn loại xe</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
              </select>
            </div>
            <input type="number" name="" id="" class="col-1 col-sm-2 search-price" min="0" placeholder="Giá">
            <button type="submit" name="" style="padding: 10px; width: 50px; font-size: 18px;" class="bike-search"  ><i class="fa-solid fa-magnifying-glass"></i></button>
          </div>
        </form>
      </div>
        <div class="container text-center">
          <div class="row align-items-start g-2">
          	<c:forEach var="item" items="${allBikes}" >
          		<div class="col-md-3 col-6" >
	              <div class="card" style="width: 100%;">
	                  <img src="./assets/img/motobikes/${item.photo}" class="card-img-top" alt="...">
	                  <div class="card-body text-left">
	                    <div class="bike-status-group">
	                      <p class="bike-status-${item.status==1?"available":"unavailable" }">${item.status==1?"Sẵn sàng":"Chưa sẵn sàng" }</p>
	                    </div>
	                    <h5 class="card-title">${item.bikeName}</h5>
	                    <p class="card-text">${item.description}</p>
	                    <div class="cover-rating">
	                      <p><i class="fa-solid fa-star" style="padding: 3px;"></i>5.0</p>
	                    </div>
	                    <p style="line-height: 14px; color: #024bb3;"><i class="fa-solid fa-location-dot"></i> An Hòa</p>
	                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i> ${item.price} vnd/ngày</p>
	                    <a href="BikeDetail?id=${item.bikeId}" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
	                  </div>
	                </div>
	            </div>
          	</c:forEach>
          </div>
        </div>
        <div class="text-center mt-3">
          <a href="BikeControler">Xem tất cả...</a>
        </div>
    </div>


<%@include file="_Footer.jsp"%>
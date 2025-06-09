<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="_Header.jsp"%>

<div id="slider">
        <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <c:forEach var="photoSlider" items="${sliderPhotos}" varStatus="loop">
      <button type="button"
              data-bs-target="#carouselExampleDark"
              data-bs-slide-to="${loop.index}"
              class="${loop.first ? 'active' : ''}"
              aria-current="${loop.first ? 'true' : ''}"
              aria-label="Slide ${loop.count}"></button>
    </c:forEach>
  </div>

  <div class="carousel-inner">
    <c:forEach var="photoSlider" items="${sliderPhotos}" varStatus="loop">
      <div class="carousel-item ${loop.first ? 'active' : ''}" data-bs-interval="${loop.count * 1000}">
        <img src="${photoSlider.photo}" class="d-block w-100 slider-img" alt="Slide ${loop.count}">
        <div class="carousel-caption d-none d-md-block" style="color: #fff;">
        </div>
      </div>
    </c:forEach>
  </div>

  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Trước</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Tiếp</span>
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
	                  <img src="${item.photo!=null?item.photo:'assets/img/icon2.png'}" class="card-img-top" alt="...">
	                  <div class="card-body text-left">
	                    <div class="bike-status-group">
	                      <p class="bike-status-${item.status==1?"available":"unavailable" }">${item.status==1?"Sẵn sàng":"Chưa sẵn sàng" }</p>
	                    </div>
	                    <h5 class="card-title">${item.bikeName}</h5>
	                    <p class="card-text">${item.description}</p>
	                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i> <span class="currency"> ${item.price}</span> vnd/ngày</p>
	                    <a href="BikeDetail?id=${item.bikeId}" class="btn btn-primary" style="width: 100%;    background-color: #3454cf;">Chi tiết</a>
	                  </div>
	                </div>
	            </div>
          	</c:forEach>
          </div>
	        <div class="text-center mt-3">
	          <a href="BikeControler" style="color:#3454cf;">Xem tất cả...</a>
	        </div>
	        <hr style="width: 50%;margin: 35px auto">
	        <div>
	        	<div class="text-center"> 
		        	<h3 class="mb-5">Giới thiệu</h3>
		        	<p style="width: 70%;margin: auto	">Chào mừng bạn đến với nền tảng HueBikeRent – nơi kết nối nhu cầu thuê và cho thuê xe một cách nhanh chóng và tiện lợi. Bạn có thể dễ dàng tìm kiếm chiếc xe phù hợp để di chuyển hoặc đăng xe của mình để cho thuê khi không sử dụng. Chúng tôi cam kết mang đến trải nghiệm an toàn, minh bạch và tối ưu cho cả người thuê lẫn chủ xe.</p>
		        </div>
	        </div>
	        <hr style="width: 50%;margin: 35px auto">
	        <div>
	        	<div class="text-center"> 
		        	<h3 class="mb-5">Tham gia cùng chúng tôi</h3>
		        	<p style="width: 70%;margin: auto">Trở thành người kinh doanh chỉ với một nút bấm</p>
		        	<a href="" type="button" class="btn btn-outline-primary" onclick="return OwnerConfirm()">Bắt đầu ngay</a>
		        </div>
	        </div>
        </div>
        
    </div>

<script type="text/javascript">
	function OwnerConfirm() {
		confirm("Bạn sẽ trở thành người cho thuê xe, chắc chắn chứ");
	}	
</script>
<%@include file="_Footer.jsp"%>
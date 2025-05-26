<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="./assets/styles/styles.css">
    <link rel="stylesheet" href="./assets/styles/cart.css">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@eonasdan/tempus-dominus@6.9.5/dist/css/tempus-dominus.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    
    <script src="https://kit.fontawesome.com/3ecdd9878f.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/luxon@3/build/global/luxon.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@eonasdan/tempus-dominus@6.9.5/dist/js/tempus-dominus.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
</head>
<body>
<%// <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">%>
<%@include file="_HeaderOnly.jsp"%>

<div class="container bike-detail-container" style="margin-top: 130px;">
    <div class="row align-items-start g-4">
        <div class="col-md-5 col-12">
            <div class="slider-cover">
                <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner w-100">
                    <c:forEach var="photo" items="${BikePhotos}">
                    	<div class="carousel-item active">
                          <img src="./assets/img/motobikes/${photo}" class="d-block w-100" alt="..." style="height: 500px; object-fit: contain; border-radius: 8px;">
                      </div>
                    </c:forEach>
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
            <h3>${getBike.bikeName}</h3>
            <h1 style="color: #f00;">đ ${getBike.price}/ ngày</h1>
            <p><b>Màu xe: </b>Đen</p>
            <p> <b>Loại xe: </b> ${getBike.bikeLine}</p>
            <p> <b>Hãng xe: </b> ${getBike.bikeManufactor}</p>
            <p><b>Biển số: </b>${getBike.licensePlate}</p>
            <p><b>Năm sản xuất: </b>${getBike.manufacturingYear}</p>
            <button class="btn btn-primary" ${act!=null?'disabled':'' }  data-bs-toggle="modal" data-bs-target="#exampleModal" >Đặt xe</button>
        </div>
    </div> 
</div>
<div class="container bike-detail-container p-3" style="margin-top:10px">
	<p style="font-weight: 600">THÔNG TIN CHỦ XE</p>
	<div class="shop-info" style="display: flex; align-items: flex-start;">

		<img src="assets/img/daiNoi.jpg" style="width:79px;height:79px;object-fit:cover; border-radius:50%;">
	
		<ul>
			<li><p>${ownerInfo.userName }</p> </li>
			<li><p><span>Số điện thoại:</span>  ${ownerInfo.phone }</p></li>
			<li><p><span>Địa chỉ:</span> ${ownerInfo.address }</p></li>
		</ul>
	</div>
</div>

<div class="container bike-detail-container p-3" style="margin-top:10px">
	<p style="font-weight: 600">NHỮNG LOẠI XE TƯƠNG TỰ</p>
	<div class="row align-items-start g-2">
		<c:forEach var="item" items="${getSimilarBike}">
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
                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i>  ${item.price} vnd/ngày</p>
                    <a href="BikeDetail?id=${item.bikeId}" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
                  </div>
                </div>
            </div>
		</c:forEach> 
     </div>
     <div class="text-center mt-3 mb-3">
     	<a href="BikeControler">Xem thêm...</a>
     </div>
     
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm vào đơn hàng</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      	<form action="Order" method="posts">
      		<input name="bikeToCartId" hidden type="text" value="${getBike.bikeId}">
      		<input name="act" hidden type="text" value="add">
	      <div class="modal-body">
	        <table class="table table-bordered">
	           <thead class="table-light">
	             <tr>
	               <th style="width: 120px;">Ảnh</th>
	               <th>Thông tin xe</th>
	               <th>Ngày nhận xe</th>
	               <th>Ngày trả xe</th>
	               <th>Giá / ngày</th>
	             </tr>
	           </thead>
	           <tbody>
	             <tr class="cart-item">
	               <td> <img src="./assets/img/motobikes/${BikePhotos[0]}" alt="" class="cart-item-img"></td>
	               <td>
	                   <ul>
	                       	<li><b>Màu xe: </b>Đen</li>
				            <li> <b>Loại xe: </b> ${getBike.bikeLine}</li>
				            <li> <b>Hãng xe: </b> ${getBike.bikeManufactor}</li>
				            <li><b>Biển số: </b>${getBike.licensePlate}</li>
				            <li><b>Năm sản xuất: </b>${getBike.manufacturingYear}</li>
	                   </ul> 
	               </td>
	               <td>
		               	<div class="input-group" id="timepickerstart" data-td-target-input="nearest" data-td-target-toggle="nearest">
			             	<input type="text" class="form-control" placeholder="dd/MM/yyyy HH:mm" name="startDay" data-td-target="#timepickerstart" />
			             	<span class="input-group-text" data-td-toggle="datetimepicker" data-td-target="#timepickerstart">
			               		<i class="fa fa-calendar"></i>
			             	</span>
		           		</div>
	         		</td>
	               <td>
	               	<div class="input-group" id="timepickerfinish" data-td-target-input="nearest" data-td-target-toggle="nearest">
	              		<input type="text" class="form-control" placeholder="dd/MM/yyyy HH:mm" name="endDay" data-td-target="#timepickerfinish" />
	              		<span class="input-group-text" data-td-toggle="datetimepicker" data-td-target="#timepickerfinish">
	                		<i class="fa fa-calendar"></i>
	              		</span>
	            	</div>
	               </td>
	               <td>${getBike.price} VND</td>
	               </td>
	             </tr>
	           </tbody> 
	         </table>
      		</div>
      		
	      <div class="modal-footer">
	        <button type="submit" class="btn btn-success">Thêm vào giỏ hàng</button>
	      </div>
         
         </form>
    </div>
  </div>
</div>
<div class="input-group" id="timepickerfinish" data-td-target-input="nearest" data-td-target-toggle="nearest">
	              		<input type="text" class="form-control" placeholder="dd/MM/yyyy HH:mm" data-td-target="#timepickerfinish" />
	              		<span class="input-group-text" data-td-toggle="datetimepicker" data-td-target="#timepickerfinish">
	                		<i class="fa fa-calendar"></i>
	              		</span>
	            	</div>
	           
	           
<%@include file="_FooterOnly.jsp"%>	            	
<script>
      document.addEventListener('DOMContentLoaded', function () {
        const commonOptions = {
          display: {
            components: {
              calendar: true,
              date: true,
              month: true,
              year: true,
              decades: true,
              clock: true,
              hours: true,
              minutes: true,
              seconds: false
            }
          },
          localization: {
            locale: 'vi'
          }
        };
        new tempusDominus.TempusDominus(document.getElementById('timepickerstart'), commonOptions);
        new tempusDominus.TempusDominus(document.getElementById('timepickerfinish'), commonOptions);
      });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    
</body>
</html>

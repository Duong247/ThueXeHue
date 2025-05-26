<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="grp-header-content">
	<h1>Quản lý đơn hàng</h1>
	<button type="button" class="btn add-bike-btn"><i class="fa-solid fa-circle-plus" style="margin: 0 5px"></i>Thêm xe mới</button>
</div>
<div class="text-center" ${orderHistory!=null?'hidden':''}>
	Hiện tại bạn chưa có đơn hàng nào để xử lý!
</div>
<div class="cover">
	<c:forEach var="order" items="${orderList }">
		<div class="card order-card">
			<div class="card-head">
				<h5 class="order-num"><b>#HD00${order.orderId }</b></h5>
				<p class="order-status order-success"><b>Hoàn thành</b></p>
			</div>
			<div class=card-body-order>
				<table class="table">
				  <tbody>
				  <c:forEach var="item" items="${order.items}" varStatus="loop">
				    <tr>
				      <th scope="row" style="max-width: 40px">${loop.index + 1}</th>
				      <td style="max-width: 80px"><img src="${item.photo != null ?item.photo : './assets/img/logo.png'}" class="img-thumbnail" ></td>
				      <td>
				      	<strong>${item.bikeName}</strong> - Biển số: ${item.licensePlate}<br/>
		                    Từ: ${item.pickupDate} - Đến: ${item.returnDate}<br/>
		                    Giá thuê: ${item.rentalFee} VND
		               </td>
				      <td>${cbo.getRentalDays(item.returnDate,item.pickupDate)} Ngày</td>
				      <td><b>${item.rentalFee} đ</b></td>
				    </tr>				  
				  </c:forEach>
				  </tbody>
				  <div class="text-right">
				  </div>
				</table>
			</div>
		</div>
	</c:forEach>
	<div class="card order-card">
		<div class="card-head">
			<h5 class="order-num"><b>#HD0011</b></h5>
			<p class="order-status order-success"><b>Hoàn thành</b></p>
		</div>
		<div class=card-body-order>
			<table class="table">
			  <tbody>
			    <tr>
			      <th scope="row" style="max-width: 40px">1</th>
			      <td style="max-width: 80px"><img src="./assets/img/logo.png" class="img-thumbnail" ></td>
			      <td>SH 350i</td>
			      <td>from: 22/02/2022</td>
			      <td>to: 25/02/2022</td>
			      <td>to: 25/02/2022</td>
			    </tr>
			    <tr>
			      <th scope="row" style="max-width: 40px">1</th>
			      <td style="max-width: 80px"><img src="./assets/img/logo.png" class="img-thumbnail" ></td>
			      <td>SH 350i</td>
			      <td>from: 22/02/2022</td>
			      <td>to: 25/02/2022</td>
			      <td>to: 25/02/2022</td>
			    </tr>
			  </tbody>
			  <div class="text-right">
			  </div>
			</table>
		</div>
	</div>
</div>
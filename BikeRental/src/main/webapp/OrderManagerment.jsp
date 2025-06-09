<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="grp-header-content">
	<h1>Quản lý đơn hàng</h1>
	
</div>
<div class="text-center" ${orderList!=null?'hidden':''}>
	Hiện tại bạn chưa có đơn hàng nào để xử lý!
</div>
<div class="cover">
	<c:forEach var="order" items="${orderList }">
		<div class="card order-card">
			<div class="card-head">
				<h5 class="order-num"><b>${String.format("#HD%04d", order.orderId)}</b></h5>
				<c:choose>
                     <c:when test="${order.status == -1}"><p class="btn btn-danger"><b>Bị hủy</b></p></c:when>
                     <c:when test="${order.status == 0}"><p class="btn btn-secondary">Chờ xác nhận</p></c:when>
                     <c:when test="${order.status == 1}"><p class="btn btn-info" style="color: #fff">Đã được xác nhận</p></c:when>
                     <c:when test="${order.status == 2}"><p class="btn btn-success">Hoàn tất</p></c:when>
                 </c:choose>
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
	                    Giá thuê: <span class="currency"> ${item.rentalFee}</span>  VND
		              </td>
				      <td>${item.getRentalDays()} Ngày</td>
				      <td><b><span class="currency">${item.getSubtotal()}</span> VND</b></td>
				    </tr>				  
				  </c:forEach>
				  </tbody>
				</table>
			  <div class="text-end">
			  	<p>Nơi giao xe: ${order.getPickupPlace() } </p>
                 <h5><span class="currency"> ${order.getTotal() }</span> VND</h5>
               </div>
                 <div class="text-end">
                 <form action="OwnerManagerment" method="post">
					<input hidden name="orderId" value="${order.orderId }">
					<input hidden name="p" value="order">                 
                  	<button ${order.status!=0?'hidden':'' } class="btn btn-info" name="act" value="accept" onclick="return acceptconfirm('${String.format('#HD%04d', order.orderId)}')"><i style="color: #fff" class="fa-solid fa-check"></i></button>
                  	<button ${order.status!=0?'hidden':'' } class="btn btn-danger" name="act" value="deny" onclick="return denyconfirm('${String.format('#HD%04d', order.orderId)}')"><i class="fa-solid fa-ban"></i></button>
                  	<button ${order.status!=1?'hidden':'' } class="btn btn-success" name="act" value="complete" onclick="return completeconfirm('${String.format('#HD%04d', order.orderId)}')"><i class="fa-solid fa-money-bill-wheat"  ></i>Hoàn tất</button>
                 </form>
                 </div>
			</div>
		</div>
	</c:forEach>
	
</div>
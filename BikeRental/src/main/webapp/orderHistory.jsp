<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/styles/styles.css">
    <link rel="stylesheet" href="./assets/styles/Manage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/3ecdd9878f.js" crossorigin="anonymous"></script>
    <script src="https://cdn.plot.ly/plotly-3.0.1.min.js" charset="utf-8"></script>
    <title>HueBikeRent</title>
    <!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- autoNumeric -->
	<script src="https://cdn.jsdelivr.net/npm/autonumeric@4.6.0/dist/autoNumeric.min.js"></script>
</head>
<body>
<%@include file="_HeaderOnly.jsp"%>
<div class="container" style="min-height: 614px;margin-top: 82px">
        <div class="row align-items-start g-4">
            <div class="col-md-9 col-12" >
                <div class="head-col text-left d-flex justify-content-between" style="margin-bottom: 0">
                    <h3>Lịch sử thuê xe</h3>
                    <a href="Order" style="padding: 5px; text-decoration: none;color: #3454cf"><i class="fa-solid fa-arrow-left" style="padding: 5px"></i>Quay lại giỏ hàng</a>
                </div>
                <hr style="border-color: #000;">
                <div class="text-center" ${orderHistory!=null?'hidden':''}>
					Bạn chưa có đơn hàng nào, <a href="BikeDetail">Thuê xe ngay</a>
				</div>
                <div class="cart-content">
					<div class="cover">
						<c:forEach var="order" items="${orderHistory}">
				            <div class="card order-card">
				                <div class="card-head">
				                    <h5 class="order-num"><b>${String.format("#HD%04d", order.orderId)}</b></h5>
				                    <c:choose>
			                            <c:when test="${order.status == -1}"><p class="btn btn-danger"><b>Bị hủy</b></p></c:when>
			                            <c:when test="${order.status == 0}"><p class="btn btn-secondary">Chờ xác nhận</p></c:when>
			                            <c:when test="${order.status == 1}"><p class="btn btn-info" style="color:#fff">Đã được xác nhận</p></c:when>
			                            <c:when test="${order.status == 2}"><p class="btn btn-success">Hoàn tất</p></c:when>
			                        </c:choose>
				                </div>
				                <div class="card-body-order">
				                    <table class="table">
				                        <tbody>
				                            <c:forEach var="item" items="${order.items}" varStatus="loop">
				                                <tr>
				                                    <th scope="row" style="max-width: 40px">${loop.index + 1}</th>
				                                    <td style="max-width: 80px">
				                                        <img src="${item.photo != null ?item.photo : './assets/img/logo.png'}" class="img-thumbnail" style="width: 80px;">
				                                    </td>
				                                    <td> 
				                                    	<strong>${item.bikeName}</strong> - Biển số: ${item.licensePlate}<br/>
									                    Từ: ${item.pickupDate} - Đến: ${item.returnDate}<br/>
									                    Giá thuê: <span class="currency">  ${item.rentalFee}</span> VND
				                                    </td>
				                                    <td>${cbo.getRentalDays(item.returnDate,item.pickupDate)} Ngày</td>
				                                    <td><b><span class="currency">${item.getSubtotal()}</span> VND</b></td>
				                                </tr>
				                            </c:forEach>
				                        </tbody>
				                    </table>
			                        <div class="text-end">
			                        	<h5><span class="currency">${order.getTotal() }</span>VND </h5>
			                        </div>
			                        <c:if test="${order.status == 0}">			                        
				                        <div class="text-end">
				                        	<form  action="Order" method="post">
				                        		<input hidden name="orderId" value="${order.orderId }">
				                        		<input hidden name="act" value="delete">
				                        		<button type="submit" class="btn btn-danger" onclick="return deleteconfirm('HD${String.format('%04d', order.orderId)}')">Hủy đơn hàng</button>
				                        	</form>
				                        </div>
			                        </c:if>
				                </div>
				            </div>
				        </c:forEach>
						
					</div>
                </div>
            </div>	
        </div>
    </div>

</body>
<script type="text/javascript">
	$(document).ready(function () {
	    AutoNumeric.multiple('.currency', {
	        digitGroupSeparator: ',',
	        decimalPlaces: 0, // không có phần thập phân
	        modifyValueOnWheel: false
	    });
	});
	
	function deleteconfirm(orderId) {
		return confirm("Đơn thuê "+orderId+" sẽ bị hủy bạn chắc chắn?");
	}
	
</script>
</html>  
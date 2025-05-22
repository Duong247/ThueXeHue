<%@page import="BikeModal.BikeBo"%>
<%@page import="CartItemModal.CartItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
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
<% 
	BikeBo bikeBo = new BikeBo();
%>
<div class="container" style="min-height: 614px;margin-top: 82px">
        <div class="row align-items-start g-4">
            <div class="col-md-9 col-12" >
                <div class="head-col text-left d-flex justify-content-between" style="margin-bottom: 0">
                    <h3> Đơn hàng của bạn</h3>
                    <a href="OrderHistory" style="padding: 5px; text-decoration: none"><i class="fa-solid fa-clock-rotate-left" style="padding: 5px"></i>Lịch sử mua hàng</a>
                </div>
                <hr style="border-color: #000;">
                <div class="cart-content">
                    <div class="text-end" style="margin: 8px 0;">
                        <a class="btn btn-danger" href="Order?act=clear">Xóa tất cả</a>
                    </div>
                    <table class="table table-bordered">
                        <thead class="table-light">
                          <tr>
                            <th style="width: 120px;">Ảnh</th>
                            <th>Thông tin xe</th>
                            <th style="width: 40%">Ngày nhận/trả xe</th>
                            <th>Giá / ngày</th>
                            <th style="width: 30px;">Thao tác</th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                        	<c:when test="${itemCartList==null || itemCartList.size()==0}">
                        		<tr class="text-center"><td colspan="6">Giỏ hàng trống</td> </tr>
                        	</c:when>
                        	<c:otherwise>
	                        	<c:forEach var="item" items="${itemCartList}">
                                    <tr class="cart-item">
                                        <td><img src="./assets/img/motobikes/${item.photo }" alt="" class="cart-item-img" style="width:100%; height:auto;"></td>
                                        <td>
                                            <ul style="padding-left: 5px">
                                                <li><b>Tên xe:</b>${item.bikeName}</li>
                                                <li><b>Màu xe:</b>${item.bikeName}</li>
                                                <li><b>Loại xe:</b>${item.bikeLine}</li>
                                                <li><b>Hãng xe:</b>${item.bikeManufactor}</li>
                                                <li><b>Biển số:</b>${item.licensePlate}</li>
                                                <li><b>Năm sản xuất:</b>${item.manufacturingYear}</li>
                                            </ul>
                                        </td>
                                        <td>
                                        <form action="Order" method="posts"> 
                                        	<input hidden name="bikeToCartId" value="${item.bikeId}">
                                        	<input hidden name="act" value="update">
                                       		<div style="width: 100%">
                                        		<p>Ngày nhận xe: </p>
                                       		</div>
                                        	<div class="input-group timepicker-start" id="timepickerstart" data-td-target-input="nearest" data-td-target-toggle="nearest">
						                        <input type="text" class="form-control start-input" name="startDay" placeholder="dd/MM/yyyy HH:mm" data-td-target="#timepickerstart" value="${item.pickupDateFormatted}"/>
						                        <span class="input-group-text" data-td-toggle="datetimepicker" data-td-target="#timepickerstart">
						                          <i class="fa fa-calendar"></i>
						                        </span>
						                    </div>
					                        <div style="width: 100%">
					                        	<p style="display: block">Ngày trả xe: </p>
					                        </div>
	                                        <div class="input-group timepicker-end" id="timepickerfinish" data-td-target-input="nearest" data-td-target-toggle="nearest">
						                        <input type="text" class="form-control end-input" name="endDay" placeholder="dd/MM/yyyy HH:mm" data-td-target="#timepickerfinish" value="${item.returnDateFormatted }"/>
						                        <span class="input-group-text" data-td-toggle="datetimepicker" data-td-target="#timepickerfinish">
						                          <i class="fa fa-calendar"></i>
						                        </span>
						                     </div>
						                     <div class="text-end" style="padding:8px 0">
						                     	<button type="submit" class="btn btn-secondary">Sửa</button>
						                     </div>
                                        </form>
                                        </td>
                                        <td>${item.rentalFee} VND</td>
                                        <td>
                                            <form method="post" action="Order">
                                                <input type="hidden" name="bikeToCartId" value="${item.bikeId}">
                                                <input type="hidden" name="act" value="delete">
                                                <button class="btn btn-danger"><i class="fa-solid fa-trash"></i></button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                        	</c:otherwise>
                        </c:choose>
                          
             
                          
                          

                        </tbody> 
                      </table>
                      
                </div>
            </div>
            <div class="col-md-3 col-12" >
                <div class="head-col text-left">
                    <h3> Thông tin nhận xe</h3>
                    <hr style="border-color: #000;">
                </div>
                <form action="Order" method="posts">
                	<input name="act" value="createOrder" hidden >
                	<input name="userId" value="${currentUserInf.getUserId() }" hidden>
                    <div class="mb-3">
                        <label for="user-name" class="form-label">Họ và tên</label>
                        <input type="text" disabled="disabled" class="form-control" id="user-name" value="${currentUserInf.getUserName() }" placeholder="Nhập họ và tên">
                      </div>
                    <div class="mb-3">
                      <label for="address" class="form-label">Địa chỉ nhận xe</label>
                      <input type="text" class="form-control" id="address" name="pickupPlace" placeholder="Nhập địa chỉ nhận xe">
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Số điện thoại</label>
                      <input type="phone" class="form-control" id="exampleInputEmail1" name="returnPlace"  placeholder="Nhập số điện thoại" value="${currentUserInf.getPhone() }">
                    </div>
                    
                    <div class="text-end">
                        <button type="submit" class="btn btn-primary">Đặt xe</button>
                    </div>
                  </form>
            </div>
        </div>
    </div>
    <%@include file="_FooterOnly.jsp" %>
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

        
        
        document.querySelectorAll('.timepicker-start').forEach(function (el) {
            new tempusDominus.TempusDominus(el, commonOptions);
          });

          document.querySelectorAll('.timepicker-end').forEach(function (el) {
            new tempusDominus.TempusDominus(el, commonOptions);
          });
      });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    

</body>
</html>
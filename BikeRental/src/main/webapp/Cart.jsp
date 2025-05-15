<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container" style="min-height: 614px;margin-top: 82px">
        <div class="row align-items-start g-4">
            <div class="col-md-8 col-12" >
                <div class="head-col text-left">
                    <h3> Đơn hàng của bạn</h3>
                    <hr style="border-color: #000;">
                </div>
                <div class="cart-content">
                    <div class="text-end" style="margin: 8px 0;">
                        <button class="btn btn-danger">Xóa tất cả</button>
                    </div>
                    <table class="table table-bordered">
                        <thead class="table-light">
                          <tr>
                            <th style="width: 120px;">Ảnh</th>
                            <th>Thông tin xe</th>
                            <th>Ngày nhận xe</th>
                            <th>Ngày trả xe</th>
                            <th>Giá / ngày</th>
                            <th style="width: 30px;">Thao tác</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr class="cart-item">
                            <td> <img src="./assets/img/sh.png" alt="" class="cart-item-img"></td>
                            <td>
                                <ul>
                                    <li><b>Tên xe:</b> Xe sh</li>
                                    <li><b>Biển số:</b> 75-AF 01100</li>
                                    <li><b>Màu xe:</b> Xám xi măng</li>
                                </ul> 
                            </td>
                            <td></td>
                            <td></td>
                            <td>100.000đ /ngày</td>
                            <td><button class="btn btn-danger"><i class="fa-solid fa-trash"></i></button>
                            </td>
                          </tr>
                          <tr class="cart-item">
                            <td> <img src="./assets/img/sh.png" alt="" class="cart-item-img"></td>
                            <td>
                                <ul>
                                    <li><b>Tên xe:</b> Xe sh</li>
                                    <li><b>Biển số:</b> 75-AF 01100</li>
                                    <li><b>Màu xe:</b> Xám xi măng</li>
                                </ul> 
                            </td>
                            <td>
                            	
                      		</td>
                            <td>
                            	
                            </td>
                            <td>100.000đ</td>
                            <td><button class="btn btn-danger"><i class="fa-solid fa-trash"></i></button>
                            </td>
                          </tr>
                          
                        </tbody> 
                      </table>
                      
                </div>
            </div>
            <div class="col-md-4 col-12" >
                <div class="head-col text-left">
                    <h3> Thông tin nhận xe</h3>
                    <hr style="border-color: #000;">
                </div>
                <form>
                    <div class="mb-3">
                        <label for="user-name" class="form-label">Họ và tên</label>
                        <input type="text" disabled="disabled" class="form-control" id="user-name" placeholder="Nhập họ và tên">
                      </div>
                    <div class="mb-3">
                      <label for="address" class="form-label">Địa chỉ nhận xe</label>
                      <input type="text" class="form-control" id="address"  placeholder="Nhập địa chỉ nhận xe">
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Số điện thoại</label>
                      <input type="phone" class="form-control" id="exampleInputEmail1" placeholder="Nhập số điện thoại">
                    </div>
                    <div class="mb-3">
                      <label for="timepickerstart" class="form-label">Ngày nhận xe:</label>
                      <div class="input-group" id="timepickerstart" data-td-target-input="nearest" data-td-target-toggle="nearest">
                        <input type="text" class="form-control" placeholder="dd/MM/yyyy HH:mm" data-td-target="#timepickerstart" />
                        <span class="input-group-text" data-td-toggle="datetimepicker" data-td-target="#timepickerstart">
                          <i class="fa fa-calendar"></i>
                        </span>
                      </div>
                    </div>
                    <div class="mb-3">
                      <label for="timepickerfinish" class="form-label">Ngày nhận xe:</label>
                      <div class="input-group" id="timepickerfinish" data-td-target-input="nearest" data-td-target-toggle="nearest">
                        <input type="text" class="form-control" placeholder="dd/MM/yyyy HH:mm" data-td-target="#timepickerfinish" />
                        <span class="input-group-text" data-td-toggle="datetimepicker" data-td-target="#timepickerfinish">
                          <i class="fa fa-calendar"></i>
                        </span>
                      </div>
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
        new tempusDominus.TempusDominus(document.getElementById('timepickerstart'), commonOptions);
        new tempusDominus.TempusDominus(document.getElementById('timepickerfinish'), commonOptions);
      });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    

</body>
</html>
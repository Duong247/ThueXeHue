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
    <!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- autoNumeric -->
	<script src="https://cdn.jsdelivr.net/npm/autonumeric@4.6.0/dist/autoNumeric.min.js"></script>
    <title>HueBikeRent</title>
</head>
<body>
<%@include file="_HeaderOnly.jsp"%>
<div style="margin-top: 85px">
	<div id="sidebar" class="bg-dark text-white p-3 transition-width" >
	  <button id="toggle-btn" class="btn btn-sm btn-light mb-2">☰</button>
	  <div class="btn-group-cover" >
	  <ul class="btn-list" style="margin-top: 15px" ${currentUserInf.role!=0?'hidden':'' }>
	  	  <li><h6 class="sidebar-content"> QUẢN LÍ WEBSITE</h6></li>
	      <li><a href="OwnerManagerment?p=slider"><i class="fa-solid fa-images"></i><span class="sidebar-content"> Quản lí sider</span></a>  </li>
	      <li><a href="OwnerManagerment?p=user"><i class="fa-solid fa-users"></i><span class="sidebar-content">Quản lí user</span></a>  </li>
	      <li><a href="OwnerManagerment?p=adminBike"><i class="fa-solid fa-person-biking"></i><span class="sidebar-content">Quản lí xe</span></a>  </li>
	    </ul>
	    <ul class="btn-list">
	      <li><h6 class="sidebar-content"> QUẢN LÍ CHO THUÊ</h6> </li>
	      <li><a href="OwnerManagerment?p=main"><i class="fa-solid fa-gauge"></i><span class="sidebar-content">Dashboard</span></a>  </li>
	      <li><a href="OwnerManagerment?p=bike"><i class="fa-solid fa-motorcycle"></i><span class="sidebar-content">Xe của tôi</span></a>  </li>
	      <li><a href="OwnerManagerment?p=order"><i class="fa-solid fa-clipboard-list"></i><span class="sidebar-content"> Quản lí đơn hàng</span></a>  </li>
	    </ul>
	  </div>

	</div>
	 
	<div id="main-content" class="bg-light p-4 content-scale" style="min-height: 85vh" >
		<c:choose>
			<c:when test="${p!=null && p.equals('user') }">
				<%@include file="UserAdminManagerment.jsp" %>
			</c:when>
			<c:when test="${p!=null && p.equals('adminBike') }">
				<%@include file="BikeAdminManagerment.jsp" %>
			</c:when>
			<c:when test="${p!=null && p.equals('slider') }">
				<%@include file="SliderMangement.jsp" %>
			</c:when>
			<c:when test="${p!=null && p.equals('order') }">
				<%@include file="OrderManagerment.jsp" %>
			</c:when>
			<c:when test="${p!=null && p.equals('bike') }">
				<%@include file="BikesManagerment.jsp" %>
			</c:when>
			<c:otherwise>
				<%@include file="DashboardContent.jsp" %>			
			</c:otherwise>
		</c:choose>
	  
	  
	</div>

</div>

<div id="footer" class="content-scale">
  <div class="footer-content">
    <p>@2025 - Bản quyền thuộc về Dương Trần</p>
  </div>
</div>



<c:if test="${hasErr}">
<script>
    window.addEventListener('DOMContentLoaded', function () {
        var exampleModal = new bootstrap.Modal(document.getElementById('exampleModal'));
        exampleModal.show();
    });
</script>
</c:if>


<script>
  document.getElementById('toggle-btn').addEventListener('click', () => {
    document.getElementById('sidebar').classList.toggle('collapsed');
    document.getElementById('main-content').classList.toggle('content-scale');
    document.getElementById('footer').classList.toggle('content-scale');
  });
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<c:if test="${act == 'update'}">
<script>
    window.addEventListener('DOMContentLoaded', function () {
        var modal = new bootstrap.Modal(document.getElementById('exampleModal'));
        modal.show();
    });
</script>
</c:if>

<script>
$(document).ready(function () {
    $('#uploadForm').submit(function (e) {
        e.preventDefault(); // Ngăn không cho form reload

        var formData = new FormData(this);

        $.ajax({
            url: 'UploadBikeImgController',
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            success: function () {
                // Gọi lại phần danh sách ảnh đã upload (AJAX render lại phần đó)
                $('#uploadedAvatarsContainer').load(location.href + " #uploadedAvatarsContainer>*", "");
            },
            error: function () {
                alert("Lỗi khi upload ảnh");
            }
        });
    });
    $('#uploadedAvatarsContainer').on('submit', '.remove-image-form', function (e) {
        e.preventDefault();  // Ngăn submit form reload trang

        var $form = $(this);
        $.ajax({
            url: $form.attr('action'),
            type: 'POST',
            data: $form.serialize(), // gửi index để xóa
            success: function () {
                // Reload lại phần ảnh đã upload sau khi xóa
            	$('#uploadedAvatarsContainer').load(location.href + " #uploadedAvatarsContainer>*", "");
            },
            error: function () {
                alert('Xóa ảnh thất bại, vui lòng thử lại.');
            }
        });
    });
});
</script>
<script type="text/javascript">
	$(document).ready(function () {
	    AutoNumeric.multiple('.currency', {
	        digitGroupSeparator: ',',
	        decimalPlaces: 0, // không có phần thập phân
	        modifyValueOnWheel: false
	    });
	});
	
	function deleteconfirm(bikeName) {
		return confirm("Xe "+ bikeName + " sẽ bị xóa, bạn chắc chắn chứ?");
	}
	
	function denyconfirm(orderId) {
		return confirm("Đơn hàng "+ orderId + " sẽ bị từ chối, bạn chắc chắn chứ?");
	}
	
	function acceptconfirm(orderId) {
		return confirm("Đơn hàng "+ orderId + " được xác nhận?");
	}
	
	function completeconfirm(orderId) {
		return confirm("Xác nhận hoàn tất dơn hàng "+ orderId + "?");
	}

</script>

</body>
</html>



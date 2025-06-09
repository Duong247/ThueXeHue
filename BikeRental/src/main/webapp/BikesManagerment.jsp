<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="grp-header-content">
	<h1>Quản lý xe</h1>
	<button type="button" class="btn add-bike-btn" data-bs-toggle="modal" style="background-color: #3454cf !important" data-bs-target="#exampleModal"><i class="fa-solid fa-circle-plus" style="margin: 0 5px"></i>Thêm xe mới</button>
</div>

<div class="cover">
  <div class="row align-items-start g-3">
	  <c:forEach var="bike" items="${OwnerBikes}">
  		<c:if test="${OwnerBikes[0].bikeId !=0}">
			<div class="content-cover col-lg-4 col-6">
				<div class="bike-card">
					<div class="upper-bike-inf " >
						<img src="${bike.getPhoto()==null?'assets/img/logo2.png':bike.getPhoto()}" class="img-thumbnail bike-img" style="max-height: 130px" alt="...">
						<div class="bike-inf" >
							<p class="bike-name"><b>Tên xe:</b> ${bike.getBikeName() }</p>
							<p><b>Biển số: </b>${bike.getLicensePlate() }</p>
							<c:choose>
								<c:when test="${bike.getStatus()==-2}">
									<p class="btn btn-danger">xe bị từ chối </p>
								</c:when>
								<c:when test="${bike.getStatus()==-1}">
									<p class="btn btn-secondary">Chờ được duyệt</p>
								</c:when>
								<c:when test="${bike.getStatus()==0}">
									<p class="btn btn-warning">Đang được thuê</p>
								</c:when>
								<c:when test="${bike.getStatus()==1}">
									<p class="btn btn-success">Sẵn sàng</p>
								</c:when>
							</c:choose>
						</div>
					</div>
					<div class="d-grid gap-2 d-md-block text-center" style="border-top:1px #ccc solid; padding: 5px">
					  <a class="btn btn-primary" href="UpdateBikeController?id=${bike.getBikeId() }" type="button"><i class="fa-solid fa-pencil"></i></a>
					  <button class="btn btn-danger" type="button" onclick="return deleteconfirm('${bike.getBikeName()}')"><i class="fa-solid fa-trash"></i></button>
					</div>
				</div>
			</div>
		  </c:if>
	  </c:forEach>
		  <c:if test="${OwnerBikes[0].bikeId ==0}">
		  	<div class="text-center">
		  		Bạn chưa đăng tải xe nào!
		  	</div>
		  </c:if>
  </div>
</div>
 
 
 
 <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="BikeSubmit"  method="post">
        	<div class="mb-3">
		    	<label for="bikeName" class="form-label">Tên xe:</label>
		    	<input type="text" class="form-control" name="bikeName" id="bikeName" placeholder="Ví dụ: Honda Air Blade,..." value="${bikeName }">
		    	<span style="color: red">${nameErr}</span>
	  		</div>
	  		<div class="mb-3">
		    	<label for="licensePlate" class="form-label">Biển số:</label>
		    	<input type="text" class="form-control" name="licensePlate" id="licensePlate" placeholder="Ví dụ: 75AF-011.00,..." value="${licensePlate}">
		    	<span style="color: red">${licensePlateErr}</span>
	  		</div>
	  		<div class="mb-3">
		    	<label for="manufacturingYear" class="form-label">Năm sản xuất:</label>
		    	<input type="number" class="form-control" id="manufacturingYear" name="manufacturingYear" value="${manufacturingYear}">
		    	<span style="color: red">${yearErr}</span>
	  		</div>
	  		<div class="mb-3">
		    	<label for="bikeLine" class="form-label">Dòng xe:</label>
		    	<select class="form-control" id="bikeLine" name="bikeLine" ">
		    		<option>Chọn dòng xe</option>
		    		<c:forEach var="item" items="${listBikeLine}">
		    			<option ${item.equals(bikeLine )?'selected':'' } value="${item}" >${item}</option>
		    		</c:forEach>  
		    	</select>
		    	<span style="color: red">${bikelineErr}</span>
	  		</div>
	  		<div class="mb-3">
		    	<label for="BikeManufactor" class="form-label">Nhà sản xuất:</label>
		    	<select  class="form-control" id="BikeManufactor" name="BikeManufactor" >
		    		<option>Chọn nhà sản xuất</option>
		    		<c:forEach var="item" items="${listManufactor}">
		    			<option ${item.equals(BikeManufactor)?'selected':'' } value="${item}" >${item}</option>
		    		</c:forEach>  		
		    	</select>
		    	<span style="color: red">${manufactorErr}</span>
	  		</div>
	  		<div class="mb-3">
		    	<label for="Description" class="form-label">Mô tả:</label>
		    	<textarea class="form-control" name="description" id="Description" >${description}</textarea>
	  		</div>
	  		<div class="mb-3">
		    	<label for="price" class="form-label">Giá thuê theo ngày:</label>
		    	<input type="text" class="form-control" id="price" name="price" value="${price }">
		    	<span style="color: red">${priceErr}</span>
	  		</div>
	  		<input hidden name="id" value="${bikeId }">
	  		<input hidden name="action" value="${act.equals('update')?act:'create'}" >
	  		<div class="modal-footer">
	        	<button type="submit" id="saveBikeBtn" class="btn btn-primary btn-submit">${act=='update'?'Lưu thay đổi':'Thêm' }</button>
	      </div>
	  	</form>
        <form id="uploadForm"  method="post" enctype="multipart/form-data">
        	<label>Ảnh :</label>
	        <input type="file" name="imgFile" />
	        <button type="submit"><i class="fa-solid fa-cloud-arrow-up"></i>Tải ảnh lên</button>
        </form>
		<div id="uploadedAvatarsContainer">
		    <jsp:include page="Uploadedimgs.jsp"/>
		</div>
      </div>
      
    </div>
  </div>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" style="min-height: 614px;">
    <div class="row align-items-start g-4">
        <div class="col-12" >
            <div class="head-col text-left d-flex justify-content-between" style="margin-bottom: 0">
                <h3>Quản lí xe</h3>
            </div>
            <hr style="border-color: #000;">
            <div class="text-right">
            	<form action="OwnerManagerment" method="post" class="text-right">
            	<div class="row g-2">
            		<div class="col-2">
            			<select style="margin-top: 5px;" name="searchBikeLine" class="form-select col-2">
            			<option value="">Chọn loại xe</option>
            			<c:forEach var="item" items="${listBikeLine }">
            				<option ${item.equals(searchBikeLine)?'selected':'' } value="${item }">${item }</option>
            			</c:forEach>
            		</select>
            		</div>
            		<div class="col-2">
            			<select style="margin-top: 5px;" name="searchManufactor" class="form-select col-2">
            			<option value="">Chọn Hãng xe</option>
            			<c:forEach var="item" items="${listBikeManufactor }">
            				<option ${item.equals(searchManufactor)?'selected':'' } value="${item }">${item }</option>
            			</c:forEach>
            		</select>
            		</div>
            		<div class="col-2">
            			<select style="margin-top: 5px;" name="searchStatus" class="form-select col-2">
	            			<option value="">Trạng thái</option>
	            			<c:forEach var="item" items="${listBikeStatus }">
	            				<option ${item.equals(searchStatus)?'selected':'' } value="${item }">${bBo.statusStr(item)}</option>
	            			</c:forEach>
	            		</select>
            		</div>
            		<div class="col-5">
            			<input style="margin-top: 5px;" type="text" name="searchBikeName" id="" class="col-5 search-price" min="0" placeholder="" value="${searchBikeName }">
            		 	<input hidden name="p" value="adminBike">
        				<button type="submit" name="" style="padding: 10px; width: 50px; font-size: 18px;" class="bike-search"  ><i class="fa-solid fa-magnifying-glass"></i></button>
            		</div>
            	</div>
            		
            	</form>
            </div>
            <div class="cover" >
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col" style="width: 80px;">#</th>
				      <th scope="col" style="width: 80px;">Ảnh</th>
				      <th scope="col">Thông tin xe</th>
				      <th scope="col">Trạng thái</th>
				      <th scope="col" style="width: 108px;">Thao tác</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:if test="${listBike==null}">
					  	<div class="text-center">
					  		<p>Không có xe phù hợp với tìm kiếm</p>
					  	</div>
				  	</c:if>
					  <c:forEach var="item" items="${listBike}" varStatus="loop">
					    <tr>
					      <th scope="row" style="vertical-align: middle !important;">${((currentPage - 1) * 15) + loop.index + 1}</th>
					      <td> <img src="${item.getPhoto()!=null?item.getPhoto():'./assets/img/logo2.png'}" class="rounded d-block" style="width: 80px;object-fit: contain"></td>
					      <td>
					      	<strong>${item.bikeName}</strong> - Biển số: ${item.getLicensePlate()}<br/>
		                    Giá thuê: ${item.getPrice()} VND
					      </td>
					      <td>
					      
					      <c:choose>
							  <c:when test="${item.status == -1}">
							    <p class="btn btn-warning" style="color: #fff">Đang chờ duyệt</p>
							  </c:when>
							  
							  <c:when test="${item.status == 1}">
							    <p class="btn btn-secondary">Sẵn sàng</p>
							  </c:when>
							  <c:when test="${item.status==-2}">
							    <p class="btn btn-danger">Bị từ chối</p>
							  </c:when>
							  <c:otherwise>
							    <p class="btn btn-success"> Đang hoạt động</p>
							  </c:otherwise>
							</c:choose>
					     </td>
					      <td>
						      <form action="OwnerManagerment" method="post">
						      	<input hidden name="id" value="${item.bikeId }">
						      	<input hidden  >
						      	<input hidden name="p" value="adminBike">
						      	<button ${item.status==-2||item.status==0?'hidden':'' } type="submit" class="btn btn-danger" name="actStatus"  value="deny"><i class="fa-solid fa-ban"></i></button>
					      		<button ${item.status!=-1?'hidden':'' } type="submit" class="btn btn-success" name="actStatus"  value="acp"><i class="fa-solid fa-check"></i></i></button>
					      		<a href="BikeDetail?id=${item.bikeId}&act=view" type="button" class="btn btn-info mt-1"><i style="color: #fff" class="fa-solid fa-eye"></i></a>
						      </form>
					      </td>
					    </tr>				  
					  </c:forEach>
				  </tbody>
				</table>
				<div class="text-center mt-3">
				  <nav aria-label="Page navigation">
				    <ul class="pagination" style="justify-content: center;">
				      <c:if test="${currentPage > 1}">
				        <li class="page-item">
				          <a class="page-link" href="OwnerManagerment?p=adminBike&pn=${currentPage - 1}&searchBikeName=${searchBikeName}&searchBikeLine=${searchBikeLine}&searchManufactor=${searchManufactor}" aria-label="Previous">
				            <span aria-hidden="true">&laquo;</span>
				          </a>
				        </li>
				      </c:if>
				
				      <c:forEach var="index" begin="1" end="${pagecount}">
				        <li class="page-item ${index == currentPage ? 'active' : ''}">
				          <a class="page-link" href="OwnerManagerment?p=adminBike&pn=${index}&searchBikeName=${searchBikeName}&searchBikeLine=${searchBikeLine}&searchManufactor=${searchManufactor}">
				            ${index}
				          </a>
				        </li>
				      </c:forEach>	
				      <c:if test="${currentPage < pagecount}">
				        <li class="page-item">
				          <a class="page-link" href="OwnerManagerment?p=adminBike&pn=${currentPage + 1}&searchBikeName=${searchBikeName}&searchBikeLine=${searchBikeLine}&searchManufactor=${searchManufactor}" aria-label="Next">
				            <span aria-hidden="true">&raquo;</span>
				          </a>
				        </li>
				      </c:if>
				    </ul>
				  </nav>
				</div>
			</div> 
        </div>	
    </div>
</div>
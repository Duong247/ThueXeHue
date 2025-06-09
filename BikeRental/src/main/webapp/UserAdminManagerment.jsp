<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container" style="min-height: 614px;">
    <div class="row align-items-start g-4">
        <div class="col-12" >
            <div class="head-col text-left d-flex justify-content-between" style="margin-bottom: 0">
                <h3>Quản lí người dùng</h3>
            </div>
            <hr style="border-color: #000;">
            <div class="text-right">
            	<form action="OwnerManagerment" method="post" class="text-right">
            		<input hidden name="p" value="user" >
            		<input type="text" name="searchInput" class="col-5 search-price" min="0" placeholder="" value="${searchVal}">
        			<button type="submit" style="padding: 10px; width: 50px; font-size: 18px;" class="bike-search"  ><i class="fa-solid fa-magnifying-glass"></i></button>
            	</form>
            </div>
            <div class="cover" >
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col" style="width: 80px;">#</th>
				      <th scope="col" style="width: 80px;">Ảnh</th>
				      <th scope="col">Thông tin người dùng</th>
				      <th scope="col">Vai trò</th>
				      <th scope="col" style="width: 80px;">Thao tác</th>
				    </tr>
				  </thead>
				  <tbody>
					  <c:forEach var="item" items="${listUser}" varStatus="loop">
					    <tr>
					      <th scope="row" style="vertical-align: middle !important;">${((currentPage - 1) * 15) + loop.index + 1}</th>
					      <td> <img src="${item.getPhoto()!=null?item.getPhoto():'./assets/img/avaUsers/noava.jpg'}" class="rounded d-block" style="width: 80px;object-fit: contain"></td>
					      <td>
					      	<strong>${item.getUserName()}</strong> <br/>
		                    Ngày sinh: ${item.getDateOfBirth()}<br/>
		                    Số điện thoại: ${item.getPhone()}
					      </td>
					      <td>
					      	<c:choose>
					      		<c:when test="${item.getRole()==1 }">
					      			<p class="btn btn-secondary">Khách hàng</p>
					      		</c:when>
					      		<c:when test="${item.getRole()==2 }">
					      			<p class="btn btn-light">Chủ xe</p>
					      		</c:when>
					      		<c:when test="${item.getRole()==0 }">
					      			<p class="btn btn-btn-outline-secondary">Admin</p>
					      		</c:when>
					      		<c:otherwise>
					      			<p class="btn btn-danger"> Bị khóa</p>
					      		</c:otherwise>
					      	</c:choose>
					      </td>
					      <td><button type="submit" class="btn btn-danger" name="actStatus"  value="deny"><i class="fa-solid fa-ban"></i></button></td>
					    </tr>				  
					  </c:forEach>
				    
				  </tbody>
				</table>
				<div class="text-center mt-3">
  <nav aria-label="Page navigation example">
    <ul class="pagination" style="justify-content: center;">
      <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
        <a class="page-link"
           href="OwnerManagerment?p=user&pn=${currentPage - 1}&searchInput=${searchVal}"
           aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>

      <c:forEach var="index" begin="1" end="${pagecount}">
        <li class="page-item ${index == currentPage ? 'active' : ''}">
          <a class="page-link"
             href="OwnerManagerment?p=user&pn=${index}&searchInput=${searchVal}">
            ${index}
          </a>
        </li>
      </c:forEach>

      <li class="page-item ${currentPage == pagecount ? 'disabled' : ''}">
        <a class="page-link"
           href="OwnerManagerment?p=user&pn=${currentPage + 1}&searchInput=${searchVal}"
           aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
</div>

			</div>

            
        </div>	
    </div>
</div>	

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="_Header.jsp"%>
<%int pagecount =  1;
if(request.getAttribute("pagecount")!=null){
	pagecount = (Integer) request.getAttribute("pagecount");
}
pagecount=(Integer)request.getAttribute("pagecount");%>
<div class="container bike-detail-container" style="margin-top: 95px">
	<div class="container " >
        <form class="search-bike" action="" method="">
          <div class="row align-items-start g-2">
            <div class="district col-md-2 col-3">
              <select class="form-select" aria-label="Default select example">
                <option selected>Chọn khu vực</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
              </select>
            </div>
            <div class="district col-md-2 col-3">
              <select class="form-select" aria-label="Default select example">
                <option selected>Chọn loại xe</option>
                <c:forEach var="item" items="${listBrands}">
	                <option value="${item}">${item}</option>
                </c:forEach>
              </select>
            </div>
            <input type="number" name="" id="" class="col-md-1 col-2 search-price" min="0" placeholder="Giá">
            <button type="submit" name="" style="padding: 10px; width: 50px; font-size: 18px;" class="bike-search"  ><i class="fa-solid fa-magnifying-glass"></i></button>
          </div>
        </form>
      </div>
        <div class="container text-center" style="min-height: 700px">
          <div class="row align-items-start g-2">
            <c:forEach var="item" items="${allBikes}" >
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
	                    <p style="line-height: 14px; color: #ba2b2b;font-weight: 600; font-size: 18px;"><i class="fa-solid fa-money-bill"></i> ${item.price} vnd/ngày</p>
	                    <a href="BikeDetail?id=${item.bikeId}" class="btn btn-primary" style="width: 100%;">Chi tiết</a>
	                  </div>
	                </div>
	            </div>
          	</c:forEach>
          </div>
        </div>
        <div class="text-center mt-3">
          <nav aria-label="Page navigation example">
			  <ul class="pagination" style="justify-content: center;">
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <c:forEach var="index" begin="1" end="<%=pagecount%>">
			    	<li class="page-item ${index==currentPage?"active":"" }"><a class="page-link" href="BikeControler?p=${index}">${index}</a></li>
			    </c:forEach>
			      <a class="page-link" href="BikeControler?p=${p+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
	        </nav>
        </div>
    </div>
</div>
	

<%@include file="_Footer.jsp"%>
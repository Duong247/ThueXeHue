<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<c:if test="${not empty sessionScope.uploadedImgs}">
    <h3>Danh sách ảnh đã chọn:</h3>
    <c:forEach var="img" items="${sessionScope.uploadedImgs}" varStatus="status">
        <div style="display: inline-block; position: relative; margin: 5px;">
            <img src="${pageContext.request.contextPath}/${img}" width="150" style="display:block;" />
            <form class="remove-image-form" action="RemoveImageController" method="post" style="position: absolute; top: 0; right: 0; margin: 0;">
                <input type="hidden" name="index" value="${status.index}" />
                <button type="submit" style="background: #ccc; color: white; border: none; border-radius: 50%; width: 20px; height: 20px; cursor: pointer;">x</button>
            </form>
        </div>
    </c:forEach>
</c:if>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container" style="min-height: 614px;">
    <div class="row align-items-start g-4">
        <div class="col-12" >
            <div class="head-col text-left d-flex justify-content-between" style="margin-bottom: 0">
                <h3>Quản lí ảnh website</h3>
            </div>
            <hr style="border-color: #000;">
        </div>	
    </div>
    <div class="card order-card" >
		<div class="card-head">
			<h5 class="order-num"><b></b></h5>
			<form id="uploadSliderForm" action="UploadSliderImg" method="post" enctype="multipart/form-data">
				<label for="imgFile" style="display: inline-block;
									        padding: 10px 20px;
									        cursor: pointer;
									        background-color: #3454cf;
									        color: white;
									        border-radius: 5px;">
	      			<i class="fa-solid fa-upload"></i> Thêm ảnh
	    		</label>
	    		<input type="file" id="imgFile" name="imgFile" id="imgFile" accept="image/*" style="display: none;">
        		<input hidden name="act" value="add">
        	</form>
		</div>
		<div class="d-flex" style="overflow-x: scroll; white-space: nowrap; ">
			<c:forEach var="photoItem" items="${listPhoto}" >
				<div class="card-body-order" style="position: relative; display: inline-block;">
					<a  style="position: absolute;top:6px;right:10px;padding: 3px 8px;background-color: #ccc; border-radius: 15px;opacity: 0.5;cursor: pointer; " onclick="return deleteConfirm() ">
						<i class="fa-solid fa-x"></i>
					</a>
					<img src="${photoItem.photo}" class="img-thumbnail" style="min-width: 300px;max-width: 400px">
				</div>			
			</c:forEach>
		</div>
	</div>
</div>

<script>
    const fileInput = document.getElementById('imgFile');
    const form = document.getElementById('uploadSliderForm');

    fileInput.addEventListener('change', function () {
      if (fileInput.files.length > 0) {
        form.submit();
      }
    });
    
    function deleteConfirm(){
    	return confirm("Bạn có chắc chắn muốn xóa ảnh này?")
    }
  </script>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>HueBikeRent</title>
</head>
<body>
<%@include file="_HeaderOnly.jsp"%>
<div style="margin-top: 85px">
	<div id="sidebar" class="bg-dark text-white p-3 transition-width" >
	  <button id="toggle-btn" class="btn btn-sm btn-light mb-2">☰</button>
	  <div class="sidebar-content">
	  	content
	  </div>
	</div>
	
	<div id="main-content" class="bg-light p-4 content-scale" >
	  <h1>Nội dung chính</h1>
	  <p>Đây là phần content chiếm phần còn lại.</p>
	</div>

</div>

<%@include file="_FooterOnly.jsp"%>

<script>
  document.getElementById('toggle-btn').addEventListener('click', () => {
    document.getElementById('sidebar').classList.toggle('collapsed');
    document.getElementById('main-content').classList.toggle('content-scale');
  });
</script>


</body>
</html>



<%@page import="MessageModal.MessageBO"%>
<%@page import="UserModal.UserBO"%>
<%@page import="UserModal.User"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String currentUser = (String) session.getAttribute("username");
	User currentUserInf = (User) session.getAttribute("currentUserInf");
    if(currentUserInf==null){
    	response.sendRedirect("Login");
    }
	String currentPhone = currentUserInf.getPhone();
    String toUser = request.getParameter("to");
    UserBO ubo = new UserBO();
    MessageBO mbo = new MessageBO();
    ArrayList<User> chatUsers = mbo.getChatUsers(currentPhone);
    request.setAttribute("chatUsers", chatUsers);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/styles/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
    <link rel="icon" href="./assets/img/icon2.png" type="image/x-icon">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/3ecdd9878f.js" crossorigin="anonymous"></script>
    <title>HueBikeRent</title>
    <!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- autoNumeric -->
	<script src="https://cdn.jsdelivr.net/npm/autonumeric@4.6.0/dist/autoNumeric.min.js"></script>
  <script>
    const currentUser = "<%= currentPhone %>";
    const toUser = "<%= toUser %>";

    function sendMessage() {
      const msg = document.getElementById("message").value;
      fetch("private-chat", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: "from=" + encodeURIComponent(currentUser) +
              "&to=" + encodeURIComponent(toUser) +
              "&message=" + encodeURIComponent(msg)
      }).then(() => {
        document.getElementById("message").value = "";
      });
    }

    setInterval(() => {
      fetch("private-chat?user=" + encodeURIComponent(currentUser) + "&with=" + encodeURIComponent(toUser))
        .then(res => res.text())
        .then(data => {
          document.getElementById("chatBox").innerHTML = data;
        });
    }, 1500);
  </script>
</head>
<body>
	<%@include file="_HeaderOnly.jsp"%>
	<div class="container" style="margin-top: 92px">
		<div class="row">
			<div class="col-4">
				<input type="text" id="searchInput" placeholder="Nhập số điện thoại hoặc tên" class="form-control mt-1 mb-2" onkeyup="searchUser()" />
				<div id="searchResult" style="border: 1px solid #ccc;height:69vh;overflow-y:scroll;">
					<ul class="list-unstyled">
				        <c:forEach var="user" items="${chatUsers}">
				            <li class="mb-3" style="padding: 15px">
				                <a href="private_chat.jsp?to=${user.phone }" class="text-decoration-none text-dark">
				                    <div class="d-flex align-items-center">
				                        <img src="${user.photo != null ? user.photo : './assets/img/icon2.png'}"
				                             class="rounded-circle me-3"
				                             style="width:50px; height:50px; object-fit: cover;" />
				                        <strong>${user.userName}</strong>
				                    </div>
				                </a>
				            </li>
				        </c:forEach>
				    </ul>
				</div>
			</div>
			<div class="col-8">
			  <h2>Chat với <%= ubo.getName(toUser)%></h2>
			  <div id="chatBox" class="border p-2 mb-2" style="border:1px solid #ccc; height:69vh; overflow-y:scroll;"></div>
			  <div class="mt-1 d-flex w-100">
				  <input type="text" id="message" placeholder="Nhập tin nhắn..." class="form-control me-2" />
				  <button onclick="sendMessage()" class="btn btn-primary">
				    <i class="fa-solid fa-paper-plane"></i>
				  </button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$('#searchInput').on('keyup', function() {
	  $.get('searchUserAjax', { keyword: $(this).val() }, function(data) {
	    $('#searchResult').html(data);
	  });
	});
</script>
</html>
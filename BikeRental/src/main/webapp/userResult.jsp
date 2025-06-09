<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="UserModal.User"%>
<%@ page import="java.util.List" %>

<%
  List<User> results = (List<User>) request.getAttribute("results");
%>

<ul class="list-unstyled">
<%
  if (results != null && !results.isEmpty()) {
    for (User user : results) {
%>
  <li class="mb-3">
  <a href="private_chat.jsp?to=<%= user.getPhone() %>" style="text-decoration: none;color: #000">
    <div class="d-flex align-items-center">
      <img src="<%= user.getPhoto()!=null?user.getPhoto():"./assets/img/icon2.png" %>" alt=""
           class="rounded-circle me-3"
           style="width:50px; height:50px; object-fit: cover;">
      <strong><%= user.getUserName() %> (<%= user.getPhone() %>)</strong>
    </div>  
  </a>
  </li>
<%
    }
  } else {
%>
  <li>Không tìm thấy người dùng nào.</li>
<%
  }
%>
</ul>

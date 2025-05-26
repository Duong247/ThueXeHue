<%@page import="UserModal.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    String currentUser = (String) session.getAttribute("username");
	User currentUserInf = (User) session.getAttribute("currentUserInf");
	String currentPhone = currentUserInf.getPhone();
    String toUser = request.getParameter("to");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Chat riêng với <%= toUser %></title>
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
  <h2>Chat riêng với <%= toUser %></h2>
  <div id="chatBox" style="border:1px solid #ccc; height:200px; overflow-y:scroll;"></div>
  <input type="text" id="message" placeholder="Nhập tin nhắn..." />
  <button onclick="sendMessage()">Gửi</button>
</body>
</html>
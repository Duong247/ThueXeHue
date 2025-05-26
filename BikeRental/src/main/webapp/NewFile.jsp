<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Chat Giả lập Realtime</title>
  <script src="chat.js"></script>
</head>
<body>
  <h2>Chat Box</h2>
  <div id="chatBox" style="border: 1px solid #ccc; height: 200px; overflow-y: scroll;"></div>
  <input type="text" id="message" placeholder="Nhập tin nhắn..." />
  <button onclick="sendMessage()">Gửi</button>
</body>
</html>
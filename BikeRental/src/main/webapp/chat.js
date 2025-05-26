function sendMessage() {
  const msg = document.getElementById("message").value;
  fetch("chat", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: "message=" + encodeURIComponent(msg)
  }).then(() => {
    document.getElementById("message").value = "";
  });
}

// Polling mỗi 1 giây để lấy tin nhắn mới
setInterval(() => {
  fetch("chat")
    .then(response => response.text())
    .then(data => {
      document.getElementById("chatBox").innerHTML = data;
    });
}, 1000);

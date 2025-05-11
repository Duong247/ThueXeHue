<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="_Header.jsp" %>

<div class="login-form-cover form-login-container container" style="margin-top: 120px">
  <div class="row align-items-start g-4">
    <div class="col-md-6 col-12 side-cover left-side-login">
      <div class="logo-login-form">
        <img src="./assets/img/icon2.png" alt="" class="logo-login">
        <h4 class="logo-name">HueBikeRent</h4>
      </div>
      <div class="head-text-cover">
        <h1 class="text-center welcome-text">Welcome!</h1>
        <p class="text-center">Thuê xe dễ dàng, trải nghiệm Huế trọn vẹn!</p>
      </div>
    </div>
    <div class="col-md-6 col-12 side-cover">
      <div class="">
        <h4 style="margin-bottom: 30px; text-align: center; font-weight:600 ">Đăng nhập</h4>
        <div style="height: 60px;">
          <div class="alert alert-danger" hidden  role="alert">
            <i class="fa-solid fa-circle-exclamation" style="margin-right: 5px"></i>Thông tin đăng nhập không đúng
          </div>
        </div>
        <form>
          <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">Email</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
              <input type="password" class="form-control" id="exampleInputPassword1">
          </div>
          <a href="./Register.html" style="display: block;margin: 10px;">Đăng ký?</a>
          <button type="submit" class="btn btn-primary" style="width: 100%;">Đăng nhập</button>
        </form>
      </div>
    </div>

  </div>
</div>


<script>
  function handleLogin(event) {
    event.preventDefault();
    const email = document.getElementById("emailInput").value;
    const password = document.getElementById("passwordInput").value;

    if (email === "admin@example.com" && password === "123456") {
      alert("Đăng nhập thành công!");
      // window.location.href = "./dashboard.html";
    } else {
      document.querySelector(".alert-danger").removeAttribute("hidden");
    }
  }
</script>

</body>
</html>

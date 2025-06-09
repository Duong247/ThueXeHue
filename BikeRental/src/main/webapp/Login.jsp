<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="_Header.jsp" %>

<div class="login-form-cover form-login-container container" style="margin-top: 120px; height: 500px">
  <div class="row align-items-start g-4">
    <div class="col-md-6 col-12 side-cover left-side-login">
      <div class="logo-login-form">
        <img src="./assets/img/icon2.png" alt="" class="logo-login">
        <h4 class="logo-name">HueBikeRent</h4>
      </div>
      <div class="head-text-cover">
        <h1 class="text-center welcome-text" style="color: #fff">Welcome!</h1>
        <p class="text-center" style="color: #fff">Thuê xe dễ dàng, trải nghiệm Huế trọn vẹn!</p>
      </div>
    </div>
    <div class="col-md-6 col-12 side-cover" style="padding: 30px 70px;">
      <div class="">
        <h4 style="margin-bottom: 30px; text-align: center;">Đăng nhập</h4>
        <div style="height: 60px;">
          <div class="alert alert-danger" ${ErrStr==null||ErrStr==''?'hidden':'' }  role="alert">
            <i class="fa-solid fa-circle-exclamation" style="margin-right: 5px"></i>${ErrStr!=null?ErrStr:''}
          </div>
        </div>
        <form action="Login" method="post">
          <div class="mb-3">
              <label for="phone" class="form-label">Số điện thoại</label>
              <input type="phone" name="phone" class="form-control" id="phone" aria-describedby="emailHelp" value="${phone }" autofocus="autofocus">
              <span style="color:red;">${rppwErr}</span>
          </div>
          <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
              <input type="password" name="pass" class="form-control" value="${pass }" id="exampleInputPassword1">
          </div>
          <div style="height: 5px"></div>
          <button type="submit" name="act" value=submit" class="btn btn-primary" style="width: 100%; background-color: #3454cf;">Đăng nhập</button>
          <p><span>Chưa có tài khoản?</span> <a href="Register" style="display: block;margin: 10px; text-decoration: none; color: #3454cf; display: inline;"> Đăng ký?</a></p>
          
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

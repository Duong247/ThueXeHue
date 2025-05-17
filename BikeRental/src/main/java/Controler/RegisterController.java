package Controler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String fullname = request.getParameter("fullname");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String address = request.getParameter("address");
			String password = request.getParameter("password");
			String repaeatPassword = request.getParameter("repeatPassword");
			LocalDate date = null;
			date = LocalDate.parse(birthday,formatter);
			String phoneRegrex="^0\\\\d{9}$";
			String nameRegrex = "^[\\\\p{L} ]{2,50}$";
			String errMess="";
			boolean hasErr=false;
			
			if (password!=null && repaeatPassword!=null && !repaeatPassword.equals(password) ) {
				errMess="Mật khẩu không trùng khớp";
				request.setAttribute("pwErr", errMess);
				request.setAttribute("rppwErr", errMess);
				hasErr = true;
			}
			
			if(password==null) {
				errMess="Vui lòng nhập mật khẩu";
				request.setAttribute("pwErr", errMess);
				hasErr = true;
			}
			
			if(repaeatPassword==null) {
				errMess="Vui lòng nhập mật khẩu lặp lại";
				request.setAttribute("rppwErr", errMess);
				hasErr=true;
			}
			
			if(birthday==null) {
				errMess="Vui lòng nhập ngày sinh";
				request.setAttribute("bdErr", errMess);
				hasErr=true;
			}else {
				if(date == null) {
					errMess="Ngày nhập không hơp lệ!";
					request.setAttribute("bdErr", errMess);
				}				
			}
			
			if(phone == null) {
				errMess="Vui lòng nhập số điện thoại";
				request.setAttribute("phoneErr", errMess);
				hasErr = true;
			}else {
				if(!phone.matches(phoneRegrex)) {
					errMess="Số điện thoại không hơp lệ!";
					request.setAttribute("phoneErr", errMess);
					hasErr = true;
				}
			}
			
			if(address== null) {
				errMess="Vui lòng nhập địa chỉ";
				request.setAttribute("addressErr", errMess);
				hasErr = true;
			}
			
			if(fullname!=null) {
				if (!fullname.matches(nameRegrex)) {
					errMess="Tên không hơp lệ!";
					request.setAttribute("nameErr", errMess);
					hasErr = true;
				}
			}else {
				errMess="Vui lòng điền tên của bạn!";
				request.setAttribute("nameErr", errMess);
				hasErr = true;
			}
			
			if(!hasErr) {
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		RequestDispatcher rq = request.getRequestDispatcher("Register.jsp");
	    rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

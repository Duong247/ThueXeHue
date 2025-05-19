package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import UserModal.UserBO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	try {
    		UserBO uBO = new UserBO();
    		String phone = request.getParameter("phone");
    		String pass=request.getParameter("pass");
    		String ErrStr="";
			if (phone!= null && request.getParameter("act")!=null) {
				if(!uBO.checkPhoneExists(phone)) {
					ErrStr = "Số điện thoại chưa được đăng ký!";					
				}else {
					if(!uBO.checkLoginInf(phone, pass)) {
						ErrStr="Sai mật khẩu!";
					}else {	
						session.setAttribute("currentUserInf", uBO.getUserLoginInfo(phone,pass));
						response.sendRedirect("Home");
						return;
					}
				}
			}
			
			if(request.getParameter("act")!=null && (pass==null || pass==""||phone==null || phone=="")) {
				ErrStr="Vui lòng điền đủ thông tin";
			}
			
			request.setAttribute("ErrStr", ErrStr);
			request.setAttribute("phone",phone );
			request.setAttribute("pass", pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rq = request.getRequestDispatcher("Login.jsp");
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

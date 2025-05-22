package Controler;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import UserModal.User;
import UserModal.UserBO;

/**
 * Servlet implementation class ChangeInfoController
 */
@WebServlet("/ChangeInfoController")
public class ChangeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserBO uBO = new UserBO();
			HttpSession session = request.getSession();
			User currentUser = (User) session.getAttribute("currentUserInf");
			
			if(currentUser==null) {
	    		response.sendRedirect("Login");
	    		return;
	    	}
			int userId = currentUser.getUserId();
			request.setAttribute("user", uBO.getUserById(userId));
			//TODO set current Id
//			request.setAttribute("user", uBO.getUserById(5));
			
			String act = request.getParameter("act");
			if(act!=null  && act.contentEquals("changePass")) {
				String oldpass = request.getParameter("oldPassword");
				String newpassword = request.getParameter("newpassword");
				String repeatPassword = request.getParameter("repeatPassword");
				String errStr = null;

				if(!newpassword.equals(repeatPassword)) {
					errStr="Xác nhận mật khẩu không trùng khớp!";
				}
//				TODO set current Id
				if(!uBO.checkOldPass(5, oldpass)) {
					errStr="Mật khẩu cũ không chính xác!";
				}
				
				if(oldpass==null||newpassword==null||repeatPassword==null||oldpass.equals("")||newpassword.equals("")||repeatPassword.equals("")) {
					errStr = "Vui lòng điền đầy đủ thông tin!";
				}
				
				if(errStr==null) {
//					TODO set current ID
					uBO.updatePassword(5, newpassword);
				}else {
					request.setAttribute("errStr", errStr);
					request.setAttribute("oldPass", oldpass);
					request.setAttribute("newPass", newpassword);
					request.setAttribute("repeatPass", repeatPassword);
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		RequestDispatcher rq = request.getRequestDispatcher("ChangeInfo.jsp");
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

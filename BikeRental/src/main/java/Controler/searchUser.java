package Controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserModal.User;
import UserModal.UserBO;

/**
 * Servlet implementation class searchUser
 */
@WebServlet("/searchUserAjax")
public class searchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
			try {
				ArrayList<User> userList= new ArrayList<User>();
				UserBO ubo = new UserBO();
				String keyword = request.getParameter("keyword").toLowerCase();
				userList = ubo.getAllUser();
				ArrayList<User> result = new ArrayList<>();
				for (User u : userList) {
					if (u.getUserName().toLowerCase().contains(keyword) || u.getPhone().contains(keyword)) {
						result.add(u);
					}
				}
				request.setAttribute("results", result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


    	    request.getRequestDispatcher("userResult.jsp").forward(request, response);
    	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

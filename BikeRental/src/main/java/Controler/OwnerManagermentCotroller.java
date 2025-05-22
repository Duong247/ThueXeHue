package Controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BikeModal.Bike;
import BikeModal.BikeBo;
import UserModal.User;

/**
 * Servlet implementation class OwnerManagermentCotroller
 */
@WebServlet("/OwnerManagerment")
public class OwnerManagermentCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerManagermentCotroller() {
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
    	User currentUser = (User) session.getAttribute("currentUserInf");
    	BikeBo bBO = new BikeBo();
    	
    	try {
    		String p= request.getParameter("p");
    		request.setAttribute("p", p);
    		if(p!=null) {
    			if(p.equals("bike")) {
    				ArrayList<Bike> OwnerBikes = bBO.getOwnerBike(currentUser.getUserId());
    				request.setAttribute("OwnerBikes", OwnerBikes);
    				request.setAttribute("listManufactor", bBO.getBikeManufactor());
    			}
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	    RequestDispatcher rq = request.getRequestDispatcher("Dashboard.jsp");
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

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
import javax.websocket.Session;

import BikeModal.BikeBo;
import CartItemModal.CartItem;
import CartItemModal.CartItemBO;
import CartItemModal.CartItemDAO;
import OrderModal.Order;
import OrderModal.OrderBo;
import UserModal.User;

/**
 * Servlet implementation class OrderHistoryController
 */
@WebServlet("/OrderHistory")
public class OrderHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistoryController() {
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
		CartItemBO cBO = new CartItemBO();
		OrderBo OBO = new OrderBo();
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUserInf");
		if(currentUser==null) {
    		response.sendRedirect("Login");
    		return;
    	}

		
		ArrayList<Order> history;
		try {
			history = OBO.getOrderHistoryByUserId(currentUser.getUserId());
	    	CartItemBO cbo = new CartItemBO();
	    	BikeBo bBO = new BikeBo();
	    	request.setAttribute("bBO", bBO);
	    	request.setAttribute("cbo",cbo);
			request.setAttribute("orderHistory", history);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rq = request.getRequestDispatcher("orderHistory.jsp");
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

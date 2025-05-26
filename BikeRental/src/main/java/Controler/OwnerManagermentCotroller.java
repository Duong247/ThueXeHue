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
import OrderModal.Order;
import OrderModal.OrderBo;
import PlotModal.Plot;
import PlotModal.PlotBO;
import PlotModal.PlotDAO;
import SliderModal.SliderBO;
import UserModal.User;
import UserModal.UserBO;

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
    	if (currentUser==null) {
    		response.sendRedirect("Login");
    		return;
    	}
    	String name = currentUser.getUserName();
    	String[] parts = name.trim().split("\\s+"); 
    	String lastName = parts[parts.length - 1];
    	request.setAttribute("lastName", lastName);
    	BikeBo bBO = new BikeBo();
    	OrderBo oBO = new OrderBo();
    	UserBO uBO = new UserBO();
    	SliderBO sBO = new SliderBO();
    	String act = (String) request.getAttribute("act");
    	request.setAttribute("act", act);
    	Bike bikeInf = (Bike) request.getAttribute("bikeInf");
    	try {
    		PlotDAO pdao = new PlotDAO();
    		request.setAttribute("bikeCount", bBO.getCountBikeOfUser(currentUser.getUserId()));
    		ArrayList<Plot> revenues = pdao.getRevenueLast7DaysFull();
    		request.setAttribute("revenues", revenues);	
    		String p= request.getParameter("p");
    		request.setAttribute("p", p);
    		String action = request.getParameter("action");
    		
    		String actStatus = request.getParameter("actStatus");
    		
    		if(actStatus!=null && actStatus.equals("deny")) {
    			String id= (String) request.getParameter("id");
    			bBO.updateDenyBikestatus(Integer.parseInt(id));
    		}
    		
    		if(p!=null) {
    			if (p.equals("adminBike")) {
    			    String pn = request.getParameter("pn");
    			    int pageNum = 1;
    			    if (pn != null) {
    			        pageNum = Integer.parseInt(pn);
    			    }

    			    String searchBikeLine = request.getParameter("searchBikeLine");
    			    String searchManufactor = request.getParameter("searchManufactor");
    			    String searchBikeName = request.getParameter("searchBikeName");
    			    String searchStatus = request.getParameter("searchStatus");

    			    if (searchBikeLine == null) searchBikeLine = "";
    			    if (searchManufactor == null) searchManufactor = "";
    			    if (searchBikeName == null) searchBikeName = "";
    			    int statusValue=-99;
    			    if (searchStatus != null || searchStatus=="") {
    			    	try {
    			    		statusValue=Integer.parseInt(searchStatus);
							
						} catch (Exception e) {
							statusValue=-99;
						}
    			    }

    			    int pageSize = 15;
    			    
    			   
    			    
    			    ArrayList<Bike> listBike = bBO.searchBikeWithPagination(searchBikeLine, searchManufactor, searchBikeName,statusValue, pageNum, pageSize);
    			    int pageCount = bBO.getBikePageCount(searchBikeLine, searchManufactor, searchBikeName,statusValue, pageSize);

    			    request.setAttribute("listBike", listBike);
    			    request.setAttribute("currentPage", pageNum);
    			    request.setAttribute("pagecount", pageCount);

    			    // Truyền lại giá trị search để giữ lại trên giao diện
    			    request.setAttribute("searchBikeLine", searchBikeLine);
    			    request.setAttribute("searchManufactor", searchManufactor);
    			    request.setAttribute("searchBikeName", searchBikeName);
    			    request.setAttribute("searchStatus", searchStatus);

    			    request.setAttribute("listManufactor", bBO.getBikeManufactor());
    			    request.setAttribute("listBikeLine", bBO.getBikeLine());
    			    request.setAttribute("p", "adminBike");
    			   
    			    ArrayList<Bike> OwnerBikes = bBO.getOwnerBike(currentUser.getUserId());
    				request.setAttribute("OwnerBikes", OwnerBikes);
    				request.setAttribute("listManufactor", bBO.getBikeManufactor());
    				request.setAttribute("listBikeLine", bBO.getBikeLine());
    				request.setAttribute(p, OwnerBikes);
    				request.setAttribute("bikeInf", bikeInf);
    				request.setAttribute("listBikeLine", bBO.getBikeLine());
    				request.setAttribute("listBikeManufactor", bBO.getBikeManufactor());
    				request.setAttribute("listBikeStatus", bBO.getBikeStatusId());
    				request.setAttribute("bBo", bBO);
    			}
    			
    			if (p.equals("user")) {
    				String keyword = request.getParameter("searchInput");
        			if (keyword == null) keyword = "";

        			int pageNum = 1;
        			String pn = request.getParameter("pn");
        			if (pn != null) pageNum = Integer.parseInt(pn);

        			int pageSize = 15;
        			ArrayList<User> listUser = uBO.SearchUser(keyword, pageNum, pageSize);
        			int pageCount = uBO.getUserPageCountByKeyword(keyword, pageSize);

        			request.setAttribute("listUser", listUser);
        			request.setAttribute("pagecount", pageCount);
        			request.setAttribute("currentPage", pageNum);
        			request.setAttribute("searchVal", keyword);
        			request.setAttribute("p", "user");
        			
        			RequestDispatcher rq = request.getRequestDispatcher("Dashboard.jsp");
        		    rq.forward(request, response);
        		    return;
    			}
    			
    			if(p.equals("order")) {
    				ArrayList<Order> listOrder;
//    				TODO listOrder = oBO.getOrdersByOwnerId(currentUser.getUserId());
    				listOrder = oBO.getOrdersByOwnerId(4);
    				request.setAttribute("orderList", listOrder);
    			}
    			
    			if(p.equals("slider")) {
    				request.setAttribute("listPhoto", sBO.getListSliderPhoto() );
    			}
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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

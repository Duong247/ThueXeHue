package Controler;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BikeModal.Bike;
import BikeModal.BikeBo;
import CartItemModal.CartItem;
import CartItemModal.CartItemBO;

/**
 * Servlet implementation class OrderCotroler
 */
@WebServlet("/Order")
public class OrderCotroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCotroler() {
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
    	
    	boolean editmode = false;
    	request.setAttribute("editmode", editmode);
    	
    	BikeBo bikeBo = new BikeBo();
    	request.setAttribute("bikeBo", bikeBo);
    	CartItemBO cbo = new CartItemBO();
    	HttpSession session = request.getSession();
    	
    	String bikeToCartId = request.getParameter("bikeToCartId");
    	String currentUserId = request.getParameter("userId") ;
    	String act = request.getParameter("act");
    	ArrayList<CartItem> cartItemList = (ArrayList<CartItem>) session.getAttribute("itemCartList");
    	if (cartItemList == null) {
    	    cartItemList = new ArrayList<CartItem>();
    	}
    	
    	if(bikeToCartId!=null && cartItemList!=null && act.equals("update")) {
			Timestamp startDay = cbo.StringToTimestamp(request.getParameter("startDay"));
	    	Timestamp endDay = cbo.StringToTimestamp(request.getParameter("endDay"));
	    	for (CartItem item : cartItemList) {
	            if (item.getBikeId() == Integer.parseInt(bikeToCartId)) {
	                item.setPickupDate(startDay);
	                item.setReturnDate(endDay);
	                break;
	            }
	        }
	    	session.setAttribute("itemCartList", cartItemList);
	    	
    	}
    	
    	if(bikeToCartId!=null && cartItemList!=null && act.equals("delete")) {
    		cartItemList.removeIf(item -> item.getBikeId() == Integer.parseInt(bikeToCartId));
    	}
    	
    	if(act!= null && act.equals("clear")) {
    		session.removeAttribute("itemCartList");
    	}
    	
    	if(act!=null && act.equals("createOrder")&& currentUserId!=null && cartItemList!=null) {
    		String pickupPlace = request.getParameter("pickupPlace");
    		String returnPlace = request.getParameter("returnPlace");
    		try {
//	    		for (CartItem cartItem: cartItemList) {
//						cbo.createOrder(cartItem.getBikeId(), cartItem.getRentalFee(),cartItem.getPickupDate(),cartItem.getReturnDate(),  Integer.parseInt(currentUserId),pickupPlace , returnPlace);
//	    		}
    			cbo.createOrder2(Integer.parseInt(currentUserId), pickupPlace, returnPlace,cartItemList);
	    		session.removeAttribute("itemCartList");
    		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		// TODO Set bike status to busy
    	}
    	
    	
		try {
			if(bikeToCartId!=null && act.equals("add")) {
				Timestamp startDay = cbo.StringToTimestamp(request.getParameter("startDay"));
		    	Timestamp endDay = cbo.StringToTimestamp(request.getParameter("endDay"));
				ArrayList<String>BikePhoto= bikeBo.getPhotoByBikeId(Integer.parseInt(bikeToCartId));
				request.setAttribute("BikePhoto", BikePhoto);
				Bike bike = bikeBo.getBikeById(Integer.parseInt(bikeToCartId));
				ArrayList<String> bikePhotoInCart = bikeBo.getPhotoByBikeId(Integer.parseInt(bikeToCartId));
				String photo = bikePhotoInCart.isEmpty() ? "default.jpg" : bikePhotoInCart.get(0);
				CartItem cartItem = new CartItem(bike.getBikeId(),bike.getBikeName(),bike.getLicensePlate(),bike.getManufacturingYear(),bike.getBikeLine(),bike.getBikeManufactor(),photo,bike.getDescription(),bike.getPrice(),startDay,endDay);
				if(!cbo.checkExists(cartItemList, cartItem)) {
					cartItemList.add(cartItem);
					session.setAttribute("itemCartList", cartItemList);	
					System.out.println(cartItemList.size());
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	RequestDispatcher rq = request.getRequestDispatcher("Cart.jsp");
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

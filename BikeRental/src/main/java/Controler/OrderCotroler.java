package Controler;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");

    	String bikeToCard = request.getParameter("bikeToCartId");
    	if (bikeToCard != null) {
    	    String startDay = request.getParameter("startDay");
    	    String enday = request.getParameter("endDay");

    	    // In ra chuỗi nhận được từ request
    	    System.out.println("Start Day: " + startDay);

    	    // Kiểm tra lại định dạng
    	    LocalDateTime ldt = LocalDateTime.parse(startDay, formatter);

    	    // Chuyển đổi sang Timestamp
    	    Timestamp timestamp = Timestamp.valueOf(ldt);
    	    
    	    // In ra Timestamp
    	    System.out.println("Timestamp for startDay: " + timestamp);
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

package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import BikeModal.BikeBo;

/**
 * Servlet implementation class BikeControler
 */
@WebServlet("/BikeControler")
public class BikeControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BikeControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    try {
	    	request.setCharacterEncoding("UTF-8");
	    	response.setContentType("text/html; charset=UTF-8");
	    	response.setCharacterEncoding("UTF-8");
	    	BikeBo bikebo = new BikeBo();
	    	int pageNum =1;
	    	String p = request.getParameter("p");
	    	if (p!=null) {
	    		pageNum =  Integer.parseInt(p); 
	    	}
	    	
	    	request.setAttribute("listBrands", bikebo.getBrand());
	    	request.setAttribute("currentPage", pageNum);
			request.setAttribute("allBikes", bikebo.getBikesWithPagination(pageNum,12));
			request.setAttribute("pagecount", bikebo.pageCount(12));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    RequestDispatcher rq = request.getRequestDispatcher("SearchBikes.jsp");
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





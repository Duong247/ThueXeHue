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

import BikeModal.Bike;
import BikeModal.BikeBo;

/**
 * Servlet implementation class UpdateBikeController
 */
@WebServlet("/UpdateBikeController")
public class UpdateBikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBikeController() {
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
    	BikeBo bBO = new BikeBo();
    	HttpSession session = request.getSession();
    	request.setAttribute("act","update");
    	
    	try {
	    	if (request.getParameter("id")!=null) {
	    		int id = Integer.parseInt(request.getParameter("id"));
	    		ArrayList<String> uploadedImgs;
				uploadedImgs = bBO.getBikePhoto(id);
	    		session.setAttribute("uploadedImgs",uploadedImgs);
	    		Bike bike = bBO.getBikeById(id);
	    		request.setAttribute("bikeInf", bike);
//	    		request.setAttribute("bikeName", bike.getBikeName());
//	    		request.setAttribute("licensePlate", bike.getLicensePlate());
//	    		request.setAttribute("manufacturingYear", bike.getManufacturingYear());
//	    		request.setAttribute("bikeLine", bike.getBikeLine());
//	    		request.setAttribute("BikeManufactor", bike.getBikeManufactor());
//	    		request.setAttribute("description", bike.getDescription());
//	    		request.setAttribute("price", bike.getPrice());
	    		RequestDispatcher rq = request.getRequestDispatcher("OwnerManagerment?p=bike");
	    	    rq.forward(request, response);
	    	    return;
	    	}
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	
    	
    	RequestDispatcher rq = request.getRequestDispatcher("OwnerManagerment");
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

package Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BikeModal.BikeBo;
import UserModal.UserBO;

/**
 * Servlet implementation class BikeDetailControler
 */
@WebServlet("/BikeDetail")
public class BikeDetailControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BikeDetailControler() {
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
    	BikeBo bikebo = new BikeBo();
    	UserBO userBo = new UserBO();
    	String bikeId = request.getParameter("id");
    	String act = request.getParameter("act");
    	if (act!=null) {
    		request.setAttribute("act",act);    		
    	}
    	if(bikeId!= null) {
    		try {
    			request.setAttribute("ownerInfo", userBo.getUserInfoByBikeId(Integer.parseInt(bikeId)));
    			request.setAttribute("getSimilarBike", bikebo.getSimilarBikes(Integer.parseInt(bikeId)));
    			request.setAttribute("BikePhotos", bikebo.getPhotoByBikeId(Integer.parseInt(bikeId)));
				request.setAttribute("getBike", bikebo.getBikeById(Integer.parseInt(bikeId)));
				request.setAttribute("id", bikeId);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        RequestDispatcher rq = request.getRequestDispatcher("BikeDetails.jsp");
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

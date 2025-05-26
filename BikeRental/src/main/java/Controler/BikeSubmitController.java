package Controler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import BikeModal.Bike;
import BikeModal.BikeBo;
import UserModal.User;

/**
 * Servlet implementation class BikeSubmitController
 */
@WebServlet("/BikeSubmit")
public class BikeSubmitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BikeSubmitController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	User currentUser = (User) session.getAttribute("currentUserInf");
    	String licensePattern = "^[0-9]{2}[A-Z]{2}[0-9]{5}$";
		
		BikeBo bBO = new BikeBo();
		// Lấy danh sách ảnh đã upload từ session
		ArrayList<String> uploadedImages = (ArrayList<String>) session.getAttribute("uploadedImgs");

		// Lấy thông tin xe từ request
		String id = request.getParameter("id");
		String bikeName = request.getParameter("bikeName");
		String licensePlate = request.getParameter("licensePlate");
		String manufacturingYear = request.getParameter("manufacturingYear"); 
//		int manufacturingYear = Integer.parseInt(request.getParameter("manufacturingYear")); 
		String bikeLine = request.getParameter("bikeLine");
		String BikeManufactor = request.getParameter("BikeManufactor");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String act = request.getParameter("action");
		
		boolean hasErr = false;
		try {
			if (bikeName == null || bikeName.trim().isEmpty()) {
			    request.setAttribute("nameErr", "Tên xe không được để trống!");
			    hasErr = true;
			}
			if (licensePlate == null || !licensePlate.matches(licensePattern)) {
			    request.setAttribute("licensePlateErr", "Biển số xe không đúng định dạng! (VD: 75AF01100)");
			    hasErr = true;
			}
			if (manufacturingYear==null ||Integer.parseInt(manufacturingYear) < 1900 || Integer.parseInt(manufacturingYear)> java.time.Year.now().getValue()) {
		        request.setAttribute("yearErr", "Năm sản xuất không hợp lệ!");
		        hasErr = true;
			}
			if (manufacturingYear==null ) {
		        request.setAttribute("yearErr", "Năm sản xuất không được để trống!");
		        hasErr = true;
			}
			if (price == null||price.trim().isEmpty()) {
				request.setAttribute("priceErr", "Giá thuê không được để trống!");
			}else {
				if ( Long.parseLong( request.getParameter("price")) < 0) {
					request.setAttribute("priceErr", "Giá thuê phải là số dương!");
					hasErr = true;
				}				
			}
			if (bikeLine == null|| bikeLine.equals("Chọn dòng xe") ) {
				request.setAttribute("bikelineErr","Vui lòng chọn dòng xe.");
				hasErr = true;
			}
			if (BikeManufactor == null || BikeManufactor.equals("Chọn nhà sản xuất")) {
				request.setAttribute("manufactorErr","Vui lòng chọn dòng xe.");
				hasErr = true;
			}
			request.setAttribute("bikeId", id);
			request.setAttribute("bikeName", bikeName);
			request.setAttribute("licensePlate", licensePlate);
			request.setAttribute("manufacturingYear", manufacturingYear );
			request.setAttribute("price", price);
			request.setAttribute("bikeLine", bikeLine);
			request.setAttribute("BikeManufactor", BikeManufactor);
			request.setAttribute("description", description);
			request.setAttribute("listBikeLine", bBO.getBikeLine());
			request.setAttribute("listManufactor", bBO.getBikeManufactor());
			
			request.setAttribute("hasErr", hasErr);
			if(hasErr) {
				RequestDispatcher rq = request.getRequestDispatcher("OwnerManagerment?p=bike");
			    rq.forward(request, response);
			    return;
			}
			if(act!= null && act.equals("create")) {
				Bike bike = new Bike(1,bikeName, licensePlate, Integer.parseInt(manufacturingYear),bikeLine,BikeManufactor,"",description,Long.parseLong( request.getParameter("price")),0,null);
				bBO.addBikeWithPhotos(bike, currentUser.getUserId(), uploadedImages);				
			}else {
				Bike bike = new Bike(Integer.parseInt(id),bikeName, licensePlate, Integer.parseInt(manufacturingYear),bikeLine,BikeManufactor,"",description,Long.parseLong( request.getParameter("price")),0,null);
				bBO.updateBikeWithPhotos(bike, uploadedImages);
				session.removeAttribute("uploadedImgs");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		RequestDispatcher rq = request.getRequestDispatcher("OwnerManagerment?p=bike");
	    rq.forward(request, response);
	}
}

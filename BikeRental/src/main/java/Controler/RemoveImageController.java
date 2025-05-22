package Controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveImageController
 */
@WebServlet("/RemoveImageController")
public class RemoveImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveImageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        ArrayList<String> uploadedImgs = (ArrayList<String>) session.getAttribute("uploadedImgs");

        String indexStr = request.getParameter("index");
        if (uploadedImgs != null && indexStr != null) {
            try {
                int index = Integer.parseInt(indexStr);
                if (index >= 0 && index < uploadedImgs.size()) {
                	uploadedImgs.remove(index);
                }
                // Cập nhật lại session
                session.setAttribute("uploadedImgs", uploadedImgs);
            } catch (NumberFormatException e) {
                // xử lý lỗi nếu cần
            }
        }
        response.setContentType("text/plain");

        // Quay lại trang form sau khi xóa
//        response.sendRedirect("Dashboard.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

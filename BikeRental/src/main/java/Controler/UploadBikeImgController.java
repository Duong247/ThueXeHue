package Controler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadBikeImgController
 */
@WebServlet("/UploadBikeImgController")
@MultipartConfig
public class UploadBikeImgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadBikeImgController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<String> uploadedImgs = (ArrayList<String>) session.getAttribute("uploadedImgs");
		if (uploadedImgs == null) {
			uploadedImgs = new ArrayList<>();
		}

        for (Part part : request.getParts()) {
            if (part.getName().equals("imgFile") && part.getSize() > 0) {
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                String savePath = request.getServletContext().getRealPath("") + File.separator + "assets/img/motobikes";

                File uploadDir = new File(savePath);
                if (!uploadDir.exists()) uploadDir.mkdirs();

                part.write(savePath + File.separator + fileName);

                // Lưu đường dẫn tương đối vào session
                String relativePath = "assets/img/motobikes/" + fileName;
                uploadedImgs.add(relativePath);
                session.setAttribute("uploadedImgs",uploadedImgs);
            }
        }
        
        
        // Quay lại form
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

package Controler;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import PlotModal.PlotDAO;
import SliderModal.SliderBO;

/**
 * Servlet implementation class UploadSliderImg
 */
@WebServlet("/UploadSliderImg")
public class UploadSliderImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadSliderImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "assets/img/";
		List<FileItem> fileItems;
		try {
			fileItems = upload.parseRequest(request);
			String fileToUpload = null;
			String act =request.getParameter("act");
			if(fileItems != null && !fileItems.isEmpty()) {
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
						// xử lý file
						String nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							//Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "assets/img";
							File dir = new File(dirUrl);
							if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);//tạo file
							fileToUpload = "assets/img/"+nameimg;
							try {
								fileItem.write(file);//lưu file
				            	System.out.println("UPLOAD THÀNH CÔNG...!");
//				            	System.out.println("Đường dẫn lưu file là: "+dirUrl);
				            	System.out.println(fileToUpload);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}else {
						String param = fileItem.getFieldName();
						if (param.equals("act")) {
							act = fileItem.getString("UTF-8");
						}
					}
				}
				SliderBO sdao = new SliderBO();
				if(act!=null && act.equals("add")) {
					sdao.saveSliderImgs(fileToUpload);
					response.sendRedirect("OwnerManagerment?p=slider");
				}
				response.sendRedirect("OwnerManagerment?p=slider");
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

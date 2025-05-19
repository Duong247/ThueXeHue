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

import UserModal.UserBO;

/**
 * Servlet implementation class ChangeInfoSubmit
 */
@WebServlet("/ChangeInfoSubmit")
public class ChangeInfoSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInfoSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBO uBO = new UserBO();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "assets/img/avaUsers";
		List<FileItem> fileItems;
		try {
			fileItems = upload.parseRequest(request);
			int userId = 0;
			String fullname = null;
			String phone = null;
			String fileToUpload = null;
			String dateOfBirth = null;
			String address = null;
			String act = null;
			String displayPhoto = null;
			
			if(fileItems != null && !fileItems.isEmpty()) {
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
						// xử lý file
						String nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							//Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "assets/img/avaUsers";
							File dir = new File(dirUrl);
							if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);//tạo file
							fileToUpload = "assets/img/avaUsers/"+nameimg;
							try {
								fileItem.write(file);//lưu file
				            	System.out.println("UPLOAD THÀNH CÔNG...!");
//				            	System.out.println("Đường dẫn lưu file là: "+dirUrl);
				            	System.out.println(fileToUpload);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					else//Neu la control
					{
						String user = fileItem.getFieldName();

						if (user.equals("fullname")) {
							fullname = fileItem.getString("UTF-8");
						}
						if (user.equals("phone")) {
							phone = fileItem.getString("UTF-8");
						}
						if (user.equals("birthday") && user != null) {
						    dateOfBirth  = fileItem.getString("UTF-8");
						}

						if (user.equals("address")) {
							address = fileItem.getString("UTF-8");
						}
						if (user.equals("act")) {
							act = fileItem.getString("UTF-8");
						}
						
						if (user.equals("userid")) {
						    String idStr = fileItem.getString("UTF-8").trim();
						    if (!idStr.isEmpty()) {
						    	userId = Integer.parseInt(idStr);
						    }
						}
						
						if (user.equals("displayPhoto")) {
							displayPhoto = fileItem.getString("UTF-8");
						}
			
					}
				}
				if(act.equals("update")) {
					if (fileToUpload == null || fileToUpload.isEmpty()) {
						fileToUpload = displayPhoto;
					}
					LocalDate localDate = LocalDate.parse(dateOfBirth); // format: yyyy-MM-dd
					Date sqlDate = Date.valueOf(localDate);
					uBO.updateUserInf(userId, fullname, sqlDate, fileToUpload, address);
					response.sendRedirect("ChangeInfoController");
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

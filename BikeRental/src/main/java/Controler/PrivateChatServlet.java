package Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MessageModal.Message;
import MessageModal.MessageBO;
import UserModal.UserBO;


@WebServlet("/private-chat")
public class PrivateChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MessageBO mbo = new MessageBO();



    public PrivateChatServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String username = request.getParameter("user");
        String withUser = request.getParameter("with");
        UserBO ubo = new UserBO();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Message> messages = null;
		try {
			messages = mbo.GetMessage(username, withUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int count = 0;
        if(messages!=null) {
        	for (Message msg : messages) {
        		if (msg.getFrom().equals(username)) {
        			out.println("<p style='text-align:right; color:blue; background-color: #d0ebff; color: #000;padding: 10px 15px;\r\n"
        					+ "    border-radius: 15px;max-width: 70%;word-wrap: break-word;margin-left:auto;display:block;'><b>Bạn:</b> " + msg.getContent() + "</p>");
        		} else {
        			try {
						out.println("<p style='text-align:left; color:green;background-color: #dee2e6; color: #000;padding: 10px 15px;\r\n"
								+ " border-radius: 15px;max-width: 70%;word-wrap: break-word;margin-left:0;display:block;'><b>" + ubo.getName(msg.getFrom())  + ":</b> " + msg.getContent() + "</p>");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		count++;
        	}        	
        }


        System.out.println("=> Tổng số tin nhắn hiển thị giữa " + username + " và " + withUser + ": " + count);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String from = request.getParameter("from");
        String to = request.getParameter("to");
        String content = request.getParameter("message");

        if (from != null && to != null && content != null && !content.trim().isEmpty()) {
            try {
				mbo.insertMessage(from, to, content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("✔ Đã lưu tin nhắn từ " + from + " → " + to + ": " + content);
        }
    }
}

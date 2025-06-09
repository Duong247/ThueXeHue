package MessageModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import CartItemModal.CartItem;
import UserModal.User;
import ketNoiModal.KetNoi;

public class MessageDAO {
	public boolean insertMessage(String sender, String reciever,String content) throws Exception {
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql=" insert into Message(sender,receiver,content)\r\n"
	    		+ " values(?,?,?)";
	    PreparedStatement cmd= kn.cn.prepareStatement(sql);
	    cmd.setString(1, sender);
	    cmd.setString(2, reciever);
	    cmd.setString(3, content);
		int rs= cmd.executeUpdate();
		return rs>0;
	}
	public ArrayList<Message> GetMessage(String sender, String reciever) throws Exception {
		ArrayList<Message> list = new ArrayList<Message>();
		KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "SELECT * FROM Message WHERE\r\n"
	    		+ "	    		 (sender = ? AND receiver = ?) OR (sender = ? AND receiver = ?)\r\n"
	    		+ "	    		 ORDER BY time ASC";
	    PreparedStatement cmd= kn.cn.prepareStatement(sql);
	    cmd.setString(1, sender);
	    cmd.setString(2, reciever);
	    cmd.setString(3, reciever);
	    cmd.setString(4, sender);
	    ResultSet rs = cmd.executeQuery();
	    while(rs.next()) {
	    	String senderU = rs.getString("sender");
	    	String receiverU = rs.getString("receiver");
	    	String contentU = rs.getString("content");
	    	list.add(new Message(senderU,receiverU,contentU));
	    }
	    rs.close();
	    cmd.close();
	    kn.cn.close();
	    return list;
		
	}
	
	public ArrayList<User> getChatUsers(String myPhone) throws Exception {
	    ArrayList<User> users = new ArrayList<>();
	    PreparedStatement cmd = null;
	    ResultSet rs = null;
	    KetNoi kn = new KetNoi();

	    try {
	        kn.ketnoi();

	        String sql = """
	            SELECT DISTINCT u.*
	            FROM [User] u
	            WHERE u.Phone IN (
	                SELECT sender FROM Message WHERE receiver = ?
	                UNION
	                SELECT receiver FROM Message WHERE sender = ?
	            )
	        """;

	        cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, myPhone);
	        cmd.setString(2, myPhone);
	        rs = cmd.executeQuery();

	        while (rs.next()) {
	            int userId = rs.getInt("UserId");
	            String fullname = rs.getString("UserName");
	            String phone = rs.getString("Phone");
	            String photo = rs.getString("Photo");
	            Date dateOfBirth = rs.getDate("DateOfBirth");
	            String address = rs.getString("Address");
	            String password = rs.getString("Password");
	            int role = rs.getInt("Role");

	            users.add(new User(userId, fullname, phone, password, dateOfBirth, address, photo, role));
	        }

	    } finally {
	        cmd.close();
	        kn.cn.close();
	    }

	    return users;
	}

}

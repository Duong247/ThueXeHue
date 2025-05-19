package UserModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BikeModal.Bike;
import ketNoiModal.KetNoi;

public class UserDAO {
	//owner info
	public User getUserInfoByBikeId(int id) throws Exception {
		User userInf= new User();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql ="\r\n"
				+ "select [User].UserId, UserName,Phone,Photo,DateOfBirth,Address,role,Password from [User] join Bike on [User].UserId = Bike.OwnerId\r\n"
				+ "where BikeId = ?\r\n";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, id);
		ResultSet rs= cmd.executeQuery();
		if(rs.next()) {
			int userId = rs.getInt("UserId");
			String fullname = rs.getString("UserName");
			String phone = rs.getString("Phone");
			String photo = rs.getString("Photo");
			Date dateOfBirth = rs.getDate("DateOfBirth");
			String address = rs.getString("Address");
			String password = rs.getString("Password");
			int role = rs.getInt("role");
			userInf = new User(userId, fullname, phone, password,dateOfBirth,address,photo,role);
		}
		rs.close();
		kn.cn.close();
		return userInf;
	}
	
	public User getUserloginInf(String phoneInput,String pasInput) throws Exception {
		User userInf= new User();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql ="select * from [User]\r\n"
				+ "where Phone=? and Password=?;";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, phoneInput);
		cmd.setString(2,pasInput);
		ResultSet rs= cmd.executeQuery();
		if(rs.next()) {
			int userId = rs.getInt("UserId");
			String fullname = rs.getString("UserName");
			String phone = rs.getString("Phone");
			String photo = rs.getString("Photo");
			Date dateOfBirth = rs.getDate("DateOfBirth");
			String address = rs.getString("Address");
			String password = rs.getString("Password");
			int role = rs.getInt("role");
			userInf = new User(userId, fullname, phone, password,dateOfBirth,address,photo,role);
		}
		rs.close();
		kn.cn.close();
		return userInf;
	}
	
	
	public User getUserById(int userId) throws Exception {
		User userInf= new User();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql ="select * from [User]\r\n"
				+ "where UserId = ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, userId);
		ResultSet rs= cmd.executeQuery();
		if(rs.next()) {
			int Id = rs.getInt("UserId");
			String fullname = rs.getString("UserName");
			String phone = rs.getString("Phone");
			String photo = rs.getString("Photo");
			Date dateOfBirth = rs.getDate("DateOfBirth");
			String address = rs.getString("Address");
			String password = rs.getString("Password");
			int role = rs.getInt("role");
			userInf = new User(Id, fullname, phone, password,dateOfBirth,address,photo,role);
		}
		rs.close();
		kn.cn.close();
		return userInf;
	}
	
	
	
	
	public boolean Register(String userName,String phone,String password,Date dateOfBirth,int role,String address) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
	   	String sql = "insert into [User](UserName, Phone,Password,DateOfBirth,role,Address)\r\n"
	   				+ "values(?,?,?,?,?,?)";
	   	PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   	cmd.setString(1,userName);
	   	cmd.setString(2, phone);
	   	cmd.setString(3, password);
	   	cmd.setDate(4, dateOfBirth);
	   	cmd.setInt(5, role);
	   	cmd.setString(6, address);
	   	int rs = cmd.executeUpdate();
	   	kn.cn.close();
	   	return rs > 0;
	}
	
	public boolean checkPhoneExists(String phone) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
	   	String sql = "select * from [User]\r\n"
	   				+ "where Phone= ?";
	   	PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   	cmd.setString(1,phone);
	   	ResultSet rs = cmd.executeQuery();
//	   	kn.cn.close();
	    return rs.next();
	}
	
	public boolean checkPLoginInf(String phone,String pass) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
	   	String sql = "select * from [User]\r\n"
	   			+ "where Phone=? and Password=?";
	   	PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   	cmd.setString(1,phone);
	   	cmd.setString(2,pass);
	   	ResultSet rs = cmd.executeQuery();
	    return rs.next();
	}
	
	public boolean updateUserInf(int userId, String fullname, Date dateofBirth,String photo, String address) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
	   	String sql = "update [User]\r\n"
	   			+ "set UserName=?,DateOfBirth=?,Photo=?,Address=?\r\n"
	   			+ "where UserId=?";
	   	PreparedStatement cmd = kn.cn.prepareStatement(sql);
	   	cmd.setString(1,fullname);
	   	cmd.setDate(2,dateofBirth);
	   	cmd.setString(3,photo);
	   	cmd.setString(4,address);
	   	cmd.setInt(5,userId);
	   	int rs = cmd.executeUpdate();
	    return rs>0;
	}
	
	public boolean checkOldPass(int userId, String oldPassword) throws Exception {
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    
	    String sql = "SELECT * FROM [User] WHERE UserId = ? AND Password = ?";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setInt(1, userId);
	    cmd.setString(2, oldPassword); 

	    ResultSet rs = cmd.executeQuery();
	    
	    boolean match = rs.next();
	    rs.close();	
	    cmd.close();
	    kn.cn.close();

	    return match;
	}
	
	public boolean updatePassword(int userId, String newPassword) throws Exception {
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "UPDATE [User] SET Password = ? WHERE UserId = ?";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, newPassword);
	    cmd.setInt(2, userId);

	    int rs = cmd.executeUpdate();
	    
	    cmd.close();
	    kn.cn.close();
	    
	    return rs > 0;
	}

	
	
	
}

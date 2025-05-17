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
	
	
}

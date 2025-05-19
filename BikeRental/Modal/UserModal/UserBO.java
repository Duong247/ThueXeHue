package UserModal;

import java.security.MessageDigest;
import java.sql.Date;

public class UserBO {
	UserDAO userDao = new UserDAO();
	
	public User getUserInfoByBikeId(int bikeId) throws Exception {
		return userDao.getUserInfoByBikeId(bikeId);
	}
	
	public boolean Registeruser(String userName,String phone,String password,Date dateOfBirth,String address) throws Exception {
		String hashPassword = hashPassword(password); 
		return userDao.Register(userName, phone, hashPassword, dateOfBirth, 1, address);
	}
	
    public static String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
    
    public boolean checkPhoneExists(String phone) throws Exception {
    	return userDao.checkPhoneExists(phone);
    }
    
    public boolean checkLoginInf(String phone,String pass) throws Exception {
    	String HashPassword = hashPassword(pass);
    	return userDao.checkPLoginInf(phone, HashPassword);
    }
    
    public User getUserLoginInfo(String phone,String pass) throws Exception {
		return userDao.getUserloginInf(phone, pass);
	}
    public User getUserById(int userId) throws Exception {
		return userDao.getUserById(userId);
	}
    
    public boolean updateUserInf(int userId, String fullname, Date dateofBirth,String photo, String address) throws Exception {
    	return userDao.updateUserInf(userId, fullname, dateofBirth, photo, address);
    }
    
    public boolean checkOldPass(int userId, String pass) throws Exception {
    	String HashPassword = hashPassword(pass);
    	System.out.println(HashPassword);
    	return userDao.checkOldPass(userId, HashPassword);
    }
    
    public boolean updatePassword(int userId, String newPass) throws Exception {
    	String HashPassword = hashPassword(newPass);
		return userDao.updatePassword(userId, HashPassword);
	}
    
    
}

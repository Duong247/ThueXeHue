package UserModal;

public class UserBO {
	UserDAO userDao = new UserDAO();
	public User getUserInfoByBikeId(int bikeId) throws Exception {
		return userDao.getUserInfoByBikeId(bikeId);
	}
}

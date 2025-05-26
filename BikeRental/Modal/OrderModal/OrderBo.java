package OrderModal;

import java.security.Timestamp;
import java.util.ArrayList;


public class OrderBo {
	OrderDao ODAO = new OrderDao();
	public ArrayList<Order>getOrderHistoryByUserId(int userId) throws Exception{
		return ODAO.getOrderHistoryByUserId(userId);
	}
	
	public ArrayList<Order>getOrdersByOwnerId(int ownerId) throws Exception{
		return ODAO.getOrdersByOwnerId(ownerId);
	}
	
}

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
	
	public boolean cancelOrder(int orderId) throws Exception{
		return ODAO.cancelOrder(orderId);
	}
	
	public boolean acceptOrder(int orderId) throws Exception{
		return ODAO.acceptOrder(orderId);
	}
	
	public boolean completeOrder(int orderId) throws Exception{
		return ODAO.completeOrder(orderId);
	}
	
}

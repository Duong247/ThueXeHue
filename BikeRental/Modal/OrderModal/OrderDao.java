package OrderModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import CartItemModal.CartItem;
import ketNoiModal.KetNoi;

public class OrderDao {
	public ArrayList<Order> getOrderHistoryByUserId(int userId) throws Exception {
	    Map<Integer, Order> orderMap = new LinkedHashMap<>();
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "SELECT o.OrderId, o.OrderDate, o.PickupPlace, o.ReturnPlace, o.Status, " +
	             "od.BikeId, b.BikeName, b.LicensePlate, b.ManufacturingYear, b.BikeLine, b.BikeManufactor, " +
	             "(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo, " +
	             "b.Description, od.RentalFee, od.PickupDate, od.ReturnDate " +
	             "FROM [Order] o " +
	             "JOIN OrderDetail od ON o.OrderId = od.OrderId " +
	             "JOIN Bike b ON od.BikeId = b.BikeId " +
	             "WHERE o.UserId = ? " +
	             "ORDER BY o.OrderDate DESC";
	    PreparedStatement ps = kn.cn.prepareStatement(sql);
	    ps.setInt(1, userId);
	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
	        int orderId = rs.getInt("OrderId");

	        Order order = orderMap.get(orderId);
	        if (order == null) {
	            order = new Order(
	                orderId,
	                rs.getTimestamp("OrderDate"),
	                rs.getString("PickupPlace"),
	                rs.getString("ReturnPlace"),
	                rs.getInt("Status")
	            );
	            orderMap.put(orderId, order);
	        }

	        CartItem item = new CartItem(
	            rs.getInt("BikeId"),
	            rs.getString("BikeName"),
	            rs.getString("LicensePlate"),
	            rs.getInt("ManufacturingYear"),
	            rs.getString("BikeLine"),
	            rs.getString("BikeManufactor"),
	            rs.getString("Photo"),
	            rs.getString("Description"),
	            rs.getLong("RentalFee"),
	            rs.getTimestamp("PickupDate"),
	            rs.getTimestamp("ReturnDate")
	        );

	        order.addItem(item);
	    }

	    rs.close();
	    ps.close();
	    kn.cn.close();

	    return new ArrayList<>(orderMap.values());
	}
	
	public ArrayList<Order> getOrdersByOwnerId(int ownerId) throws Exception {
	    Map<Integer, Order> orderMap = new LinkedHashMap<>();
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();

	    String sql = "SELECT o.OrderId, o.OrderDate, o.PickupPlace, o.ReturnPlace, o.Status, " +
	                 "od.BikeId, b.BikeName, b.LicensePlate, b.ManufacturingYear, b.BikeLine, b.BikeManufactor, " +
	                 "(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo, " +
	                 "b.Description, od.RentalFee, od.PickupDate, od.ReturnDate " +
	                 "FROM [Order] o " +
	                 "JOIN OrderDetail od ON o.OrderId = od.OrderId " +
	                 "JOIN Bike b ON od.BikeId = b.BikeId " +
	                 "WHERE b.OwnerId = ? " +
	                 "ORDER BY o.OrderDate DESC";

	    PreparedStatement ps = kn.cn.prepareStatement(sql);
	    ps.setInt(1, ownerId);
	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
	        int orderId = rs.getInt("OrderId");

	        Order order = orderMap.get(orderId);
	        if (order == null) {
	            order = new Order(
	                orderId,
	                rs.getTimestamp("OrderDate"),
	                rs.getString("PickupPlace"),
	                rs.getString("ReturnPlace"),
	                rs.getInt("Status")
	            );
	            orderMap.put(orderId, order);
	        }

	        CartItem item = new CartItem(
	            rs.getInt("BikeId"),
	            rs.getString("BikeName"),
	            rs.getString("LicensePlate"),
	            rs.getInt("ManufacturingYear"),
	            rs.getString("BikeLine"),
	            rs.getString("BikeManufactor"),
	            rs.getString("Photo"),
	            rs.getString("Description"),
	            rs.getLong("RentalFee"),
	            rs.getTimestamp("PickupDate"),
	            rs.getTimestamp("ReturnDate")
	        );

	        order.addItem(item);
	    }

	    rs.close();
	    ps.close();
	    kn.cn.close();

	    return new ArrayList<>(orderMap.values());
	}


	
	

}

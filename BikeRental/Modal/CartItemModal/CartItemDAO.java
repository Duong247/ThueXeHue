package CartItemModal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ketNoiModal.KetNoi;

public class CartItemDAO {

	public boolean addNewOrder(int bikeId, long rentalFee, Timestamp pickupDate, Timestamp returnDate, int userId,
			String pickupPlace, String returnPlace) throws Exception {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		try {
			// Kết nối
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			conn = kn.cn;
			conn.setAutoCommit(false);

			// them OrderDetail
			String sql1 = "INSERT INTO OrderDetail (BikeId, RentalFee, PickupDate, ReturnDate) VALUES (?, ?, ?, ?)";
			ps1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			ps1.setInt(1, bikeId);
			ps1.setLong(2, rentalFee);
			ps1.setTimestamp(3, pickupDate);
			ps1.setTimestamp(4, pickupDate);
			ps1.executeUpdate();

			// lay OrderDetailId vua insert
			rs = ps1.getGeneratedKeys();
			int orderDetailId = -1;
			if (rs.next()) {
				orderDetailId = rs.getInt(1);
			} else {
				conn.rollback();
				return false;
			}

			// Them Order
			String sql2 = "INSERT INTO [Order] (OrderDetailId, UserId, PickupPlace, ReturnPlace) VALUES (?, ?, ?, ?)";
			ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, orderDetailId);
			ps2.setInt(2, userId);
			ps2.setString(3, pickupPlace);
			ps2.setString(4, returnPlace);
			ps2.executeUpdate();

			conn.commit();
			return true;
		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null)
				rs.close();
			if (ps1 != null)
				ps1.close();
			if (ps2 != null)
				ps2.close();
			if (conn != null)
				conn.close();
		}
	}

	public boolean addNewOrderWithDetails(int userId, String pickupPlace, String returnPlace,
			ArrayList<CartItem> details) throws Exception {
		Connection conn = null;
		PreparedStatement psOrder = null;
		PreparedStatement psDetail = null;
		ResultSet rs = null;

		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			conn = kn.cn;
			conn.setAutoCommit(false);

			// 1. Insert into Order
			String sqlOrder = "INSERT INTO [Order] (UserId, PickupPlace, ReturnPlace) VALUES (?, ?, ?)";
			psOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
			psOrder.setInt(1, userId);
			psOrder.setString(2, pickupPlace);
			psOrder.setString(3, returnPlace);
			psOrder.executeUpdate();

			rs = psOrder.getGeneratedKeys();
			int orderId = -1;
			if (rs.next()) {
				orderId = rs.getInt(1);
			} else {
				conn.rollback();
				return false;
			}

			// 2. Insert all order details with the new orderId
			String sqlDetail = "INSERT INTO OrderDetail (OrderId, BikeId, RentalFee, PickupDate, ReturnDate) VALUES (?, ?, ?, ?, ?)";
			psDetail = conn.prepareStatement(sqlDetail);

			for (CartItem od : details) {
				psDetail.setInt(1, orderId);
				psDetail.setInt(2, od.getBikeId());
				psDetail.setLong(3, od.getRentalFee());
				psDetail.setTimestamp(4, od.getPickupDate());
				psDetail.setTimestamp(5, od.getReturnDate());
				psDetail.addBatch();
			}
			psDetail.executeBatch();

			conn.commit();
			return true;

		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null)
				rs.close();
			if (psOrder != null)
				psOrder.close();
			if (psDetail != null)
				psDetail.close();
			if (conn != null)
				conn.close();
		}
	}

	public boolean addMultipleOrdersByOwner(int userId, String pickupPlace, String returnPlace,
			ArrayList<CartItem> cartItemList) throws Exception {
		Connection conn = null;
		PreparedStatement psOrder = null;
		PreparedStatement psDetail = null;
		ResultSet rs = null;

		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			conn = kn.cn;
			conn.setAutoCommit(false);

			// Gom nhóm các CartItem theo ownerId
			Map<Integer, List<CartItem>> groupedByOwner = new HashMap<>();

			for (CartItem item : cartItemList) {
				int ownerId = item.getOwnerId();
				groupedByOwner.computeIfAbsent(ownerId, k -> new ArrayList<>()).add(item);
			}

			String sqlOrder = "INSERT INTO [Order] (UserId, PickupPlace, ReturnPlace) VALUES (?, ?, ?)";
			String sqlDetail = "INSERT INTO OrderDetail (OrderId, BikeId, RentalFee, PickupDate, ReturnDate) VALUES (?, ?, ?, ?, ?)";

			for (Map.Entry<Integer, List<CartItem>> entry : groupedByOwner.entrySet()) {
				List<CartItem> group = entry.getValue();

				// 1. Tạo đơn hàng
				psOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
				psOrder.setInt(1, userId);
				psOrder.setString(2, pickupPlace);
				psOrder.setString(3, returnPlace);
				psOrder.executeUpdate();

				rs = psOrder.getGeneratedKeys();
				int orderId = -1;
				if (rs.next()) {
					orderId = rs.getInt(1);
				} else {
					conn.rollback();
					return false;
				}
				psOrder.close();
				rs.close();

				// 2. Thêm chi tiết đơn hàng
				psDetail = conn.prepareStatement(sqlDetail);
				for (CartItem item : group) {
					psDetail.setInt(1, orderId);
					psDetail.setInt(2, item.getBikeId());
					psDetail.setLong(3, item.getRentalFee());
					psDetail.setTimestamp(4, item.getPickupDate());
					psDetail.setTimestamp(5, item.getReturnDate());
					psDetail.addBatch();
				}
				psDetail.executeBatch();
				psDetail.close();
			}

			conn.commit();
			return true;

		} catch (Exception e) {
			if (conn != null)
				conn.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (rs != null)
				rs.close();
			if (psOrder != null)
				psOrder.close();
			if (psDetail != null)
				psDetail.close();
			if (conn != null)
				conn.close();
		}
	}

	public ArrayList<CartItem> getOrderHistoryByUserId(int userId) throws Exception {
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "SELECT \r\n" + "    o.OrderId,\r\n" + "    o.OrderDate,\r\n" + "    o.PickupPlace,\r\n"
				+ "    o.ReturnPlace,\r\n" + "    od.BikeId,\r\n" + "    b.BikeName,\r\n" + "    b.LicensePlate,\r\n"
				+ "    b.ManufacturingYear,\r\n" + "    b.BikeLine,\r\n" + "    b.BikeManufactor,\r\n"
				+ "    bp.Photo, -- lấy ảnh\r\n" + "    b.Description,\r\n" + "    od.RentalFee,\r\n"
				+ "    od.PickupDate,\r\n" + "    od.ReturnDate\r\n" + "FROM [Order] o\r\n"
				+ "JOIN OrderDetail od ON o.OrderId = od.OrderDetailId\r\n" + "JOIN Bike b ON od.BikeId = b.BikeId\r\n"
				+ "LEFT JOIN BikePhoto bp ON bp.BikeId = b.BikeId AND bp.Priority = (\r\n"
				+ "    SELECT MIN(Priority)\r\n" + "    FROM BikePhoto\r\n" + "    WHERE BikeId = b.BikeId\r\n"
				+ ")\r\n" + "WHERE o.UserId = ?\r\n" + "ORDER BY o.OrderDate DESC";

		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CartItem item = new CartItem();
			item.setBikeId(rs.getInt("BikeId"));
			item.setBikeName(rs.getString("BikeName"));
			item.setLicensePlate(rs.getString("LicensePlate"));
			item.setManufacturingYear(rs.getInt("ManufacturingYear"));
			item.setBikeLine(rs.getString("BikeLine"));
			item.setBikeManufactor(rs.getString("BikeManufactor"));
			item.setPhoto(rs.getString("Photo"));
			item.setDescription(rs.getString("Description"));
			item.setRentalFee(rs.getLong("RentalFee"));
			item.setPickupDate(rs.getTimestamp("PickupDate"));
			item.setReturnDate(rs.getTimestamp("ReturnDate"));
			list.add(item);
		}
		rs.close();
		ps.close();
		kn.cn.close();
		return list;
	}

}

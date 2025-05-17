package CartItemModal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class CartItemDAO {

	public boolean addNewOrder(int bikeId, long rentalFee, Timestamp pickupDate, Timestamp returnDate,
			int userId, String pickupPlace, String returnPlace) throws Exception {
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
				
				//them OrderDetail
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
				if (conn != null) conn.rollback(); 
				e.printStackTrace();
				return false;
			} finally {
				if (rs != null) rs.close();
				if (ps1 != null) ps1.close();
				if (ps2 != null) ps2.close();
				if (conn != null) conn.close();
			}
		}
	
	public boolean addNewOrderWithDetails(int userId, String pickupPlace, String returnPlace,
		    ArrayList<CartItem> details  ) throws Exception 
	{
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
		        if (conn != null) conn.rollback();
		        e.printStackTrace();
		        return false;
		    } finally {
		        if (rs != null) rs.close();
		        if (psOrder != null) psOrder.close();
		        if (psDetail != null) psDetail.close();
		        if (conn != null) conn.close();
		    }
		}

}

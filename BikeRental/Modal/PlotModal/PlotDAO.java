package PlotModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class PlotDAO {
	public ArrayList<Plot> getRevenueLast7DaysFull(int userId) throws Exception {
	    ArrayList<Plot> list = new ArrayList<>();
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "\r\n"
	    		+ "WITH Last7Days AS (\r\n"
	    		+ "    SELECT CAST(GETDATE() AS DATE) AS OrderDay\r\n"
	    		+ "    UNION ALL\r\n"
	    		+ "    SELECT DATEADD(DAY, -1, OrderDay)\r\n"
	    		+ "    FROM Last7Days\r\n"
	    		+ "    WHERE DATEADD(DAY, -1, OrderDay) >= DATEADD(DAY, -6, CAST(GETDATE() AS DATE))\r\n"
	    		+ "),\r\n"
	    		+ "OwnerOrders AS (\r\n"
	    		+ "    SELECT o.OrderId, o.OrderDate, od.RentalFee, od.PickupDate, od.ReturnDate\r\n"
	    		+ "    FROM [Order] o\r\n"
	    		+ "    JOIN OrderDetail od ON o.OrderId = od.OrderId\r\n"
	    		+ "    JOIN Bike b ON od.BikeId = b.BikeId\r\n"
	    		+ "    WHERE o.Status = 2 AND b.OwnerId = ?\r\n"
	    		+ ")\r\n"
	    		+ "SELECT \r\n"
	    		+ "    FORMAT(d.OrderDay, 'dddd', 'en-US') AS DayLabel, \r\n"
	    		+ "    ISNULL(SUM(oo.RentalFee * \r\n"
	    		+ "        (DATEDIFF(DAY, oo.PickupDate, oo.ReturnDate))\r\n"
	    		+ "    ), 0) AS TotalRevenue\r\n"
	    		+ "FROM Last7Days d\r\n"
	    		+ "LEFT JOIN OwnerOrders oo ON CAST(oo.OrderDate AS DATE) = d.OrderDay\r\n"
	    		+ "GROUP BY d.OrderDay\r\n"
	    		+ "ORDER BY d.OrderDay;";
// TODO: set status =1
	    PreparedStatement ps = kn.cn.prepareStatement(sql);
	    ps.setInt(1, userId);
	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
	    	String label = rs.getString("DayLabel");
	        long revenue = rs.getLong("TotalRevenue");
	        list.add(new Plot(label,revenue));
	    }

	    rs.close();
	    ps.close();
	    kn.cn.close();

	    return list;
	}
	
	public int BikeInOrderCount(int ownerId) throws Exception {
		int count=0;
		KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "select count(*) as Ordercount from [Order] as o join OrderDetail as  od on o.OrderId = od.OrderId\r\n"
	    		+ "join Bike as b on b.BikeId = od.BikeId\r\n"
	    		+ "where OwnerId=? and o.Status>=0";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setInt(1, ownerId);
	    ResultSet rs = cmd.executeQuery();
	    if (rs.next()) {
	    	count = rs.getInt("Ordercount");
	    }
	    rs.close();
	    cmd.close();
	    kn.cn.close();
	    return count;
	}
	
	public int totalMoney(int ownerId) throws Exception {
		int count=0;
		KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "SELECT sum( Price*DATEDIFF(DAY, PickupDate, ReturnDate) )as Subtotal\r\n"
	    		+ "FROM [Order] AS o\r\n"
	    		+ "JOIN OrderDetail AS od ON o.OrderId = od.OrderId\r\n"
	    		+ "JOIN Bike AS b ON b.BikeId = od.BikeId\r\n"
	    		+ "WHERE b.OwnerId = ? AND o.Status = 2";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setInt(1, ownerId);
	    ResultSet rs = cmd.executeQuery();
	    if (rs.next()) {
	    	count = rs.getInt("Subtotal");
	    }
	    rs.close();
	    cmd.close();
	    kn.cn.close();
	    return count;
	}
	
	
}

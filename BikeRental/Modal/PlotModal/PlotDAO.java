package PlotModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class PlotDAO {
	public ArrayList<Plot> getRevenueLast7DaysFull() throws Exception {
	    ArrayList<Plot> list = new ArrayList<>();
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "WITH Last7Days AS (\r\n"
	    		+ "    SELECT CAST(GETDATE() AS DATE) AS OrderDay\r\n"
	    		+ "    UNION ALL\r\n"
	    		+ "    SELECT DATEADD(DAY, -1, OrderDay)\r\n"
	    		+ "    FROM Last7Days\r\n"
	    		+ "    WHERE DATEADD(DAY, -1, OrderDay) >= DATEADD(DAY, -6, CAST(GETDATE() AS DATE))\r\n"
	    		+ ")\r\n"
	    		+ "SELECT \r\n"
	    		+ "    FORMAT(d.OrderDay, 'dddd') AS DayLabel, \r\n"
	    		+ "    ISNULL(SUM(od.RentalFee), 0) AS TotalRevenue\r\n"
	    		+ "FROM Last7Days d\r\n"
	    		+ "LEFT JOIN [Order] o ON CAST(o.OrderDate AS DATE) = d.OrderDay AND o.Status = 0\r\n"
	    		+ "LEFT JOIN OrderDetail od ON o.OrderId = od.OrderId\r\n"
	    		+ "GROUP BY d.OrderDay\r\n"
	    		+ "ORDER BY d.OrderDay;";
// TODO: set status =1
	    PreparedStatement ps = kn.cn.prepareStatement(sql);
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
	
	
	
}

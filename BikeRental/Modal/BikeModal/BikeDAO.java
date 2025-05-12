package BikeModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class BikeDAO {
	public ArrayList<Bike> getAllBikes() throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Photo\r\n"
				+ "from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			int bikeId = rs.getInt("BikeId");
			String bikeName = rs.getString("BikeName");
			String licensePlate = rs.getString("LicensePlate");
			int manufacturingYear = rs.getInt("ManufacturingYear");
			String BikeLine = rs.getString("BikeLine");
			String BikeManufactor = rs.getString("BikeManufactor");
			int status = rs.getInt("Status");
			String photo= rs.getString("photo");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,status));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
	public ArrayList<Bike> getBikesWithPagination(int page,int pagesize) throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="\r\n"
				+ "SELECT Bike.BikeId, BikeName, LicensePlate, ManufacturingYear, BikeLine, OwnerId, BikeManufactor, Status, Photo\r\n"
				+ "FROM Bike LEFT JOIN BikePhoto ON Bike.BikeId = BikePhoto.BikeId\r\n"
				+ "ORDER BY Bike.BikeId\r\n"
				+ "OFFSET (? - 1) * ? ROWS\r\n"
				+ "FETCH NEXT ? ROWS ONLY;";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, page);
		cmd.setInt(2, pagesize);
		cmd.setInt(3, pagesize);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			int bikeId = rs.getInt("BikeId");
			String bikeName = rs.getString("BikeName");
			String licensePlate = rs.getString("LicensePlate");
			int manufacturingYear = rs.getInt("ManufacturingYear");
			String BikeLine = rs.getString("BikeLine");
			String BikeManufactor = rs.getString("BikeManufactor");
			int status = rs.getInt("Status");
			String photo= rs.getString("photo");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,status));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
}

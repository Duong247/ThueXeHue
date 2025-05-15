package BikeModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class BikeDAO {
	public ArrayList<Bike> getAllBikes() throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime\r\n"
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
			String description = rs.getString("Description");
			Long price = rs.getLong("price");
			String photo= rs.getString("Photo");
			Date CreatedTime = rs.getDate("CreatedTime");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
	public ArrayList<Bike> get_8Bikes() throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select Top 8 Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime\r\n"
				+ "from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId\r\n"
				+ "where Status=1\r\n"
				+ "order by CreatedTime";
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
			String description = rs.getString("Description");
			Long price = rs.getLong("price");
			String photo= rs.getString("Photo");
			Date CreatedTime = rs.getDate("CreatedTime");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
	public Bike getBikeById(int id) throws Exception{
		Bike bike = null;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime\r\n"
				+ "from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId\r\n"
				+ "where Bike.BikeId = ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, id);
		ResultSet rs= cmd.executeQuery();
		
		if (rs.next()) {
			int bikeId = rs.getInt("BikeId");
			String bikeName = rs.getString("BikeName");
			String licensePlate = rs.getString("LicensePlate");
			int manufacturingYear = rs.getInt("ManufacturingYear");
			String BikeLine = rs.getString("BikeLine");
			String BikeManufactor = rs.getString("BikeManufactor");
			int status = rs.getInt("Status");
			String description = rs.getString("Description");
			Long price = rs.getLong("price");
			String photo= rs.getString("Photo");
			Date CreatedTime = rs.getDate("CreatedTime");
			bike =new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime);
		}
		rs.close();
		kn.cn.close();
		return bike;
	}
	
	
	
	public ArrayList<Bike> getBikesWithPagination(int page,int pagesize) throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="\r\n"
				+ "SELECT Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime\r\n"
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
			String description = rs.getString("Description");
			Long price = rs.getLong("price");
			String photo= rs.getString("Photo");
			Date CreatedTime = rs.getDate("CreatedTime");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
	public int PageCount(int pagesize) throws Exception {
		KetNoi kn = new KetNoi();
		int pageCount=0;
		kn.ketnoi();
		String sql="SELECT CEILING(CAST(COUNT(*) AS FLOAT) / ?) AS TotalPages\r\n"
				+ "FROM Bike;";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, pagesize);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			pageCount= rs.getInt("TotalPages");
		}
		rs.close();
		kn.cn.close();
		return pageCount;
	}
	
	public ArrayList<String> getBikeBrand() throws Exception{
		ArrayList<String> brands = new ArrayList<String>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select * from BikeManufactor";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			String brandname = rs.getString("BikeManufactor");
			brands.add(brandname);
		}
		rs.close();
		kn.cn.close();
		return brands;
	}
	
	
	public ArrayList<String> getPhotoByBikeId(int id) throws Exception{
		ArrayList<String> Photos = new ArrayList<String>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select* from BikePhoto\r\n"
				+ "where BikeId = ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, id);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			Photos.add(rs.getString("Photo"));
		}
		rs.close();
		kn.cn.close();
		return Photos;
	}
	
	public ArrayList<Bike> getBikeSimilar(int id) throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select Top 8 Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime\r\n"
				+ "from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId\r\n"
				+ "where BikeLine =(\r\n"
				+ "				select BikeLine\r\n"
				+ "				from Bike\r\n"
				+ "				where BikeId =?)\r\n"
				+ "and Status = 1";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, id);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			int bikeId = rs.getInt("BikeId");
			String bikeName = rs.getString("BikeName");
			String licensePlate = rs.getString("LicensePlate");
			int manufacturingYear = rs.getInt("ManufacturingYear");
			String BikeLine = rs.getString("BikeLine");
			String BikeManufactor = rs.getString("BikeManufactor");
			int status = rs.getInt("Status");
			String description = rs.getString("Description");
			Long price = rs.getLong("price");
			String photo= rs.getString("Photo");
			Date CreatedTime = rs.getDate("CreatedTime");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
	
}

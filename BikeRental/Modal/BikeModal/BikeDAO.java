package BikeModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	
	public ArrayList<Bike> getOwnerBike(int userid) throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select b.BikeId,BikeName,LicensePlate,ManufacturingYear,BikeLine,BikeManufactor,Description,Price,Status,CreatedTime ,\r\n"
				+ "(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo\r\n"
				+ "from [User] left join Bike as b on [User].UserId = b.OwnerId\r\n"
				+ "where [User].UserId = ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, userid);
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
	
	public boolean addBikeWithPhotos(Bike bike,int currentUserId,ArrayList<String> photolist) throws Exception {

	    PreparedStatement psBike = null;
	    PreparedStatement psPhoto = null;
	    ResultSet rs = null;
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();

	    try {

	        // 1. Insert vào bảng Bike
	        String sqlInsertBike = "INSERT INTO Bike (BikeName, LicensePlate, ManufacturingYear, BikeLine, OwnerId, BikeManufactor, Status, Description, Price, CreatedTime) " +
	                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE())";
	        psBike = kn.cn.prepareStatement(sqlInsertBike, Statement.RETURN_GENERATED_KEYS);
	        psBike.setString(1, bike.getBikeName());
	        psBike.setString(2, bike.getLicensePlate());
	        psBike.setInt(3, bike.getManufacturingYear());
	        psBike.setString(4, bike.getBikeLine());
	        psBike.setInt(5, currentUserId);
	        psBike.setString(6, bike.getBikeManufactor());
	        psBike.setInt(7, bike.getStatus());
	        psBike.setString(8, bike.getDescription());
	        psBike.setDouble(9, bike.getPrice());

	        int rowsAffected = psBike.executeUpdate();

	        rs = psBike.getGeneratedKeys();
	        int newBikeId = 0;
	        if (rs.next()) {
	            newBikeId = rs.getInt(1);
	        } 

	        // 2. Insert vào bảng BikePhoto
	        String sqlInsertPhoto = "INSERT INTO BikePhoto (Photo, BikeId) VALUES (?, ?)";
	        psPhoto = kn.cn.prepareStatement(sqlInsertPhoto);
	        for (String photo : photolist) {
	            psPhoto.setString(1, photo);
	            psPhoto.setInt(2, newBikeId);
	            psPhoto.addBatch();
	        }
	        psPhoto.executeUpdate();

	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        if (rs != null) rs.close();
	        if (psBike != null) psBike.close();
	        if (psPhoto != null) psPhoto.close();
	        if (kn != null) kn.cn.close();
	    }
	}
	
	public ArrayList<String> getBikeManufactor() throws Exception{
		ArrayList<String> listBikeManufactors = new ArrayList<String>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select * from BikeManufactor";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			String BikeManufactor = rs.getString("BikeManufactor");
			listBikeManufactors.add(BikeManufactor);
		}
		rs.close();
		kn.cn.close();
		return listBikeManufactors;
	}
	

	public ArrayList<String> getBikePhoto(int id) throws Exception{
		ArrayList<String> bikePhotos= new ArrayList<String>(); 
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select * from BikePhoto\r\n"
				+ "where BikeId = ?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, id);
		ResultSet rs= cmd.executeQuery();
		if (rs.next()) {
			String photo= rs.getString("Photo");
			bikePhotos.add(photo);
		}
		rs.close();
		kn.cn.close();
		return bikePhotos;
	}

	
	
	
}

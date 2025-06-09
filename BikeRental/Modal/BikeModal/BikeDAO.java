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
		String sql="select *, (SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo\r\n"
				+ "from Bike as b\r\n";
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
			int ownerId = rs.getInt("ownerId");
			Date CreatedTime = rs.getDate("CreatedTime");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime,ownerId));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
	public ArrayList<Bike> get_8Bikes() throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select Top 8 *, (SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo\r\n"
				+ "from Bike as b\r\n"
				+ "where Status>-2\r\n"
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
			int ownerId = rs.getInt("ownerId");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime,ownerId));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
	public Bike getBikeById(int id) throws Exception{
		Bike bike = null;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select b.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo,CreatedTime\r\n"
				+ "from Bike as b \r\n"
				+ "where b.BikeId = ?";
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
			int ownerId = rs.getInt("ownerId");
			bike =new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime,ownerId);
		}
		rs.close();
		kn.cn.close();
		return bike;
	}
	
	
	
	public ArrayList<Bike> getBikesWithPagination(int page,int pagesize) throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="SELECT b.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo,CreatedTime,OwnerId\r\n"
				+ "FROM Bike as b\r\n"
				+ "where Status>-2\r\n"
				+ "ORDER BY b.BikeId\r\n"
				+ "OFFSET (? - 1) * ? ROWS\r\n"
				+ "FETCH NEXT ? ROWS ONLY";
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
			int ownerId = rs.getInt("ownerId");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime,ownerId));
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
		String sql="select Top 8 Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime,OwnerId\r\n"
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
			int ownerId = rs.getInt("ownerId");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime,ownerId));
		}
		rs.close();
		kn.cn.close();
		return bikes;
	}
	
	public ArrayList<Bike> getOwnerBike(int userid) throws Exception{
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select b.BikeId,BikeName,LicensePlate,ManufacturingYear,BikeLine,BikeManufactor,Description,Price,Status,CreatedTime ,b.OwnerId,\r\n"
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
			int ownerId = rs.getInt("ownerId");
			bikes.add(new Bike(bikeId,bikeName,licensePlate,manufacturingYear,BikeLine,BikeManufactor,photo,description,price,status,CreatedTime,ownerId));
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
	        psBike.setInt(7, -1);
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
	
	public boolean updateBikeWithPhotos(Bike bike, ArrayList<String> photolist) throws Exception {
	    PreparedStatement psUpdateBike = null;
	    PreparedStatement psDeletePhotos = null;
	    PreparedStatement psInsertPhoto = null;
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();

	    try {
	        String sqlUpdateBike = "UPDATE Bike SET BikeName = ?, LicensePlate = ?, ManufacturingYear = ?, " +
	                "BikeLine = ?, BikeManufactor = ?, Status = ?, Description = ?, Price = ? WHERE BikeId = ?";
	        psUpdateBike = kn.cn.prepareStatement(sqlUpdateBike);
	        psUpdateBike.setString(1, bike.getBikeName());
	        psUpdateBike.setString(2, bike.getLicensePlate());
	        psUpdateBike.setInt(3, bike.getManufacturingYear());
	        psUpdateBike.setString(4, bike.getBikeLine());
	        psUpdateBike.setString(5, bike.getBikeManufactor());
	        psUpdateBike.setInt(6, bike.getStatus());
	        psUpdateBike.setString(7, bike.getDescription());
	        psUpdateBike.setDouble(8, bike.getPrice());
	        psUpdateBike.setInt(9, bike.getBikeId());

	        int updateCount = psUpdateBike.executeUpdate();

	        String sqlDeletePhotos = "DELETE FROM BikePhoto WHERE BikeId = ?";
	        psDeletePhotos = kn.cn.prepareStatement(sqlDeletePhotos);
	        psDeletePhotos.setInt(1, bike.getBikeId());
	        psDeletePhotos.executeUpdate();

	        String sqlInsertPhoto = "INSERT INTO BikePhoto (Photo, BikeId) VALUES (?, ?)";
	        psInsertPhoto = kn.cn.prepareStatement(sqlInsertPhoto);
	        for (String photo : photolist) {
	            psInsertPhoto.setString(1, photo);
	            psInsertPhoto.setInt(2, bike.getBikeId());
	            psInsertPhoto.addBatch();
	        }
	        psInsertPhoto.executeBatch();

	        return updateCount > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        if (psUpdateBike != null) psUpdateBike.close();
	        if (psDeletePhotos != null) psDeletePhotos.close();
	        if (psInsertPhoto != null) psInsertPhoto.close();
	        if (kn != null) kn.cn.close();
	    }
	}

	public ArrayList<String> getBikeBikeLine() throws Exception{
		ArrayList<String> listBikeLine =new ArrayList<String>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select * from BikeLine";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			String BikeLine= rs.getString("BikeLine");
			listBikeLine.add(BikeLine);
		}
		rs.close();
		kn.cn.close();
		return listBikeLine;
	}
	
	public ArrayList<String> getBikeStatus() throws Exception{
		ArrayList<String> listBikeStatus =new ArrayList<String>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select * from BikeStatus";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			String BikeStatus= rs.getString("statusMessage");
			listBikeStatus.add(BikeStatus);
		}
		rs.close();
		kn.cn.close();
		return listBikeStatus;
	}
	
	
	public ArrayList<Integer> getBikeStatusId() throws Exception{
		ArrayList<Integer> listBikeStatus =new ArrayList<Integer>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select * from BikeStatus";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			int BikeStatus= rs.getInt("statusId");
			listBikeStatus.add(BikeStatus);
		}
		rs.close();
		kn.cn.close();
		return listBikeStatus;
	}
	
	public String statusStr(int statusId) throws Exception {
		String BikeStatus="";
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select * from BikeStatus where statusId=?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, statusId);
		ResultSet rs= cmd.executeQuery();
		while (rs.next()) {
			BikeStatus= rs.getString("statusMessage");
		}
		rs.close();
		kn.cn.close();
		return BikeStatus;
	}
	
	public boolean updateDenyBikestatus(int bikeId)throws Exception{
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="update Bike\r\n"
				+ "set Status = -2\r\n"
				+ "where BikeId=?";
		try {
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			cmd.setInt(1, bikeId);
			int rs= cmd.executeUpdate();
			return rs>0;
		}finally {
	        kn.cn.close();
	    } 
	}
	
	
	
	
	
	public int  getCountBikeOfUser(int id ) throws Exception{
		int count =0;
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select COUNT(*) as countBike from Bike\r\n"
				+ "where OwnerId=?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, id);
		ResultSet rs= cmd.executeQuery();
		if(rs.next()) {
			count= rs.getInt("countBike");
			
		}
		rs.close();
		kn.cn.close();
		return count;
	}
	
	public boolean checkBikeExistsInOrder(int bikeId) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql="select * \r\n"
				+ "from Bike\r\n"
				+ "where BikeId in( \r\n"
				+ "				select BikeId\r\n"
				+ "				from OrderDetail join [Order] as o on OrderDetail.OrderId = o.OrderId \r\n"
				+ "				where Status =1 or status=0)\r\n"
				+ "and BikeId = 1";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setInt(1, bikeId);
		ResultSet rs= cmd.executeQuery();
		if(rs.next()) {
			rs.close();
			kn.cn.close();
			return true;
		}
		rs.close();
		kn.cn.close();
		return false;
	}
	
	public int getBikePageCount(String bikeLine, String manufactor, String bikeName, int status, int pageSize) throws Exception {
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();

	    StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM Bike WHERE BikeLine LIKE ? AND BikeManufactor LIKE ? AND BikeName LIKE ?");
	    if (status != -99) {
	        sql.append(" AND Status = ?");
	    }

	    PreparedStatement cmd = kn.cn.prepareStatement(sql.toString());
	    cmd.setString(1, "%" + bikeLine + "%");
	    cmd.setString(2, "%" + manufactor + "%");
	    cmd.setString(3, "%" + bikeName + "%");

	    if (status != -99) {
	        cmd.setInt(4, status);
	    }

	    ResultSet rs = cmd.executeQuery();
	    int count = 0;
	    if (rs.next()) {
	        count = rs.getInt(1);
	    }

	    rs.close();
	    kn.cn.close();

	    return (int) Math.ceil((double) count / pageSize);
	}

	public ArrayList<Bike> searchBikeWithPagination(String bikeLine, String manufactor, String bikeName, int status, int pageNum, int pageSize) throws Exception {
	    ArrayList<Bike> list = new ArrayList<>();
	    KetNoi kn = new KetNoi();
	    kn.ketnoi();

	    StringBuilder sql = new StringBuilder(
	        "SELECT *, (SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo \r\n"
	        + "FROM Bike AS b WHERE Status>-2 AND BikeLine LIKE ? AND BikeManufactor LIKE ? AND BikeName LIKE ?"
	    );

	    if (status != -99) {
	        sql.append(" AND Status = ?");
	    }

	    sql.append(" ORDER BY BikeId OFFSET ((? - 1) * ?) ROWS FETCH NEXT ? ROWS ONLY");

	    PreparedStatement cmd = kn.cn.prepareStatement(sql.toString());
	    cmd.setString(1, "%" + bikeLine + "%");
	    cmd.setString(2, "%" + manufactor + "%");
	    cmd.setString(3, "%" + bikeName + "%");

	    int paramIndex = 4;
	    if (status != -99) {
	        cmd.setInt(paramIndex++, status);
	    }

	    cmd.setInt(paramIndex++, pageNum);
	    cmd.setInt(paramIndex++, pageSize);
	    cmd.setInt(paramIndex, pageSize);

	    ResultSet rs = cmd.executeQuery();
	    while (rs.next()) {
	        int bikeId = rs.getInt("BikeId");
	        String name = rs.getString("BikeName");
	        String licensePlate = rs.getString("LicensePlate");
	        int manufacturingYear = rs.getInt("ManufacturingYear");
	        String BikeLine = rs.getString("BikeLine");
	        String BikeManufactor = rs.getString("BikeManufactor");
	        int bikeStatus = rs.getInt("Status");
	        String description = rs.getString("Description");
	        Long price = rs.getLong("price");
	        String photo = rs.getString("Photo");
	        Date createdTime = rs.getDate("CreatedTime");
	        int ownerId = rs.getInt("ownerId");
	        list.add(new Bike(bikeId, name, licensePlate, manufacturingYear, BikeLine, BikeManufactor, photo, description, price, bikeStatus, createdTime,ownerId));
	    }

	    rs.close();
	    kn.cn.close();
	    return list;	
	}
	
	public boolean acceptBike(int bikeId) throws Exception{
		KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql="Update Bike\r\n"
	    		+ "set Status = 0\r\n"
	    		+ "where BikeId=?	";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setInt(1, bikeId);
	    int rs = cmd.executeUpdate();
	    return rs>0;
	}
	
	
	public boolean deletetBike(int bikeId) throws Exception{
		KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql="delete from Bike\r\n"
	    		+ "where BikeId=?	";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setInt(1, bikeId);
	    int rs = cmd.executeUpdate();
	    return rs>0;
	}


	
	
	
}

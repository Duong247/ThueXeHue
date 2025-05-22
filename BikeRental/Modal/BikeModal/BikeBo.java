package BikeModal;

import java.util.ArrayList;

public class BikeBo {
	BikeDAO bikeDao = new BikeDAO();
	public ArrayList<Bike> getAllBikes() throws Exception{
		return bikeDao.getAllBikes();
	}
	
	public ArrayList<Bike> get_8_Bikes() throws Exception{
		return bikeDao.get_8Bikes();
	}
	
	public ArrayList<Bike> getBikesWithPagination(int page,int pagesize) throws Exception{
		return bikeDao.getBikesWithPagination(page,pagesize);
	}
	
	public int pageCount(int pageSize) throws Exception {
		return bikeDao.PageCount(pageSize);
	}
	
	public ArrayList<String> getBrand()  throws Exception{
		return bikeDao.getBikeBrand();
	}
	
	public Bike getBikeById(int id) throws Exception {
		return bikeDao.getBikeById(id);
	}
	
	public ArrayList<String> getPhotoByBikeId(int id) throws Exception {
		return bikeDao.getPhotoByBikeId(id);
	}
	
	public ArrayList<Bike> getSimilarBikes(int id) throws Exception{
		return bikeDao.getBikeSimilar(id);
	}
	
	public ArrayList<Bike> getOwnerBike(int id) throws Exception{
		return bikeDao.getOwnerBike(id);
	}
	
	public ArrayList<String> getBikePhoto(int id) throws Exception{
		return bikeDao.getBikePhoto(id);
	}
	
	public boolean addBikeWithPhotos(Bike bike,int userId, ArrayList<String> photo) throws Exception {
		return bikeDao.addBikeWithPhotos(bike, userId, photo);
	}
	
	public ArrayList<String> getBikeManufactor() throws Exception{
		return bikeDao.getBikeManufactor();
	}
	
	
	
}

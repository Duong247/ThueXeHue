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
	public ArrayList<String> getBikeLine() throws Exception{
		return bikeDao.getBikeBikeLine();
	}
	
	public boolean updateBikeWithPhotos(Bike bike, ArrayList<String> photo) throws Exception {
		return bikeDao.updateBikeWithPhotos(bike, photo);
	}
	
	public int getCountBikeOfUser(int id) throws Exception {
		return bikeDao.getCountBikeOfUser(id);
	}
	
	public boolean checkBikeExistsInOrder(int bikeId) throws Exception{
		return bikeDao.checkBikeExistsInOrder(bikeId);
	}
	
	public int getBikePageCount(String bikeLine, String manufactor, String bikeName,int Statusid, int pageSize) throws Exception {
		return bikeDao.getBikePageCount(bikeLine, manufactor, bikeName,Statusid, pageSize);
	}
	
	public ArrayList<Bike> searchBikeWithPagination(String bikeLine, String manufactor, String bikeName,int Statusid, int pageNum, int pageSize) throws Exception {
		return bikeDao.searchBikeWithPagination(bikeLine, manufactor, bikeName, Statusid, pageNum, pageSize);
	}
	
	public ArrayList<String> getBikeStatus() throws Exception {
		return bikeDao.getBikeStatus();
	}
	
	public String statusStr(int statusId) throws Exception{
		return bikeDao.statusStr(statusId);
	}
	
	public ArrayList<Integer> getBikeStatusId()throws Exception{
		return bikeDao.getBikeStatusId();
	}
	
	
	public boolean updateDenyBikestatus(int bikeId) throws Exception{
		return bikeDao.updateDenyBikestatus(bikeId);
	}
	
}

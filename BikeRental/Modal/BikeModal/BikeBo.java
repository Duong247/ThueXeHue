package BikeModal;

import java.util.ArrayList;

public class BikeBo {
	BikeDAO bikeDao = new BikeDAO();
	public ArrayList<Bike> getAllBikes() throws Exception{
		return bikeDao.getAllBikes();
	}
	
	public ArrayList<Bike> getBikesWithPagination(int page,int pagesize) throws Exception{
		return bikeDao.getBikesWithPagination(page,pagesize);
	}
}

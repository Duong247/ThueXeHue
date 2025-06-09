package PlotModal;

import java.util.ArrayList;

public class PlotBO {
	PlotDAO pDAO;
	
	public ArrayList<Plot> getRevenueLast7DaysFull(int userId) throws Exception{
		return pDAO.getRevenueLast7DaysFull(userId);
	}
	
	public int BikeInOrderCount(int ownerId) throws Exception{
		return pDAO.BikeInOrderCount(ownerId);
	}
	
	public int totalMoney(int ownerId) throws Exception{
		return pDAO.totalMoney(ownerId);
	}
}

package PlotModal;

import java.util.ArrayList;

public class PlotBO {
	PlotDAO pDAO;
	
	public ArrayList<Plot> getRevenueLast7DaysFull() throws Exception{
		return pDAO.getRevenueLast7DaysFull();
	}
	
	
}

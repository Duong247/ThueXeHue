package SliderModal;

import java.util.ArrayList;

public class SliderBO {
	SliderDAO sDAO = new SliderDAO() ;
	
	public boolean saveSliderImgs(String photo) throws Exception {
		return sDAO.SaveSliderImg(photo);
	}
	
	public ArrayList<Slider> getListSliderPhoto() throws Exception{
		return sDAO.getListSliderPhoto();
	}
}

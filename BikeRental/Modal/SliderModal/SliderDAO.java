package SliderModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModal.KetNoi;

public class SliderDAO {
	public boolean SaveSliderImg(String photo) throws Exception {
		KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "insert into Slider(sliderPhoto)\r\n"
	    		+ "values(?)";
	    PreparedStatement ps = kn.cn.prepareStatement(sql);
	    try {			
	    	ps.setString(1, photo);
	    	int rs = ps.executeUpdate();
	    	return rs>0;
		}finally {
		    ps.close();
		    kn.cn.close();
		}
	}
	
	public ArrayList<Slider> getListSliderPhoto() throws Exception{
		ArrayList<Slider> list = new ArrayList<Slider>();
		KetNoi kn = new KetNoi();
	    kn.ketnoi();
	    String sql = "select * from Slider";
	    PreparedStatement ps = kn.cn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
	    	int id = rs.getInt("sliderId");
	    	String photo = rs.getString("sliderPhoto");
	        list.add(new Slider(id,photo));
	    }
	    rs.close();
	    ps.close();
	    kn.cn.close();

	    return list;
	}
}

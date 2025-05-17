package CartItemModal;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class CartItemBO {
	public Timestamp StringToTimestamp(String dateFormat) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a", new Locale("vi", "VN"));
		LocalDateTime ldt = LocalDateTime.parse(dateFormat, formatter);
		Timestamp timestamp = Timestamp.valueOf(ldt);
		return timestamp;
	}
	
	public boolean checkExists(ArrayList<CartItem> list,CartItem item ) {
		for(CartItem i:list) {
			if(item.getBikeId() == i.getBikeId()) {
				return true;
			}
		}
		return false;
	}
	
	
}

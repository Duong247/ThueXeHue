package CartItemModal;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CartItemBO {
	CartItemDAO cdao= new CartItemDAO();
	public Timestamp StringToTimestamp(String dateFormat) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a", new Locale("vi", "VN"));
		LocalDateTime ldt = LocalDateTime.parse(dateFormat, formatter);
		Timestamp timestamp = Timestamp.valueOf(ldt);
		return timestamp;
	}
	
	public String timestampToString(Timestamp timestamp) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a", new Locale("vi", "VN"));
	    LocalDateTime ldt = timestamp.toLocalDateTime();
	    return ldt.format(formatter);
	}

	
	public boolean checkExists(ArrayList<CartItem> list,CartItem item ) {
		for(CartItem i:list) {
			if(item.getBikeId() == i.getBikeId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean createOrder(int bikeId, long rentalFee, Timestamp pickupDate, Timestamp returnDate,
			int userId, String pickupPlace, String returnPlace) throws Exception {
		return cdao.addNewOrder(bikeId, rentalFee, pickupDate, returnDate, userId, pickupPlace, returnPlace);
	}
	public boolean createOrder2(int userId, String pickupPlace, String returnPlace,ArrayList<CartItem> details ) throws Exception {
		return cdao.addNewOrderWithDetails(userId, pickupPlace, returnPlace,details);
	}
	
	public ArrayList<CartItem>getOrderHistoryByUserId(int userId) throws Exception{
		return cdao.getOrderHistoryByUserId(userId);
	}
	
	public long getRentalDays(Timestamp returnDate,Timestamp pickupDate) {
	    long millis = returnDate.getTime() - pickupDate.getTime();
	    return TimeUnit.DAYS.convert(millis, TimeUnit.MILLISECONDS);
	}
}

package CartItemModal;

import java.security.Timestamp;


public class CartItem {
	private int bikeId;
	private long rentalFee;
	private Timestamp pickupDate;
	private Timestamp returnDate;
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(int bikeId, long rentalFee, Timestamp pickupDate, Timestamp returnDate) {
		super();
		this.bikeId = bikeId;
		this.rentalFee = rentalFee;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
	}
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public long getRentalFee() {
		return rentalFee;
	}
	public void setRentalFee(long rentalFee) {
		this.rentalFee = rentalFee;
	}
	public Timestamp getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(Timestamp pickupDate) {
		this.pickupDate = pickupDate;
	}
	public Timestamp getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}
	
	
}

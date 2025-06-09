package CartItemModal;


import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CartItem {
	private int bikeId;
	private String bikeName;
	private String licensePlate;
	private int manufacturingYear;
	private String BikeLine;
	private String BikeManufactor;
	private String Photo;
	private String Description;
	private long rentalFee;
	private int ownerId;
	private Timestamp pickupDate;
	private Timestamp returnDate;
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public CartItem(int bikeId, String bikeName, String licensePlate, int manufacturingYear, String bikeLine,
			String bikeManufactor, String photo, String description, long rentalFee, int ownerId, Timestamp pickupDate,
			Timestamp returnDate) {
		super();
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.licensePlate = licensePlate;
		this.manufacturingYear = manufacturingYear;
		BikeLine = bikeLine;
		BikeManufactor = bikeManufactor;
		Photo = photo;
		Description = description;
		this.rentalFee = rentalFee;
		this.ownerId = ownerId;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
	}


	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public int getManufacturingYear() {
		return manufacturingYear;
	}
	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}
	public String getBikeLine() {
		return BikeLine;
	}
	public void setBikeLine(String bikeLine) {
		BikeLine = bikeLine;
	}
	public String getBikeManufactor() {
		return BikeManufactor;
	}
	public void setBikeManufactor(String bikeManufactor) {
		BikeManufactor = bikeManufactor;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
	
	public String getPickupDateFormatted() {
	    if (pickupDate == null) return "";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", new Locale("vi", "VN"));
	    return pickupDate.toLocalDateTime().format(formatter);
	}
	
	public String getReturnDateFormatted() {
	    if (returnDate == null) return "";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", new Locale("vi", "VN"));
	    return returnDate.toLocalDateTime().format(formatter);
	}


	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	public long getRentalDays() {
	    long millis = this.returnDate.getTime() - this.pickupDate.getTime();
	    return TimeUnit.DAYS.convert(millis, TimeUnit.MILLISECONDS);
	}
	
	public long getSubtotal() {
		return this.rentalFee*this.getRentalDays();
	}
	
	
}

package BikeModal;

public class Bike {
	private int bikeId;
	private String bikeName;
	private String licensePlate;
	private int manufacturingYear;
	private String BikeLine;
	private String BikeManufactor;
	private String Photo;
	private int status;
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bike(int bikeId, String bikeName, String licensePlate, int manufacturingYear, String bikeLine,
			String bikeManufactor, String photo, int status) {
		super();
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.licensePlate = licensePlate;
		this.manufacturingYear = manufacturingYear;
		BikeLine = bikeLine;
		BikeManufactor = bikeManufactor;
		Photo = photo;
		this.status = status;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}

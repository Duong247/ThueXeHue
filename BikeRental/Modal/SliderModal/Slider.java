package SliderModal;

public class Slider {
	private int PhotoId;
	private String photo;
	public Slider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Slider(int photoId, String photo) {
		super();
		PhotoId = photoId;
		this.photo = photo;
	}
	public int getPhotoId() {
		return PhotoId;
	}
	public void setPhotoId(int photoId) {
		PhotoId = photoId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}

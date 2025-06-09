package OrderModal;

import java.sql.Timestamp;
import java.util.ArrayList;

import CartItemModal.CartItem;

public class Order {
	private int orderId;
    private Timestamp orderDate;
    private String pickupPlace;
    private String returnPlace;
    private int status;
    private ArrayList<CartItem> items = new ArrayList<>();
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, Timestamp orderDate, String pickupPlace, String returnPlace, int status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.pickupPlace = pickupPlace;
		this.returnPlace = returnPlace;
		this.status = status;
		this.items = new ArrayList<>();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getPickupPlace() {
		return pickupPlace;
	}
	public void setPickupPlace(String pickupPlace) {
		this.pickupPlace = pickupPlace;
	}
	public String getReturnPlace() {
		return returnPlace;
	}
	public void setReturnPlace(String returnPlace) {
		this.returnPlace = returnPlace;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ArrayList<CartItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}
	
	public void addItem(CartItem item) {
        this.items.add(item);
    }
	
	public Order(ArrayList<CartItem> items) {
        this.items = items;
    }

	public double getTotal() {
	    return items.stream()
	                .mapToDouble(item -> item.getSubtotal())
	                .sum();
	}
	
	
    
    
}

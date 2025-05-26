package PlotModal;

public class Plot {
	private String dayLabel;
	private long totalRevenue;
	public Plot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plot(String dayLabel, long totalRevenue) {
		super();
		this.dayLabel = dayLabel;
		this.totalRevenue = totalRevenue;
	}
	public String getDayLabel() {
		return dayLabel;
	}
	public void setDayLabel(String dayLabel) {
		this.dayLabel = dayLabel;
	}
	public long getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(long totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	
}

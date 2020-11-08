package dto;

public class DashboardDTO {
	
	int numberUser,numberCourse,numberOrder ;
	float totalEarning;
	public int getNumberUser() {
		return numberUser;
	}
	public void setNumberUser(int numberUser) {
		this.numberUser = numberUser;
	}
	public int getNumberCourse() {
		return numberCourse;
	}
	public void setNumberCourse(int numberCourse) {
		this.numberCourse = numberCourse;
	}
	public int getNumberOrder() {
		return numberOrder;
	}
	public void setNumberOrder(int numberOrder) {
		this.numberOrder = numberOrder;
	}
	public float getTotalEarning() {
		return totalEarning;
	}
	public void setTotalEarning(float totalEarning) {
		this.totalEarning = totalEarning;
	}
	public DashboardDTO(int numberUser, int numberCourse, int numberOrder, float totalEarning) {
		super();
		this.numberUser = numberUser;
		this.numberCourse = numberCourse;
		this.numberOrder = numberOrder;
		this.totalEarning = totalEarning;
	}
	@Override
	public String toString() {
		return "DashboardDTO [numberUser=" + numberUser + ", numberCourse=" + numberCourse + ", numberOrder="
				+ numberOrder + ", totalEarning=" + totalEarning + "]";
	}
	
	
	
	
	

}

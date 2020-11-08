package dto;

public class CourseofUserDTO {
	
	String nameCourse, dateBuy;

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public String getDateBuy() {
		return dateBuy;
	}

	public void setDateBuy(String dateBuy) {
		this.dateBuy = dateBuy;
	}

	public CourseofUserDTO(String nameCourse, String dateBuy) {
		super();
		this.nameCourse = nameCourse;
		this.dateBuy = dateBuy;
	}

	@Override
	public String toString() {
		return "CourseofUserDTO [nameCourse=" + nameCourse + ", dateBuy=" + dateBuy + "]";
	}
	
	

}

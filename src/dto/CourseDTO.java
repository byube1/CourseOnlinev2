/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author WIN 10
 */
public class CourseDTO {

    private String courseID, CategoryID,categoryName;
    private String courseName, courseTime, certificate, courseDescription;
    private double coursePrice;
    private int numberOfStudent;
    private String img;

    public CourseDTO() {
    }

    public CourseDTO(String courseID, String CategoryID, String courseName, String courseTime, String certificate, String courseDescription, double coursePrice, int numberOfStudent, String img) {
        this.courseID = courseID;
        this.CategoryID = CategoryID;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.certificate = certificate;
        this.courseDescription = courseDescription;
        this.coursePrice = coursePrice;
        this.numberOfStudent = numberOfStudent;
        this.img = img;
    }
    
    public CourseDTO(String courseID, String CategoryID, String categoryName,String courseName, String courseTime, String certificate, String courseDescription, double coursePrice, int numberOfStudent, String img) {
        this.courseID = courseID;
        this.CategoryID = CategoryID;
        this.categoryName = categoryName;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.certificate = certificate;
        this.courseDescription = courseDescription;
        this.coursePrice = coursePrice;
        this.numberOfStudent = numberOfStudent;
        this.img = img;
    }
    public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

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
public class ShoppingCartItem {

    private CourseDTO course;
    private int quantity;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(CourseDTO course, int quantity) {
        this.course = course;
        this.quantity = quantity;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

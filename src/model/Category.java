/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Category implements java.io.Serializable{
    int IDCategory;
    String Category;

    public Category() {
    }

    public Category(int IDCategory, String Category) {
        this.IDCategory = IDCategory;
        this.Category = Category;
    }

    public int getIDCategory() {
        return IDCategory;
    }

    public void setIDCategory(int IDCategory) {
        this.IDCategory = IDCategory;
    }

    
    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    @Override
    public String toString() {
        return "Category{" + "IDCategory=" + IDCategory + ", Category=" + Category + '}';
    }
    
}

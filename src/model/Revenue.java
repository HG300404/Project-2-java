/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Revenue implements java.io.Serializable {
    String Date,ProductName, Price,Total,Quantity;
    
    public Revenue() {
    }

    public Revenue(String Date, String ProductName, String Price,String Quantity, String Total) {
        this.Date = Date;
        this.ProductName = ProductName;
        this.Price = Price;
        this.Total = Total;
        this.Quantity = Quantity;
    }
  
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    

    @Override
    public String toString() {
        return "Revenue{" + "Date=" + Date + ", ProductName=" + ProductName + ", Price=" + Price + ", Total=" + Total + ", Quantity=" + Quantity + '}';
    }

    
}

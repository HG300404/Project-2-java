/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Product implements java.io.Serializable{
    int IDProduct,Amount,PriceBuy,PriceSell;
    String ProductName,TypeName;

    public Product() {
    }

    public Product(int IDProduct) {
        this.IDProduct = IDProduct;
    }

    public Product(int IDProduct, String TypeName, String ProductName,int Amount, int PriceBuy, int PriceSell) {
        this.IDProduct = IDProduct;
        this.Amount = Amount;
        this.PriceBuy = PriceBuy;
        this.PriceSell = PriceSell;
        this.ProductName = ProductName;
        this.TypeName = TypeName;
    }

    

    public int getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(int IDProduct) {
        this.IDProduct = IDProduct;
    }

    
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    
    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public int getPriceBuy() {
        return PriceBuy;
    }

    public void setPriceBuy(int PriceBuy) {
        this.PriceBuy = PriceBuy;
    }

    public int getPriceSell() {
        return PriceSell;
    }

    public void setPriceSell(int PriceSell) {
        this.PriceSell = PriceSell;
    }

    @Override
    public String toString() {
        return "Product{" + "IDProduct=" + IDProduct + ", Amount=" + Amount + ", PriceBuy=" + PriceBuy + ", PriceSell=" + PriceSell + ", ProductName=" + ProductName + ", TypeName=" + TypeName + '}';
    }

    
    

}

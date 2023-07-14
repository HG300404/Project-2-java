/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Bill implements java.io.Serializable{
   int ID;
   String CusName;
   String Phone;
   String Email;
   String Date;
   String Total;
   String NameEmp;

    public Bill() {
    }

    public Bill(int ID, String CusName, String Phone, String Email, String Date, String Total, String NameEmp) {
        this.ID = ID;
        this.CusName = CusName;
        this.Phone = Phone;
        this.Email = Email;
        this.Date = Date;
        this.Total = Total;
        this.NameEmp = NameEmp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getNameEmp() {
        return NameEmp;
    }

    public void setNameEmp(String NameEmp) {
        this.NameEmp = NameEmp;
    }
       
   
}

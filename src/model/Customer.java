/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Customer implements java.io.Serializable{
    int IDCus;
    String CusName;
    String DateAdd;
    String Phone;
    String Email;
    int Unpaid;

    public Customer() {
    }

    public Customer(int IDCus, String CusName, String DateAdd, String Phone, String Email, int Unpaid) {
        this.IDCus = IDCus;
        this.CusName = CusName;
        this.DateAdd = DateAdd;
        this.Phone = Phone;
        this.Email = Email;
        this.Unpaid = Unpaid;
    }

    

    public int getIDCus() {
        return IDCus;
    }

    public void setIDCus(int IDCus) {
        this.IDCus = IDCus;
    }


    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getDateAdd() {
        return DateAdd;
    }

    public void setDateAdd(String DateAdd) {
        this.DateAdd = DateAdd;
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

    public int getUnpaid() {
        return Unpaid;
    }

    public void setUnpaid(int Unpaid) {
        this.Unpaid = Unpaid;
    }

    @Override
    public String toString() {
        return "Customer{" + "IDCus=" + IDCus + ", CusName=" + CusName + ", DateAdd=" + DateAdd + ", Phone=" + Phone + ", Email=" + Email + ", Unpaid=" + Unpaid + '}';
    }

    
   

     
    
}

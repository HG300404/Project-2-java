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
public class Supplier implements java.io.Serializable{
    int IDSup;
    String SupName;
    String DateAdd;
    String Phone;
    String Email;

    public Supplier() {
    }

    public Supplier(int IDSup, String SupName, String DateAdd, String Phone, String Email) {
        this.IDSup = IDSup;
        this.SupName = SupName;
        this.DateAdd = DateAdd;
        this.Phone = Phone;
        this.Email = Email;
    }

    public int getIDSup() {
        return IDSup;
    }

    public void setIDSup(int IDSup) {
        this.IDSup = IDSup;
    }

    public String getSupName() {
        return SupName;
    }

    public void setSupName(String SupName) {
        this.SupName = SupName;
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

    @Override
    public String toString() {
        return "Supplier{" + "IDSup=" + IDSup + ", SupName=" + SupName + ", DateAdd=" + DateAdd + ", Phone=" + Phone + ", Email=" + Email + '}';
    }


}

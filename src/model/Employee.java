/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author Administrator
 */
public class Employee implements java.io.Serializable {
    int IDEmp;
    String NameEmp;
    String Phone;
    String Email;

    public Employee() {
    }

    public Employee(int IDEmp, String NameEmp, String Phone, String Email) {
        this.IDEmp = IDEmp;
        this.NameEmp = NameEmp;
        this.Phone = Phone;
        this.Email = Email;
    }

    public int getIDEmp() {
        return IDEmp;
    }

    public void setIDEmp(int IDEmp) {
        this.IDEmp = IDEmp;
    }

    
    public String getNameEmp() {
        return NameEmp;
    }

    public void setNameEmp(String NameEmp) {
        this.NameEmp = NameEmp;
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
        return "Employee{" + "IDEmp=" + IDEmp + ", NameEmp=" + NameEmp + ", Phone=" + Phone + ", Email=" + Email + '}';
    }

 
    
   
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Administrator
 */
public class User implements java.io.Serializable{
    String UserName,Password,Role;
    int IDUser;

    public User() {
     //   super();
    }

    public User(String UserName, String Password, String Role, int IDUser) {
        this.UserName = UserName;
        this.Password = Password;
        this.Role = Role;
        this.IDUser = IDUser;
    }

   

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    @Override
    public String toString() {
        return "User{" + "UserName=" + UserName + ", Password=" + Password + ", Role=" + Role + ", IDUser=" + IDUser + '}';
    }

    
   
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class Server extends UnicastRemoteObject implements DAOInterface {

    public Server() throws RemoteException {
//        super();
    }

    public static void main(String[] args) throws RemoteException {
        try {
            Registry reg = LocateRegistry.createRegistry(9999);
            reg.rebind("db", new Server());
            System.out.println("Server is ready");
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }

    @Override
    public int insertEmp(int id, String name, String phone, String email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO employee(IDEmp, NameEmp, Phone, Email)"
                    + " VALUES('" + id + "','" + name + "','"
                    + phone + "','" + email + "'" + ")";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int updateEmp(int id, String name, String phone, String email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE employee "
                    + " SET "
                    //                    + " IDEmp='" + id + "'"
                    //                    + ", NameEmp='" + name + "'"
                    + " Phone='" + phone + "'"
                    + ", Email='" + email + "'"
                    + " WHERE IDEmp='" + id + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteEmp(int id, String name, String phone, String email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "DELETE from employee "
                    + " WHERE IDEmp='" + id + "'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Employee> selectAllEmp() throws RemoteException {
        ArrayList<Employee> ketQua = new ArrayList<Employee>();
        try {

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM employee ";
            //ORDER BY IDEmp 
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
                String NameEmp = rs.getString("NameEmp");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");

                Employee employee = new Employee(IDEmp, NameEmp, Phone, Email);
                ketQua.add(employee);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Employee> selectByConditionEmp(String condition) throws RemoteException {
        ArrayList<Employee> ketQua = new ArrayList<Employee>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM employee WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
                String NameEmp = rs.getString("NameEmp");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");

                Employee employee = new Employee(IDEmp, NameEmp, Phone, Email);
                ketQua.add(employee);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public String getIDEmp() throws RemoteException {
        int id = 1;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "select max(IDEmp) from employee";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    @Override
    public int insertUser(String UserName, String Password, String Role, int IDUser) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String enrText = null;
//            enrText = MD5Encryptor.encrypt(Password);
            enrText = encrypt(Password);
            String sql = "INSERT INTO user(UserName,Password,Role,IDUser)"
                    + " VALUES('" + UserName + "','" + enrText + "','" + Role + "','" + IDUser + "'" + ")";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int updateUser(String UserName, String Password, String Role, int IDUser) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String enrText = null;
            enrText = encrypt(Password);
            String sql = "UPDATE user "
                    + " SET "
                    + //    " UserName='"+t.getUserName()+"'"+                
                    " Password='" + enrText + "'"
                    + ", Role='" + Role + "'"
                    + //    ", IDUser='"+t.getIDUser()+"'"+
                    " WHERE UserName='" + UserName + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteUser(String UserName, String Password, String Role, int IDUser) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "DELETE from user "
                    + " WHERE UserName='" + UserName + "'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectAllUser() throws RemoteException {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM user";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String UserName = rs.getString("UserName");
                String Password = rs.getString("Password");
                String Role = rs.getString("Role");
                int IDUser = Integer.parseInt(rs.getString("IDUser"));

                User user = new User(UserName, Password, Role, IDUser);
                ketQua.add(user);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectByConditionUser(String condition) throws RemoteException {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM user WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String UserName = rs.getString("UserName");
                String Password = rs.getString("Password");
                String Role = rs.getString("Role");
                int IDUser = Integer.parseInt(rs.getString("IDUser"));

                User user = new User(UserName, Password, Role, IDUser);
                ketQua.add(user);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public String getIDUser() throws RemoteException {
        int id = 1;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "select max(IDUser) from user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    @Override
    public int insertCus(int IDCus, String CusName, String DateAdd, String Phone, String Email, int Unpaid) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO customer(IDCus, CusName, DateAdd, Phone, Email,Unpaid)"
                    + " VALUES('" + IDCus + "','" + CusName + "','" + DateAdd + "','"
                    + Phone + "','" + Email + "','" + Unpaid + "'" + ")";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int updateCus(int IDCus, String CusName, String DateAdd, String Phone, String Email, int Unpaid) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE customer "
                    + " SET "
                    + //   " IDCus='"+t.getIDCus()+"'"+
                    //    ", CusName='"+t.getCusName()+"'"+
                    " DateAdd='" + DateAdd + "'"
                    + ", Phone='" + Phone + "'"
                    + ", Email='" + Email + "'"
                    + ", Unpaid='" + Unpaid + "'"
                    + " WHERE IDCus='" + IDCus + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteCus(int IDCus, String CusName, String DateAdd, String Phone, String Email, int Unpaid) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "DELETE from customer "
                    + " WHERE IDCus='" + IDCus + "'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Customer> selectAllCus() throws RemoteException {
        ArrayList<Customer> ketQua = new ArrayList<Customer>();
        try {

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM customer";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDCus = Integer.parseInt(rs.getString("IDCus"));
                String CusName = rs.getString("CusName");
                String DateAdd = rs.getString("DateAdd");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");
                int Unpaid = Integer.parseInt(rs.getString("Unpaid"));
                Customer customer = new Customer(IDCus, CusName, DateAdd, Phone, Email, Unpaid);
                ketQua.add(customer);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Customer> selectByConditionCus(String condition) throws RemoteException {
        ArrayList<Customer> ketQua = new ArrayList<Customer>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM customer WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDCus = Integer.parseInt(rs.getString("IDCus"));
                String CusName = rs.getString("CusName");
                String DateAdd = rs.getString("DateAdd");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");
                int Unpaid = Integer.parseInt(rs.getString("Unpaid"));

                Customer customer = new Customer(IDCus, CusName, DateAdd, Phone, Email, Unpaid);
                ketQua.add(customer);

            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public String getIDCus() throws RemoteException {
        int id = 1;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "select max(IDCus) from customer";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    @Override
    public int insertPro(int IDProduct, String TypeName, String ProductName, int Amount, int PriceBuy, int PriceSell) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO product(IDProduct, ProductName, TypeName, Amount, PriceBuy,PriceSell)"
                    + " VALUES('" + IDProduct + "','" + ProductName + "','" + TypeName + "','" + Amount + "','" + PriceBuy + "','" + PriceSell + "'" + ")";

            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int updatePro(int IDProduct, String TypeName, String ProductName, int Amount, int PriceBuy, int PriceSell) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE product "
                    + " SET "
                    + //     " TypeName='"+t.getTypeName()+"'"+
                    //      " ProductName='"+t.getProductName()+"'"+
                    //      ", Amount='"+t.getAmount()+"'"+
                    " PriceBuy='" + PriceBuy + "'"
                    + ", PriceSell='" + PriceSell + "'"
                    + " WHERE IDProduct='" + IDProduct + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deletePro(int IDProduct, String TypeName, String ProductName, int Amount, int PriceBuy, int PriceSell) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "DELETE from product "
                    + " WHERE IDProduct='" + IDProduct + "'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Product> selectAllPro() throws RemoteException {
        ArrayList<Product> ketQua = new ArrayList<Product>();
        try {

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM product";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDProduct = Integer.parseInt(rs.getString("IDProduct"));
                String ProductName = rs.getString("ProductName");
                String TypeName = rs.getString("TypeName");
                int Amount = Integer.parseInt(rs.getString("Amount"));
                int PriceBuy = Integer.parseInt(rs.getString("PriceBuy"));
                int PriceSell = Integer.parseInt(rs.getString("PriceSell"));
                Product product = new Product(IDProduct, TypeName, ProductName, Amount, PriceBuy, PriceSell);
                ketQua.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Product> selectByConditionPro(String condition) throws RemoteException {
        ArrayList<Product> ketQua = new ArrayList<Product>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM product WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDProduct = Integer.parseInt(rs.getString("IDProduct"));
                String ProductName = rs.getString("ProductName");
                String TypeName = rs.getString("TypeName");
                int Amount = Integer.parseInt(rs.getString("Amount"));
                int PriceBuy = Integer.parseInt(rs.getString("PriceBuy"));
                int PriceSell = Integer.parseInt(rs.getString("PriceSell"));
                Product product = new Product(IDProduct, TypeName, ProductName, Amount, PriceBuy, PriceSell);
                ketQua.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public String getIDPro() throws RemoteException {
        int id = 1;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "select max(IDProduct) from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    @Override
    public int insertCat(int IDCategory, String Category) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO category(IDCategory,Category)"
                    + " VALUES('" + IDCategory + "','" + Category + "'" + ")";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int updateCat(int IDCategory, String Category) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE Category "
                    + " SET "
                    + " Category='" + Category + "'"
                    + " WHERE IDCategory='" + IDCategory + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteCat(int IDCategory, String Category) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "DELETE from category "
                    + " WHERE IDCategory='" + IDCategory + "'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Category> selectAllCat() throws RemoteException {
        ArrayList<Category> ketQua = new ArrayList<Category>();
        try {

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM category";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDCategory = Integer.parseInt(rs.getString("IDCategory"));
                String Category = rs.getString("Category");
                Category category = new Category(IDCategory, Category);
                ketQua.add(category);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Category> selectByConditionCat(String condition) throws RemoteException {
        ArrayList<Category> ketQua = new ArrayList<Category>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM category WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDCategory = Integer.parseInt(rs.getString("IDCategory"));
                String Category = rs.getString("Category");
                Category category = new Category(IDCategory, Category);
                ketQua.add(category);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public String getIDCat() throws RemoteException {
        int id = 1;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "select max(IDCategory) from category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    @Override
    public int insertInfor(int IDEmp, String NameEmp, String Phone, String Email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO Infor(IDEmp, NameEmp, Phone, Email)"
                    + " VALUES('" + IDEmp + "','" + NameEmp + "','"
                    + Phone + "','" + Email + "'" + ")";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int updateInfor(int IDEmp, String NameEmp, String Phone, String Email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE infor "
                    + " SET "
                    + //    ", NameEmp='"+t.getNameEmp()+"'"+
                    //     ", Phone='"+t.getPhone()+"'"+
                    " Email='" + Email + "'"
                    + " WHERE IDEmp='" + IDEmp + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteInfor(int IDEmp, String NameEmp, String Phone, String Email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "DELETE from infor "
                    + " WHERE IDEmp='" + IDEmp + "'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Infor> selectAllInfor() throws RemoteException {
        ArrayList<Infor> ketQua = new ArrayList<Infor>();
        try {

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM infor";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
                String NameEmp = rs.getString("NameEmp");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");

                Infor infor = new Infor(IDEmp, NameEmp, Phone, Email);
                ketQua.add(infor);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Infor> selectByConditionInfor(String condition) throws RemoteException {
        ArrayList<Infor> ketQua = new ArrayList<Infor>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM infor WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDEmp = Integer.parseInt(rs.getString("IDEmp"));
                String NameEmp = rs.getString("NameEmp");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");

                Infor infor = new Infor(IDEmp, NameEmp, Phone, Email);
                ketQua.add(infor);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insertSup(int IDSup, String SupName, String DateAdd, String Phone, String Email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO supplier(IDSup,SupName,DateAdd,Phone,Email)"
                    + " VALUES('" + IDSup + "','" + SupName + "','" + DateAdd + "','" + Phone + "','" + Email + "'" + ")";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int updateSup(int IDSup, String SupName, String DateAdd, String Phone, String Email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE suplier "
                    + " SET "
                    + ", SupName='" + SupName + "'"
                    + ", DateAdd='" + DateAdd + "'"
                    + ", Phone='" + Phone + "'"
                    + ", Email='" + Email + "'"
                    + " WHERE IDSup='" + IDSup + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteSup(int IDSup, String SupName, String DateAdd, String Phone, String Email) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "DELETE from supplier "
                    + " WHERE IDSup='" + IDSup + "'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Supplier> selectAllSup() throws RemoteException {
        ArrayList<Supplier> ketQua = new ArrayList<Supplier>();
        try {

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM supplier";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDSup = Integer.parseInt(rs.getString("IDSup"));
                String SupName = rs.getString("SupName");
                String DateAdd = rs.getString("DateAdd");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");

                Supplier supplier = new Supplier(IDSup, SupName, DateAdd, Phone, Email);
                ketQua.add(supplier);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Supplier> selectByConditionSup(String condition) throws RemoteException {
        ArrayList<Supplier> ketQua = new ArrayList<Supplier>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM supplier WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int IDSup = Integer.parseInt(rs.getString("IDSup"));
                String SupName = rs.getString("SupName");
                String DateAdd = rs.getString("DateAdd");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");

                Supplier supplier = new Supplier(IDSup, SupName, DateAdd, Phone, Email);
                ketQua.add(supplier);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public String getIDSup() throws RemoteException {
        int id = 1;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "select max(IDSup) from supplier";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    @Override
    public int insertRev(String Date, String ProductName, String Price, String Quantity, String Total) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO revenue(Date,ProductName,Price,Quantity,Total)"
                    + " VALUES('" + Date + "','" + ProductName + "','" + Price + "','" + Quantity + "','" + Total + "'" + ")";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;

    }

    @Override
    public int updateRev(String Date, String ProductName, String Price, String Quantity, String Total) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE revenue "
                    + " SET "
                    + " ProductName='" + ProductName + "'"
                    + ", Price='" + Price + "'"
                    + ", Total='" + Total + "'"
                    + ", Quantity='" + Quantity + "'"
                    + " WHERE Date='" + Date + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteRev(String Date, String ProductName, String Price, String Quantity, String Total) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "DELETE from revenue "
                    + " WHERE Date='" + Date + "' and ProductName ='" + ProductName + "'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Revenue> selectAllRev() throws RemoteException {
        ArrayList<Revenue> ketQua = new ArrayList<Revenue>();
        try {

            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM revenue";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String Date = rs.getString("Date");
                String ProductName = rs.getString("ProductName");
                String Price = rs.getString("Price");
                String Quantity = rs.getString("Quantity");
                String Total = rs.getString("Total");
                Revenue revenue = new Revenue(Date, ProductName, Price, Quantity, Total);
                ketQua.add(revenue);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Revenue> selectByConditionRev(String condition) throws RemoteException {
        ArrayList<Revenue> ketQua = new ArrayList<Revenue>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM revenue WHERE " + condition;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String Date = rs.getString("Date");
                String ProductName = rs.getString("ProductName");
                String Price = rs.getString("Price");
                String Quantity = rs.getString("Quantity");
                String Total = rs.getString("Total");

                Revenue revenue = new Revenue(Date, ProductName, Price, Quantity, Total);
                ketQua.add(revenue);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Revenue selectByDateRev(Revenue t) throws RemoteException {
        Revenue ketQua = null;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT * FROM revenue WHERE Date='" + t.getDate() + "'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String Date = rs.getString("Date");
                String ProductName = rs.getString("ProductName");
                String Price = rs.getString("Price");
                String Quantity = rs.getString("Quantity");
                String Total = rs.getString("Total");

                ketQua = new Revenue(Date, ProductName, Price, Quantity, Total);

            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Product getProductBuyByName(String name) throws RemoteException {
        Product p = new Product();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "select * from product where ProductName='" + name + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                p.setProductName(rs.getString("ProductName"));
                p.setTypeName(rs.getString("TypeName"));
                p.setPriceBuy(Integer.parseInt(rs.getString("PriceBuy")));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Product getProductSellByName(String name) throws RemoteException {
        Product p = new Product();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "select * from product where ProductName='" + name + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                p.setProductName(rs.getString("ProductName"));
                p.setTypeName(rs.getString("TypeName"));
                p.setPriceSell(Integer.parseInt(rs.getString("PriceSell")));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public int updateByProductName(String name, int amount) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE product "
                    + " SET "
                    + " Amount='" + amount + "'"
                    + " WHERE ProductName='" + name + "\'";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;

    }

    @Override
    public String getIDBill() throws RemoteException {
        int id = 1;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "select max(ID) from bill";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    @Override
    public void saveBill(Bill bill) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "insert into bill values ('" + bill.getID() + "','" + bill.getCusName() + "','" + bill.getPhone() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getNameEmp() + "')";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getIDImport() throws RemoteException {
        int id = 1;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "select max(ID) from input";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    @Override
    public void saveImport(Input input) throws RemoteException {
        int ketQua = 0;
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            Statement st = conn.createStatement();
            String sql = "insert into input values ('" + input.getID() + "','" + input.getSupName() + "','" + input.getPhone() + "','" + input.getEmail() + "','" + input.getDate() + "','" + input.getTotal() + "','" + input.getNameEmp() + "')";
            ketQua = st.executeUpdate(sql);
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public List<RevenueBean> getListRevenue() throws RemoteException {
        List<RevenueBean> list = new ArrayList<>();
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            String sql = "SELECT Date, Sum(Total) AS Sum FROM revenue GROUP BY Date";
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RevenueBean revenueBean = new RevenueBean();
                revenueBean.setDate(rs.getString("Date"));
                revenueBean.setTotal((int) Double.parseDouble(rs.getString("Sum")));
                list.add(revenueBean);
            }
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    @Override
    public String encrypt(String srcText) throws RemoteException{
        String enrText;
        
        MessageDigest msd = null;
        try {
            msd = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] srcTextBytes = null;
        try {
            srcTextBytes = srcText.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] enrTextBytes = msd.digest(srcTextBytes);
                
        BigInteger bigInt = new BigInteger(1, enrTextBytes);
        enrText =  bigInt.toString(32);
        return enrText;    
    }

    @Override
    public void openFile(String file) throws RemoteException {
        try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch(IOException ioe){
            System.out.println(ioe);
        }
    }

    @Override
    public void exportarExcel(JTable jt) throws RemoteException {
         try{
           JFileChooser jFileChooser = new JFileChooser();
           jFileChooser.showSaveDialog(jt);
           File saveFile = jFileChooser.getSelectedFile();
           if (saveFile != null){
               saveFile = new File (saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("film");
               Row rowCol = sheet.createRow(0);
               
               for (int i=0; i<jt.getColumnCount();++i){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(jt.getColumnName(i));
               }
               
               for (int j=0; j<jt.getRowCount(); j++){
                   Row row = sheet.createRow(j+1);
                   for (int k =0; k<jt.getColumnCount(); k++){
                       Cell cell = row.createCell(k);
                       if (jt.getValueAt(j,k) != null){
                           cell.setCellValue(jt.getValueAt(j, k).toString());
                       }
                   }
               }
               
               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
               wb.write(out);
               wb.close();
               out.close();
               openFile(saveFile.toString());
           } else {
               JOptionPane.showMessageDialog(null,"File is not Exists");
           }
       }
           catch(FileNotFoundException e)
                   {
                 System.out.println(e);
                   } 
           catch(IOException io){
                   System.out.println(io);
                      }
           
    }

}

package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Administrator
 */
public interface DAOInterface extends Remote {
//    Employee

    public int insertEmp(int id, String name, String phone, String email) throws RemoteException;

    public int updateEmp(int id, String name, String phone, String email) throws RemoteException;

    public int deleteEmp(int id, String name, String phone, String email) throws RemoteException;

    public ArrayList<Employee> selectAllEmp() throws RemoteException;
//    public Employee selectByIdEmp(Employee t) throws RemoteException;  

    public ArrayList<Employee> selectByConditionEmp(String condition) throws RemoteException;

    public String getIDEmp() throws RemoteException;
//    User

    public int insertUser(String UserName, String Password, String Role, int IDUser) throws RemoteException;

    public int updateUser(String UserName, String Password, String Role, int IDUser) throws RemoteException;

    public int deleteUser(String UserName, String Password, String Role, int IDUser) throws RemoteException;

    public ArrayList<User> selectAllUser() throws RemoteException;

    public ArrayList<User> selectByConditionUser(String condition) throws RemoteException;

    public String getIDUser() throws RemoteException;
////    Customer

    public int insertCus(int IDCus, String CusName, String DateAdd, String Phone, String Email, int Unpaid) throws RemoteException;

    public int updateCus(int IDCus, String CusName, String DateAdd, String Phone, String Email, int Unpaid) throws RemoteException;

    public int deleteCus(int IDCus, String CusName, String DateAdd, String Phone, String Email, int Unpaid) throws RemoteException;

    public ArrayList<Customer> selectAllCus() throws RemoteException;

    public ArrayList<Customer> selectByConditionCus(String condition) throws RemoteException;

    public String getIDCus() throws RemoteException;

//    public ArrayList<Customer> filterUnpaidByName(String name) throws RemoteException;
//    Product
    public int insertPro(int IDProduct, String TypeName, String ProductName, int Amount, int PriceBuy, int PriceSell) throws RemoteException;

    public int updatePro(int IDProduct, String TypeName, String ProductName, int Amount, int PriceBuy, int PriceSell) throws RemoteException;

    public int deletePro(int IDProduct, String TypeName, String ProductName, int Amount, int PriceBuy, int PriceSell) throws RemoteException;

    public ArrayList<Product> selectAllPro() throws RemoteException;

    public ArrayList<Product> selectByConditionPro(String condition) throws RemoteException;

    public String getIDPro() throws RemoteException;

    public int updateByProductName(String name, int amount) throws RemoteException;
//    public ArrayList<Product> getAllRecordsByCategory(String category) throws RemoteException;
//    public ArrayList<Product> filterProductByName(String name, String category) throws RemoteException;

    public Product getProductBuyByName(String name) throws RemoteException;

    public Product getProductSellByName(String name) throws RemoteException;
//    Category

    public int insertCat(int IDCategory, String Category) throws RemoteException;

    public int updateCat(int IDCategory, String Category) throws RemoteException;

    public int deleteCat(int IDCategory, String Category) throws RemoteException;

    public ArrayList<Category> selectAllCat() throws RemoteException;

    public ArrayList<Category> selectByConditionCat(String condition) throws RemoteException;

    public String getIDCat() throws RemoteException;
//    Infor

    public int insertInfor(int IDEmp, String NameEmp, String Phone, String Email) throws RemoteException;

    public int updateInfor(int IDEmp, String NameEmp, String Phone, String Email) throws RemoteException;

    public int deleteInfor(int IDEmp, String NameEmp, String Phone, String Email) throws RemoteException;

    public ArrayList<Infor> selectAllInfor() throws RemoteException;

    public ArrayList<Infor> selectByConditionInfor(String condition) throws RemoteException;
//  Supplier

    public int insertSup(int IDSup, String SupName, String DateAdd, String Phone, String Email) throws RemoteException;

    public int updateSup(int IDSup, String SupName, String DateAdd, String Phone, String Email) throws RemoteException;

    public int deleteSup(int IDSup, String SupName, String DateAdd, String Phone, String Email) throws RemoteException;

    public ArrayList<Supplier> selectAllSup() throws RemoteException;

    public ArrayList<Supplier> selectByConditionSup(String condition) throws RemoteException;

    public String getIDSup() throws RemoteException;
//    Revenue

    public int insertRev(String Date, String ProductName, String Price, String Quantity, String Total) throws RemoteException;

    public int updateRev(String Date, String ProductName, String Price, String Quantity, String Total) throws RemoteException;

    public int deleteRev(String Date, String ProductName, String Price, String Quantity, String Total) throws RemoteException;

    public ArrayList<Revenue> selectAllRev() throws RemoteException;

    public ArrayList<Revenue> selectByConditionRev(String condition) throws RemoteException;

    public Revenue selectByDateRev(Revenue t) throws RemoteException;
//  Bill

    public String getIDBill() throws RemoteException;

    public void saveBill(Bill bill) throws RemoteException;
//   Import

    public String getIDImport() throws RemoteException;

    public void saveImport(Input input) throws RemoteException;

    public List<RevenueBean> getListRevenue() throws RemoteException;

    public String encrypt(String srcText) throws RemoteException;

    public void openFile(String file) throws RemoteException;

    public void exportarExcel(JTable jt) throws RemoteException;
}

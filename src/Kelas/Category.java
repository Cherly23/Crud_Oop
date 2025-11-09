/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author cherly
 */
public class Category extends Koneksi{
    private String categoryName;
    private int categoryId;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public Category(){
        koneksi = super.configDB();
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public void TambahCategory(){
        query = "INSERT INTO category (categoryName) VALUES(?) ";
        
        try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, categoryName);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");
        }
    }
    public void UbahCategory() {
        query = "UPDATE category SET categoryName=? WHERE categoryId=? ";
        
        try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, categoryName);
            ps.setInt(2, categoryId);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
        }
    }
    public void HapusCategory(){
        query = "DELETE FROM category WHERE categoryId = ? ";
        
        try {
            ps = koneksi.prepareStatement(query);
            ps.setInt(1, categoryId);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal DiHapus");
        }
        
    }
    public ResultSet TampilCategory(){
        query = "SELECT * FROM category";
        
        try {
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }
        return rs;
    }
    
    public ResultSet dataComboBox() {
        try {
            query = "SELECT categoryName FROM category";
            
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;
    }
    
    public ResultSet konversi() {
        try {
            query = "SELECT categoryId FROM category WHERE categoryName = ?";
            
            ps = koneksi.prepareStatement(query);
            ps.setString(1, this.categoryName);
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;  
    }
    
    public ResultSet autoId() {
        try {
            query = "SELECT categoryId AS ID FROM category ORDER BY categoryId DESC LIMIT 1";
            
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }
        return rs;
    }
}

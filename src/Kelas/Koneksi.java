/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author cherly
 */
public class Koneksi {
    private Connection mysqlconfig;
    public Connection configDB(){
        try {
            String url = "jdbc:mysql://localhost:3306/crudOop_202457201017";
            String user = "root";
            String pass = "";
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return mysqlconfig;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dito
 */
import java.sql.*;

public class DataHandler205314159 {
    // string ‘localhost’ anda ganti dengan IP server yang digunakan 
    String jdbcUrl  = "jdbc:mysql://localhost:3306/pbo2sem3_perpus";
    String userid = "root";
    String password = "";
    Connection conn;

    public DataHandler205314159() {
    }

    public void getDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // dari Driver class
            conn = DriverManager.getConnection(jdbcUrl, userid, password);
            System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            // perform error handling here
            System.out.println("Masih belum konek");
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Tidak bisa tutup koneksi");
        }
    }
}
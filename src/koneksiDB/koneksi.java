/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksiDB;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author basith
 */
public class koneksi {
    private static Connection con;
    public static Connection getcon(){
        if (con == null) {
            try{
                String url = "jdbc:mysql://localhost/db_penduduk";
                String username = "root";
                String pass = "";
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    con = DriverManager.getConnection(url, username, pass);
                JOptionPane.showMessageDialog(null, "Koneksi Berhasil!","Pesan", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi TIdak Berhasil!","Pesan", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(e);
            }
        }
        return con;
    }
}

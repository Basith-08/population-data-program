/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.arsipPenduduk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import koneksiDB.koneksi;
import view.viewArsip;

/**
 *
 * @author basith
 */
public class model_arsipPenduduk implements arsipPenduduk {

    @Override
    public void Tampil(viewArsip arsip) throws SQLException {
        arsip.tblmodel.getDataVector().removeAllElements();
        arsip.tblmodel.fireTableDataChanged();
        
        try {
            Connection con = koneksi.getcon();
            Statement stt = con.createStatement();
            String sql = "SELECT * FROM penduduk ORDER BY nik ASC";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                Object[] ob = new Object[15];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getDate(4);
                ob[4] = rs.getString(5);
                ob[5] = rs.getString(6);
                ob[6] = rs.getString(7);
                ob[7] = rs.getString(8);
                ob[8] = rs.getString(9);
                ob[9] = rs.getString(10);
                ob[10] = rs.getString(11);
                ob[11] = rs.getString(12);
                ob[12] = rs.getString(13);
                arsip.tblmodel.addRow(ob);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Hapus(viewArsip arsip) throws SQLException {
        String usrNik = arsip.tblArsip.getValueAt(arsip.tblArsip.getSelectedRow(),0).toString();
        try {
        Connection con = koneksi.getcon();
        String sql = "DELETE FROM penduduk WHERE nik=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usrNik);
            int intTambah = ps.executeUpdate();
            if (intTambah>0){
               JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");                  
            }
            else{
               JOptionPane.showMessageDialog(null, "Data Gagal di hapus");                  
            }
            Tampil(arsip);
          
        } catch (Exception e) {
            System.out.println("koneksi gagal " + e.toString());
        }
    }
}

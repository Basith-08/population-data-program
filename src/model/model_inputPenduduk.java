/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.inputPenduduk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import koneksiDB.koneksi;
import view.viewInput;

/**
 *
 * @author basith
 */
public class model_inputPenduduk implements inputPenduduk {

    @Override
    public void Simpan(viewInput input) throws SQLException {
        try {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
            
            Connection con = koneksi.getcon();
            String sql = "Insert Into penduduk Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, input.txtNik.getText());
            ps.setString(2, input.txtNama.getText());
            ps.setString(3, input.txtTempatLahir.getText());
            ps.setString(4, dateFormat.format(input.tanggalLahir.getDate()));
            ps.setString(5, (String) input.cbJeKe.getSelectedItem());
            ps.setString(6, (String) input.cbGolDar.getSelectedItem());
            ps.setString(7, input.txtAlamat.getText());
            ps.setString(8, (String) input.cbAgama.getSelectedItem());
            ps.setString(9, (String) input.cbPenTer.getSelectedItem());
            ps.setString(10, input.txtStsPnddk.getText());
            ps.setString(11, input.txtPkrjn.getText());
            ps.setString(12, input.txtStatus.getText());
            ps.setString(13, input.txtKewarganegaraan.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di simpan");
            ps.close();
            Baru (input);           
        } catch (Exception e) {
            System.out.println(e);
        } finally {
           Tampil(input);

        }
    }

    @Override
    public void Tampil(viewInput input) throws SQLException {
        input.tblmodel.getDataVector().removeAllElements();
        input.tblmodel.fireTableDataChanged();
        
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
                input.tblmodel.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Edit(viewInput input) throws SQLException {
          try {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");

            Connection con = koneksi.getcon();
            String sql = "Update penduduk SET nama=?, tempat_lahir=?, "
                    + "tanggal_lahir=?, jenis_kelamin=?, golongan_darah=?, "
                    + "alamat=?, agama=?, pendidikan_terakhir=?, status_pendidikan=?, "
                    + "pekerjaan=?, status=? , kewarganegaraan=? where nik=?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(13, input.txtNik.getText());
            ps.setString(1, input.txtNama.getText());
            ps.setString(2, input.txtTempatLahir.getText());
            ps.setString(3, dateFormat.format(input.tanggalLahir.getDate()));
            ps.setString(4, (String) input.cbJeKe.getSelectedItem());
            ps.setString(5, (String) input.cbGolDar.getSelectedItem());
            ps.setString(6, input.txtAlamat.getText());
            ps.setString(7, (String) input.cbAgama.getSelectedItem());
            ps.setString(8, (String) input.cbPenTer.getSelectedItem());
            ps.setString(9, input.txtStsPnddk.getText());
            ps.setString(10, input.txtPkrjn.getText());
            ps.setString(11, input.txtStatus.getText());
            ps.setString(12, input.txtKewarganegaraan.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di edit");
            ps.close();
            Baru(input);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal di edit");
            System.out.println(e);
        } finally {
           Tampil(input);
           input.setLebarKolom();
           Baru(input);
        }
    }

    @Override
    public void Baru(viewInput input) throws SQLException {
        input.txtNik.setText("");
        input.txtNama.setText("");
        input.txtTempatLahir.setText("");
        input.tanggalLahir.setDate(null);
        input.cbJeKe.setSelectedIndex(0);
        input.cbGolDar.setSelectedIndex(0);
        input.txtAlamat.setText("");
        input.cbAgama.setSelectedIndex(0);
        input.cbPenTer.setSelectedIndex(0);
        input.txtStsPnddk.setText("");
        input.txtPkrjn.setText("");
        input.txtStatus.setText("");
        input.txtKewarganegaraan.setText("");
    }

    @Override
    public void KlikTabel(viewInput input) throws SQLException {
        SimpleDateFormat date = new SimpleDateFormat("yyy-MM-dd");
        try {            
            int pilih = input.tabel.getSelectedRow();
            if (pilih == -1 ) {
                return;
            }
            input.txtNik.setText(input.tblmodel.getValueAt(pilih, 0).toString());
            input.txtNama.setText(input.tblmodel.getValueAt(pilih, 1).toString());
            input.txtTempatLahir.setText(input.tblmodel.getValueAt(pilih, 2).toString());
            input.tanggalLahir.setDate((date).parse(input.tblmodel.getValueAt(pilih, 3).toString()) );
            input.cbJeKe.setSelectedItem(input.tblmodel.getValueAt(pilih, 4).toString());
            input.cbGolDar.setSelectedItem(input.tblmodel.getValueAt(pilih, 5).toString());
            input.txtAlamat.setText(input.tblmodel.getValueAt(pilih, 6).toString());
            input.cbAgama.setSelectedItem(input.tblmodel.getValueAt(pilih, 7).toString());
            input.cbPenTer.setSelectedItem(input.tblmodel.getValueAt(pilih, 8).toString());
            input.txtStsPnddk.setText(input.tblmodel.getValueAt(pilih, 9).toString());
            input.txtPkrjn.setText(input.tblmodel.getValueAt(pilih, 10).toString());
            input.txtStatus.setText(input.tblmodel.getValueAt(pilih, 11).toString());
            input.txtKewarganegaraan.setText(input.tblmodel.getValueAt(pilih, 12).toString());
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

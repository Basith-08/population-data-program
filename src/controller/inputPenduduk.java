/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.sql.SQLException;
import view.viewInput;

/**
 *
 * @author basith
 */
public interface inputPenduduk {
    public void Simpan (viewInput input) throws SQLException;
    public void Tampil (viewInput input) throws SQLException;
    public void Edit (viewInput input) throws SQLException;
    public void Baru(viewInput input) throws SQLException;
    public void KlikTabel(viewInput input) throws SQLException;
}

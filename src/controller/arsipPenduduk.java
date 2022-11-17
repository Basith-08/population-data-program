/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.sql.SQLException;
import view.viewArsip;

/**
 *
 * @author basith
 */
public interface arsipPenduduk {
    public void Tampil(viewArsip arsip) throws SQLException;
    public void Hapus(viewArsip arsip) throws SQLException;
}

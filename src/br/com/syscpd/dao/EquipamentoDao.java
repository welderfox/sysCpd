/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.dao;

import br.com.syscpd.conexaobd.ModuloConexao;
import br.com.syscpd.model.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author teste
 */
public class EquipamentoDao {

    public void salvar(Equipamento eq) {
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("insert into tbequipamento");
            sql.append("(descricao,marca,modelo,qtd,idfornecedor,tipo)");
            sql.append("values(?,?,?,?,?,?)");
            Connection co = ModuloConexao.conector();

            PreparedStatement pst = co.prepareStatement(sql.toString());
            pst.setString(1, eq.getDescricao());
            pst.setString(2, eq.getMarca());
            pst.setString(3, eq.getModelo());
            pst.setInt(4, eq.getIdFornecedor());
            pst.setInt(5, eq.getCodInterno());
            pst.setInt(6, eq.getQuantidade());
            pst.execute();

//        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
//
//            JOptionPane.showMessageDialog(null, "Codigo interno duplicado!!");
//            //System.out.println(""+e);
        } catch (SQLException f) {
            JOptionPane.showMessageDialog(null, f);
        }
    }

    public void update(Equipamento up) {
        StringBuilder sql = new StringBuilder();
        sql.append("update tbequipamento set descricao =?,marca=?,modelo=?, codInterno=? where cod =?");
        Connection co = ModuloConexao.conector();
        try {
            PreparedStatement pst = co.prepareStatement(sql.toString());
            pst.setString(1, up.getDescricao());
            pst.setString(2, up.getMarca());
            pst.setString(3, up.getModelo());
            pst.setInt(4, up.getCodInterno());
            pst.setString(5, up.getCodEquipamento());

            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void listarPoFornecedor() {

    }

}

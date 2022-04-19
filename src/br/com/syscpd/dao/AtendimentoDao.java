/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.dao;

import br.com.syscpd.conexaobd.ModuloConexao;
import br.com.syscpd.model.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author teste
 */
public class AtendimentoDao {

    public void salvar(Atendimento at) {
        StringBuilder sql = new StringBuilder();

        sql.append("insert into tblatendimento");
        sql.append("(iduser,loja,nome,funcao,tipoproblema,solucaoproblema,situacao)");
        sql.append("values(?,?,?,?,?,?,?)");

        Connection co = ModuloConexao.conector();

        try {
            PreparedStatement pst = co.prepareStatement(sql.toString());

            pst.setString(1, at.getIduser());
            pst.setString(2, at.getLoja());
            pst.setString(3, at.getNome());
            pst.setString(4, at.getFuncao());
            pst.setString(5, at.getTipo_problema());
            pst.setString(6, at.getSol_problema());
            pst.setString(7, at.getSituacao());
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void atualizaAT(Atendimento up) {

        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE tblatendimento SET situacao =? WHERE idatendimento =?");
        
        Connection co = ModuloConexao.conector();

        try {
            PreparedStatement pst = co.prepareStatement(sql.toString());

            pst.setString(1, up.getSituacao());
            pst.setString(2, up.getId_atendimento());
            
            pst.executeUpdate();
           

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

}

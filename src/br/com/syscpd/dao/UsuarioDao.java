/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.dao;

import br.com.syscpd.conexaobd.ModuloConexao;
import br.com.syscpd.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author teste
 */
public class UsuarioDao {
    public void salvar(Usuario u) {
        StringBuilder sql = new StringBuilder();

        sql.append("insert into tbusuario");
        sql.append("(nome,usuario,login,senha)");
        sql.append("values(?,?,?,?)");

        Connection co = ModuloConexao.conector();

        try {

            PreparedStatement pst = co.prepareStatement(sql.toString());

            pst.setString(1, u.getNome());
            pst.setString(2, u.getUsuario());
            pst.setString(3, u.getLogin());
            pst.setString(4, u.getSenha());

            pst.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.dao;

import br.com.syscpd.conexaobd.ModuloConexao;
import br.com.syscpd.model.Fornecedor;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author teste
 */
public class FornecedorDao {

    public void salvar(Fornecedor forn) {

        StringBuilder sql = new StringBuilder();

        sql.append("insert into tbfornecedor");
        sql.append("(nomefornecedor,cnpj,cpf,telefone,celular,endereco,data_cadastro,estado,cep,email)");
        sql.append("values(?,?,?,?,?,?,?,?,?,?)");

        Connection co = ModuloConexao.conector();

        try {
            PreparedStatement pst = co.prepareStatement(sql.toString());

            pst.setString(1, forn.getNomeFornecedor());
            pst.setString(2, forn.getCnpj());
            pst.setString(3, forn.getCpf());
            pst.setString(4, forn.getTelefone());
            pst.setString(5, forn.getCelular());
            pst.setString(6, forn.getEndereco());
            pst.setString(7, forn.getData());
            pst.setString(8, forn.getEstado());
            pst.setString(9, forn.getCep());
            pst.setString(10, forn.getEmail());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void delete(Fornecedor forn) {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja remover fornecedor ?", "Tem certeza!", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {

            StringBuilder sql = new StringBuilder();

            sql.append("DELETE FROM tbfornecedor WHERE idfornecedor =?;");

            Connection co = ModuloConexao.conector();

            try {
                PreparedStatement pst = co.prepareCall(sql.toString());

                pst.setString(1, forn.getIdFornecedor());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Contato removido com sucesso!");

            } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {

                JOptionPane.showMessageDialog(null, "Existe equipamento vinculado ao fornecedor!");
                System.out.println("" + e);
            } catch (HeadlessException | SQLException f) {
                JOptionPane.showMessageDialog(null, f);
            }
        } else {

        }

    }

    public void update(Fornecedor up) {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar este fornecedor ?", "Tem certeza!", JOptionPane.YES_NO_OPTION);

        StringBuilder sql = new StringBuilder();

        sql.append("update tbfornecedor set nomefornecedor=?,cnpj=?,cpf=?,telefone=?,celular=?,"
                + "endereco=?,estado=?,cep=?,"
                + "email=? where idfornecedor=?");

        Connection co = ModuloConexao.conector();

        if (confirma == JOptionPane.YES_OPTION) {

            try {
                PreparedStatement pst = co.prepareStatement(sql.toString());

                pst.setString(1, up.getNomeFornecedor());
                pst.setString(2, up.getCnpj());
                pst.setString(3, up.getCpf());
                pst.setString(4, up.getTelefone());
                pst.setString(5, up.getCelular());
                pst.setString(6, up.getEndereco());
                pst.setString(7, up.getEstado());
                pst.setString(8, up.getCep());
                pst.setString(9, up.getEmail());
                pst.setInt(10, Integer.parseInt(up.getIdFornecedor()));

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Contato atualizado!!");

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        } else {
        }
    }

}

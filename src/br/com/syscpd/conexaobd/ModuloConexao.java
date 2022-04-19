/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.conexaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuloConexao {
    public static Connection conector() {

        Connection conexao;
        // chamando o driver de conexão
        String driver = "com.mysql.jdbc.Driver";

        // informações do banco
        String url = "jdbc:mysql://127.0.0.1:3306/relatendimento";
        String user = "root";
        String password = "123456";
        
        //conectando com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
           
        } catch (ClassNotFoundException | SQLException erro) {
            System.out.println(erro);
            return null;
        }
    }
}

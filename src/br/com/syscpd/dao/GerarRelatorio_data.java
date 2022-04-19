/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.dao;

import br.com.syscpd.conexaobd.ModuloConexao;
import br.com.syscpd.model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author teste
 */
public class GerarRelatorio_data {
    
  public void relatorioatendimentos(Relatorio rel){
        
            /**StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT * FROM tblatendimento WHERE data_atendimento BETWEEN =? AND =?;");
            
            Connection co = ModuloConexao.conector();
            try {
           PreparedStatement pst = co.prepareStatement(sql.toString());
           
                    pst.setString(1, rel.getDatainicial() );
                    pst.setString(2, rel.getDatafinal());
                    
                    pst.execute();
                    
                    
            
        } catch (Exception e) {
            
        }**/
}
    
}

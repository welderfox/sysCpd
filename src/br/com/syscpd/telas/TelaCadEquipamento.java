/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.telas;

import br.com.syscpd.conexaobd.ModuloConexao;
import br.com.syscpd.model.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import br.com.syscpd.dao.EquipamentoDao;
import java.awt.Color;

/**
 *
 * @author teste
 */
public class TelaCadEquipamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadEquipamento
     */
    public TelaCadEquipamento() {
        initComponents();
        TabelaFornecedor();
        TabelaEquipamento();
    }

//    public void salvarEquipamento(Equipamento equip) {
//         
//            
//        EquipamentoDao svEqp = new EquipamentoDao();
//        equip.setDescricao(txt_descricao.getText());
//        equip.setMarca(txt_marca.getText());
//        equip.setModelo(txt_modelo.getText());
//        equip.setIdFornecedor(Integer.parseInt(lbl_idfornecedor.getText()));
//        equip.setCodInterno(Integer.parseInt(txt_codInterno.getText()));
//        
//        //validação dos campos
//        if (txt_codInterno.getText().trim().length() <= 0 || txt_descricao.getText().trim().length() <= 0 || txt_fornecedor.getText().trim().length() <= 0) {
//            JOptionPane.showMessageDialog(null, "Equipamento !!");
//            txt_codInterno.setBackground(Color.red);
//
//        } else {
//            svEqp.salvar(equip);
//            JOptionPane.showMessageDialog(null, "Equipamento salvo !!");
//            txt_codInterno.setBackground(Color.WHITE);
//            limpar();
//
//        }
//
//    }
    public void salvarEquip(Equipamento eq) {
        EquipamentoDao sv = new EquipamentoDao();
        eq.setDescricao(txt_descricao.getText());
        eq.setMarca(txt_marca.getText());
        eq.setModelo(txt_modelo.getText());
        eq.setCodInterno(Integer.parseInt(codInterno.getText()));
        eq.setIdFornecedor(Integer.parseInt(lbl_idfornecedor.getText()));
        eq.setQuantidade(Integer.parseInt(txt_qtd.getText()));
        eq.setTipo(cbx_tipo.getSelectedItem().toString());
        sv.salvar(eq);
        limpar();
//        if (txt_descricao.getText().isEmpty() || txt_marca.getText().isEmpty() || txt_modelo.getText().isEmpty()|| lbl_idfornecedor.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Prencher todos os campos!!");
//        } else {
//            sv.salvar(eq);
//            JOptionPane.showMessageDialog(null, "Salvo!");
//            limpar();
//        }
    }

    public void updateEquipamento(Equipamento upEqp) {
        EquipamentoDao update = new EquipamentoDao();
        upEqp.setDescricao(txt_descricao.getText());
        upEqp.setMarca(txt_marca.getText());
        upEqp.setModelo(txt_modelo.getText());
        upEqp.setCodEquipamento(lbl_codProduto.getText());
        upEqp.setCodInterno(Integer.parseInt(codInterno.getText()));
        update.update(upEqp);
        limpar();

//        if (txt_descricao.getText().isEmpty() || txt_marca.getText().isEmpty() || txt_modelo.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!!");
//        } else {
//            update.update(upEqp);
//            JOptionPane.showMessageDialog(null, "Cadastro atualizado !");
//            limpar();
//        }
    }

    public void TabelaFornecedor() {
        StringBuilder sql = new StringBuilder();
        Connection connection = ModuloConexao.conector();
        ResultSet resultado;

        sql.append("SELECT idfornecedor as ID, nomefornecedor as NOME from tbfornecedor");

        try {

            PreparedStatement comando = connection.prepareStatement(sql.toString());
            resultado = comando.executeQuery();
            tbl_fornecedor.setModel(DbUtils.resultSetToTableModel(resultado));
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void TabelaEquipamento() {
        StringBuilder sql = new StringBuilder();
        Connection connection = ModuloConexao.conector();
        ResultSet resultado;

        sql.append("SELECT cod as 'COD EQUIPAMENTO', descricao as 'DESCRIÇÃO',"
                + " marca as MARCA, modelo as MODELO, cod as 'CODIGO INTERNO' from tbequipamento");

        try {

            PreparedStatement comando = connection.prepareStatement(sql.toString());
            resultado = comando.executeQuery();
            tbl_equipamento.setModel(DbUtils.resultSetToTableModel(resultado));
            //connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void setar() {

        int setar = tbl_fornecedor.getSelectedRow();
        lbl_idfornecedor.setText(tbl_fornecedor.getModel().getValueAt(setar, 0).toString());
        txt_fornecedor.setText(tbl_fornecedor.getModel().getValueAt(setar, 1).toString());

    }

    public void setarEquipamento() {
        int setar = tbl_equipamento.getSelectedRow();
        lbl_codProduto.setText(tbl_equipamento.getModel().getValueAt(setar, 0).toString());
        txt_descricao.setText(tbl_equipamento.getModel().getValueAt(setar, 1).toString());
        txt_marca.setText(tbl_equipamento.getModel().getValueAt(setar, 2).toString());
        txt_modelo.setText(tbl_equipamento.getModel().getValueAt(setar, 3).toString());
        codInterno.setText(tbl_equipamento.getModel().getValueAt(setar, 4).toString());

    }

    public void limpar() {
        lbl_codProduto.setText("");
        lbl_idfornecedor.setText("");
        txt_descricao.setText("");
        txt_fornecedor.setText("");
        txt_marca.setText("");
        txt_modelo.setText("");
        codInterno.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_fornecedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_idfornecedor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_codProduto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_fornecedor = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_equipamento = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        codInterno = new javax.swing.JTextField();
        bt_salvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_qtd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbx_tipo = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastro de Equipamentos");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("FORNECEDOR:");

        txt_fornecedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txt_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fornecedorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("ID FORNECEDOR");

        lbl_idfornecedor.setBackground(new java.awt.Color(0, 0, 0));
        lbl_idfornecedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_idfornecedor.setForeground(new java.awt.Color(255, 5, 15));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("COD EQUIPAMENTO");

        lbl_codProduto.setBackground(new java.awt.Color(0, 0, 0));
        lbl_codProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_codProduto.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("DESCRIÇÃO:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EQUIPAMENTO");

        txt_descricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txt_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descricaoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("MARCA:");

        txt_marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txt_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_marcaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("MODELO:");

        txt_modelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txt_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modeloActionPerformed(evt);
            }
        });

        tbl_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbl_fornecedor.setCellSelectionEnabled(true);
        tbl_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_fornecedorMouseClicked(evt);
            }
        });
        tbl_fornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_fornecedorKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_fornecedor);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("FORNECEDORES");

        tbl_equipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_equipamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_equipamentoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_equipamentoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_equipamento);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("CODIGO INTERNO:");

        codInterno.setToolTipText("Codigo interno");

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/syscpd/icones/pendriveSave32x32.png"))); // NOI18N
        bt_salvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_salvar.setPreferredSize(new java.awt.Dimension(32, 32));
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/syscpd/icones/Busca_data32x32.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setPreferredSize(new java.awt.Dimension(32, 32));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("QUANTIDADE:");

        txt_qtd.setToolTipText("Quantidade");
        txt_qtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qtdActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("TIPO:");

        cbx_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENTRADA", "SAIDA" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_idfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_codProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(2, 2, 2)
                        .addComponent(codInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(137, 137, 137)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(77, 77, 77))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(72, 72, 72)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addComponent(txt_modelo, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_marca, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                            .addComponent(txt_descricao))))
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(289, 289, 289))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(lbl_idfornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_codProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(codInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txt_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        setBounds(285, 45, 1026, 542);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fornecedorActionPerformed

    private void txt_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descricaoActionPerformed

    private void txt_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modeloActionPerformed

    private void tbl_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_fornecedorMouseClicked
        // setar Fornecedor na tela
        setar();
        tbl_equipamento.setEnabled(false);
    }//GEN-LAST:event_tbl_fornecedorMouseClicked

    private void tbl_fornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_fornecedorKeyReleased
        // setar Fornecedor na tela
        setar();
        tbl_equipamento.setEnabled(false);
    }//GEN-LAST:event_tbl_fornecedorKeyReleased

    private void tbl_equipamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_equipamentoMousePressed
        // TODO add your handling cod
        setarEquipamento();
    }//GEN-LAST:event_tbl_equipamentoMousePressed

    private void tbl_equipamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_equipamentoMouseClicked
        // TODO add your handling code here:
        setarEquipamento();
        bt_salvar.setEnabled(false);
    }//GEN-LAST:event_tbl_equipamentoMouseClicked

    private void txt_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_marcaActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        // TODO add your handling code here:
        if (txt_descricao.getText().isEmpty() || txt_marca.getText().isEmpty() || txt_modelo.getText().isEmpty() || lbl_idfornecedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prencher todos os campos!!");
        } if (codInterno.getText().length()<=0) {
            codInterno.setBackground(Color.red);
        } else {
            Equipamento sv = new Equipamento();
            salvarEquip(sv);
            tbl_equipamento.setEnabled(true);
            codInterno.setBackground(Color.white);
            JOptionPane.showMessageDialog(null, "Salvo!!");
        }

    }//GEN-LAST:event_bt_salvarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (txt_descricao.getText().isEmpty() || txt_marca.getText().isEmpty() || txt_modelo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos!!");
        } else {
            Equipamento up = new Equipamento();
            updateEquipamento(up);
            bt_salvar.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Atualizado!!");

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_qtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qtdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_salvar;
    private javax.swing.JComboBox cbx_tipo;
    private javax.swing.JTextField codInterno;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_codProduto;
    private javax.swing.JLabel lbl_idfornecedor;
    private javax.swing.JTable tbl_equipamento;
    private javax.swing.JTable tbl_fornecedor;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JTextField txt_fornecedor;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_qtd;
    // End of variables declaration//GEN-END:variables
}

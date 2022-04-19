/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syscpd.telas;

import br.com.syscpd.conexaobd.ModuloConexao;
import br.com.syscpd.dao.AtendimentoDao;
import br.com.syscpd.model.Atendimento;
import static br.com.syscpd.telas.TelaLogin.idusuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author teste
 */
public class TelaAtendimento extends javax.swing.JInternalFrame {

    private final int id;

    /**
     * Creates new form TelaAtendimento
     */
    public TelaAtendimento() {

        initComponents();
        id = idusuario;

        lbl_id.setText(String.format("%d", id));

        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.LONG);
        lbldata.setText(formatador.format(data));

        prencherTabela();

    }

    //Metodo para salvar atendimento.
    public void salvarAtendimento(Atendimento at) {

        AtendimentoDao aten = new AtendimentoDao();

        at.setIduser(lbl_id.getText());
        at.setLoja(cbx_loja.getSelectedItem().toString());
        at.setNome(txt_nome.getText());
        at.setFuncao(cbx_funcao.getSelectedItem().toString());
        at.setTipo_problema(txt_problema.getText());
        at.setSol_problema(txt_solucao.getText());
        at.setSituacao(cbx_status.getSelectedItem().toString());
        
        //Validação dos campos obrigatorios
        if (txt_nome.getText().isEmpty()
                || cbx_loja.getSelectedItem().equals(false)
                || txt_problema.getText().isEmpty()
                || txt_solucao.getText().isEmpty()
                || cbx_funcao.getSelectedItem().equals(false)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campo obrigatorios !");
        } else {
            aten.salvar(at);
            JOptionPane.showMessageDialog(null, "Atendimento salvo!");
            prencherTabela();
        }

        txt_nome.setText("");
        txt_problema.setText("");
        txt_solucao.setText("");

    }

    //metodo para prencher tabela atendimento
    public void prencherTabela() {

        StringBuilder sql = new StringBuilder();

        ResultSet resultado;

        sql.append("select idatendimento as 'NºAt',data_atendimento as Data,loja as Loja,"
                + "nome as Nome,funcao as Função,tipoproblema as Problema,solucaoproblema as Solução,"
                + "iduser as Usuário,situacao as Situação from tblatendimento where loja like ?");

        try {
            Connection connection = ModuloConexao.conector();
            PreparedStatement comando = connection.prepareStatement(sql.toString());
            comando.setString(1, txt_pesquisa.getText() + "%");
            resultado = comando.executeQuery();
            tbl_atendimento.setModel(DbUtils.resultSetToTableModel(resultado));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    //Metodo para setar o dados selecionados da tabela nos campos atendimentos.
    public void setar_campos() {

        int setar = tbl_atendimento.getSelectedRow();
        lbl_id_Atendimento.setText(tbl_atendimento.getModel().getValueAt(setar, 0).toString());
        cbx_loja.setSelectedItem(tbl_atendimento.getModel().getValueAt(setar, 2).toString());
        txt_nome.setText(tbl_atendimento.getModel().getValueAt(setar, 3).toString());
        cbx_funcao.setSelectedItem(tbl_atendimento.getModel().getValueAt(setar, 4).toString());
        txt_problema.setText(tbl_atendimento.getModel().getValueAt(setar, 5).toString());
        txt_solucao.setText(tbl_atendimento.getModel().getValueAt(setar, 6).toString());
        cbx_status.setSelectedItem(tbl_atendimento.getModel().getValueAt(setar, 8).toString());

    }

    //Metodo para limpar os campos da tela atendimento.
    public void lipar() {

        //cbx_funcao.setSelectedItem(null);
        cbx_status.setSelectedItem("Pendente");
        txt_nome.setText("");
        txt_problema.setText("");
        txt_solucao.setText("");
        lbl_id_Atendimento.setText(null);

    }
    //Metodo para atualizar informçoes do atendimento apos ser gravado(fazer alterção)

    public void update(Atendimento up) {
        AtendimentoDao update = new AtendimentoDao();

        up.setSituacao(cbx_status.getSelectedItem().toString());
        up.setId_atendimento(lbl_id_Atendimento.getText());

        update.atualizaAT(up);

        JOptionPane.showMessageDialog(null, "Atendimento atualizado!");
        prencherTabela();

        //limpas os dados da tela
        //cbx_funcao.setSelectedItem(null);
        cbx_status.setSelectedItem("Pendente");
        txt_nome.setText("");
        txt_problema.setText("");
        txt_solucao.setText("");
        lbl_id_Atendimento.setText(null);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        cbx_loja = new javax.swing.JComboBox<>();
        txt_nome = new javax.swing.JTextField();
        cbx_funcao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_problema = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_solucao = new javax.swing.JTextArea();
        txt_pesquisa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_atendimento = new javax.swing.JTable();
        btn_salvar = new javax.swing.JButton();
        lbldata = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_limpar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbx_status = new javax.swing.JComboBox<>();
        btn_atualiza = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lbl_id_Atendimento = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Atendimento CPD");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID usuário");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Loja *");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Solicitante *");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Função *");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Detalhe *");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Solução *");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pesquisar");

        lbl_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(178, 0, 19));
        lbl_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cbx_loja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loja 02", "Loja 03", "Loja 04", "Loja 05", "Loja 06", "Loja 07", "Loja 08", "Loja 09", "Loja 10", "Loja 11", "Loja 12", "Loja 13", "Loja 14", "Loja 15", "Loja 16", "Loja 17", "Loja 18", "Loja 19", "Loja 20", "Loja 21", "Loja 22", "Loja 23", "Loja 24", "Loja 25", "Loja 27", "Loja 28", "Loja 29", "Loja 30", "Loja 31", "Loja 32", "Loja 33", "Loja 34", "Loja 35", "Loja 36", "Loja 37", "Loja 38", "Loja 39", "Loja 40", "Loja 41", "Loja 42", "Loja 43", "Loja 44", "Loja 45", "Loja 46", "Loja 47", "Loja 48", "Loja 49", "Loja 50", "Loja 51", "Loja 52", "Loja 53 ", "Loja 54", "Loja 55", "Loja 56", "Loja 57", "Loja 58", "Loja 59", "Loja 60", "Loja 61", "Loja 62", "Loja 63", "Loja 64", "Loja 65", "Loja 66", "Loja 67", "Loja 68", "Loja 69", "Loja 70", "Loja 71", "Loja 72", "Loja 73", "Loja 74", "Loja 75", "Loja 76", "Loja 77", "Loja 78", "Loja 79", "Loja 80", "Loja 81", "Loja 82", "Loja 83", "Loja 84", "Loja 85", "Loja 86", "Loja 87", "Loja 88", "Loja 90", "Loja 91", "Loja 92", "Loja 93", "Loja 94", "Loja 95", "Loja 96", "Loja 97", "Loja 98", "Loja 99", "Loja 100", "Loja 101", "Loja 102", "Loja 103", "Loja 104", "Loja 105", "Loja 106", "Loja 107", "Loja 108", "Loja 109", "Loja 110", "Loja 111", "Loja 112", "Loja 113", "Loja 114", "Loja 115", "Loja 116", "Loja 117", "Loja 118", "Loja 119", "Loja 120", "Loja 121", "Loja 122", "Loja 123", "Loja 124", "Loja 125", "Loja 126", "Loja 127", "Loja 128", "Loja 129", "Loja 130", "Loja 131", "Loja 132", "Loja 134", "Loja 135", "Loja 136", "Loja 137", "Loja 138", "Loja 139", "Loja 140", "Loja 141", "Loja 142", "Loja 143", "Loja 144", "Loja 145", "Loja 146", "Loja 147", "Loja 148", "Loja 149", "Loja 150", "Loja 151", "Loja 153", "Loja 154", "Loja 155", "Loja 156", "Loja 157", "Loja 158", "Loja 159", "Loja 160", "Loja 161", "Loja 162", "Loja 163", "Loja 164", "Loja 165", "Loja 166", "Loja 167", "Loja 168", "Loja 169", "Loja 170", "Loja 171", "Loja 172", "Loja 173", "Loja 174", "Loja 175", "Loja 176", "Loja 177", "Loja 178", "Loja 179", "Loja 180", "Loja 181", "Loja 182", "Loja 183", "Loja 184", "Loja 185", "Loja 186", "Loja 187", "Loja 188", "Loja 189", "Loja 190", "Loja 191", "Loja 192", "Loja 193", "Loja 194", "Loja 195", "Loja 196", "Loja 197", "Loja 198", "Loja 199", "Loja 205", "Loja 206", "Loja 207", "Loja 209", "Loja 208", "Loja 210", "Loja 211", "Loja 212", "S&I", "CEASA", "IMPERIAL", "CD NACIONAL", "CD ATALAIA", "ALMOXARIFADO", "RH", "SEGURANÇA DO TRABALHO" }));

        cbx_funcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supervisor", "Gerente", "Cpd", "Linha de Frente", "Operadora de PDV", "Tesoureira", "Conferente" }));
        cbx_funcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_funcaoActionPerformed(evt);
            }
        });

        txt_problema.setColumns(20);
        txt_problema.setRows(5);
        txt_problema.setToolTipText("Digite o problema");
        jScrollPane1.setViewportView(txt_problema);

        txt_solucao.setColumns(20);
        txt_solucao.setRows(5);
        txt_solucao.setToolTipText("Digite a solução do problema");
        jScrollPane2.setViewportView(txt_solucao);

        txt_pesquisa.setToolTipText("Digite loja");
        txt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisaActionPerformed(evt);
            }
        });
        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/syscpd/icones/pesquisa_32x32.png"))); // NOI18N
        jLabel9.setToolTipText("Pesquisar");

        tbl_atendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6", "Título 7", "Título 8"
            }
        ));
        tbl_atendimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_atendimento.setGridColor(new java.awt.Color(153, 153, 255));
        tbl_atendimento.setInheritsPopupMenu(true);
        tbl_atendimento.getTableHeader().setReorderingAllowed(false);
        tbl_atendimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_atendimentoMouseClicked(evt);
            }
        });
        tbl_atendimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_atendimentoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_atendimento);

        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/syscpd/icones/salvar_32x32.png"))); // NOI18N
        btn_salvar.setToolTipText("Gravar atendimento");
        btn_salvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salvar.setPreferredSize(new java.awt.Dimension(32, 32));
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        lbldata.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setText("* Campos obrigatórios");

        btn_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/syscpd/icones/clear_32x32.png"))); // NOI18N
        btn_limpar.setToolTipText("Limpar formulário");
        btn_limpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpar.setPreferredSize(new java.awt.Dimension(32, 32));
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Status");

        cbx_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Finalizado" }));
        cbx_status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_statusMouseClicked(evt);
            }
        });
        cbx_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_statusActionPerformed(evt);
            }
        });

        btn_atualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/syscpd/icones/update_32x32.png"))); // NOI18N
        btn_atualiza.setToolTipText("Atualiza atendimento");
        btn_atualiza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_atualiza.setPreferredSize(new java.awt.Dimension(32, 32));
        btn_atualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Nº Atendimento");

        lbl_id_Atendimento.setForeground(new java.awt.Color(255, 67, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbx_loja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_funcao, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_id_Atendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(189, 189, 189)
                        .addComponent(lbldata, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_id, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(lbldata, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(lbl_id_Atendimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_loja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_funcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(cbx_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_atualiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        setBounds(200, 80, 1177, 688);
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_funcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_funcaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_funcaoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        // salvando o atendimento nobanco de dados.
        Atendimento at = new Atendimento();
        salvarAtendimento(at);
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        // Preencher tabela

        prencherTabela();
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void tbl_atendimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_atendimentoKeyReleased
        // setando os campos
        btn_salvar.setEnabled(false);
        txt_problema.setEditable(false);
        txt_solucao.setEditable(false);
        setar_campos();
    }//GEN-LAST:event_tbl_atendimentoKeyReleased

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        // Limpa os campos da tela
        btn_salvar.setEnabled(true);
        txt_problema.setEditable(true);
        txt_solucao.setEditable(true);
        lipar();
    }//GEN-LAST:event_btn_limparActionPerformed

    private void cbx_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_statusActionPerformed

    private void btn_atualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizaActionPerformed
        // TODO add your handling code here:
        Atendimento up = new Atendimento();
        update(up);
    }//GEN-LAST:event_btn_atualizaActionPerformed

    private void tbl_atendimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_atendimentoMouseClicked
        // prencher campos ao cliclar na tabela.
        btn_salvar.setEnabled(false);
        txt_problema.setEditable(false);
        txt_solucao.setEditable(false);
        setar_campos();

    }//GEN-LAST:event_tbl_atendimentoMouseClicked

    private void cbx_statusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_statusMouseClicked
        // habilita botão para atualizar atendimento
        //btn_salvar.setEnabled(true);
    }//GEN-LAST:event_cbx_statusMouseClicked

    private void txt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualiza;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<String> cbx_funcao;
    private javax.swing.JComboBox<String> cbx_loja;
    private javax.swing.JComboBox<String> cbx_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_Atendimento;
    private javax.swing.JLabel lbldata;
    private javax.swing.JTable tbl_atendimento;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_pesquisa;
    private javax.swing.JTextArea txt_problema;
    private javax.swing.JTextArea txt_solucao;
    // End of variables declaration//GEN-END:variables
}

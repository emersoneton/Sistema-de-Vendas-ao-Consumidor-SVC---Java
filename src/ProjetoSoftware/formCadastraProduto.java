package ProjetoSoftware;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class formCadastraProduto extends javax.swing.JFrame {

    // private PreparedStatement PreparedStatement;
    public formCadastraProduto() {
        initComponents();
        this.setLocationRelativeTo(null);//Centralizar Jframe
        //     txtCodigo.setDocument(new SoNumeros());
        //      txtDesricao.setDocument(new SoLetrasMaiusculas());
        txtPreco.setForeground(Color.BLUE);
        txtDesricao.setDocument(new SoLetrasMaiusculas());
        txtEan.setDocument(new SoNumeros());
        txtEan.requestFocus();
        Carrega();
        caixas_de_combinacao();
        carregarImagens();
    }

    public void Carrega(){
        txtPreco.setText("0.00");
         try {
            this.con = database.getConnection();

            Produto PRO = new Produto();

            PRO.setCodigo(txtCodigo.getText());

            String PROCodigo = PRO.getCodigo();
            
            PreparedStatement busca = con.prepareStatement("select first(1) pro_cod + 1 from cpro a where not exists (select pro_cod from cpro B where B.pro_cod = A.pro_cod + 1) order by 1");

           ResultSet rs = busca.executeQuery();
           if(!rs.isBeforeFirst()){
                txtCodigo.setText("1");
            }else{
                rs.next();

                txtCodigo.setText(rs.getString("ADD"));
           }

        } catch (Exception ex) {
            Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    public void caixas_de_combinacao(){
         try {
            this.con = database.getConnection();

            Grupo_Produto PRO = new Grupo_Produto();
            
            String PROCodigo = PRO.descricao;

            
            PreparedStatement posted = con.prepareStatement("select GRUPO_COD,GRUPO_DES from CGRUPO order by GRUPO_DES");
            
            ResultSet rs = posted.executeQuery();
            Caixa_Grupo.addItem("Selecione");
            while (rs.next()) {

                String descricao = rs.getString("GRUPO_DES");

                    Caixa_Grupo.addItem(descricao);
                    
            }

        } catch (Exception ex) {
            Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
         
          try {
            this.con = database.getConnection();

            Unidade_Produto PRO = new Unidade_Produto();
            
            String PROCodigo = PRO.descricao;

            
            PreparedStatement posted = con.prepareStatement("select * from Cunidade order by UNIDADE_ABRE");
            
            ResultSet rs = posted.executeQuery();
           Caixa_Unidade.addItem("Selecione");
            while (rs.next()) {

                String descricao = rs.getString("UNIDADE_ABRE");

                    Caixa_Unidade.addItem(descricao);
                    
            }

        } catch (Exception ex) {
            Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void carregarImagens(){
     ImageIcon inserir = new ImageIcon("C:/Imagem/09_Inserir.png");
     ImageIcon editar = new ImageIcon("C:/Imagem/06_Editar.png");
     ImageIcon excluir = new ImageIcon("C:/Imagem/07_Excluir.png");
     ImageIcon pesquisar = new ImageIcon("C:/Imagem/11_Lupa.png");
     ImageIcon excel = new ImageIcon("C:/Imagem/03_Excel.png");
     ImageIcon sair = new ImageIcon("C:/Imagem/08_Fechar.png");
     ImageIcon Limpar = new ImageIcon("C:/Imagem/05_Clear.png");
     ImageIcon Atualizar = new ImageIcon("C:/Imagem/13_Atualizar.png");
     ImageIcon Cadastrar = new ImageIcon("C:/Imagem/14_Cadastrar.png");
     
        btnSalvar.setIcon(inserir);
        btnSair.setIcon(sair);
        btnEditar.setIcon(editar);
        btnExcluir.setIcon(excluir);
        btnCancelar.setIcon(Limpar);
        btnBuscar.setIcon(pesquisar);
        btnAtualizar.setIcon(Atualizar);
        btnCadastrar.setIcon(Cadastrar);
    }
     public void importaProduto(String recebe){
        
        txtCodigo.setText(recebe);
        
    }
    private Connection con;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtEan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDesricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Caixa_Unidade = new javax.swing.JComboBox<>();
        txtPreco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Caixa_Grupo = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Código:");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        txtEan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEanKeyPressed(evt);
            }
        });

        jLabel3.setText("Descrição:");

        txtDesricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesricaoActionPerformed(evt);
            }
        });
        txtDesricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDesricaoKeyPressed(evt);
            }
        });

        jLabel4.setText("Und:");

        Caixa_Unidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_UnidadeActionPerformed(evt);
            }
        });
        Caixa_Unidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Caixa_UnidadeKeyPressed(evt);
            }
        });

        txtPreco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecoMouseClicked(evt);
            }
        });
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecoKeyPressed(evt);
            }
        });

        jLabel2.setText("Código de Barras:");

        jLabel5.setText("Preço:");

        jLabel6.setText("Grupo:");

        Caixa_Grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_GrupoActionPerformed(evt);
            }
        });
        Caixa_Grupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Caixa_GrupoKeyPressed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesricao))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEan))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(Caixa_Unidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Caixa_Grupo, 0, 161, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDesricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Caixa_Unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar)
                    .addComponent(Caixa_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAtualizar)
                        .addContainerGap())))
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Caixa_UnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_UnidadeActionPerformed

    }//GEN-LAST:event_Caixa_UnidadeActionPerformed

    private void txtDesricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesricaoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       Salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    public void Salvar(){
         int num = 0;
        try {
            this.con = database.getConnection();
             Produto PRO = new Produto();
             
             String Codigo = txtCodigo.getText();
         
             PreparedStatement busca = con.prepareStatement("select * from cpro");
                    
                 ResultSet rs = busca.executeQuery();
            if(!rs.isBeforeFirst()){
                txtEan.requestFocus();
            } else{
                      while(rs.next()){
                         String PROCod = rs.getString("pro_cod");
                         if(PROCod.trim().equals(Codigo)){
                            JOptionPane.showMessageDialog(null, "CÓDIGO JÁ INFORMADO PARA OUTRO PRODUTO!");
                            num = 1;
                         }
                     }
            }

        } catch (Exception ex) {
            Logger.getLogger(formLancaNota.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(num == 0){
            try {
                this.con = database.getConnection();
                //Statement st = con.createStatement();

                //CHAMANDO A CLASSE CLIENTE  DO NOME CLI
                Produto PRO = new Produto();

                //ESCREVENDO OS BOTÕES DENTRO DAS VARIAVEIS CRIADAS NA CLASSE CLIENTE
                PRO.setCodigo(txtCodigo.getText());
                PRO.setEan(txtEan.getText());
                PRO.setDescricao(txtDesricao.getText());
                PRO.setPreco(txtPreco.getText());
                PRO.setUnidade(Caixa_Unidade.getActionCommand());
                PRO.setGrupo(Caixa_Grupo.getActionCommand());

                if (Caixa_Unidade.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Secione uma opção de unidade!");
                } else {

                        PRO.unidade = Caixa_Unidade.getSelectedItem().toString();

                if (Caixa_Grupo.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Secione um Grupo!");
                } else {
                       PRO.grupo = Caixa_Grupo.getSelectedItem().toString();

                    //RECEBER TUDO QUE FOI DIGITADO NOS BOTÕES ACIMA
                    String PROcodigo = PRO.codigo;
                    String PROean = PRO.ean;
                    String PROdescricao = PRO.descricao;
                    String PROpreco = PRO.preco;
                    String PROunidade = PRO.unidade;
                    String PROgrupo = PRO.grupo;

                    //PREENCHE OS VALORES DO BANC
                    try ( //CRIA CONEXAO COM BANCO - PREPAREDSTATEMENT
                            PreparedStatement banco = con.prepareStatement("insert into CPRO (PRO_COD,PRO_EAN,PRO_DES,PRO_PRE,PRO_UNI,pro_grupo,PRO_ESTOQUE) values (?,?,?,?,?,?,?)")) {

                        //PREENCHE OS VALORES DO BANCO
                        banco.setString(1, PROcodigo);
                        banco.setString(2, PROean);
                        banco.setString(3, PROdescricao);
                        banco.setString(4, PROpreco);
                        banco.setString(5, PROunidade);
                        banco.setString(6, PROgrupo);
                        banco.setString(7, "0");
                        //EXECUTA

                        banco.execute();
                    }
                    JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);

                    limpar();

                    System.out.println("Gravado!");
                    con.close();

                     }
                }
            } catch (Exception ex) {
    //            Logger.getLogger(formCadastraFor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int num = 0;
        try {
            this.con = database.getConnection();

            Produto PRO = new Produto();

            PRO.setCodigo(txtCodigo.getText());

            String PROCodigo = PRO.getCodigo();

            PreparedStatement posted = con.prepareStatement("select PRO_COD,PRO_DES,PRO_EAN,PRO_UNI,PRO_PRE,PRO_GRUPO from cpro");

            ResultSet rs = posted.executeQuery();

            while (rs.next()) {

                String PROCod = rs.getString("PRO_COD");

                if (PROCod.trim().equals(PROCodigo)) {

                    PRO.setDescricao(txtDesricao.getText());
                    PRO.setEan(txtEan.getText());
                    PRO.setPreco(txtPreco.getText());
                    PRO.setCodigo(txtCodigo.getText());
                    PRO.setUnidade((String) Caixa_Unidade.getSelectedItem());
                    PRO.setGrupo((String) Caixa_Grupo.getSelectedItem());

                    String PRODescricao = PRO.descricao;
                    String PROEan = PRO.ean;
                    String PROPreco = PRO.preco;
                    String PROCodi = PRO.codigo;
                    String PROUni = PRO.unidade;
                    String PROGru = PRO.grupo;

                    try (PreparedStatement update = con.prepareStatement("update cpro set pro_des = '" + PRODescricao + "', pro_ean = '" + PROEan + "',pro_pre = '" + PROPreco + "',pro_uni = '" + PROUni + "',pro_GRUPO = '" + PROGru + "' where pro_cod = '" + PROCodi + "'")) {

                        update.execute();
                        JOptionPane.showMessageDialog(null, "PRODUTO ALTERADO COM SUCESSO!");
                        num = 1;
                    }
                    
                    con.close();
                    limpar();
                    Carrega();
                }
                
            }
            if(num==0) JOptionPane.showMessageDialog(null, "NÃO TEM ESSE CÓDIGO CADASTRADO NO BANCO DE DADOS!");
            
        } catch (Exception ex) {
    //        Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       limpar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int a = 0;
        try {
            this.con = database.getConnection();

            Produto PRO = new Produto();

            PRO.setCodigo(txtCodigo.getText());

            String PROCodigo = PRO.getCodigo();

            PreparedStatement posted = con.prepareStatement("select cpro.pro_cod, cpro.pro_des,cpro.pro_ean,cpro.pro_uni,cpro.pro_pre,cpro.pro_grupo, cgrupo.grupo_cod,cgrupo.grupo_des from cpro,cgrupo");

            ResultSet rs = posted.executeQuery();

            while (rs.next()) {

                String PROCod = rs.getString("PRO_COD");

                if (PROCod.trim().equals(PROCodigo)) {

                    String descricao = rs.getString("PRO_DES");
                    String ean = rs.getString("PRO_EAN");
                    String preco = rs.getString("PRO_PRE");
                    String grupo = rs.getString("PRO_GRUPO");
                    
                    txtDesricao.setText(descricao);
                    txtEan.setText(ean);
                    txtPreco.setText(preco);
                    Caixa_Unidade.setSelectedItem(rs.getString("PRO_UNI"));
                    Caixa_Grupo.setSelectedItem(rs.getString("PRO_GRUPO"));

                    a = 1;
                }

            }

            if (a == 0) {
                JOptionPane.showMessageDialog(null, "NÃO FOI ENCONTRADO ESSE CÓDIGO NO BANCO DE DADOS!");
            }

        } catch (Exception ex) {
            Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    public void limpar() {

        txtCodigo.setText("");
        txtDesricao.setText("");
        txtEan.setText("");
        txtPreco.setText("");
        Caixa_Unidade.setSelectedItem("Selecione");
        Caixa_Grupo.setSelectedItem("Selecione");
        txtEan.requestFocus();
        Carrega();
    }


    private void Caixa_GrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_GrupoActionPerformed
         
    }//GEN-LAST:event_Caixa_GrupoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        new formCadastraGrupo().setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int a = 0;
        try {
            this.con = database.getConnection();

            Produto PRO = new Produto();

            PRO.setCodigo(txtCodigo.getText());

            String PROCodigo = PRO.getCodigo();

            PreparedStatement posted = con.prepareStatement("select PRO_COD,PRO_DES from cpro");

            ResultSet rs = posted.executeQuery();

            while (rs.next()) {

                String PROCod = rs.getString("PRO_COD");
                String PRODes = rs.getString("PRO_DES");

                if (PROCod.trim().equals(PROCodigo)) {
                    int resposta = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE EXPLUIR O PRODUTO " + PRODes + "?");
                    if (resposta == JOptionPane.YES_OPTION) {
                        try (PreparedStatement stmp = con.prepareStatement("DELETE FROM cpro WHERE pro_cod ='" + PROCod + "'")) {
                            stmp.executeUpdate();
                            con.close();
                            limpar();
                        }

                        JOptionPane.showMessageDialog(null, "PRODUTO EXLUIDO COM SUCESSO!");
                        Carrega();
                    }

                    a = 1;

                }

            }

            if (a == 0) {
                JOptionPane.showMessageDialog(null, "NÃO FOI ENCONTRADO ESSE CÓDIGO NO BANCO DE DADOS!");
            }
            limpar();
        } catch (Exception ex) {
     //       Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if(evt.getKeyCode() == 113){
            new formPesquisaProduto().setVisible(true);
          //  dispose();
        }else if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtEan.requestFocus();
        } 
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtEanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEanKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtDesricao.requestFocus();
        } 
    }//GEN-LAST:event_txtEanKeyPressed

    private void txtDesricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesricaoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            Caixa_Unidade.requestFocus();
        } 
    }//GEN-LAST:event_txtDesricaoKeyPressed

    private void txtPrecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecoMouseClicked
        txtPreco.selectAll();
    }//GEN-LAST:event_txtPrecoMouseClicked

    private void txtPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnSalvar.requestFocus();
        } 
    }//GEN-LAST:event_txtPrecoKeyPressed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            Salvar();
        } 
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void Caixa_UnidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Caixa_UnidadeKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            Caixa_Grupo.requestFocus();
        } 
    }//GEN-LAST:event_Caixa_UnidadeKeyPressed

    private void Caixa_GrupoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Caixa_GrupoKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtPreco.requestFocus();
            txtPreco.selectAll();
        } 
    }//GEN-LAST:event_Caixa_GrupoKeyPressed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        Caixa_Unidade.removeAllItems();
        Caixa_Grupo.removeAllItems();
        caixas_de_combinacao();        
    }//GEN-LAST:event_btnAtualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new formCadastraProduto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> Caixa_Grupo;
    private javax.swing.JComboBox<String> Caixa_Unidade;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDesricao;
    private javax.swing.JTextField txtEan;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables

    //  private void limpar() {
    //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //  }
}

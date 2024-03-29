/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoSoftware;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Emerson
 */

public class formCadastraGrupo extends javax.swing.JFrame {
 String Caso;
 String Caso2;
    private Connection con;
    
    /**
     * Creates new form formCadastraGrupo
     */
    public formCadastraGrupo() {
        initComponents();
        txtCodigo.setText("1");
        txtCodigo1.setText("1");
        txtDescricao.setDocument(new SoLetrasMaiusculas());
        txtDescricao1.setDocument(new SoLetrasMaiusculas());
        txtAbreviatura.setDocument(new SoLetrasMaiusculas());
       // this.setLocationRelativeTo(null);//Centralizar Jframe
        txtDescricao.requestFocus();
        seleciona();
        carregarImagens();
    }
    
    public void importaGrupo(String recebe){
        
        txtCodigo.setText(recebe);
        
    }
     public void importaUnidade(String recebe){
        
        txtCodigo1.setText(recebe);

    }
    
    public void seleciona(){
         try {
            this.con = database.getConnection();

            Produto PRO = new Produto();

            PRO.setCodigo(txtCodigo.getText());

            String PROCodigo = PRO.getCodigo();

            PreparedStatement busca = con.prepareStatement("select first(1) GRUPO_COD + 1 from CGRUPO a where not exists (select GRUPO_COD from CGRUPO B where B.GRUPO_COD = A.GRUPO_COD + 1) order by 1");

           ResultSet rs = busca.executeQuery();
           
           rs.next();

           txtCodigo.setText(rs.getString("ADD"));
           
           PreparedStatement busca2 = con.prepareStatement("select first(1) UNIDADE_COD + 1 from CUNIDADE a where not exists (select UNIDADE_COD from CUNIDADE B where B.UNIDADE_COD = A.UNIDADE_COD + 1) order by 1");

           ResultSet rs2 = busca2.executeQuery();
           
           rs2.next();

           txtCodigo1.setText(rs2.getString("ADD"));
                    
        } catch (Exception ex) {
            Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    public void carregarImagens(){
     ImageIcon inserir = new ImageIcon("C:/Imagem/09_Inserir.png");
     ImageIcon editar = new ImageIcon("C:/Imagem/06_Editar.png");
     ImageIcon pesquisar = new ImageIcon("C:/Imagem/11_Lupa.png");
     ImageIcon Voltar = new ImageIcon("C:/Imagem/20_Voltar.png");
     
        btnSalvar.setIcon(inserir);
        btnVoltar.setIcon(Voltar);
        btnEditar.setIcon(editar);
        btnBuscar.setIcon(pesquisar);
        btnSalvar1.setIcon(inserir);
        btnVoltar1.setIcon(Voltar);
        btnEditar1.setIcon(editar);
        btnBuscar1.setIcon(pesquisar);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        txtDescricao1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAbreviatura = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        btnSalvar1 = new javax.swing.JButton();
        btnVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Grupo / Unidade");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Código:");

        jLabel2.setText("Descrição:");

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnVoltar)
                    .addComponent(btnEditar)
                    .addComponent(btnBuscar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CADASTRO GRUPO", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Código:");

        jLabel4.setText("Descrição:");

        txtCodigo1.setEditable(false);
        txtCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo1ActionPerformed(evt);
            }
        });
        txtCodigo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigo1KeyPressed(evt);
            }
        });

        txtDescricao1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescricao1KeyPressed(evt);
            }
        });

        jLabel5.setText("Abreviatura:");

        txtAbreviatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbreviaturaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescricao1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescricao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        btnSalvar1.setText("Salvar");
        btnSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar1ActionPerformed(evt);
            }
        });

        btnVoltar1.setText("Voltar");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar1)
                    .addComponent(btnEditar1)
                    .addComponent(btnSalvar1)
                    .addComponent(btnVoltar1))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CADASTRO UNIDADE", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    public void limpar() {

       txtCodigo.setText("");
       txtDescricao.setText("");
       txtCodigo1.setText("");
       txtDescricao1.setText("");
       txtAbreviatura.setText("");
    }
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        try {
            this.con = database.getConnection();

            Grupo_Produto GRU = new Grupo_Produto();
            
            GRU.setCodigo(txtCodigo.getText());
            GRU.setDescricao(txtDescricao.getText());
            
            String GRUCod = GRU.codigo;
            String GRUDescricao = GRU.descricao;
    
            try ( //CRIA CONEXAO COM BANCO - PREPAREDSTATEMENT
                    PreparedStatement banco = con.prepareStatement("insert into cgrupo (grupo_cod,grupo_des) values (?,?)")) {
                
                banco.setString(1, GRUCod);
                banco.setString(2, GRUDescricao);
                
                banco.execute();

            }
             JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);

            limpar();
            seleciona();
            System.out.println("Gravado!");
            con.close();
            txtDescricao.requestFocus();
            
   
        } catch (Exception ex) {
            Logger.getLogger(formCadastraGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_btnSalvarActionPerformed
  
    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed

    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int num = 0; 
        try {
            this.con = database.getConnection();
            
            Grupo_Produto GRU = new Grupo_Produto();
            
            GRU.setCodigo(txtCodigo.getText());
            GRU.setNum(txtDescricao.getText());
            
            String GRUCodigo = GRU.codigo;
            
            try (PreparedStatement busca = con.prepareStatement("select grupo_des,grupo_cod from cgrupo")) {

                ResultSet rs = busca.executeQuery();
                
                while(rs.next()){
                    String GRUCod = rs.getString("GRUPO_COD");

                    if(GRUCod.trim().equals(GRUCodigo)){
                        Caso = rs.getString("GRUPO_DES"); //Variavel Global para fazer alteração na tabelas de produtos
                        
                        String Descrição = rs.getString("GRUPO_DES");
                        
                        txtDescricao.setText(Descrição);
                       num = 1; 
                    }
                
                }
       
            }
            if(num==0) JOptionPane.showMessageDialog(null, "NÃO TEM ESSE CÓDIGO CADASTRADO NO BANCO DE DADOS!");

        } catch (Exception ex) {
            Logger.getLogger(formCadastraGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnSalvar.setVisible(false);
    }//GEN-LAST:event_btnBuscarActionPerformed
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int num = 0;
        try {
            this.con = database.getConnection();
            
            Grupo_Produto GRU = new Grupo_Produto();
            
            GRU.setCodigo(txtCodigo.getText());
            GRU.setDescricao(txtDescricao.getText());
            
            
            String GRUCodigo = GRU.codigo;
            String GRUDescricao = GRU.descricao;

            try (PreparedStatement busca = con.prepareStatement("select grupo_des,grupo_cod from cgrupo")) {

                ResultSet rs = busca.executeQuery();
                
                while(rs.next()){
                    String GRUCod = rs.getString("GRUPO_COD");
                    
                    if(GRUCod.trim().equals(GRUCodigo)){
                        
                        try (PreparedStatement edit = con.prepareStatement("update cgrupo set grupo_des = '"+GRUDescricao+"' where grupo_cod = '"+GRUCod+"'")) {
                            edit.executeUpdate();
                            
                        }
                        
                        try (PreparedStatement edit2 = con.prepareStatement("update cpro set pro_grupo = '"+GRUDescricao+"' where pro_grupo = '"+Caso+"'")) {
                            edit2.executeUpdate();
                            
                        }
                        limpar();
                        seleciona();
                        num = 1;
                        con.close();
                    }
                
                }
       
            }
            if(num==0) JOptionPane.showMessageDialog(null, "NÃO TEM ESSE CÓDIGO CADASTRADO NO BANCO DE DADOS!");
        } catch (Exception ex) {
            Logger.getLogger(formCadastraGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo1ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
  int num = 0; 
        try {
            this.con = database.getConnection();
            
           Unidade_Produto GRU = new Unidade_Produto();
            
            GRU.setCodigo(txtCodigo1.getText());
            GRU.setDescricao(txtDescricao1.getText());
            GRU.setAbrev(txtAbreviatura.getText());
            
            
            String GRUCodigo = GRU.codigo;
            String GRUDescricao = GRU.descricao;
            String GRUAbreviatura = GRU.abrev;
            
            
            try (PreparedStatement busca = con.prepareStatement("select * from cunidade")) {

                ResultSet rs = busca.executeQuery();
                
                while(rs.next()){
                    String GRUCod = rs.getString("unidade_COD");

                    if(GRUCod.trim().equals(GRUCodigo)){
                        Caso2 = rs.getString("unidade_ABRE"); //Variavel Global para fazer alteração na tabelas de produtos
                        
                        String Descrição = rs.getString("unidade_DES");
                        String Abreviatura = rs.getString("unidade_abre");
                        
                        txtDescricao1.setText(Descrição);
                        txtAbreviatura.setText(Abreviatura);
                       num = 1; 
                    }
                
                }

            }
            if(num==0) JOptionPane.showMessageDialog(null, "NÃO TEM ESSE CÓDIGO CADASTRADO NO BANCO DE DADOS!");

        } catch (Exception ex) {
            Logger.getLogger(formCadastraGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }     
        btnSalvar1.setVisible(false);
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
      int num = 0;
        try {
            this.con = database.getConnection();
            
            Unidade_Produto GRU = new Unidade_Produto();
            
            GRU.setCodigo(txtCodigo1.getText());
            GRU.setDescricao(txtDescricao1.getText());
            GRU.setAbrev(txtAbreviatura.getText());
            
            
            
            String GRUCodigo = GRU.codigo;
            String GRUDescricao = GRU.descricao;
            String GRUAbreviatura = GRU.abrev;

            try (PreparedStatement busca = con.prepareStatement("select * from CUNIDADE")) {

                ResultSet rs = busca.executeQuery();
                
                while(rs.next()){
                    String GRUCod = rs.getString("UNIDADE_COD");
                    
                    if(GRUCod.trim().equals(GRUCodigo)){
                        
                        try (PreparedStatement edit = con.prepareStatement("update CUNIDADE set UNIDADE_des = '"+GRUDescricao+"',unidade_abre = '"+GRUAbreviatura+"' where UNIDADE_cod = '"+GRUCod+"'")) {
                            edit.executeUpdate();

                        }

                        try (PreparedStatement edit2 = con.prepareStatement("update cpro set pro_uni = '"+GRUAbreviatura+"' where pro_uni = '"+Caso2+"'")) {
                            edit2.executeUpdate();
                        }
                        con.close();
                        limpar();
                        seleciona();
                        num = 1;
                    }
                JOptionPane.showMessageDialog(null, "REGISTROS ALTERADOS COM SUCESSO!");
                }
            }
            if(num==0) JOptionPane.showMessageDialog(null, "NÃO TEM ESSE CÓDIGO CADASTRADO NO BANCO DE DADOS!");
        } catch (Exception ex) {
            Logger.getLogger(formCadastraGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar1ActionPerformed
         try {
            this.con = database.getConnection();

              Unidade_Produto GRU = new Unidade_Produto();
            
            GRU.setCodigo(txtCodigo1.getText());
            GRU.setDescricao(txtDescricao1.getText());
            GRU.setAbrev(txtAbreviatura.getText());
            
            
            String GRUCodigo = GRU.codigo;
            String GRUDescricao = GRU.descricao;
            String GRUAbreviatura = GRU.abrev;
    
            try ( //CRIA CONEXAO COM BANCO - PREPAREDSTATEMENT
                    PreparedStatement banco = con.prepareStatement("insert into cunidade (unidade_cod,unidade_des,unidade_abre) values (?,?,?)")) {
                
                banco.setString(1, GRUCodigo);
                banco.setString(2, GRUDescricao);
                banco.setString(3, GRUAbreviatura);
                
                banco.execute();

            }
             JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            limpar();
            seleciona();
            System.out.println("Gravado!");
            con.close();
            txtAbreviatura.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(formCadastraGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_btnSalvar1ActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
       dispose();
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if(evt.getKeyCode() == 113){
            new formPesquisaGrupo().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo1KeyPressed
         if(evt.getKeyCode() == 113){
            new formPesquisaUnidade().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_txtCodigo1KeyPressed

    private void txtAbreviaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbreviaturaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtDescricao1.requestFocus();
        }
    }//GEN-LAST:event_txtAbreviaturaKeyPressed

    private void txtDescricao1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricao1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnSalvar1.requestFocus();
        }
    }//GEN-LAST:event_txtDescricao1KeyPressed

    private void txtDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_txtDescricaoKeyPressed

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
            java.util.logging.Logger.getLogger(formCadastraGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCadastraGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCadastraGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCadastraGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCadastraGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvar1;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtAbreviatura;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDescricao1;
    // End of variables declaration//GEN-END:variables

   
}

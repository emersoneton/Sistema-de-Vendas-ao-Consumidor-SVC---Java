/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoSoftware;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AraujoRS
 */
public class TelaPrincipal2 extends javax.swing.JFrame {

    private Connection con;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal2(String user) {
        initComponents();
        //setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        lblUser.setText(user);
        //jMenuItem5.setEnabled(false);
        //JOptionPane.showMessageDialog(null, getTitle());
    }

    private TelaPrincipal2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblUser = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        Logof = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SVC - Sistemas de Vendas ao Consumidor");

        jDesktopPane1.setLayer(lblUser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(lblUser)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(lblUser)
                .addContainerGap())
        );

        jMenu1.setText("Cadastro");

        jMenuItem5.setText("Cliente");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Produto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem4.setText("Grupo Produto");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem11.setText("Documento de Caixa");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Vendas e Entradas");

        jMenuItem1.setText("Venda NFC-e");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem7.setText("Entradas NFE");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Relatório");

        jMenuItem2.setText("Relatório");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem10.setText("Fechamento de Caixa");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Ajuda");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu5.setText("Sair");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu5KeyPressed(evt);
            }
        });

        jMenuItem8.setText("Sair");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        Logof.setText("Logof");
        Logof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogofActionPerformed(evt);
            }
        });
        jMenu5.add(Logof);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        setBounds(0, 0, 312, 200);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       try {
            new formCadastra().setVisible(true);//Chama nova tela
            //formCadastra clientes;
            //clientes = new formCadastra();
            //jDesktopPane1.add(clientes);
            //clientes.show();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaPrincipal2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    private void cmdFormCliFornActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
    }                                              

    private void cmdFormUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                               
    try {
            this.con = database.getConnection();

            //VERIFICAR SE USUÁRIO JÁ EXISTE
            PreparedStatement posted = con.prepareStatement("SELECT USER_NOME,USER_SENHA,USER_TIPO,USER_STATUS FROM CUSER ");

            ResultSet rs = posted.executeQuery();

            while (rs.next()) {
                String nomeUser = rs.getString("USER_NOME");
                String permUser = rs.getString("USER_TIPO");

                if ((nomeUser.equals(lblUser.getText()))&&(permUser.equals("M"))) {
                    FormUsuario cadPerfil = new FormUsuario();
                    cadPerfil.setVisible(true);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Usuário não possui permissão para acessar esse módulo!");
        } catch (Exception ex) {

            Logger.getLogger(TelaPrincipal2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                              

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            this.con = database.getConnection();

            Cliente clienteTabela = new Cliente();
            clienteTabela.setNome(lblUser.getText());

            String usuario = clienteTabela.getNome();
            
            PreparedStatement posted = con.prepareStatement("SELECT * FROM CUSER WHERE "
                    + "(USER_NOME = ?)");
            
            posted.setString(1, usuario);
                        
            ResultSet rs = posted.executeQuery();

            while (rs.next()) {
                String linhaNome = rs.getString("USER_NOME");
                String linhaSenha = rs.getString("USER_SENHA");
                String linhaTipo = rs.getString("USER_TIPO");
                String linhaStatus = rs.getString("USER_STATUS");
                
                if (usuario.equals(linhaNome)) {
                 PreparedStatement banco = con.prepareStatement("update cuser set user_status = 0 where user_nome = '"+lblUser.getText()+"'");
                    banco.executeUpdate();
                    con.close();
                    rs.close();
                    posted.close();
                    banco.close();
                    //limpar();
                    dispose();//Fecha tela atual
                    new Login().setVisible(true);//Chama nova tela
                    return;   
                }
            }
                
        } catch (Exception ex) {

            Logger.getLogger(TelaPrincipal2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new formCadastraProduto().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new formCadastraGrupo().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new formVendas().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new formRelatorio().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new formLancaNota().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new formFechamentoDeCaixa().setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new formDocumentoSangrias().setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenu5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu5KeyPressed
        
    }//GEN-LAST:event_jMenu5KeyPressed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
       // dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        new formAjuda().setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void LogofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogofActionPerformed
        try {
            this.con = database.getConnection();

            Cliente clienteTabela = new Cliente();
            clienteTabela.setNome(lblUser.getText());

            String usuario = clienteTabela.getNome();
            
            PreparedStatement posted = con.prepareStatement("SELECT * FROM CUSER WHERE "
                    + "(USER_NOME = ?)");
            
            posted.setString(1, usuario);
                        
            ResultSet rs = posted.executeQuery();

            while (rs.next()) {
                String linhaNome = rs.getString("USER_NOME");
                String linhaSenha = rs.getString("USER_SENHA");
                String linhaTipo = rs.getString("USER_TIPO");
                String linhaStatus = rs.getString("USER_STATUS");
                
                if (usuario.equals(linhaNome)) {
                 PreparedStatement banco = con.prepareStatement("update cuser set user_status = 0 where user_nome = '"+lblUser.getText()+"'");
                    banco.executeUpdate();
                    con.close();
                    rs.close();
                    posted.close();
                    banco.close();
                    //limpar();
                    dispose();//Fecha tela atual
                    new Login().setVisible(true);//Chama nova tela
                    return;   
                }
            }
                
        } catch (Exception ex) {

            Logger.getLogger(TelaPrincipal2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LogofActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            this.con = database.getConnection();

            Cliente clienteTabela = new Cliente();
            clienteTabela.setNome(lblUser.getText());

            String usuario = clienteTabela.getNome();
            
            PreparedStatement posted = con.prepareStatement("SELECT * FROM CUSER WHERE "
                    + "(USER_NOME = ?)");
            
            posted.setString(1, usuario);
                        
            ResultSet rs = posted.executeQuery();

            while (rs.next()) {
                String linhaNome = rs.getString("USER_NOME");
                String linhaSenha = rs.getString("USER_SENHA");
                String linhaTipo = rs.getString("USER_TIPO");
                String linhaStatus = rs.getString("USER_STATUS");
                
                if (usuario.equals(linhaNome)) {
                 PreparedStatement banco = con.prepareStatement("update cuser set user_status = 0 where user_nome = '"+lblUser.getText()+"'");
                    banco.executeUpdate();
                    con.close();
                    rs.close();
                    posted.close();
                    banco.close();
                    //limpar();
                    dispose();//Fecha tela atual
                    return;   
                }
            }
                
        } catch (Exception ex) {

            Logger.getLogger(TelaPrincipal2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    public static void centralizar(JInternalFrame fr){  
    Dimension d = fr.getDesktopPane().getSize();  
    fr.setLocation((d.width - fr.getSize().width) / 2, (d.height - fr.getSize().height) / 2);     
}  

    
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
            java.util.logging.Logger.getLogger(TelaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Logof;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables

    
}

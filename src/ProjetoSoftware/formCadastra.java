package ProjetoSoftware;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public final class formCadastra extends javax.swing.JFrame {

    public formCadastra()throws FileNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);//Centralizar Jframe
        setResizable(false);//Não permite editar o tamanho
      //  setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        carregaEstado();
        carregarImagens();
        txtCPF.grabFocus();
        txtNumero.setDocument(new SoNumeros());
        txtNome.setDocument(new SoLetrasMaiusculas());
        txtNomePesquisa.setDocument(new SoLetrasMaiusculas());
        txtEndereco.setDocument(new SoLetrasMaiusculas());
        txtBairro.setDocument(new SoLetrasMaiusculas());
        txtCidade.setDocument(new SoLetrasMaiusculas());
        cmdCep.setForeground(Color.BLUE);
        ajusta_tamanho_coluna();
        //txtPhoneRes.setSize(116, 20);
        //txtPhoneCel.setSize(116, 20);
        //txtPhoneRes.setPreferredSize(new Dimension(116, 20));
        //txtPhoneCel.setPreferredSize(new Dimension(116, 20));
    }
    
    //PARA CHAMAR A CONEXAO
    private Connection con;
    //private DefaultTableModel tabela;

    public void carregarImagens(){
     ImageIcon inserir = new ImageIcon("C:/Imagem/09_Inserir.png");
     ImageIcon editar = new ImageIcon("C:/Imagem/06_Editar.png");
     ImageIcon excluir = new ImageIcon("C:/Imagem/07_Excluir.png");
     ImageIcon pesquisar = new ImageIcon("C:/Imagem/11_Lupa.png");
     ImageIcon excel = new ImageIcon("C:/Imagem/03_Excel.png");
     ImageIcon sair = new ImageIcon("C:/Imagem/08_Fechar.png");
          
        btnInserir.setIcon(inserir);
        btnEditar.setIcon(editar);
        btnExcluir.setIcon(excluir);
        btnPesquisar.setIcon(pesquisar);
        btnGeraExcel.setIcon(excel);
        btnSair.setIcon(sair);
        
        btnInserir.setHorizontalAlignment(SwingConstants.CENTER);
        btnEditar.setHorizontalAlignment(SwingConstants.CENTER);
        btnExcluir.setHorizontalAlignment(SwingConstants.CENTER);
        btnPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
        btnGeraExcel.setHorizontalAlignment(SwingConstants.CENTER);
        btnSair.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter CPF = new javax.swing.text.MaskFormatter("###.###.###-##");
            txtCPF = new javax.swing.JFormattedTextField(CPF);
        } catch (Exception e) {}
        txtNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
            txtCEP = new javax.swing.JFormattedTextField(cep);
        }catch (Exception e){}
        cmdCep = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtCEP = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
            txtCEP = new javax.swing.JFormattedTextField(cep);
        }catch (Exception e){}
        txtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmdEstado = new javax.swing.JComboBox<>();
        txtPhoneRes = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##) ####-####");

            txtPhoneRes = new javax.swing.JFormattedTextField(telefone);
        }catch(Exception e){
        }
        jLabel5 = new javax.swing.JLabel();
        txtPhoneCel = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter telefoneCel = new javax.swing.text.MaskFormatter("(##) #####-####");

            txtPhoneCel = new javax.swing.JFormattedTextField(telefoneCel);
        }catch(Exception e){
        }
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        try {
            javax.swing.text.MaskFormatter CNPJ = new javax.swing.text.MaskFormatter("##.###.###/####-##");
            txtCNPJ = new javax.swing.JFormattedTextField(CNPJ);
        } catch (Exception e) {
        }
        jLabel12 = new javax.swing.JLabel();
        cmdPesquisa = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtNomePesquisa = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cmdListarClientes = new javax.swing.JCheckBox();
        txtConsulta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnInserir = new javax.swing.JButton();
        btnGeraExcel = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jLabel1.setText("CPF:");

        jLabel2.setText("NOME:");

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });
        txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCPFKeyPressed(evt);
            }
        });

        jLabel10.setText("BAIRRO:");

        cmdCep.setText("PROCESSAR");
        cmdCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCepActionPerformed(evt);
            }
        });

        jLabel4.setText("CEP:");

        jLabel3.setText("END:");

        jLabel7.setText("Nº:");

        jLabel6.setText("CITY:");

        jLabel9.setText("UF:");

        txtPhoneRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneResActionPerformed(evt);
            }
        });

        jLabel5.setText("PF RES:");

        jLabel8.setText("PF CEL:");

        jLabel11.setText("E-MAIL:");

        txtCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCNPJActionPerformed(evt);
            }
        });
        txtCNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCNPJKeyPressed(evt);
            }
        });

        jLabel12.setText("CNPJ:");

        cmdPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdPesquisa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(cmdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(cmdCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPhoneRes)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addComponent(txtPhoneCel, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCep)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(30, 30, 30))
        );

        jTabbedPane2.addTab("Cad. Cliente | Fornecedor", jPanel1);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "CNPJ", "NOME - CLIENTE | FORNECEDOR"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel13.setText("NOME:");

        txtNomePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePesquisaActionPerformed(evt);
            }
        });
        txtNomePesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomePesquisaKeyReleased(evt);
            }
        });

        cmdListarClientes.setText("LC");
        cmdListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdListarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdListarClientes)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(txtConsulta))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdListarClientes)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Pesq. Cliente | Fornecedor", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Comandos ..."));

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnGeraExcel.setText("Excel");
        btnGeraExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeraExcelActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Buscar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnLimpar.setText("Clear");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGeraExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGeraExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if((cmdPesquisa.isSelected()==true)&&(txtCNPJ.getText().replace("-", "").replace("/", "").replace(".", "").trim().isEmpty()==true)){
            JOptionPane.showMessageDialog(null, "Campo CNPJ de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            txtCNPJ.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }
        if((cmdPesquisa.isSelected()==false)&&(txtCPF.getText().replace("-", "").replace(".", "").trim().isEmpty()==true)){
            JOptionPane.showMessageDialog(null, "Campo CPF de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            txtCPF.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }
        if(txtNome.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo NOME de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            txtNome.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }
        if(txtCEP.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo CEP de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            txtCEP.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }
        if(txtBairro.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo BAIRRO de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            txtBairro.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }        
        if(txtEndereco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo ENDEREÇO de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            txtEndereco.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }
        if(txtNumero.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo NUMERO de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            txtNumero.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }        
        if(txtCidade.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo CIDADE de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            txtCidade.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }        
        if(cmdEstado.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Campo ESTADO de preenchimento obrigatório!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            cmdEstado.grabFocus();
            return;
            //throw new IllegalArgumentException("Números naturais não podem ser negativos!");
        }
        
        try {
            this.con = database.getConnection();

            //CHAMANDO A CLASSE CLIENTE  DO NOME CLI
            Cliente CLI = new Cliente();

            //ESCREVENDO OS BOTÕES DENTRO DAS VARIAVEIS CRIADAS NA CLASSE CLIENTE
            CLI.setCpf(txtCPF.getText());
            CLI.setCnpj(txtCNPJ.getText());
            CLI.setNome(txtNome.getText());
            CLI.setEndereco(txtEndereco.getText());
            CLI.setNumero(txtNumero.getText());
            CLI.setCidade(txtCidade.getText());
            CLI.setCep(txtCEP.getText());
            CLI.setTelefone(txtPhoneRes.getText());
            CLI.setTelefoneCelular(txtPhoneCel.getText());
            CLI.setEmail(txtEmail.getText());
            CLI.setEstado((String) cmdEstado.getSelectedItem());
            CLI.setBairro(txtBairro.getText());
            
            //RECEBER TUDO QUE FOI DIGITADO NOS BOTÕES ACIMA
            String CLIcpf = CLI.cpf;
            String CLIcnpj = CLI.cnpj;
            String CLINome = CLI.nome;
            String CLIendereco = CLI.endereco;
            String CLInumero = CLI.numero;
            String CLIcidade = CLI.cidade;
            String CLIcep = CLI.cep;
            String CLIphoneRes = CLI.telefone;
            String CLIphoneCel = CLI.telefoneCelular;
            String CLIestado = CLI.estado;
            String CLIemail = CLI.email;
            String CLIbairro = CLI.bairro;
            //String CLIcodigoCliente = CLI.codCliente;
            
            String ultimoValor = null;
            String id_cliente = null;
            int valor = 1;
            PreparedStatement codCli = con.prepareStatement("select * from CCLI order by CLI_COD ");
            ResultSet rsr = codCli.executeQuery();
                while(rsr.next()==true){
                    ultimoValor = rsr.getString("CLI_COD");
                }
                
                int cod = Integer.parseInt(ultimoValor.trim()) + valor;
                id_cliente = Integer.toString(cod);
                
             if (id_cliente == null){
                 id_cliente = "1";
             }
            
            System.out.println(id_cliente);
            //CRIA CONEXAO COM BANCO - PREPAREDSTATEMENT
            PreparedStatement banco = con.prepareStatement("insert into CCLI (CLI_CPF,CLI_CNPJ,CLI_NOME,CLI_ENDERECO,CLI_NUMERO,CLI_CEP,CLI_TELEFONE1,CLI_TELEFONE2,CLI_EMAIL,CLI_CIDADE,CLI_ESTADO,CLI_BAIRRO,CLI_COD) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //PREENCHE OS VALORES DO BANCO
            banco.setString(1, CLIcpf);
            banco.setString(2, CLIcnpj);
            banco.setString(3, CLINome);
            banco.setString(4, CLIendereco);
            banco.setString(5, CLInumero);
            banco.setString(6, CLIcep);
            banco.setString(7, CLIphoneRes);
            banco.setString(8, CLIphoneCel);
            banco.setString(9, CLIemail);
            banco.setString(10, CLIcidade);
            banco.setString(11, CLIestado);
            banco.setString(12, CLIbairro);
            banco.setString(13, id_cliente);
            
            //EXECUTA
            rsr.close();
            codCli.close();
            
            banco.execute();
            banco.close();
            
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
            limpar();
            carregaEstado();
            System.out.println("Gravado!");
            con.close();
            
            System.out.println("CPF: " + CLIcpf);
            System.out.println("CNPJ: " + CLIcnpj);
            System.out.println("NOME: " + CLINome);
            System.out.println("ENDEREÇO: " + CLIendereco);
            System.out.println("NUMERO: " + CLInumero);
            System.out.println("CIDADE: " + CLIcidade);
            System.out.println("CEP: " + CLIcep);
            System.out.println("PHONE RES: " + CLIphoneRes);
            System.out.println("PHONE CEL: " + CLIphoneCel);
            System.out.println("ESTADO [UF]: " + CLIestado);
            System.out.println("E-MAIL: " + CLIemail);

        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    public void limpar() {
        txtCEP.setBackground(null);
        txtEndereco.setBackground(null);
        txtBairro.setBackground(null);
        txtCidade.setBackground(null);
        txtCPF.setText("");
        txtCNPJ.setText("");
        cmdCep.setSelected(false);
        cmdPesquisa.setSelected(false);
        txtCEP.setText("");
        txtNome.setText("");
        txtEndereco.setText("");
        txtCidade.setText("");
        txtPhoneRes.setText("");
        txtPhoneCel.setText("");
        txtBairro.setText("");
        txtNumero.setText("");
        cmdEstado.removeAllItems();
        txtEmail.setText("");
        txtBairro.setText("");
        txtCPF.requestFocus();
    }
    
        public void buscaCep() {
            //Faz a busca para o cep 58043-280
            WebServiceCep webServiceCep = WebServiceCep.searchCep(txtCEP.getText());
            //A ferramenta de busca ignora qualquer caracter que nao seja numero.
            //caso a busca ocorra bem, imprime os resultados.
            if (webServiceCep.wasSuccessful()) {
                txtEndereco.setText(webServiceCep.getLogradouroFull());
                txtCidade.setText(webServiceCep.getCidade());
                txtBairro.setText(webServiceCep.getBairro());
                cmdEstado.setSelectedItem(webServiceCep.getUf());
                //System.out.println("Cep: " + webServiceCep.getCep());
                //System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
                //System.out.println("Bairro: " + webServiceCep.getBairro());
                //System.out.println("Cidade: "
                //+ webServiceCep.getCidade() + "/" + webServiceCep.getUf());

                //caso haja problemas imprime as exce??es.
            } else {
                //JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());

                //JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
                JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode()
                        +"\nDescrição do erro: " + webServiceCep.getResultText(),
                        "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
    }
        
    private void btnGeraExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeraExcelActionPerformed
        chamaToExcel();
    }//GEN-LAST:event_btnGeraExcelActionPerformed

    public void chamaToExcel(){
        {
            JFileChooser fc = new JFileChooser();
            int option = fc.showSaveDialog(tabela);  // da erro aqui
            if (option == JFileChooser.APPROVE_OPTION) {
                String filename = fc.getSelectedFile().getName();
                String path = fc.getSelectedFile().getParentFile().getPath();
                int len = filename.length();
                String ext = "";
                String file = "";
                if (len > 4) {
                    ext = filename.substring(len - 4, len);
                }
                if (ext.equals(".xls")) {
                    file = path + "\\" + filename;
                } else {
                    file = path + "\\" + filename + ".xls";
                }
                toExcel(tabela, new File(file));
            }
            JOptionPane.showMessageDialog(null,
                    "ARQUIVO GERADO COM SUCESSO!" + "\n"
                    + "DIRETÓRIO: " + fc.getSelectedFile().getParentFile().getPath() + "\\" + fc.getSelectedFile().getName());
        } 
}
   

    public void toExcel(JTable tabela, File file){
        try {
            TableModel model = tabela.getModel();
            FileWriter excel = new FileWriter(file);
            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write(model.getColumnName(i) + "\t");
            }
            excel.write("\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i, j).toString() + "\t");
                }
                excel.write("\n");
            }
            excel.close();
        } catch (IOException e) {
            System.out.println(e);
        }
}          
    
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    public void buscaCNPJ(){
        try {
            this.con = database.getConnection();
            //Statement st = con.createStatement();

            Cliente clienteTabela = new Cliente();
            clienteTabela.setCnpj(txtCNPJ.getText());
            
            String resultCnpj = clienteTabela.getCnpj();
            //PreparedStatement posted = con.prepareStatement("INSERT INTO CCLI(NOME_CLIENTE, END_CLIENTE, COD_CLIENTE) VALUES ('" + resultNome + "')");
            //PreparedStatement posted = con.prepareStatement("SELECT * FROM CCLI WHERE CLI_CPF='" + resultCpf + "'");
            PreparedStatement posted = con.prepareStatement("SELECT CLI_CPF,CLI_CNPJ,CLI_NOME,CLI_ENDERECO,CLI_NUMERO,"
                    + "CLI_CEP,CLI_TELEFONE1,CLI_TELEFONE2,CLI_EMAIL,CLI_CIDADE,CLI_ESTADO,CLI_BAIRRO FROM CCLI ");

            ResultSet rs = posted.executeQuery();

            //rs.beforeFirst(); // move o cursor para o início do result set.
            while (rs.next()) {
                String linhaCNPJ = rs.getString("CLI_CNPJ");
                //if (rs.next() == true) {
                if (linhaCNPJ.trim().equals(resultCnpj)) {
                    String cpf = rs.getString("CLI_CPF");
                    String nome = rs.getString("CLI_NOME");
                    String endereco = rs.getString("CLI_ENDERECO");
                    String numero = rs.getString("CLI_NUMERO");
                    String cep = rs.getString("CLI_CEP");
                    String phoneRes = rs.getString("CLI_TELEFONE1");
                    String phoneCel = rs.getString("CLI_TELEFONE2");
                    String email = rs.getString("CLI_EMAIL");
                    String cidade = rs.getString("CLI_CIDADE");
                    String estado = rs.getString("CLI_ESTADO");
                    String bairro = rs.getString("CLI_BAIRRO");

                    txtCPF.setText(cpf);
                    txtNome.setText(nome);
                    txtEndereco.setText(endereco);
                    txtNumero.setText(numero);
                    txtCEP.setText(cep);
                    txtPhoneRes.setText(phoneRes);
                    txtPhoneCel.setText(phoneCel);
                    txtEmail.setText(email);
                    txtCidade.setText(cidade);
                    cmdEstado.setSelectedItem(estado);
                    txtBairro.setText(bairro);

                    //con.close();
                    //rs.close();
                    //posted.close();
                    JOptionPane.showMessageDialog(null, "CNPJ: " + txtCNPJ.getText() + "\n"
                            + "Cliente: " + txtNome.getText() + " encontrado com sucesso!",
                            "", JOptionPane.PLAIN_MESSAGE);

                    //posted.executeUpdate();
                    con.close();
                    rs.close();
                    posted.close();
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "CNPJ " + txtCNPJ.getText() + " não localizado!",
                    "", JOptionPane.PLAIN_MESSAGE);

            con.close();
            rs.close();
            posted.close();
            limpar();

        } catch (Exception ex) {
            Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscaCPF(){
        try {
            this.con = database.getConnection();
            //Statement st = con.createStatement();

            Cliente clienteTabela = new Cliente();
            clienteTabela.setCpf(txtCPF.getText());

            String resultCpf = clienteTabela.getCpf();
            //PreparedStatement posted = con.prepareStatement("INSERT INTO CCLI(NOME_CLIENTE, END_CLIENTE, COD_CLIENTE) VALUES ('" + resultNome + "')");
            //PreparedStatement posted = con.prepareStatement("SELECT * FROM CCLI WHERE CLI_CPF='" + resultCpf + "'");
            PreparedStatement posted = con.prepareStatement("SELECT CLI_CPF,CLI_CNPJ,CLI_NOME,CLI_ENDERECO,CLI_NUMERO,"
                    + "CLI_CEP,CLI_TELEFONE1,CLI_TELEFONE2,CLI_EMAIL,CLI_CIDADE,CLI_ESTADO,CLI_BAIRRO FROM CCLI ");

            ResultSet rs = posted.executeQuery();

            //rs.beforeFirst(); // move o cursor para o início do result set.
            while (rs.next()) {
                String linha = rs.getString("CLI_CPF");
                //if (rs.next() == true) {
                if (linha.trim().equals(resultCpf)) {
                    String cnpj = rs.getString("CLI_CNPJ");
                    String nome = rs.getString("CLI_NOME");
                    String endereco = rs.getString("CLI_ENDERECO");
                    String numero = rs.getString("CLI_NUMERO");
                    String cep = rs.getString("CLI_CEP");
                    String phoneRes = rs.getString("CLI_TELEFONE1");
                    String phoneCel = rs.getString("CLI_TELEFONE2");
                    String email = rs.getString("CLI_EMAIL");
                    String cidade = rs.getString("CLI_CIDADE");
                    String estado = rs.getString("CLI_ESTADO");
                    String bairro = rs.getString("CLI_BAIRRO");

                    txtCNPJ.setText(cnpj);
                    txtNome.setText(nome);
                    txtEndereco.setText(endereco);
                    txtNumero.setText(numero);
                    txtCEP.setText(cep);
                    txtPhoneRes.setText(phoneRes);
                    txtPhoneCel.setText(phoneCel);
                    txtEmail.setText(email);
                    txtCidade.setText(cidade);
                    cmdEstado.setSelectedItem(estado);
                    txtBairro.setText(bairro);

                    //con.close();
                    //rs.close();
                    //posted.close();
                    JOptionPane.showMessageDialog(null, "CPF: " + txtCPF.getText() + "\n"
                            + "Cliente: " + txtNome.getText() + " encontrado com sucesso!",
                            "", JOptionPane.PLAIN_MESSAGE);

                    //posted.executeUpdate();
                    con.close();
                    rs.close();
                    posted.close();
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "CPF " + txtCPF.getText() + " não localizado!",
                    "", JOptionPane.PLAIN_MESSAGE);

            con.close();
            rs.close();
            posted.close();
            limpar();

        } catch (Exception ex) {
            Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (cmdPesquisa.isSelected()) {
            buscaCNPJ();
        } else {
            buscaCPF();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
        carregaEstado();
        //repaint();
        //revalidate();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            this.con = database.getConnection();
            //Statement st = con.createStatement();

            //CHAMANDO A CLASSE CLIENTE  DO NOME CLI
            Cliente CLI = new Cliente();

            //ESCREVENDO OS BOTÕES DENTRO DAS VARIAVEIS CRIADAS NA CLASSE CLIENTE
            CLI.setCpf(txtCPF.getText());
            CLI.setCnpj(txtCNPJ.getText());
            CLI.setNome(txtNome.getText());
            CLI.setEndereco((String) txtEndereco.getText());
            CLI.setNumero(txtNumero.getText());
            CLI.setCidade(txtCidade.getText());
            CLI.setCep(txtCEP.getText());
            CLI.setTelefone(txtPhoneRes.getText());
            CLI.setTelefoneCelular(txtPhoneCel.getText());
            CLI.setEmail(txtEmail.getText());
            CLI.setEstado((String) cmdEstado.getSelectedItem());
            CLI.setBairro(txtBairro.getText());

            //RECEBER TUDO QUE FOI DIGITADO NOS BOTÕES ACIMA
            String CLIcpf = CLI.cpf;
            String CLIcnpj = CLI.cnpj;
            String CLINome = CLI.nome;
            String CLIendereco = CLI.endereco;
            String CLInumero = CLI.numero;
            String CLIcidade = CLI.cidade;
            String CLIcep = CLI.cep;
            String CLIphoneRes = CLI.telefone;
            String CLIphoneCel = CLI.telefoneCelular;
            String CLIestado = CLI.estado;
            String CLIemail = CLI.email;
            String CLIbairro = CLI.bairro;

            int resposta = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente alterar o CPF: [" + CLIcpf + "] selecionado?",
                    "title", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                String sql = "UPDATE CCLI SET CLI_CNPJ=?, CLI_NOME=?, CLI_ENDERECO=?, CLI_NUMERO=?, CLI_CEP=?, CLI_TELEFONE1=?, CLI_TELEFONE2=?, CLI_EMAIL=?, CLI_CIDADE=?, CLI_ESTADO=?, CLI_BAIRRO=? WHERE CLI_CPF=? ";
                PreparedStatement posted = con.prepareStatement(sql);
                posted.setString(1, CLIcnpj);
                posted.setString(2, CLINome);
                posted.setString(3, CLIendereco);
                posted.setString(4, CLInumero);
                posted.setString(5, CLIcep);
                posted.setString(6, CLIphoneRes);
                posted.setString(7, CLIphoneCel);
                posted.setString(8, CLIemail);
                posted.setString(9, CLIcidade);
                posted.setString(10, CLIestado);
                posted.setString(11, CLIbairro);
                posted.setString(12, CLIcpf);
                
                posted.executeUpdate();
                con.close();
                                            //CLI_NOME,CLI_CPF,CLI_ENDERECO,CLI_NUMERO,CLI_CEP,CLI_TELEFONE1,CLI_TELEFONE2,CLI_EMAIL,CLI_CIDADE,CLI_ESTADO,CLI_BAIRRO
                //PreparedStatement posted = con.prepareStatement("UPDATE CCLI SET CLI_NOME='" + CLINome + " WHERE CLI_CPF = '"+CLIcpf+"'");
                /*PreparedStatement posted = con.prepareStatement("UPDATE CCLI SET CLI_NOME='" + CLINome +
                        "',CLI_ENDERECO='" + CLIendereco +
                        "',CLI_NUMERO='" + CLInumero +
                        "',CLI_CEP='" + CLIcep +
                        "',CLI_TELEFONE1='" + CLIphoneRes +
                        "',CLI_TELEFONE2='" + CLIphoneCel +
                        "',CLI_EMAIL='" + CLIemail +
                        "',CLI_CIDADE='" + CLIcidade +
                        "',CLI_ESTADO='" + CLIestado +
                        "',CLI_BAIRRO='" + CLIbairro + " WHERE CLI_CPF = '"+CLIcpf+"'");*/

                JOptionPane.showMessageDialog(null, "Dado alterado com Sucesso ! ",
                        "", JOptionPane.PLAIN_MESSAGE);
                limpar();
                carregaEstado();

            } else if (resposta == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Opção cancelada pelo usuário!",
                        "", JOptionPane.PLAIN_MESSAGE);
                limpar();
                carregaEstado();
            }

        } catch (Exception ex) {
            Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
        }
                                 
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
                
        try {
            this.con = database.getConnection();
            //Statement st = con.createStatement();

            Cliente clienteTabela = new Cliente();
            clienteTabela.setCpf(txtCPF.getText());

            String resultCPF = clienteTabela.getCpf();

            System.out.println("CPF: " + resultCPF);

            int resposta = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente excluir o CPF: [" + resultCPF + "] selecionado?",
                    "title", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                PreparedStatement posted = con.prepareStatement("DELETE FROM CCLI WHERE CLI_CPF='" + resultCPF + "'");

                JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso ! ",
                        "", JOptionPane.PLAIN_MESSAGE);

                posted.executeUpdate();

                con.close();
                limpar();
                carregaEstado();

            } else if (resposta == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Opção cancelada pelo usuário!",
                        "Mensagem", JOptionPane.PLAIN_MESSAGE);
                limpar();
            }

        } catch (Exception ex) {
            Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
       /* try {
            this.con = database.getConnection();
            //Statement st = con.createStatement();

            //CHAMANDO A CLASSE CLIENTE  DO NOME CLI
            Cliente CLI = new Cliente();

            //ESCREVENDO OS BOTÕES DENTRO DAS VARIAVEIS CRIADAS NA CLASSE CLIENTE
            CLI.setCpf(txtCPF.getText());
            CLI.setNome(txtNome.getText());
            CLI.setEndereco((String)txtEndereco.getText());
            CLI.setNumero(txtNumero.getText());
            CLI.setCidade(txtCidade.getText());
            CLI.setCep(txtCEP.getText());
            CLI.setTelefone(txtPhoneRes.getText());
            CLI.setTelefoneCelular(txtPhoneCel.getText());
            CLI.setEmail(txtEmail.getText());
            CLI.setEstado((String) cmdEstado.getSelectedItem());
            CLI.setBairro(txtBairro.getText());
            
            //RECEBER TUDO QUE FOI DIGITADO NOS BOTÕES ACIMA
            String CLIcpf = CLI.cpf;
            String CLINome = CLI.nome;
            String CLIendereco = CLI.endereco;
            String CLInumero = CLI.numero;
            String CLIcidade = CLI.cidade;
            String CLIcep = CLI.cep;
            String CLIphoneRes = CLI.telefone;
            String CLIphoneCel = CLI.telefoneCelular;
            String CLIestado = CLI.estado;
            String CLIemail = CLI.email;
            String CLIbairro = CLI.bairro;

            String sgl = ("DELETE FROM CCLI WHERE CLI_CPF='"+CLIcpf+"'");
            PreparedStatement delete = con.prepareStatement(sgl);
            //editar.setString(1, CLINome);
            //editar.setString(2, txtCPF.getText());
            //editar.setString(3, CLIendereco);
            //editar.setString(4, CLInumero);
            //editar.setString(5, CLIcep);
            //editar.setString(6, CLIphoneRes);
            //editar.setString(7, CLIphoneCel);
            //editar.setString(8, CLIemail);
            //editar.setString(9, CLIcidade);
            //editar.setString(10, CLIestado);
            //editar.setString(11, CLIbairro);
            
            int rowsUpdate = delete.executeUpdate();
            
            int resposta = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente excluir o CPF: [" + CLIcpf + "] selecionado?",
                    "Mensagem", JOptionPane.YES_NO_OPTION);
            
            if(rowsUpdate > 0){
                System.out.println("CPF deletado com sucesso!");
                JOptionPane.showMessageDialog(null, "CPF deletado com sucesso!", "Mensagem",
                    JOptionPane.INFORMATION_MESSAGE);
                    limpar();
            }
            delete.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cmdPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPesquisaActionPerformed
        if(cmdPesquisa.isSelected()){
            txtCPF.setText("");
            txtCNPJ.setText("");
            cmdPesquisa.setText("CNPJ selecionado!");
            txtCNPJ.grabFocus();
        }else{
            cmdPesquisa.setText("");
            txtCNPJ.setText("");
        }
    }//GEN-LAST:event_cmdPesquisaActionPerformed

    private void txtCNPJKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCNPJKeyPressed

    }//GEN-LAST:event_txtCNPJKeyPressed

    private void txtCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCNPJActionPerformed

    private void txtPhoneResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneResActionPerformed

    }//GEN-LAST:event_txtPhoneResActionPerformed

    private void cmdCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCepActionPerformed
        if (txtCEP.getText().replace("-", "").trim().isEmpty()==true) {
            //txtCEP.getText().replace("(","").replace(")","").replace("-","");
            JOptionPane.showMessageDialog(null, "Campo CEP de preenchimento obrigatório!",
                "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            cmdCep.setSelected(false);
            txtCEP.setText(null);
            txtCEP.grabFocus();
            return;
        }
        if (cmdCep.isSelected()) {
            buscaCep();
            if(txtEndereco.getText().trim().isEmpty()){
                cmdCep.setSelected(false);
                txtCEP.setBackground(null);
                txtEndereco.setBackground(null);
                txtBairro.setBackground(null);
                txtCidade.setBackground(null);
                txtCEP.setText(null);
                txtCEP.setText("");
                txtEndereco.setText("");
                txtNumero.setText("");
                txtCidade.setText("");
                txtBairro.setText("");
                cmdEstado.setSelectedItem(null);
                txtCEP.grabFocus();
                return;
            }
            txtCEP.setBackground(Color.YELLOW);
            txtEndereco.setBackground(Color.YELLOW);
            txtBairro.setBackground(Color.YELLOW);
            txtCidade.setBackground(Color.YELLOW);
            txtNumero.grabFocus();
        } else {
            txtCEP.setBackground(null);
            txtEndereco.setBackground(null);
            txtBairro.setBackground(null);
            txtCidade.setBackground(null);
            txtCEP.setText("");
            txtEndereco.setText("");
            txtNumero.setText("");
            txtCidade.setText("");
            txtBairro.setText("");
            cmdEstado.setSelectedItem(null);
            txtCEP.grabFocus();
        }
    }//GEN-LAST:event_cmdCepActionPerformed

    private void txtCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFKeyPressed

    }//GEN-LAST:event_txtCPFKeyPressed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void cmdListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarClientesActionPerformed
        if (cmdListarClientes.isSelected()) {
            DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
            try {
                this.con = database.getConnection();

                PreparedStatement posted = con.prepareStatement("SELECT * FROM CCLI");

                ResultSet rs = posted.executeQuery();

                if (rs != null) {
                    while (rs.next()) {
                        tab.addRow(new String[]{
                            rs.getString("CLI_CPF"),
                            rs.getString("CLI_CNPJ"),
                            rs.getString("CLI_NOME"),});
                    }
                }

                JOptionPane.showMessageDialog(null, "CADASTRO DE CLIENTES | FORNECEDORES!" + "\n"
                        + "" + txtNome.getText() + " CARREGADOS COM SUCESSO",
                        "", JOptionPane.PLAIN_MESSAGE);

                con.close();
                rs.close();
                posted.close();

            } catch (Exception ex) {
                Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //O DefaultTableModel serve para colocar os dados
            //(colunas e linhas) de uma tabela, separado do objeto tabela (JTable).
            TableRowSorter sorter = null;
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();        
            sorter = new TableRowSorter<TableModel>(modelo);
            tabela.setRowSorter(sorter);
        
            txtConsulta.setText("");
            txtNomePesquisa.setText("");
            DefaultTableModel dm = (DefaultTableModel)tabela.getModel();
            sorter.setRowFilter(null);
            dm.getDataVector().removeAllElements();	
            tabela.repaint();
        }
    }//GEN-LAST:event_cmdListarClientesActionPerformed

    private void ajusta_tamanho_coluna(){
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();        
        tabela.setModel(model);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(300);
        model.fireTableDataChanged();
    }
    
    private void txtNomePesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomePesquisaKeyReleased
        TableRowSorter sorter = null;
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();        
        sorter = new TableRowSorter<TableModel>(modelo);
        tabela.setRowSorter(sorter);

        String text = txtNomePesquisa.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txtNomePesquisaKeyReleased

    private void txtNomePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePesquisaActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
                               
    int linhaSelecionada = tabela.getSelectedRow(); //retorna a linha selecionada
    //txtConsulta.setText("" + tabela.getValueAt(linhaSelecionada, 0));
    Object CPF = tabela.getValueAt(linhaSelecionada, 0);
    Object CNPJ = tabela.getValueAt(linhaSelecionada, 1);
    Object Nome = tabela.getValueAt(linhaSelecionada, 2);
    txtConsulta.setText("" + CPF + " - " + CNPJ + " - " + Nome);
    
     //JTable table = new JTable(tabela);
     DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();        
           RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
           tabela.setRowSorter(sorter);
//atribui o valor da linha, coluna 1 a um jTextField
// no lugar de 1 coloque o numero da coluna que deseja passar para o textfield sendo que a contagem começa em Zero.
    }//GEN-LAST:event_tabelaMouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        /*if ( jTabbedPane2.getSelectedIndex () == 0 ){
            limpar();
        }
        if ( jTabbedPane2.getSelectedIndex () == 1 ){
            limpar();
        }*/
    }//GEN-LAST:event_jTabbedPane2MouseClicked
         
    public void carregaEstado(){
        cmdEstado.removeAllItems();
        cmdEstado.addItem("AC");
        cmdEstado.addItem("AL");
        cmdEstado.addItem("AM");
        cmdEstado.addItem("AP");
        cmdEstado.addItem("BA");
        cmdEstado.addItem("CE");
        cmdEstado.addItem("DF");
        cmdEstado.addItem("ES");
        cmdEstado.addItem("GO");
        cmdEstado.addItem("MA");
        cmdEstado.addItem("MG");
        cmdEstado.addItem("MS");
        cmdEstado.addItem("MT");
        cmdEstado.addItem("PA");
        cmdEstado.addItem("PB");
        cmdEstado.addItem("PE");
        cmdEstado.addItem("PI");
        cmdEstado.addItem("PR");
        cmdEstado.addItem("RJ");
        cmdEstado.addItem("RN");
        cmdEstado.addItem("RO");
        cmdEstado.addItem("RR");
        cmdEstado.addItem("RS");
        cmdEstado.addItem("SC");
        cmdEstado.addItem("SE");
        cmdEstado.addItem("SP");
        cmdEstado.addItem("TO");
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new formCadastra().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGeraExcel;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox cmdCep;
    private javax.swing.JComboBox<String> cmdEstado;
    private javax.swing.JCheckBox cmdListarClientes;
    private javax.swing.JCheckBox cmdPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomePesquisa;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPhoneCel;
    private javax.swing.JTextField txtPhoneRes;
    // End of variables declaration//GEN-END:variables
}


package ProjetoSoftware;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class formVendas extends javax.swing.JFrame {

    DefaultListModel MODELO;
    private Connection con;
    private int viewRow;
    int item = 1;

    
    public formVendas() {
        initComponents();
        int modelRow = tabela.convertRowIndexToModel(viewRow);
        txtValorTotal.setForeground(Color.BLUE);
        txtDesconto.setForeground(Color.RED);
        txtTotalNota.setForeground(Color.BLUE);
        txtDescontoNota.setForeground(Color.RED);
        txtValorTotal.setText("0.00");
        txtDesconto.setText("0.00");
        txtQuantidade.setDocument(new SoNumeros());
        txtCodigo.setDocument(new SoNumeros());
        txtCodigo.setDocument(new SoLetrasMaiusculas());
        txtNumeroFatura.setEditable(false);
        carregar();
        Iniciar();
        NumeroFatura();
        Receita();
        carregarImagens();
    }
    public void importaNota(String recebe){
        
        txtCodigoBusca.setText(recebe);
        
    }
    public void importaCliente(String recebe){
        
        txtCodigoCliente.setText(recebe);
        
    }
    public void Iniciar(){
      txtQuantidade.setText("1");
      txtCodigo.requestFocus();
      txtDinheiro.setText("0.00");
    }
    public void NumeroFatura(){
        try {
            this.con = database.getConnection();
            
                     PreparedStatement busca = con.prepareStatement("select first(1) nfenum + 1 from ctenfe a where not exists (select nfenum from ctenfe B where B.nfenum = A.nfenum + 1 and nfeope = '065') order by 1");

                      ResultSet rs = busca.executeQuery();
                       if(!rs.isBeforeFirst()){
                            txtNumeroFatura.setText("1");
                         }else{
                            rs.next();
                            txtNumeroFatura.setText(rs.getString("ADD"));
                       }

        } catch (Exception ex) {
         //   Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void carregar(){
            DefaultTableModel tab = (DefaultTableModel) tabela.getModel();
         //   SwingUtilities.updateComponentTreeUI(formVendas);
        //    formVendas.repaint();
            try {
                this.con = database.getConnection();

                try (PreparedStatement posted = con.prepareStatement("select * from cpro ORDER BY PRO_DES"); 
                        ResultSet rs = posted.executeQuery()) {
                    
                    
                    if (rs != null) {
                        while (rs.next()) {
                            tab.addRow(new String[]{
                                rs.getString("PRO_COD"),rs.getString("PRO_DES"),rs.getString("PRO_EAN"),});
                        }
                    }
                    
                    con.close();
                }

            } catch (Exception ex) {
                Logger.getLogger(formCadastra.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     
    public void Receita(){
         try {
            this.con = database.getConnection();
            
                     PreparedStatement busca = con.prepareStatement("select * from docrec WHERE DOCSIT = '0' order by docnum");

                      ResultSet rs = busca.executeQuery();
                       while(rs.next()){
                            cmdReceitas.addItem(rs.getString("docdes"));
                       }
                       
        } catch (Exception ex) {
         //   Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
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
     ImageIcon Sangria = new ImageIcon("C:/Imagem/17_Moeda.png");
     ImageIcon insere = new ImageIcon("C:/Imagem/15_Inserir.png");
     ImageIcon Finalizar = new ImageIcon("C:/Imagem/18_Finalizar.png");
     ImageIcon Enviar = new ImageIcon("C:/Imagem/19_Enviar.png");
     
        btnSangria.setIcon(Sangria);
        btnSair.setIcon(sair);
        btnBuscar.setIcon(pesquisar);
        btnCancelarItem.setIcon(Limpar);
        btnCancelarNotaFiscal.setIcon(Limpar);
        btnCancelarVenda.setIcon(Limpar);
        BtnAdicionar.setIcon(insere);
        btnFinalizarVenda.setIcon(Finalizar);
        btnEmitir.setIcon(Enviar);
        btnCancelar.setIcon(Limpar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BtnAdicionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnFinalizarVenda = new javax.swing.JButton();
        btnCancelarVenda = new javax.swing.JButton();
        btnCancelarItem = new javax.swing.JButton();
        btnSangria = new javax.swing.JButton();
        txtValorTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaItens = new javax.swing.JTable();
        txtNumeroFatura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        cmdReceitas = new javax.swing.JComboBox<>();
        txtDinheiro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoBusca = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelaItensEstorno = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTotalNota = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDescontoNota = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        txtSituacao = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnCancelarNotaFiscal = new javax.swing.JButton();
        btnEmitir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENDAS");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Produto");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyPressed(evt);
            }
        });

        jLabel2.setText("Quantidade");

        BtnAdicionar.setText("Adicionar");
        BtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdicionarActionPerformed(evt);
            }
        });
        BtnAdicionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAdicionarKeyPressed(evt);
            }
        });

        jLabel3.setText("Valor Total");

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnFinalizarVenda.setText("FINALIZAR VENDA");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });
        btnFinalizarVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnFinalizarVendaKeyPressed(evt);
            }
        });

        btnCancelarVenda.setText("CANCELAR VENDA");
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });

        btnCancelarItem.setText("CANCELAR ITEM");
        btnCancelarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarItemActionPerformed(evt);
            }
        });

        btnSangria.setText("SANGRIAS");
        btnSangria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSangriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSangria, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarVenda)
                    .addComponent(btnCancelarItem)
                    .addComponent(btnFinalizarVenda)
                    .addComponent(btnSangria))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Desconto");

        txtDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescontoActionPerformed(evt);
            }
        });
        txtDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescontoKeyPressed(evt);
            }
        });

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ));
        tabela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(50);
            tabela.getColumnModel().getColumn(0).setMaxWidth(50);
            tabela.getColumnModel().getColumn(2).setMinWidth(120);
            tabela.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Itens do Pedido"));

        TabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição", "Ean", "Quantidade", "Total", "D"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TabelaItens);
        if (TabelaItens.getColumnModel().getColumnCount() > 0) {
            TabelaItens.getColumnModel().getColumn(0).setMinWidth(50);
            TabelaItens.getColumnModel().getColumn(0).setMaxWidth(50);
            TabelaItens.getColumnModel().getColumn(1).setMinWidth(50);
            TabelaItens.getColumnModel().getColumn(1).setMaxWidth(50);
            TabelaItens.getColumnModel().getColumn(3).setMinWidth(120);
            TabelaItens.getColumnModel().getColumn(3).setMaxWidth(120);
            TabelaItens.getColumnModel().getColumn(4).setMinWidth(80);
            TabelaItens.getColumnModel().getColumn(4).setMaxWidth(80);
            TabelaItens.getColumnModel().getColumn(5).setMinWidth(70);
            TabelaItens.getColumnModel().getColumn(5).setMaxWidth(70);
            TabelaItens.getColumnModel().getColumn(6).setMinWidth(20);
            TabelaItens.getColumnModel().getColumn(6).setMaxWidth(20);
        }
        TabelaItens.getAccessibleContext().setAccessibleName("");
        TabelaItens.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        txtNumeroFatura.setBackground(new java.awt.Color(153, 153, 153));
        txtNumeroFatura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNumeroFatura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNumeroFatura.setSelectedTextColor(new java.awt.Color(255, 0, 0));
        txtNumeroFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroFaturaActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero Cupom");

        jLabel10.setText("Cliente");

        txtCodigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoClienteKeyPressed(evt);
            }
        });

        cmdReceitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdReceitasKeyPressed(evt);
            }
        });

        txtDinheiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDinheiroMouseClicked(evt);
            }
        });
        txtDinheiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDinheiroKeyPressed(evt);
            }
        });

        jLabel11.setText("Dinheiro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumeroFatura, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(BtnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmdReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAdicionar)))
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroFatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(133, 133, 133)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(243, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Venda", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ESTORNO DA NOTA FISCAL"));
        jPanel4.setToolTipText("");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Nota Fiscal");

        txtCodigoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoBuscaKeyPressed(evt);
            }
        });

        TabelaItensEstorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição", "Quantidade", "Total"
            }
        ));
        jScrollPane4.setViewportView(TabelaItensEstorno);
        if (TabelaItensEstorno.getColumnModel().getColumnCount() > 0) {
            TabelaItensEstorno.getColumnModel().getColumn(0).setMinWidth(50);
            TabelaItensEstorno.getColumnModel().getColumn(0).setMaxWidth(50);
            TabelaItensEstorno.getColumnModel().getColumn(1).setMinWidth(50);
            TabelaItensEstorno.getColumnModel().getColumn(1).setMaxWidth(50);
            TabelaItensEstorno.getColumnModel().getColumn(3).setMinWidth(80);
            TabelaItensEstorno.getColumnModel().getColumn(3).setMaxWidth(80);
            TabelaItensEstorno.getColumnModel().getColumn(4).setMinWidth(70);
            TabelaItensEstorno.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel7.setText("Cliente:");

        txtCliente.setEditable(false);

        jLabel8.setText("Endereço:");

        txtEndereco.setEditable(false);

        jLabel14.setText("Cidade:");

        txtCidade.setEditable(false);

        jLabel16.setText("Bairro:");

        txtBairro.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBairro))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel12.setText("Total Nota");

        txtTotalNota.setEditable(false);

        jLabel13.setText("Desconto Nota");

        txtDescontoNota.setEditable(false);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("Data da Nota");

        txtData.setEditable(false);

        txtSituacao.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        txtSituacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCodigoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)))
                        .addGap(31, 31, 31)
                        .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalNota, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescontoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodigoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBuscar)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(txtDescontoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCancelarNotaFiscal.setText("CANCELAR NOTA FISCAL");
        btnCancelarNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarNotaFiscalActionPerformed(evt);
            }
        });

        btnEmitir.setText("EMITIR NOTA FISCAL");

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelarNotaFiscal)
                .addGap(28, 28, 28)
                .addComponent(btnEmitir, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarNotaFiscal)
                    .addComponent(btnEmitir)
                    .addComponent(btnCancelar)
                    .addComponent(btnSair))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.getAccessibleContext().setAccessibleName("ESTORNO DA NOTA");

        jTabbedPane1.addTab("Estorno", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int contador = 0;
    
    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        //O DefaultTableModel serve para colocar os dados
        //(colunas e linhas) de uma tabela, separado do objeto tabela (JTable).
        TableRowSorter sorter = null;
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        sorter = new TableRowSorter<TableModel>(modelo);
        tabela.setRowSorter(sorter);

        String texto = txtCodigo.getText();
        if(texto.length() == 0){
            sorter.setRowFilter(null);
        }else{
               sorter.setRowFilter(RowFilter.regexFilter(texto));
        }

    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed

        
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescontoActionPerformed

    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed
       cancelaitem();
    }//GEN-LAST:event_btnCancelarVendaActionPerformed
    
    public void cancelaitem(){
        DefaultTableModel val = (DefaultTableModel) TabelaItens.getModel();
       int codigo = TabelaItens.getRowCount();
         for(int x=codigo-1 ; x>=0 ; x--){
             val.removeRow(x);
         }
       txtDesconto.setText("0.00");
       txtValorTotal.setText("0.00");
       txtDinheiro.setText("0.00");
       txtCodigoCliente.setText("");
       txtCodigo.setText("");
       txtCodigo.requestFocus();
       item=1;
       NumeroFatura();
       cmdReceitas.setSelectedItem("DINHEIRO");
    }
    
    public static int strToInt(String valor, int padrao) 
{
   try {
       return Integer.valueOf(valor); // Para retornar um Integer, use Integer.parseInt
   } 
   catch (NumberFormatException e) {  // Se houver erro na conversão, retorna o valor padrão
       return padrao;
   }
}
    
    private void BtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAdicionarActionPerformed
       TesteParaAdicionar();
    }//GEN-LAST:event_BtnAdicionarActionPerformed

    public void TesteParaAdicionar(){
                DefaultTableModel tabela1 = (DefaultTableModel)TabelaItens.getModel();
        int segue = 0;
           int numero = TabelaItens.getRowCount();
           for(int x = 0; x<numero; x++ ){
               String Tabela = TabelaItens.getValueAt(x, 1).toString();
               String Tabela1 = TabelaItens.getValueAt(x, 2).toString();
               String Tabela2 = TabelaItens.getValueAt(x, 3).toString();
               String Digitado = txtCodigo.getText();
               if(Tabela.equals(Digitado)){
              //     JOptionPane.showMessageDialog(null, "CÓDIGO JÁ INSERIDO!");
              try {
                   
                    DefaultTableModel table = (DefaultTableModel) TabelaItens.getModel();

                    Vector auxTable = new Vector();

                    auxTable.add(txtCodigo.getText());
                    auxTable.add(1);

                    String Pcoluna = "";
                    String Scoluna = "";
                    
                    boolean exists = false;
                    for (int i = 0; i < table.getRowCount(); i++) {
                        Pcoluna = TabelaItens.getValueAt(i, 1).toString().trim();
                        Scoluna = TabelaItens.getValueAt(i, 4).toString().trim();
                        String Soma = TabelaItens.getValueAt(i, 5).toString().trim();
                        
                       
                           this.con = database.getConnection();
                           PreparedStatement busca = con.prepareStatement("select * from cpro where pro_cod = '"+Pcoluna+"'");
                           ResultSet rs = busca.executeQuery();
                           
                           rs.next();
                           
                           double preco = rs.getDouble("pro_pre");
                            if (txtCodigo.getText().equals(Pcoluna)) {
                                segue = 1;
                            int index = i;
                            TabelaItens.getSelectionModel().setSelectionInterval(index, index);
                            //JOptionPane.showMessageDialog(null, "Existe! " + i, "Mensagem", JOptionPane.PLAIN_MESSAGE);
                            int soma =  Integer.parseInt(TabelaItens.getValueAt(i, 4).toString());
                            int QtdTabela = Integer.parseInt(Scoluna);
                            int Qtd = Integer.parseInt(txtQuantidade.getText());
                            int quantidadetotal = Qtd + QtdTabela; 
                            double soma1 = Double.parseDouble(Soma);
                            double resultSoma = preco * quantidadetotal;
                            int result = soma + Qtd;
                            TabelaItens.getModel().setValueAt(result, TabelaItens.getSelectedRow(), 4);
                            TabelaItens.getModel().setValueAt(resultSoma, TabelaItens.getSelectedRow(), 5);
                            TabelaItens.clearSelection();
                       //     getSum();
                            SwingUtilities.invokeLater(() -> {
                                txtCodigo.setText("");
                                txtCodigo.requestFocusInWindow();
                            });
                            exists = true;
                            break;
                            
                        }
                    }
                    if (!exists) {
                        table.addRow(auxTable);
                        contador++;
                    //    this.lblTotalEan.setText(contador+"");
                        getSum();
                        txtCodigo.setText("");
                        txtCodigo.requestFocusInWindow();//or inWindow
                        
                    }
                          
  
                       } catch (SQLException ex) {
                           Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (Exception ex) {
                           Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
                       }

                       
               }
               if(Tabela1.equals(Digitado)){
             //     JOptionPane.showMessageDialog(null, "CÓDIGO JÁ INSERIDO!");
              try {
                   
                    DefaultTableModel table = (DefaultTableModel) TabelaItens.getModel();

                    Vector auxTable = new Vector();

                    auxTable.add(txtCodigo.getText());
                    auxTable.add(1);

                    String Pcoluna = "";
                    String Scoluna = "";
                    
                    boolean exists = false;
                    for (int i = 0; i < table.getRowCount(); i++) {
                        Pcoluna = TabelaItens.getValueAt(i, 2).toString().trim();
                        Scoluna = TabelaItens.getValueAt(i, 4).toString().trim();
                        String Soma = TabelaItens.getValueAt(i, 5).toString().trim();
                        
                       
                           this.con = database.getConnection();
                           PreparedStatement busca = con.prepareStatement("select * from cpro where pro_des = '"+Pcoluna+"'");
                           ResultSet rs = busca.executeQuery();
                           
                           rs.next();
                           
                           double preco = rs.getDouble("pro_pre");
                            if (txtCodigo.getText().equals(Pcoluna)) {
                               segue = 1;
                            int index = i;
                            TabelaItens.getSelectionModel().setSelectionInterval(index, index);
                            //JOptionPane.showMessageDialog(null, "Existe! " + i, "Mensagem", JOptionPane.PLAIN_MESSAGE);
                            int soma =  Integer.parseInt(TabelaItens.getValueAt(i, 4).toString());
                            int QtdTabela = Integer.parseInt(Scoluna);
                            int Qtd = Integer.parseInt(txtQuantidade.getText());
                            int quantidadetotal = Qtd + QtdTabela; 
                            double soma1 = Double.parseDouble(Soma);
                            double resultSoma = preco * quantidadetotal;
                            int result = soma + Qtd;
                            TabelaItens.getModel().setValueAt(result, TabelaItens.getSelectedRow(), 4);
                            TabelaItens.getModel().setValueAt(resultSoma, TabelaItens.getSelectedRow(), 5);
                            TabelaItens.clearSelection();
                       //     getSum();
                            SwingUtilities.invokeLater(() -> {
                                txtCodigo.setText("");
                                txtCodigo.requestFocusInWindow();
                            });
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        table.addRow(auxTable);
                        contador++;
                    //    this.lblTotalEan.setText(contador+"");
                        getSum();
                        txtCodigo.setText("");
                        txtCodigo.requestFocusInWindow();//or inWindow
                       
                    }
                          
  
                       } catch (SQLException ex) {
                           Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (Exception ex) {
                           Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
                       }

                     
               }
               if(Tabela2.equals(Digitado)){
              //     JOptionPane.showMessageDialog(null, "CÓDIGO JÁ INSERIDO!");
              try {
                  
                    DefaultTableModel table = (DefaultTableModel) TabelaItens.getModel();

                    Vector auxTable = new Vector();

                    auxTable.add(txtCodigo.getText());
                    auxTable.add(1);

                    String Pcoluna = "";
                    String Scoluna = "";
                    
                    boolean exists = false;
                    for (int i = 0; i < table.getRowCount(); i++) {
                        Pcoluna = TabelaItens.getValueAt(i, 3).toString().trim();
                        Scoluna = TabelaItens.getValueAt(i, 4).toString().trim();
                        String Soma = TabelaItens.getValueAt(i, 5).toString().trim();
                        
                       
                           this.con = database.getConnection();
                           PreparedStatement busca = con.prepareStatement("select * from cpro where pro_ean = '"+Pcoluna+"'");
                           ResultSet rs = busca.executeQuery();
                           
                           rs.next();
                           
                           double preco = rs.getDouble("pro_pre");
                            if (txtCodigo.getText().equals(Pcoluna)) {
                               segue = 1;
                            int index = i;
                            TabelaItens.getSelectionModel().setSelectionInterval(index, index);
                            //JOptionPane.showMessageDialog(null, "Existe! " + i, "Mensagem", JOptionPane.PLAIN_MESSAGE);
                            int soma =  Integer.parseInt(TabelaItens.getValueAt(i, 4).toString());
                            int QtdTabela = Integer.parseInt(Scoluna);
                            int Qtd = Integer.parseInt(txtQuantidade.getText());
                            int quantidadetotal = Qtd + QtdTabela; 
                            double soma1 = Double.parseDouble(Soma);
                            double resultSoma = preco * quantidadetotal;
                            int result = soma + Qtd;
                            TabelaItens.getModel().setValueAt(result, TabelaItens.getSelectedRow(), 4);
                            TabelaItens.getModel().setValueAt(resultSoma, TabelaItens.getSelectedRow(), 5);
                            TabelaItens.clearSelection();
                       //     getSum();
                            SwingUtilities.invokeLater(() -> {
                                txtCodigo.setText("");
                                txtCodigo.requestFocusInWindow();
                            });
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        table.addRow(auxTable);
                        contador++;
                    //    this.lblTotalEan.setText(contador+"");
                        getSum();
                        txtCodigo.setText("");
                        txtCodigo.requestFocusInWindow();//or inWindow
                       
                    }
                          
  
                       } catch (SQLException ex) {
                           Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
                       } catch (Exception ex) {
                           Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
                       }
                
                        
           }
            
            double tot = 0;
                /*        double count=0;
                        for (int i=0; i<=TabelaItens.getRowCount()-1;i++) {
                            count=Double.parseDouble(TabelaItens.getValueAt(i, 5).toString());
                            int qtd = Integer.parseInt(TabelaItens.getValueAt(i, 4).toString());
                            tot+= count * qtd;
                        }

                        String ValorTotal = "" + tot; 
                        txtValorTotal.setText(ValorTotal);*/
               
           
        }
           if(segue == 0) {
                adicionar();
            }
            double count=0;
            for (int i=0; i<=TabelaItens.getRowCount()-1;i++) {
                count+=Double.parseDouble(TabelaItens.getValueAt(i, 5).toString());
            }
            
            String ValorTotal = "" + count; 
            txtValorTotal.setText(ValorTotal);
    }
    public void adicionar(){
        DecimalFormat df = new DecimalFormat("#.##");
 

        int ver = 0;
        float Total2;

        try {
            this.con = database.getConnection();
            
            Produto PRO = new Produto();

            PRO.setCodigo(txtCodigo.getText().trim());
            PRO.setDescricao(txtCodigo.getText().trim());
            PRO.setEan(txtCodigo.getText().trim());

            String PROCodigo = PRO.codigo;
            String PRODescri = PRO.descricao;
            String PROEan = PRO.ean;

            PreparedStatement banco = null;
            try {
                banco = con.prepareStatement("select * from cpro");
            } catch (SQLException ex) {
                Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            ResultSet rs = banco.executeQuery();
            
            while(rs.next()){

                String PROCod = rs.getString("pro_cod");
                String PRODes = rs.getString("PRO_DES");
                String PROean = rs.getString("PRO_EAN");
                
            if((PROCod.trim().equals(PROCodigo))){

                    String PROcodigo = rs.getString("pro_cod");
                    String PRODescricao = rs.getString("pro_des");
                    String PROUnidade = rs.getString("pro_uni");
                    String PROValor = rs.getString("pro_pre");
                    String PROcbarras = rs.getString("PRO_ean");

                    int qtd = Integer.parseInt(txtQuantidade.getText());
                    float vlr = Float.parseFloat(PROValor);

                    Total2 = qtd * vlr;
                    
                    String TotNota = df.format(Total2);
 
                    String TotalIten = "" + Total2;

                    float TotalNota = Float.parseFloat(TotalIten);
                 
                    String Items = "" + item;

               DefaultTableModel val = (DefaultTableModel) TabelaItens.getModel();

               val.addRow(new String[]{Items,PROCod,PRODes,PROcbarras,txtQuantidade.getText(),TotalIten});
               
                     
                    ver = 1;
                    txtCodigo.setText("");
                    txtCodigo.requestFocus();
                    item++;
            }
            if((PRODes.trim().equals(PRODescri))){

                    String PROcodigo = rs.getString("pro_cod");
                    String PRODescricao = rs.getString("pro_des");
                    String PROUnidade = rs.getString("pro_uni");
                    String PROValor = rs.getString("pro_pre");
                    String PROcbarras = rs.getString("PRO_ean");

                    int qtd = Integer.parseInt(txtQuantidade.getText());
                    float vlr = Float.parseFloat(PROValor);
                   
                    Total2 = qtd * vlr;
                    
                    String TotNota = df.format(Total2);
                    
                    String TotalIten = "" + Total2;
                    
                    String Items = "" + item;

               DefaultTableModel val = (DefaultTableModel) TabelaItens.getModel();
            
               val.addRow(new String[]{Items,PROCod,PRODes,PROcbarras,txtQuantidade.getText(),TotalIten});
               
                    ver = 1;
                    txtCodigo.setText("");
                    txtCodigo.requestFocus();
                    item++;
            }
            if((PROEan.trim().equals(PROean))){

                
                    String PROcodigo = rs.getString("pro_cod");
                    String PRODescricao = rs.getString("pro_des");
                    String PROUnidade = rs.getString("pro_uni");
                    String PROValor = rs.getString("pro_pre");
                    String PROcbarras = rs.getString("PRO_ean");

                    int qtd = Integer.parseInt(txtQuantidade.getText());
                    float vlr = Float.parseFloat(PROValor);
                   
                    Total2 = qtd * vlr;
                    
                    String TotNota = df.format(Total2);
                    
                    String TotalIten = "" + Total2;
                    
                    String Items = "" + item;

               DefaultTableModel val = (DefaultTableModel) TabelaItens.getModel();
            
               val.addRow(new String[]{Items,PROCod,PRODes,PROcbarras,txtQuantidade.getText(),TotalIten});
               
                    ver = 1;
                    txtCodigo.setText("");
                    txtCodigo.requestFocus();
                    item++;
            }
            }
            
            
        /*    double count=0;
            for (int i=0; i<=TabelaItens.getRowCount()-1;i++) {
                count+=Double.parseDouble(TabelaItens.getValueAt(i, 5).toString());
            }
            
            String ValorTotal = "" + count; 
            txtValorTotal.setText(ValorTotal);*/
            
            if(ver == 0){
                JOptionPane.showMessageDialog(null, "O PRODUTO NÃO ESTÁ CADASTRADO!");
                txtCodigo.setText("");
                txtCodigo.requestFocus();
                
            }
        } catch (Exception ex){
            Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iniciar();
    }
    private void tabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyPressed
       // txtCodigo.setText(tabela.set);
    }//GEN-LAST:event_tabelaKeyPressed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        try{
  
           int row = tabela.getSelectedRow();
           
           String Table_click=(tabela.getModel().getValueAt(row, 1).toString());
           
           txtCodigo.setText(Table_click);
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnCancelarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarItemActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)TabelaItens.getModel();
        if (TabelaItens.getSelectedRow() >= 0){
         //   while(dtm != null){
            int linha = TabelaItens.getSelectedRow();
            dtm.removeRow(TabelaItens.getSelectedRow());
            TabelaItens.setModel(dtm);
          //  
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
        
    }//GEN-LAST:event_btnCancelarItemActionPerformed

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        FinalizarVenda();
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    public void FinalizarVenda(){
                String operacao = "065",situacao = "0",documento = null;
        try {
            this.con = database.getConnection();
            int x;
            Produto PRO = new Produto();
            
           String numitem,codigo,descricao,quantidade,total,VLRPRO = null,QuantidadeProduto,QuantidadeBanco = null,clicod = null,clinome = null,clibai = null,clicid = null,cliend = null; 
           DefaultTableModel tabela1 = (DefaultTableModel)TabelaItens.getModel();
           int numero = TabelaItens.getRowCount();
           
           if(numero > 0){

                for(x = 0; x<numero; x++ ){
                //       JOptionPane.showMessageDialog(null, x);  

                 numitem=(TabelaItens.getModel().getValueAt(x, 0).toString());
                 codigo=(TabelaItens.getModel().getValueAt(x, 1).toString());
                 descricao=(TabelaItens.getModel().getValueAt(x, 2).toString());
                 quantidade=(TabelaItens.getModel().getValueAt(x, 4).toString());
                 total=(TabelaItens.getModel().getValueAt(x, 5).toString());
                      try (PreparedStatement posted = con.prepareStatement("select * from cpro where pro_cod = '"+codigo+"'"); 
                             ResultSet rs = posted.executeQuery()) {

                             while (rs.next()) {
                                 String PROCod = rs.getString("PRO_COD");
                                 if (PROCod.trim().equals(codigo)){
                                     VLRPRO = rs.getString("PRO_PRE");
                                     QuantidadeBanco = rs.getString("PRO_ESTOQUE");
                                 }
                             }

                     }

                      if("".equals(txtCodigoCliente.getText().trim())){
                          clicod = null;
                          clinome = null;
                          clibai = null;
                          clicid = null;
                          cliend = null;
                      }else {
                          try (PreparedStatement posted1 = con.prepareStatement("select * from CCLI where CLI_cod = '"+txtCodigoCliente.getText()+"'"); 
                             ResultSet rs1 = posted1.executeQuery()) {

                             while (rs1.next()) {

                                     clicod = rs1.getString("cli_COD");
                                     clinome = rs1.getString("cli_nome");
                                     clibai = rs1.getString("cli_bairro");
                                     clicid = rs1.getString("cli_cidade");
                                     cliend = rs1.getString("cli_endereco");

                             }
                         }
                      }
                      try (PreparedStatement posted1 = con.prepareStatement("select * from docrec where docdes = '"+cmdReceitas.getSelectedItem().toString()+"'"); 
                             ResultSet rs1 = posted1.executeQuery()) {

                             while (rs1.next()) {

                                     documento = rs1.getString("docdoc");

                             }
                         }


                     int qtd = Integer.parseInt(quantidade);
                     int qtdbanco = Integer.parseInt(QuantidadeBanco);
                     int qtdEstoque = (qtdbanco - qtd);
                     QuantidadeProduto = "" + qtdEstoque;

                 try ( //CRIA CONEXAO COM BANCO - PREPAREDSTATEMENT
                             PreparedStatement banco = con.prepareStatement("insert into cteitm (ITMITM,ITMCODPRO,ITMDESPRO,ITMQTD,ITMVLRTOT,itmvlrpro,itmnum,itmcli,ITMOPE,itmsit) values (?,?,?,?,?,?,?,?,?,?)")) {

                         //PREENCHE OS VALORES DO BANCO
                         banco.setString(1, numitem);
                         banco.setString(2, codigo);
                         banco.setString(3, descricao);
                         banco.setString(4, quantidade);
                         banco.setString(5, total);
                         banco.setString(6, VLRPRO);
                         banco.setString(7, txtNumeroFatura.getText());
                         banco.setString(8, clicod);
                         banco.setString(9, operacao);  
                         banco.setString(10, situacao);
                         banco.execute();

                     } 

                  try ( //CRIA CONEXAO COM BANCO - PREPAREDSTATEMENT
                             PreparedStatement PRODUTO = con.prepareStatement("update cpro set pro_estoque = '"+QuantidadeProduto+"' where pro_cod = '"+codigo+"'")) {

                         PRODUTO.execute();

                     } 

               }
               java.util.Date d = new Date();
               String DATE = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d); // PEGA DATA DO COMPUTADOR

               
                PRO.setValortotal(txtValorTotal.getText());
                PRO.setDesconto(txtDesconto.getText());
                String ValorTotal = PRO.valortotal;
                String Desconto = PRO.desconto;
                 try ( //CRIA CONEXAO COM BANCO - PREPAREDSTATEMENT

                         PreparedStatement banco2 = con.prepareStatement("insert into ctenfe (NFEVLRTOT,NFEVLRDES,NFENUM,NFEDAT,nfecodcli,nfenomecli,nfeclibai,nfecidcli,nfeendcli,nfeope,nfesit,NFEREC,nferecdin) values (?,?,?,?,?,?,?,?,?,?,?,?,?)")) {

                         //PREENCHE OS VALORES DO BANCO
                         banco2.setString(1, ValorTotal);
                         banco2.setString(2, Desconto);
                         banco2.setString(3, txtNumeroFatura.getText());
                         banco2.setString(4, DATE);
                         banco2.setString(5, clicod);
                         banco2.setString(6, clinome);
                         banco2.setString(7, clibai);
                         banco2.setString(8, clicid);
                         banco2.setString(9, cliend);
                         banco2.setString(10, operacao);
                         banco2.setString(11, situacao);
                         banco2.setString(12, documento);
                         banco2.setString(13, txtDinheiro.getText());
                         banco2.execute();

                     } 
                con.close();
                JOptionPane.showMessageDialog(null, "Cupom Fiscal Eletronico Emitido com Sucesso!", "Mensagem",
                             JOptionPane.INFORMATION_MESSAGE);  
              gerapdf();
              cancelaitem();
              item=1; 
         } else{
               JOptionPane.showMessageDialog(null, "NÃO HÁ ITENS PARA FINALIZAR A VENDA!");
               txtQuantidade.requestFocus();
           }
        } catch (Exception ex) {
       //     Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void gerapdf() throws Exception{
         this.con = database.getConnection();
         Document document =new Document();
        try {
            java.util.Date d = new Date();
            String DATE = java.text.DateFormat.getDateInstance(DateFormat.FULL).format(d); // PEGA DATA DO COMPUTADOR
            PdfWriter.getInstance(document, new FileOutputStream("Cupom"+txtNumeroFatura.getText()+".pdf"));
           
           document.open();
           document.add(new Paragraph("                                                            CUPOM FISCAL ELETRONICO"));
           document.add(new Paragraph(""
                   + ""
                   + "Data: "+DATE+"     Numero Nota: " +txtNumeroFatura.getText()));
           
           document.add(new Paragraph("                               DADOS ESTABELECIMENTO"));
           document.add(new Paragraph("Sistemas de Vendas ao Consumidor LTDA\n" +
            "CNPJ: 04.995.470/0001-92   Fantasia: SVC\n" +
            "Avenida Sertório, 5200       Bairro: Sarandi\n" +
            "Porto Alegre – RS"));
           document.add(new Paragraph("  "
                   + ""
                   + ""));
           if(txtCodigoCliente.getText().length()>=0){
               PreparedStatement cliente;
                try {
                    cliente = con.prepareStatement("select * from ccli where cli_cod = '"+txtCodigoCliente.getText()+"'");
                    
                     ResultSet rs = cliente.executeQuery();
               
                    rs.next();
                    
                        document.add(new Paragraph("                                    DADOS CLIENTE"));
                        document.add(new Paragraph("Nome: " + rs.getString("CLI_nome") + "   Cpf: " + rs.getString("CLI_cpf")));
                        document.add(new Paragraph("Endereço:" +rs.getString("CLI_endereco")+ "    Numero: "+rs.getString("CLI_numero")));
                        document.add(new Paragraph("Bairro: " +rs.getString("CLI_bairro")+ "   Cidade: " +rs.getString("CLI_cidade")+ "   Estado: " +rs.getString("CLI_estado")));
                        document.add(new Paragraph("Telefone: " +rs.getString("CLI_telefone1")));
                        document.add(new Paragraph("  "
                                + ""
                                + ""));
                } catch (SQLException ex) {
              //      Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
                }
           }

           document.add(new Paragraph("                                    ITENS DA NOTA"));
           DefaultTableModel val = (DefaultTableModel) TabelaItens.getModel(); 
           int cont = TabelaItens.getRowCount();
           for(int x=0 ; x<cont ;x++){
               String Item = TabelaItens.getValueAt(x, 0).toString();
               String descricao = TabelaItens.getValueAt(x, 2).toString();
               String qtd = TabelaItens.getValueAt(x, 4).toString();
               String total = TabelaItens.getValueAt(x, 5).toString();
               document.add(new Paragraph("Item - "+Item+ "   Descrição - "+descricao+"    Quantidade - "+qtd+"    Total - "+total));
           }
           
            document.add(new Paragraph("  "
                   + ""
                   + ""));
            document.add(new Paragraph("                                    DADOS DO PAGAMENTO"));
            document.add(new Paragraph("Forma de Pagamento - "+cmdReceitas.getSelectedItem().toString()));
            if(!"0.00".equals(txtDinheiro.getText())){
            document.add(new Paragraph("Entrada em Dinheiro - "+txtDinheiro.getText()));
            }
     
            document.add(new Paragraph("  "
                   + ""
                   + ""));
           document.add(new Paragraph("                              43181204995470000192121715336578658000000"+txtNumeroFatura.getText()));
           
           document.add(new Paragraph("  "
                   + ""
                   + ""));
           document.add(new Paragraph("                                    TOTAL DA NOTA"));
           document.add(new Paragraph("                Total Nota: " +txtValorTotal.getText()+"    Desconto: " +txtDesconto.getText()));
    
        
        
        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }finally{
            document.close();
        }
        
        try {
            Desktop.getDesktop().open(new File("Cupom"+txtNumeroFatura.getText()+".pdf"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtCodigo.requestFocus();
        }else if(evt.getKeyCode() == 112){
            FinalizarVenda();
        }
    }//GEN-LAST:event_txtQuantidadeKeyPressed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             TesteParaAdicionar();
        }else if(evt.getKeyCode() == KeyEvent.VK_SHIFT){
             txtQuantidade.requestFocus();
             txtQuantidade.selectAll();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void BtnAdicionarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAdicionarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            TesteParaAdicionar();
        }
    }//GEN-LAST:event_BtnAdicionarKeyPressed

    private void txtNumeroFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroFaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroFaturaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void buscar(){
        int a = 0, situacao = 0;
        try {
            this.con = database.getConnection();

            Nota PRO = new Nota();

            PRO.setCodigo(txtCodigoBusca.getText());

            String PROCodigo = PRO.getCodigo();

            PreparedStatement posted = con.prepareStatement("select * from ctenfe where nfeope = '065'");

            ResultSet rs = posted.executeQuery();

                while (rs.next()) {
                    
                    String PROCod = rs.getString("NFENUM");

                    if (PROCod.trim().equals(PROCodigo)) {
                        situacao = rs.getInt("nfesit");
                        String TotalNota = rs.getString("nfevlrtot");
                        String DescontoNota = rs.getString("nfevlrdes");
                        String cliente = rs.getString("nfenomecli");
                        String clientecodigo = rs.getString("nfecodcli");
                        String clientebairro = rs.getString("nfeclibai");
                        String clientecidade = rs.getString("nfecidcli");
                        String endereco = rs.getString("nfeendCLI");
                        String data = rs.getString("nfedat");
                       // double data = rs.getInt("nfedat");

                       // String Date = "" + data;
                        txtTotalNota.setText(TotalNota);
                        txtDescontoNota.setText(DescontoNota);
                        txtCliente.setText(cliente);
                        txtEndereco.setText(endereco);
                        txtCidade.setText(clientecidade);
                        txtBairro.setText(clientebairro);
                        txtData.setText(data);

                        PreparedStatement BuscaItens = con.prepareStatement("select * from cteitm where itmnum = '"+PROCod+"' and itmope = '065'");

                        ResultSet rs1 = BuscaItens.executeQuery();

                        while (rs1.next()) {

                        String Item = rs1.getString("itmitm");
                        String codItem = rs1.getString("itmcodpro");
                        String descricao = rs1.getString("itmdespro");
                        String quantidade = rs1.getString("itmqtd");
                        String total = rs1.getString("itmvlrpro");

                             DefaultTableModel val = (DefaultTableModel) TabelaItensEstorno.getModel();

                             val.addRow(new String[]{Item,codItem,descricao,quantidade,total});

                             
                        }
                   
                        a = 1;
                    }
                }

           con.close();

            if (a == 0) {
                JOptionPane.showMessageDialog(null, "NÃO TEM ESSE CUPOM FISCAL NO BANCO DE DADOS!");
            }

        } catch (Exception ex) {
        //    Logger.getLogger(formCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(situacao == 0){
        }else{
            txtSituacao.setForeground(Color.RED);
            txtSituacao.setText("NOTA JÁ ESTÁ CANCELADA");
            btnCancelarNotaFiscal.setEnabled(false);
                            }
    }
    
    private void txtCodigoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBuscaKeyPressed
       if(evt.getKeyCode() == 113){
            new formPesquisaNota().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_txtCodigoBuscaKeyPressed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtCodigoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoClienteKeyPressed
        if(evt.getKeyCode() == 113){
            new formPesquisaCliente().setVisible(true);
            dispose();
        }else if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            cmdReceitas.requestFocus();
        }
        if(evt.getKeyCode() == 112){
            FinalizarVenda();
        } 
    }//GEN-LAST:event_txtCodigoClienteKeyPressed

    private void btnCancelarNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarNotaFiscalActionPerformed
       int Qtd[] = new int[5], cont = 0;
       int Item[] = new int[5];
        int pergunta = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE CANCELAR O CUPOM FISCAL ELETRONICO?");
        if (pergunta == JOptionPane.YES_OPTION){
            try {
                this.con = database.getConnection();

                String Codigo = txtCodigoBusca.getText();

                try (PreparedStatement delete = con.prepareStatement("UPDATE CTENFE SET NFESIT = '1' WHERE NFENUM = '"+Codigo+"' AND NFEOPE = '065'")) {
                    delete.execute();
                }

                try (PreparedStatement delete2 = con.prepareStatement("UPDATE CTEITM SET ITMSIT = '1' WHERE ITMNUM = '"+Codigo+"' AND ITMOPE = '065'")) {
                    delete2.execute();
                }

                   PreparedStatement itemestoque = con.prepareStatement("select * from cteitm,cpro where cpro.pro_cod = cteitm.itmcodpro and itmope = '065' and itmnum = '"+txtCodigoBusca.getText()+"'");
                   ResultSet rs1 = itemestoque.executeQuery();
                    
                    while (rs1.next()) {
                     
                    DefaultTableModel val = (DefaultTableModel) TabelaItensEstorno.getModel();
                    int tabela2 = TabelaItensEstorno.getRowCount();
                    String iten = rs1.getString("pro_cod");     
                    String estoque = rs1.getString("pro_estoque");
                    String qtditem = rs1.getString("itmqtd");

                        for(int x = 0; x<tabela2 ;x++){
                            String qtdTabela = TabelaItensEstorno.getValueAt(x, 3).toString();
                            String codigo = TabelaItensEstorno.getValueAt(x, 1).toString();

                            int qtd = Integer.parseInt(qtditem);
                            int est = Integer.parseInt(estoque);
                            int qtdTab = Integer.parseInt(qtdTabela);
                            int vlr = est + qtdTab;
                            int cod = Integer.parseInt(codigo);
                            Qtd[x] = vlr;
                            Item[x] = cod;
                        }
                    }

                     DefaultTableModel val = (DefaultTableModel) TabelaItensEstorno.getModel();
                     int tabela1 = TabelaItensEstorno.getRowCount();
                     for(int x = 0; x<tabela1 ;x++){
                          try (PreparedStatement buscabanco = con.prepareStatement("update cpro set pro_estoque = '"+Qtd[x]+"' where pro_cod = '"+Item[x]+"'")) {
                          buscabanco.execute();
                        }
                     }
 
                JOptionPane.showMessageDialog(null, "NOTA CANCELADA COM SUCESSO!");
                cancela();
            } catch (Exception ex) {
        //        Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);  
        }  
        }
    }//GEN-LAST:event_btnCancelarNotaFiscalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescontoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnFinalizarVenda.requestFocus();
        } else if(evt.getKeyCode() == 112){
            FinalizarVenda();
        }
    }//GEN-LAST:event_txtDescontoKeyPressed

    private void btnFinalizarVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnFinalizarVendaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            FinalizarVenda();
        } 
    }//GEN-LAST:event_btnFinalizarVendaKeyPressed

    private void txtDinheiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDinheiroMouseClicked
        txtDinheiro.selectAll();
    }//GEN-LAST:event_txtDinheiroMouseClicked

    private void cmdReceitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdReceitasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtDinheiro.requestFocus();
            txtDinheiro.selectAll();
        } 
    }//GEN-LAST:event_cmdReceitasKeyPressed

    private void txtDinheiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDinheiroKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtDesconto.requestFocus();
            txtDesconto.selectAll();
        } else if(evt.getKeyCode() == 112){
            FinalizarVenda();
        }
        if(evt.getKeyCode() == 114){
            Sangria();
        }
    }//GEN-LAST:event_txtDinheiroKeyPressed

    private void btnSangriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSangriaActionPerformed
        Sangria();
    }//GEN-LAST:event_btnSangriaActionPerformed
    
    public void Sangria(){
        try {
            this.con = database.getConnection();
            java.util.Date d = new Date();
            String DATE = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d); // PEGA DATA DO COMPUTADOR
            
            String Valor = txtDinheiro.getText();
            if(Valor.trim().equals("0.00")){
               JOptionPane.showMessageDialog(null, "Valor de Sangria não Informado!");
            }else if(Valor.trim().equals("0")){
               JOptionPane.showMessageDialog(null, "Valor de Sangria não pode ser (0)!");
            }else{
                 PreparedStatement sangria = con.prepareStatement("insert into DOCSAN (SANDES,SANVLR,SANDAT,SANDOC) values (?,?,?,?)");
                sangria.setString(1, cmdReceitas.getSelectedItem().toString());
                sangria.setString(2, txtDinheiro.getText());
                sangria.setString(3, DATE);
                sangria.setString(4, "SRG");
                sangria.execute();

                JOptionPane.showMessageDialog(null, "SANGRIA SALVA COM SUCESSO!");
            }
            cancelaitem();
        } catch (Exception ex) {
            Logger.getLogger(formVendas.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void cancela(){
        txtCodigoBusca.setText("");
        txtTotalNota.setText("");
        txtDescontoNota.setText("");
        txtCliente.setText("");
        txtEndereco.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtData.setText("");
        txtSituacao.setText("");
        btnCancelarNotaFiscal.setEnabled(true);
        DefaultTableModel val = (DefaultTableModel) TabelaItensEstorno.getModel();
         int codigo = TabelaItensEstorno.getRowCount();
         for(int x=codigo-1 ; x>=0 ; x--){
             val.removeRow(x);
         }
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
            java.util.logging.Logger.getLogger(formVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdicionar;
    private javax.swing.JTable TabelaItens;
    private javax.swing.JTable TabelaItensEstorno;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarItem;
    private javax.swing.JButton btnCancelarNotaFiscal;
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnEmitir;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSangria;
    private javax.swing.JComboBox<String> cmdReceitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoBusca;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtDescontoNota;
    private javax.swing.JTextField txtDinheiro;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNumeroFatura;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JLabel txtSituacao;
    private javax.swing.JTextField txtTotalNota;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables

    private void getSum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package ProjetoSoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class database {
    public Connection conn;
    public PreparedStatement pstmt;
    public ResultSet rs;
    //ctrl+espaço e depois enter, chama o void main
    public static void main(String[] args) throws Exception {
        //getConnection();
        //post();
        //update();
        //pesquisar();
    }
    
    //ABRIR CONEXAO COM BANCO DE DADOS
    public static Connection getConnection() throws Exception{
        try{
            String driver = "org.firebirdsql.jdbc.FBDriver";
            //No final do url foi colocado a charset = ?lc_ctype=ISO8859_1 
            //Esse precedimento corrige erros de caracter na conexao ao banco de dados
            String url = "jdbc:firebirdsql:localhost/3050:c:/VENDAS/VENDAS.FDB?lc_ctype=ISO8859_1";
            String username = "SYSDBA";
            String password = "masterkey";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        }catch(Exception e){System.out.println(e);}
        
        return null;
    }
    
    //FECHAR CONEXÃO BANCO DE DADOS
    public void fecharBanco(){
      try{              
            if (conn != null)
                conn.close();
            if (pstmt != null)
                pstmt.close();
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Falha ao desconectar, ERRO: " + e.getMessage());
      }
  }
    
    // CHAMO A CONEXÃO E FAÇO UM INSERT NA TABELA FIREBIRD => OK
    public static void post() throws Exception{
        final String nome = "Irene";
        final String Endereco = "Rua São Joaquim";
        final String numero = "176";
        
        try{
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO CCLI(NOME_CLIENTE, END_CLIENTE, COD_CLIENTE) VALUES ('"+nome+"', '"+Endereco+"', '"+numero+"')");
            
            posted.executeUpdate();           
        }catch(Exception e){System.out.println(e);}
        finally{
            System.out.println("Insert Completed.");
        }
    }
    
    public static void update(){
        
    }
    
    public static void pesquisar(){
        String comando = "SELECT NOME_CLIENTE, END_CLIENTE, COD_CLIENTE FROM CCLI"; 
        try {
            PreparedStatement prep = getConnection().prepareStatement(comando);
            //esse getConnection() está tratando da conexão com o bd.
            ResultSet rs = prep.executeQuery();
             
            rs.next();
            
            while(rs.next()){
            String nomeCliente =(rs.getString(1));
            String endCliente =(rs.getString(2));
            String codCliente =(rs.getString(3));
            
            System.out.println(nomeCliente + "-" + endCliente + "-" + codCliente);
        }
             
            /*//CONSULTA DE APENAS UMA PESSOA NO BANCO
            //int exp = rs.getInt("coluna"); //se for Varchar ou char usa rs.getString
            String nomeCliente = rs.getString("NOME_CLIENTE");
            String endCliente = rs.getString("END_CLIENTE");
            String codCliente = rs.getString("COD_CLIENTE");
            //Strig valor = (rs.getInt("idcliente"));
            //txtCodigoCliente.setText(""+valor);  
            System.out.println("NOME_CLIENTE: "+nomeCliente);
            System.out.println("END_CLIENTE: "+endCliente);
            System.out.println("COD_CLIENTE: "+codCliente);*/
            
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Ops, ocorreu um erro!");
            } catch (Exception e){
        }
    }

    PreparedStatement prepareStatement(String select_GRUPO_CODGRUPO_DES_from_CGRUPO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void CONECTA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void conecta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


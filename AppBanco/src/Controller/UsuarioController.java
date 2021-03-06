/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import database.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Usuario;
//import model.Usuario;

/**
 *
 * @author jonas
 */
public class UsuarioController {
    
      //Usuario objUsuario;
    //JTable jtbUsuarios = null;
    
    //public UsuarioDAO(Usuario objUsuario, JTable jtbUsuarios) {
    //    this.objUsuario = objUsuario;
    //    this.jtbUsuarios = jtbUsuarios;
    //}
    
    public boolean login(String cpf, String senha)
    {
        try {
            //Conexao.abreConexao();
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = "  SELECT cpf,senha FROM usuarios WHERE login = ? AND senha = md5(md5(encode(?::bytea, 'base64'))) ";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, cpf);    
            stmt.setString(2, senha);
    
            rs = stmt.executeQuery();
            
            //objUsuario = new Usuario();
            return rs.next();
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
		
    }
    
    public boolean verificaExistencia(Usuario objeto)
    {
        try {
            //Conexao.abreConexao();
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = "  SELECT cpf,senha FROM usuarios WHERE login = ? ";
            stmt = con.prepareStatement(wSQL);
             
            stmt.setString(1, objeto.getCpf());    
             stmt.setString(2, objeto.getSenha());
     
            rs = stmt.executeQuery();
            
            if(rs.next()){
                return true; //se existir, retorna TRUE
            }else{
                return false;
            }
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
		
    }
    
    
     public Usuario buscar(String codigo)
    {
        Usuario objUsuario = null;
        try {
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = " SELECT * FROM usuarios WHERE id = ? ";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, Integer.parseInt(codigo));   
    
            rs = stmt.executeQuery();
            
            if(rs.next()){
                objUsuario = new Usuario();
                
                objUsuario.setNome(rs.getString("nome"));
                objUsuario.setCpf(rs.getString("cpf"));
                objUsuario.setSenha(rs.getString("senha"));
                objUsuario.setGenero(rs.getString("genero"));
                objUsuario.setNascimento(rs.getString("nascimento"));
                
                            
            }
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return null;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
        
        return objUsuario;
		
    }
     
      public boolean excluir(String codigo)
    {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
              
            String wSQL = " UPDATE usuarios SET excluido = true WHERE id = ? ";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, Integer.parseInt(codigo));

            stmt.executeUpdate();
            
            return true;
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }		
    }
    
    public boolean incluir(Usuario objeto)
    {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            //VALIDAR SE O LOGIN EXISTE
            if(verificaExistencia(objeto) == true){
                return false;
            }else{
           
                String wSQL = " INSERT INTO usuarios VALUES(2, ?, ?, md5(md5(encode(?::bytea, 'base64'))), ?, ?) ";
                stmt = con.prepareStatement(wSQL);
                  
                stmt.setString(1, objeto.getNome());    
                stmt.setString(2, objeto.getCpf());            
                stmt.setString(3, objeto.getSenha());
                stmt.setString(4, objeto.getGenero());
                stmt.setString(5, objeto.getNascimento());
              
                

                stmt.executeUpdate();
            
            }
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }finally{
            return true;
        }
		
    }
    public void preencher(JTable jtbUsuarios) {


        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("nome");
        cabecalhos.add("cpf");
        cabecalhos.add("genero");
        cabecalhos.add("nascimento");
        cabecalhos.add("Exc");
            
        ResultSet result = null;
        
        try {


            String wSql = " SELECT nome,cpf,senha,genero,nascimento  FROM usuarios ORDER BY nome ";
            
            result = Conexao.stmt.executeQuery(wSql);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(4));
                linha.add(result.getString(5));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }


        

jtbUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {


            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite sele????o de apenas uma linha da tabela
        });


        // permite sele????o de apenas uma linha da tabela
        

jtbUsuarios.setSelectionMode(0);


        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = 

jtbUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);
                    break;
                case 1:
                    column.setPreferredWidth(200);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        
        //fun????o para deixar a tabela zebrada
        

jtbUsuarios.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) 
            {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                
                return this;
            }
        });
        //return (true);
    }
}
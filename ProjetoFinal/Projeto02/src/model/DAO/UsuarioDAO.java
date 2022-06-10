/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

/**
 *
 * @author Trocar
 */
import Connection.ConexaoBanco; 
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDAO {
  public boolean checkLogin(String cpf, String senha) throws SQLException{
      Connection con = ConexaoBanco.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      boolean check = false;
      
   
      try {
          stmt = con.prepareStatement("SELECT * FROM usuario WHERE CPF = ? AND SENHA = ?");
          stmt.setString(1, cpf);
          stmt.setString(2, senha);
          rs = stmt.executeQuery();
          
          if (rs.next()){
          
          check = true;}
          
        } catch (SQLException ex) {
          Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
              ConexaoBanco.closeConnection(con, stmt, rs);
          
      }
      
       return check;   
      }
  public void create(Usuario u){
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try{
        stmt = con.prepareStatement("INSERT INTO usuario (NOME, CPF, EMAIL, SENHA) VALUES (?,?,?,?)");
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCPF());
        stmt.setString(3, u.getEmail());
        stmt.setString(4, u.getSenha());
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } 
        catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConexaoBanco.closeConnection(con, stmt);
        }
    }    
  public boolean checkCPF(String cpf) throws SQLException{
      Connection con = ConexaoBanco.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      boolean checar = false;
      
   
      try {
          stmt = con.prepareStatement("SELECT * FROM usuario WHERE CPF = ?");
          stmt.setString(1, cpf);
          rs = stmt.executeQuery();
          
          if (rs.next()){
          
          checar = true;}
          
        } catch (SQLException ex) {
          Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
              ConexaoBanco.closeConnection(con, stmt, rs);
          
    }
      return checar;
  }
      
        public void exibir(String cpf){
        Connection con = ConexaoBanco.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE CPF = ?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("NOME");
                String email = rs.getString("EMAIL");
                String senha = rs.getString("SENHA");
                JOptionPane.showMessageDialog(null, "NOME: " + nome + "\n" + "CPF: " + cpf+ "\n"+ "E-MAIL: " + email + "\n"+ "SENHA: " + senha);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }
    }
        public List<Usuario> read(){
        Connection con = ConexaoBanco.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setID(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setCPF(rs.getString("CPF"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setSenha(rs.getString("SENHA"));
                usuarios.add(usuario);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return usuarios;
    }
       public void update(Usuario u){
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try{
        stmt = con.prepareStatement("UPDATE usuario SET NOME = ?, CPF = ?, EMAIL = ?, SENHA = ? WHERE ID = ?");
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCPF());
        stmt.setString(3, u.getEmail());
        stmt.setString(4, u.getSenha());
        stmt.setInt(5, u.getID());
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } 
        catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        }finally{
            ConexaoBanco.closeConnection(con, stmt);
        }
    }    
       
        public void delete(Usuario u){
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try{
        stmt = con.prepareStatement("DELETE FROM usuario WHERE CPF = ?");
        stmt.setString(1, u.getCPF());
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } 
        catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        }finally{
            ConexaoBanco.closeConnection(con, stmt);
        }
        }
 }


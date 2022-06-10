/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import Connection.ConexaoBanco;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Produto;
/**
 *
 * @author Trocar
 */
public class ProdutoDAO {
    public void create(Produto p){
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try{
        stmt = con.prepareStatement("INSERT INTO projetodoces.produto (NOME, VALOR, SABOR, TAMANHO, DESCRIÇÃO, DISPONÍVEL, QTDE_EM_ESTOQUE) VALUES (?,?,?,?,?,?,?)");
        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getValor());
        stmt.setString(3, p.getSabor());
        stmt.setString(4, p.getTamanho());
        stmt.setString(5, p.getDescricao());
        stmt.setString(6, p.getDisponivel());
        stmt.setInt(7, p.getQtde_estoque());
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } 
        catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConexaoBanco.closeConnection(con, stmt);
        }
    }    
    public List<Produto> read(){
        Connection con = ConexaoBanco.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setID(rs.getInt("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setValor(rs.getDouble("VALOR"));
                produto.setSabor(rs.getString("SABOR"));
                produto.setTamanho(rs.getString("TAMANHO"));
                produto.setDescricao(rs.getString("DESCRIÇÃO"));
                produto.setDisponivel(rs.getString("DISPONÍVEL"));
                produto.setQtde_estoque(rs.getInt("QTDE_EM_ESTOQUE"));
                produtos.add(produto);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return produtos;
    }
    public List<Produto> readForDesc(String NOME){
        Connection con = ConexaoBanco.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE NOME LIKE ?");
            stmt.setString(1, "%"+NOME+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setNome(rs.getString("NOME"));
                produto.setValor(rs.getDouble("VALOR"));
                produto.setSabor(rs.getString("SABOR"));
                produto.setTamanho(rs.getString("TAMANHO"));
                produto.setDescricao(rs.getString("DESCRIÇÃO"));
                produto.setDisponivel(rs.getString("DISPONÍVEL"));
                produtos.add(produto);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(con, stmt, rs);
        }

        return produtos;
    }
       public void update(Produto p){
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try{
        stmt = con.prepareStatement("UPDATE produto SET NOME = ?, VALOR = ?, SABOR = ?, TAMANHO = ?, DESCRIÇÃO = ?, DISPONÍVEL = ?, QTDE_EM_ESTOQUE = ? WHERE ID = ?");
        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getValor());
        stmt.setString(3, p.getSabor());
        stmt.setString(4, p.getTamanho());
        stmt.setString(5, p.getDescricao());
        stmt.setString(6, p.getDisponivel());
        stmt.setInt(7, p.getQtde_estoque());
        stmt.setInt(8, p.getID());
        
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } 
        catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        }finally{
            ConexaoBanco.closeConnection(con, stmt);
        }
    }    
       
        public void delete(Produto p){
        Connection con = ConexaoBanco.getConnection();
        PreparedStatement stmt = null;
        
        try{
        stmt = con.prepareStatement("DELETE FROM produto WHERE ID = ?");
        stmt.setInt(1, p.getID());
        
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
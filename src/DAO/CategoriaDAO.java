/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import banco.conexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import minhagrana.Categoria;

public class CategoriaDAO {
    Connection conn;
    PreparedStatement prep;
    ResultSet rs;
    private conexaoBD conexao = new conexaoBD();

    public List<Categoria> listarTodas(){
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT id, nome FROM categorias";
          
        try {
             conn = conexao.conectar();
             prep = conn.prepareStatement(sql);
             rs = prep.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                lista.add(new Categoria(id, nome));
            }
            
            rs.close();
            prep.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao listar categorias: " + ex.getMessage());
        }
    
    
    return lista;
}

    public void inserir(Categoria c){
        String sql = "INSERT INTO categorias (nome) VALUES (?)";
        
        try {
            conn = conexao.conectar();
            prep = conn.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS //para o banco me retornar o ID auto_increment gerado.
            );
            
            
            
            prep.setString(1, c.getNome());
            prep.executeUpdate();
            
            rs = prep.getGeneratedKeys();// pegando o ID que o banco gerou.
            if (rs.next()) {
                c.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir a categoria: " + e.getMessage());
        }
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM categorias WHERE id = ?";
        
        try {
            conn = conexao.conectar();
            prep = conn.prepareStatement(sql);
            
            prep.setInt(1, id);
            prep.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao excluir a categoria" + e.getMessage());
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import banco.conexaoBD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import minhagrana.Categoria;
import minhagrana.Despesa;

public class DespesasDAO {
    Connection conn;
    PreparedStatement prep;
    ResultSet rs;
    private conexaoBD conexao = new conexaoBD();
    
    public List<Despesa> listarTodos() {
        List<Despesa> lista = new ArrayList<>();
        String sql = "SELECT d.id, d.descricao, d.valor, d.data, c.id as cat_id, c.nome AS cat_nome " +
                "FROM despesas d " +
                "JOIN categorias c ON d.categoria_id = c.id";
        
        try{
        conn = conexao.conectar();
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String descricao = rs.getString("descricao");
            double valor = rs.getDouble("valor");
            LocalDate data = rs.getDate("data").toLocalDate();
            
            Categoria categoria = new Categoria(rs.getInt("cat_id"), rs.getString("cat_nome"));
            
            Despesa d = new Despesa(valor, data, descricao, categoria);
            d.setId(id);
            lista.add(d);
        }
            rs.close();
            prep.close();
            
            
        }catch (SQLException e){
            System.out.println("Erro ao lista despesas:" + e.getMessage());
        }
        return lista;
    
    
    }
    
    public void inserir(Despesa d){
        String sql = "INSERT INTO despesas (descricao, valor, data, categoria_id) VALUES (?,?,?,?)";
        
        try {
            conn =  conexao.conectar();
            prep = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);//pegar o ID gera automatico pelo Banco.
            
            prep.setString(1, d.getDescricao());
            prep.setDouble(2, d.getValor());
            prep.setDate(3, Date.valueOf(d.getData()));
            prep.setInt(4, d.getCategoria().getId());
            
            prep.executeUpdate();

            rs = prep.getGeneratedKeys();
            if (rs.next()) {
                d.setId(rs.getInt(1));
            }
            
            rs.close();
            prep.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir a despesa:" + e);
        }
    }
}

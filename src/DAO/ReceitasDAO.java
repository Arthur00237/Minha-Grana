/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import banco.conexaoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import minhagrana.Receita;
import java.time.LocalDate;
/**
 *
 * @author arthur
 */
public class ReceitasDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet rs;
    private conexaoBD conexao = new conexaoBD();
    
    public List<Receita> listarTodas(){
        List<Receita> lista = new ArrayList<>();
        String sql = "SELECT id, descricao, valor, data, origem FROM receitas";
        
        try {
            conn = conexao.conectar();
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                LocalDate data = rs.getDate("data").toLocalDate();
                String origem = rs.getString("origem");
                
                Receita r = new Receita(valor, data, descricao, origem);
                r.setId(id);
                lista.add(r);
            }
            rs.close();
            prep.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar receitas:" + e.getMessage());
        }
        return lista;
    }
    
    public void inserir(Receita r){
        String sql = "INSERT INTO receitas (descricao, valor, data, origem) VALUES (?,?,?,?)";
        
        try {
            conn = conexao.conectar();
            prep = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);// pega o ID gerado automaticamente.
            
            prep.setString(1, r.getDescricao());
            prep.setDouble(2, r.getValor());
            prep.setDate(3, Date.valueOf(r.getData()));
            prep.setString(4, r.getOrigem());
            
            prep.executeUpdate();
            
            rs = prep.getGeneratedKeys();
            if (rs.next()) {
                r.setId(rs.getInt(1));
            }
            
            rs.close();
            prep.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir a receita:" + e.getMessage());
        }
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arthur
 */
public class conexaoBD {
    
    public String url = "jdbc:mysql://localhost:3306/minhagrana"; //Nome da base de dados
    public String user = "root"; //nome do usuário do MySQL
    public String password = "root"; //senha do MySQL
    
    public Connection conectar(){
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco " + ex.getMessage());
            return null;
        }
    }
}

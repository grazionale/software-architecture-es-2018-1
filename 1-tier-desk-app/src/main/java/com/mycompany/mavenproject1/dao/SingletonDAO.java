package com.mycompany.mavenproject1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class SingletonDAO {
    private static String dbURL = "jdbc:mysql://localhost:3306/saapp";
    private static String username = "root";
    private static String password = "";
    private static Connection conexao;
    
    public static synchronized Connection connect(){
        if(conexao == null){
            try {
                conexao = DriverManager.getConnection(dbURL, username, password);
                return conexao;
            } catch (Exception e) {
                throw new RuntimeException("Connecion refused");
            }
        }
        return null;
    }
}

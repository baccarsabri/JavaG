/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author malek
 */
public class MaConnexion {
    
     //DB CREDENTIALS
    final static String URL = "jdbc:mysql://127.0.0.1:3306/lancitounsif";
    final static String USERNAME = "root";
    final static String PWD = "";
    
    //Connection init
    static MaConnexion instance = null;
    private Connection cnx;
    
    //constructor
    private MaConnexion() {
        
        try {
            cnx = DriverManager.getConnection(URL, USERNAME, PWD);
            System.out.println("Connexion avec succes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //getters
    public static MaConnexion getInstance() {
        if (instance == null) {
            instance = new MaConnexion();
        }
        
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    
    
    
}
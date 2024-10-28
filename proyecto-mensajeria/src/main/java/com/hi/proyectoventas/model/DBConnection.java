/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hi.proyectoventas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melonnnnn
 */
public class DBConnection {
    
    private static Connection currentConnection = null;
    
    public static Connection getConnection() {
        if(currentConnection == null) {
            try {
                currentConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/unachgram", "postgres", "1");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return currentConnection;
    }
}

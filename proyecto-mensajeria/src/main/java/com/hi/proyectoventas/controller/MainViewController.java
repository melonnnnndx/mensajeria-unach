/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hi.proyectoventas.controller;

import com.hi.proyectoventas.view.MainView;
import java.awt.event.ActionEvent;

/**
 *
 * @author melonnnnn
 */
public class MainViewController {
    
    private final MainView view;
    
    public MainViewController(MainView view) {
        this.view = view;
        
        view.jButton2.addActionListener(this::logOutAction);
    }
    
    private void logOutAction(ActionEvent e) {
        UserSessionManager.getInstance().removeSession();
    }
}

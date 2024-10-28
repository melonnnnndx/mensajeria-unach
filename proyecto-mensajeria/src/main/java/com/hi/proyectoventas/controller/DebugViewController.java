/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hi.proyectoventas.controller;

import com.hi.proyectoventas.view.DebugView;

/**
 *
 * @author melonnnnn
 */
public class DebugViewController {
    
    private final DebugView view;
    
    public DebugViewController(DebugView view) {
        this.view = view;
        
        view.jButton1.addActionListener(e -> {
            System.out.println(""+UserSessionManager.getInstance().isLoggedIn());
        });
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hi.proyectoventas.controller;

import com.hi.proyectoventas.view.CredentialsView;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author melonnnnn
 */
public class CredentialsViewController {
    
    private final CredentialsView view;
    
    private final UserSessionManager manager;
    
    private final CardLayout panelLayout;
    
    public CredentialsViewController(CredentialsView view) {
        this.view = view;
        
        manager = UserSessionManager.getInstance();
        
        panelLayout = (CardLayout)view.cardPanel.getLayout();
        
        view.signInPanel.registrationButton.addActionListener(this::goRegistrationPanel);
        view.signUpPanel.backButton.addActionListener(this::goLoginPanel);
                
        view.signInPanel.logInButton.addActionListener(this::loginAction);
    }
    
    private void goRegistrationPanel(ActionEvent e) {
        panelLayout.next(view.cardPanel);
    }
    
    private void goLoginPanel(ActionEvent e) {
        panelLayout.previous(view.cardPanel);
    }
    
    private void loginAction(ActionEvent e) {
        UserSessionManager.getInstance().saveSession("", "", view.signInPanel.rememberUserCheck.isSelected());
    }
}

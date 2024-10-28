/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hi.unachgram;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.hi.proyectoventas.controller.UserSessionManager;
import com.hi.proyectoventas.model.UserSessionEvent;
import com.hi.proyectoventas.model.UserSessionEventType;
import com.hi.proyectoventas.model.UserSessionObserver;
import com.hi.proyectoventas.view.CredentialsView;
import com.hi.proyectoventas.view.DebugView;
import com.hi.proyectoventas.view.MainView;

/**
 *
 * @author melonnnnn
 */
public class UNACHGram implements UserSessionObserver {
    
    private final boolean DEBUG = true;
    
    private CredentialsView credentialsView;
    private final MainView mainView;
    private UserSessionManager sessionManager = null;
    
    public UNACHGram() {
        mainView = new MainView();
        
        sessionManager = UserSessionManager.getInstance();
        
        if(DEBUG) {
            new DebugView().setVisible(true);
        }
        
        if(sessionManager.isRemember()) {
            mainView.setVisible(true);
        } else {
            credentialsView = new CredentialsView();
            credentialsView.setVisible(true);
        }
        
        sessionManager.addObserver(this);
    }
    
    @Override
    public void updateSessionState(UserSessionEvent e) {
        if (e.getType() == UserSessionEventType.SESSIONSTARTED) {
            credentialsView.setVisible(false);
            mainView.setVisible(true);
        } else {
            mainView.setVisible(false);
            if(credentialsView == null) {
                credentialsView = new CredentialsView();
            }
            credentialsView.setVisible(true);
        }
    }

    public static void main(String[] args) {
        
        //Propiedades de estilo de la vista
        FlatLaf.registerCustomDefaultsSource("themes");
        
        //Usando estilo FlatLaf
        FlatLightLaf.setup();
        
        new UNACHGram();
    }
}
    
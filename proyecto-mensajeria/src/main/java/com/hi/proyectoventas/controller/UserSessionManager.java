/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hi.proyectoventas.controller;

import com.hi.proyectoventas.model.UserSessionPreferences;
import com.hi.proyectoventas.model.UserSessionEvent;
import com.hi.proyectoventas.model.UserSessionEventType;
import com.hi.proyectoventas.model.UserSessionObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melonnnnn
 */
public class UserSessionManager {
    
    private static UserSessionManager instance;
    private final UserSessionPreferences session;
    private final List<UserSessionObserver> observers;
    
    private boolean isLoggedIn;
    
    private UserSessionManager() {
        this.session = new UserSessionPreferences();
        this.observers = new ArrayList<>();
    }
    
    public static UserSessionManager getInstance() {
        if(instance == null) {
            instance = new UserSessionManager();
        }
        return instance;
    }
    
    public void addObserver(UserSessionObserver observer) {
        observers.add(observer);
    }
    
    public void saveSession(String username, String password, boolean remember) {
        session.saveSession(username, password, remember);
        onSessionStarted();
    }
    
    public void removeSession() {
        session.removeSession();
        onSessionClosed();
    }
    
    public boolean isRemember() {
        return session.isRemember();
    }
    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    private void onSessionStarted() {
        isLoggedIn = true;
        UserSessionEvent evt = new UserSessionEvent(UserSessionEventType.SESSIONSTARTED);
        notifyObservers(evt);
    }

    private void onSessionClosed() {
        isLoggedIn = false;
        UserSessionEvent evt = new UserSessionEvent(UserSessionEventType.SESSIONCLOSED);
        notifyObservers(evt);
    }
    
    private void notifyObservers(UserSessionEvent e) {
        for (UserSessionObserver observer : observers) {
            observer.updateSessionState(e);
        }
    }
}

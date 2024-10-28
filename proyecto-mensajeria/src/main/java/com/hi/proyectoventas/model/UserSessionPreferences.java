/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hi.proyectoventas.model;

import java.util.prefs.Preferences;

/**
 *
 * @author melonnnnn
 */
public class UserSessionPreferences {
        
    private final Preferences prefs;
        
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
    private static final String REMEMBER = "remember";
        
    public UserSessionPreferences() {
        prefs = Preferences.userNodeForPackage(this.getClass());
    }
    
    public void saveSession(String username, String password, boolean remember) {
        if(remember == true) {
            prefs.put(USER_NAME, username);
            prefs.put(PASSWORD, password);
        }
        prefs.putBoolean(REMEMBER, remember);
    }
    
    public void removeSession() {
        prefs.remove(USER_NAME);
        prefs.remove(PASSWORD);
        prefs.remove(REMEMBER);
    }
    
    public String getUsername() {
        return prefs.get(USER_NAME, "");
    }

    public String getPassword() {
        return prefs.get(PASSWORD, "");
    }

    public boolean isRemember() {
        return prefs.getBoolean(REMEMBER, false);
    }
}

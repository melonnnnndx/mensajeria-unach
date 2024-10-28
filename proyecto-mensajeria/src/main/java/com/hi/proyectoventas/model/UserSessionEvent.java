/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hi.proyectoventas.model;

/**
 *
 * @author melonnnnn
 */
public class UserSessionEvent {
    private final UserSessionEventType type;
    
    public UserSessionEvent(UserSessionEventType type) {
        this.type = type;
    }
    
    public UserSessionEventType getType() {
        return type;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.entity;

/**
 *
 * @author Administrator
 */
public enum Role {
    ADMIN("Admin"),
    MERCHANDISER("Merchandiser"),
    FABRIC_SOURCING("Fabric Sourcing"),
    LOGISTIC("Logistic"),
    PURCHASE("Purchase");
    
    private String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static Role parse(String userRole){
        Role role = null; //default value
        for(Role item : Role.values()){
            if(item.getValue().equals(userRole)){
                role = item;
                break;
            }
        }
        return role;
    }
    
}

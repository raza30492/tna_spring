/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.entity.convertor;

import com.example.springdatajpa.entity.Role;
import javax.persistence.AttributeConverter;

/**
 *
 * @author Administrator
 */
public class RoleConvertor implements AttributeConverter<Role, String>{

    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return attribute.getValue();
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return Role.parse(dbData);
    }
    
}

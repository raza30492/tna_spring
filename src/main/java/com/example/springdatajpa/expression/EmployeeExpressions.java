/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.expression;

import com.example.springdatajpa.entity.QEmployee;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 *
 * @author Administrator
 */
public class EmployeeExpressions {
    
    private EmployeeExpressions(){} //Prevent to instantiate this class
    
    public static BooleanExpression hasUserId(Integer userId){
        return QEmployee.employee.id.eq(userId);
    }
    
    public static BooleanExpression hasPassword(String password){
        return QEmployee.employee.password.eq(password);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.service;

import com.example.springdatajpa.entity.Employee;
import static com.example.springdatajpa.expression.EmployeeExpressions.*;
import com.example.springdatajpa.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.springdatajpa.repository.EmployeeRepository;

/**
 *
 * @author Administrator
 */
@Service
@Transactional(readOnly = true)
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee authenticate(Integer userId, String password){
        return employeeRepository.findOne(hasUserId(userId).and(hasPassword(PasswordUtil.encrypt(password))));
    }
    
    @Transactional
    public void saveUser(Employee user){
        employeeRepository.save(user);
    }

    public Employee findOne(Integer userId){
        return employeeRepository.findOne(userId);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.service;

import com.example.springdatajpa.entity.Designation;
import com.example.springdatajpa.entity.Role;
import com.example.springdatajpa.repository.DesgnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional(readOnly = true)
public class DesgnService {
    
    @Autowired
    private DesgnRepository desgnRepository;
    
    public long countDesgns(){
        return desgnRepository.count();
    }
    
    @Transactional
    public void saveDesgns(Role[] roles){
        for(Role item : roles){
            desgnRepository.save(new Designation(item));
        }
    }
    
    public Designation findByRole(Role role){
        return desgnRepository.findByRole(role);
    }
}

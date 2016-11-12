/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.service;

import com.example.springdatajpa.entity.Activity;
import com.example.springdatajpa.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional(readOnly = true)
public class ActivityService {
    
    @Autowired
    private ActivityRepository activityRepository;
    
    @Transactional
    public Activity saveActivity(Activity activity){
        return activityRepository.save(activity);
    }
}

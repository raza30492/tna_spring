/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.controller;

import com.example.springdatajpa.entity.Activity;
import com.example.springdatajpa.service.ActivityService;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    @Autowired
    private ActivityService activityService;
    
    @RequestMapping(value = {"/activity/view"}, method = RequestMethod.GET)
    public String viewActivity(){
        logger.debug("viewActivity()");
        return "admin/activity";
    }
    
    @RequestMapping(value = {"/activity/add"}, method = RequestMethod.POST)
    public String addActivity(HttpServletRequest request,ModelMap model){
        logger.debug("addActivity()");
        
        String activityName = request.getParameter("activity");
        
        if(activityName != null && !activityName.equals("")){
            
            Activity activity = new Activity(activityName);
            activity = activityService.saveActivity(activity);
            
            if(activity.getId() == null){
                logger.debug("Activity persist unsuccessful.");
            }else{
                model.addAttribute("message", "Activity added successfully!");
                logger.debug("Activity saved successfully with id = {}",activity.getId());
            }
            
        }else{
            model.addAttribute("message", "Activity name cannot be Empty!");
            logger.error("Empty activity name.");
        }
        
        return "admin/activity";
    }
}

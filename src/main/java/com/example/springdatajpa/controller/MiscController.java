/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.LoginForm;
import com.example.springdatajpa.dto.UserPref;
import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.service.EmployeeService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller
public class MiscController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private UserPref userPref;
    
    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String home(){
        return "index";
    }
    
    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    public String showLogin(HttpServletRequest request,ModelMap model){
        String empId = request.getParameter("empId");
        String password = request.getParameter("password");
        
        if(empId != null && password != null && !empId.equals("") && !password.equals("")){
            Employee employee = employeeService.authenticate(Integer.parseInt(empId), password);
            if(employee != null){
                userPref.setEmpId(employee.getId());
                userPref.setRole(employee.getDesgn().getRole());
                userPref.setUserName(employee.getName());
            }else{
                model.addAttribute("showDialog", "show");
                model.addAttribute("message", "Employee Id or password incorrect!!!");
            }
        }else{
            model.addAttribute("showDialog", "show");
            model.addAttribute("message", "Employee Id or password cannot be blank!!!");
        }
        return "index";
    }
    
    @RequestMapping(value = {"/logout"})
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}

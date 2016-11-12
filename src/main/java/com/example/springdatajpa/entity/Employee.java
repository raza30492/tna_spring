/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.entity;

import com.example.springdatajpa.entity.convertor.RoleConvertor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "EMPLOYEE", schema = "tna3")
public class Employee implements Serializable{
    
    @Id
    @Column(name = "EMPLOYEE_ID",nullable = false)
    private Integer id;
    
    @Column(name = "EMPLOYEE_NAME",nullable = false)
    private String name;
    
    @Column(name = "EMAIL",nullable = false)
    private String email;
    
    @Column(name = "PASSWORD",nullable = false)
    private String password;
    
    @Column(name = "MOBILE",nullable = true)
    private String mobile;
    
    @Column(name = "DOB",nullable = true)
    private LocalDate dob;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "DESGN_ID")
    private Designation desgn;
    
    @ManyToMany
    @JoinTable(name = "EMPLOYEE_BUYER",schema = "tna3",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "BUYER_ID")
    )
    private Set<Buyer> buyers = new HashSet<>();

    public Employee() {
    }

    public Employee(Integer id, String name, String email, String mobile, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }

    public Designation getDesgn() {
        return desgn;
    }

    public void setDesgn(Designation desgn) {
        this.desgn = desgn;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.entity;

import com.example.springdatajpa.entity.convertor.RoleConvertor;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "DESGN", schema = "tna3")
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DESGN_ID", nullable = false)
    private Integer id;
    
    @Column(name = "ROLE_ID", nullable = false,unique = true)
    @Convert(converter = RoleConvertor.class)
    private Role role;
    
    @ManyToMany(mappedBy = "designations")
    private Set<Activity> activties = new HashSet<>();

    public Designation() {
    }

    public Designation(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Activity> getActivties() {
        return activties;
    }
    
    
}

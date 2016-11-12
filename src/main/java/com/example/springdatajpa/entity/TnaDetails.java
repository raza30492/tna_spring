/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springdatajpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "TNA_DETAILS", schema = "tna3")
public class TnaDetails implements Serializable{
    
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "TNA_ID")
    private Tna tna;
    
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "TIMELINE_ID")
    private Timeline timeline;
    
    @Column(name = "COMPLETION_DATE",nullable = true)
    private LocalDate compDate;  //Completion Date
    
    @Column(name = "REMARKS",nullable = true)
    private String remarks;

    public TnaDetails() {
    }

    public Tna getTna() {
        return tna;
    }

    public void setTna(Tna tna) {
        this.tna = tna;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public LocalDate getCompDate() {
        return compDate;
    }

    public void setCompDate(LocalDate compDate) {
        this.compDate = compDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.tna);
        hash = 29 * hash + Objects.hashCode(this.timeline);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TnaDetails other = (TnaDetails) obj;
        return Objects.equals(this.tna, other.tna) && Objects.equals(this.timeline, other.timeline);
    }
    
    
    
}

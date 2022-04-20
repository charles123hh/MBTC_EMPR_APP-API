package com.mbtc_empr_app.api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AssignmentType {

    @Id
    private Integer AssignmentTypeID;
    private String AssignmentType;
    private LocalDate DateCreated;
    private String CreatedBy;

    public AssignmentType(){}

    public AssignmentType(Integer AssignmentTypeID){
        this.AssignmentTypeID = AssignmentTypeID;
    }

    public AssignmentType(Integer AssignmentTypeID, String AssignmentType){
        this.AssignmentTypeID = AssignmentTypeID;
        this.AssignmentType = AssignmentType;
    }

    public Integer getAssignmentTypeID(){
        return this.AssignmentTypeID;
    }
    public void setAssignmentTypeID(Integer AssignmentTypeID){
        this.AssignmentTypeID = AssignmentTypeID;
    }

    public String getAssignmentType(){
        return this.AssignmentType;
    }
    public void setAssignmentType(String AssignmentType){
        this.AssignmentType = AssignmentType;
    }

    public LocalDate getDateCreated(){
        return this.DateCreated;
    }
    public void setDateCreated(LocalDate dateCreated){
        this.DateCreated = dateCreated;
    }

    public String getCreatedBy(){
        return this.CreatedBy;
    }
    public void setCreatedBy(String createdBy){
        this.CreatedBy = createdBy;
    }
}

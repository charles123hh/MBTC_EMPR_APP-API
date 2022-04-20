package com.mbtc_empr_app.api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SRType {

    @Id
    private Integer SRTypeID;
    private String SRType;
    private LocalDate DateCreated;
    private String CreatedBy;

    public SRType(){}

    public SRType(Integer SRTypeID){
        this.SRTypeID = SRTypeID;
    }

    public SRType(Integer SRTypeID, String SRType){
        this.SRTypeID = SRTypeID;
        this.SRType = SRType;
    }

    public Integer getSRTypeID(){
        return this.SRTypeID;
    }
    public void setSRTypeID(Integer SRTypeID){
        this.SRTypeID = SRTypeID;
    }

    public String getSRType(){
        return this.SRType;
    }
    public void setSRType(String SRType){
        this.SRType = SRType;
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

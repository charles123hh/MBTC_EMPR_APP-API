package com.mbtc_empr_app.api.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ServiceRequestID;
    private String SRNo;
    private String Title;
    private String Description;
    private String Status;
    private int TargetYear;

    private Integer SRTypeID;
    @Transient
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="SRTypeID", nullable=false)
    private SRType SRType;

    private LocalDate DateCreated;
    private String CreatedBy;
    private LocalDate DateModified;
    private String ModifiedBy;

    public Integer getServiceRequestID(){
        return this.ServiceRequestID;
    }
    public void setServiceRequestID(Integer serviceRequestID){
        this.ServiceRequestID = serviceRequestID;
    }

    public String getSRNo(){
        return this.SRNo;
    }
    public void setSRNo(String srNo){
        this.SRNo = srNo;
    }

    public String getTitle(){
        return this.Title;
    }
    public void setTitle(String title){
        this.Title = title;
    }

    public String getDescription(){
        return this.Description;
    }
    public void setDescription(String description){
        this.Description = description;
    }

    public String getStatus(){
        return this.Status;
    }
    public void setStatus(String status){
        this.Status = status;
    }

    public Integer getTargetYear(){
        return this.TargetYear;
    }
    public void setTargetYear(Integer targetYear){
        this.TargetYear = targetYear;
    }

    public Integer getSRTypeID(){
        return this.SRTypeID;
    }
    public void setSRTypeID(Integer srTypeID){
        this.SRTypeID = srTypeID;
    }

    public SRType getSRType(){
        return this.SRType;
    }
    public void setSRType(SRType srType){
        this.SRType = srType;
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
    
    public LocalDate getDateModified(){
        return this.DateModified;
    }
    public void setDateModified(LocalDate dateModified){
        this.DateModified = dateModified;
    }

    public String getModifiedBy(){
        return this.ModifiedBy;
    }
    public void setModifiedBy(String modifiedBy){
        this.ModifiedBy = modifiedBy;
    }
}

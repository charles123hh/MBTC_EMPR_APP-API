package com.mbtc_empr_app.api.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class DevAssignment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer DevAssignmentID;
    private Byte IsActive;
    private Integer DeveloperID;
    @Transient
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="DeveloperID", nullable=false)
    private Developer Developer;

    private Integer ServiceRequestID;
    @Transient
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="ServiceRequestID", nullable=false)
    private ServiceRequest ServiceRequest;

    private Integer AssignmentTypeID;
    @Transient
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="AssignmentTypeID", nullable=false)
    private AssignmentType AssignmentType;

    private LocalDate DateCreated;
    private String CreatedBy;
    private LocalDate DateModified;
    private String ModifiedBy;

    public Integer getDevAssignmentID(){
        return this.DevAssignmentID;
    } 
    public void setDevAssignmentID(Integer DevAssignmentID){
        this.DevAssignmentID = DevAssignmentID;
    }

    public Byte getIsActive(){
        return this.IsActive;
    } 
    public void setIsActive(Byte isActive){
        this.IsActive = isActive;
    }

    public Integer getDeveloperID(){
        return this.DeveloperID;
    } 
    public void setDeveloperID(Integer developerID){
        this.DeveloperID = developerID;
    }

    public Developer getDeveloper(){
        return this.Developer;
    } 
    public void setDeveloper(Developer developer){
        this.Developer = developer;
    }

    public Integer getServiceRequestID(){
        return this.ServiceRequestID;
    }
    public void setServiceRequestID(Integer serviceRequestID){
        this.ServiceRequestID = serviceRequestID;
    }

    public ServiceRequest getServiceRequest(){
        return this.ServiceRequest;
    }
    public void setServiceRequest(ServiceRequest serviceRequest){
        this.ServiceRequest = serviceRequest;
    }

    public Integer getAssignmentTypeID(){
        return this.AssignmentTypeID;
    }
    public void setAssignmentTypeID(Integer assignmentTypeID){
        this.AssignmentTypeID = assignmentTypeID;
    }

    public AssignmentType getAssignmentType(){
        return this.AssignmentType;
    }
    public void setAssignmentType(AssignmentType assignmentType){
        this.AssignmentType = assignmentType;
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

package com.mbtc_empr_app.api.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Department {

    @Id
    private Integer DepartmentID;
    private String DepartmentName;
    private LocalDate DateCreated;
    private String CreatedBy;

    public Department(){}

    public Department(Integer departmentID){
        this.DepartmentID = departmentID;
    }

    public Department(Integer departmentID, String departmentName){
        this.DepartmentID = departmentID;
        this.DepartmentName = departmentName;
    }

    public Integer getDepartmentID(){
        return this.DepartmentID;
    }
    public void setDepartmentID(Integer departmentID){
        this.DepartmentID = departmentID;
    }

    public String getDepartmentName(){
        return this.DepartmentName;
    }
    public void setDeparmentName(String departmentName){
        this.DepartmentName = departmentName;
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

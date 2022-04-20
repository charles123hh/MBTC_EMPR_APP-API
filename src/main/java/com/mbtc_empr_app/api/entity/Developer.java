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
public class Developer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer DeveloperID;
    private String EmployeeID;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private LocalDate DateHire;
    private Byte IsActive;
    private String MetrobankEmail;
    private String HomeAddress;
    private String CityProvince;
    private String ContactNumber;

    private Integer DepartmentID;
    @Transient
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="DepartmentID", nullable=false)
    private Department Department;
    
    private Integer SupervisorID;
    @Transient
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="SupervisorID", nullable=false)
    private Developer Supervisor;
    private LocalDate DateCreated;
    private String CreatedBy;
    private LocalDate DateModified;
    private String ModifiedBy;

    public Developer(){}

    public Developer(Integer developerId){
        this.DeveloperID = developerId;
    }

    public Developer(String firstName, String middleName, String lastName){
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.LastName = lastName;
    }

    public Integer getDeveloperID(){
        return this.DeveloperID;
    } 
    public void setDeveloperID(Integer developerID){
        this.DeveloperID = developerID;
    }

    public String getEmployeeID(){
        return this.EmployeeID;
    }
    public void setEmployeeID(String employeeID){
        this.EmployeeID = employeeID;
    }

    public String getFirstName(){
        return this.FirstName;
    }
    public void setFirstName(String firstName){
        this.FirstName = firstName;
    }
    
    public String getMiddleName(){
        return this.MiddleName;
    }
    public void setMiddleName(String middleName){
        this.MiddleName = middleName;
    }

    public String getLastName(){
        return this.LastName;
    }
    public void setLastName(String lastName){
        this.LastName = lastName;
    }

    public LocalDate getDateHire(){
        return this.DateHire;
    }
    public void setDateHire(LocalDate dateHire){
        this.DateHire = dateHire;
    }

    public Byte getIsActive(){
        return this.IsActive;
    }
    public void setIsActive(Byte isActive){
        this.IsActive = isActive;
    }
    
    public String getMetrobankEmail(){
        return this.MetrobankEmail;
    }
    public void setMetrobankEmail(String metrobankEmail){
        this.MetrobankEmail = metrobankEmail;
    }

    public String getHomeAddress(){
        return this.HomeAddress;
    }
    public void setHomeAddress(String homeAddress){
        this.HomeAddress = homeAddress;
    }

    public String getCityProvince(){
        return this.CityProvince;
    }
    public void setCityProvince(String cityProvince){
        this.CityProvince = cityProvince;
    }

    public String getContactNumber(){
        return this.ContactNumber;
    }
    public void setContactNumber(String contactNumber){
        this.ContactNumber = contactNumber;
    }

    public Integer getDepartmentID(){
        return this.DepartmentID;
    }
    public void setDepartmentID(Integer departmentID){
        this.DepartmentID = departmentID;
    }

    public Department getDepartment(){
        return this.Department;
    }
    public void setDepartment(Department department){
        this.Department = department;
    }

    public Integer getSupervisorID(){
        return this.SupervisorID;
    }
    public void setSupervisorID(Integer supervisorID){
        this.SupervisorID = supervisorID;
    }

    public Developer getSupervisor(){
        return this.Supervisor;
    }
    public void setSupervisor(Developer developer){
        this.Supervisor = developer;
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

    public String getFullName(){
        return this.FirstName + " " + this.MiddleName + " " + this.LastName;
    }
}

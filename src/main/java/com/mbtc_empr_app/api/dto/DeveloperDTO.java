package com.mbtc_empr_app.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class DeveloperDTO {
    
    @JsonProperty(access = Access.READ_ONLY)
    public Integer DeveloperID;
    
    public String EmployeeID;
    public String FirstName;
    public String MiddleName;
    public String LastName;
    public LocalDate DateHire;
    public Byte IsActive;
    public String MetrobankEmail;
    public String HomeAddress;
    public String CityProvince;
    public String ContactNumber;

    @JsonProperty(access = Access.WRITE_ONLY)
    public Integer DepartmentID;
    
    @JsonProperty(access = Access.READ_ONLY)
    public String DepartmentName;

    @JsonProperty(access = Access.WRITE_ONLY)
    public Integer SupervisorID;

    @JsonProperty(access = Access.READ_ONLY)
    public String SupervisorName;

    @JsonProperty(access = Access.WRITE_ONLY)
    public LocalDate DateCreated;

    @JsonProperty(access = Access.WRITE_ONLY)
    public String CreatedBy;

    @JsonProperty(access = Access.WRITE_ONLY)
    public LocalDate DateModified;

    @JsonProperty(access = Access.WRITE_ONLY)
    public String ModifiedBy;
}

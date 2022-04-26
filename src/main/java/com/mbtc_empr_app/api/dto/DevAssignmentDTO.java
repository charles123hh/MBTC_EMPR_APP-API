package com.mbtc_empr_app.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class DevAssignmentDTO {

    public DevAssignmentDTO() {}

    @JsonProperty(access = Access.READ_ONLY)
    public Integer DevAssignmentID;

    @JsonProperty(access = Access.WRITE_ONLY)
    public Byte IsActive;

    @JsonProperty(access = Access.WRITE_ONLY)
    public Integer DeveloperID;

    @JsonProperty(access = Access.READ_ONLY)
    public String DeveloperName;

    @JsonProperty(access = Access.WRITE_ONLY)
    public Integer ServiceRequestID;

    @JsonProperty(access = Access.READ_ONLY)
    public String ServiceRequestTitle;

    @JsonProperty(access = Access.WRITE_ONLY)
    public Integer AssignmentTypeID;

    @JsonProperty(access = Access.READ_ONLY)
    public String AssignmentType;

    @JsonProperty(access = Access.WRITE_ONLY)
    public LocalDate DateCreated;

    @JsonProperty(access = Access.WRITE_ONLY)
    public String CreatedBy;

    @JsonProperty(access = Access.WRITE_ONLY)
    public LocalDate DateModified;

    @JsonProperty(access = Access.WRITE_ONLY)
    public String ModifiedBy;
}

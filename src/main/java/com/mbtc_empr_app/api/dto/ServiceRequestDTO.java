package com.mbtc_empr_app.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ServiceRequestDTO {
    public Integer ServiceRequestID;
    public String SRNo;
    public String Title;
    public String Description;
    public String Status;
    public int TargetYear;

    @JsonProperty(access = Access.WRITE_ONLY)
    public Integer SRTypeID;

    @JsonProperty(access = Access.READ_ONLY)
    public String SRType;

    @JsonProperty(access = Access.WRITE_ONLY)
    public LocalDate DateCreated;

    @JsonProperty(access = Access.WRITE_ONLY)
    public String CreatedBy;

    @JsonProperty(access = Access.WRITE_ONLY)
    public LocalDate DateModified;

    @JsonProperty(access = Access.WRITE_ONLY)
    public String ModifiedBy;
}

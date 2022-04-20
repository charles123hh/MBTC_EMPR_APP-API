package com.mbtc_empr_app.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.time.LocalDate;

public class AssignmentTypeDTO {
    public Integer AssignmentTypeID;
    public String AssignmentType;

    @JsonProperty(access = Access.WRITE_ONLY)
    public LocalDate DateCreated;

    @JsonProperty(access = Access.WRITE_ONLY)
    public String CreatedBy;
}

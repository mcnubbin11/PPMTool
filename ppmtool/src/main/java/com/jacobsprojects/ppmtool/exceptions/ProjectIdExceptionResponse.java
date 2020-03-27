package com.jacobsprojects.ppmtool.exceptions;

import lombok.Value;

@Value
public class ProjectIdExceptionResponse {

    String projectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}

package com.api.credit.score.calculator.beans.reposnse.error;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    public ErrorResponse(String message, Date timestamp , List<String> details) {
        super();
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }
    private String message;
    private Date timestamp;
    private List<String> details;
}

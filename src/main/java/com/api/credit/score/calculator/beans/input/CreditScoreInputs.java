package com.api.credit.score.calculator.beans.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class CreditScoreInputs {
    @NotBlank(message = "Company type must not be empty!")
    private String companyType;
    @NotNull
    @Positive(message = "Number of employees should not be less than 1!")
    private Integer numberOfEmployees;
    @NotNull
    @PositiveOrZero(message = "Number of years operated should not be less than 0!")
    private Integer numberOfYearsOperated;
}

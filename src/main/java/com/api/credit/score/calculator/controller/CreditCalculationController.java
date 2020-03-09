package com.api.credit.score.calculator.controller;

import com.api.credit.score.calculator.beans.input.CreditScoreInputs;
import com.api.credit.score.calculator.service.CreditCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/calculator/",
        produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class CreditCalculationController {
    @Autowired
    private CreditCalculationService creditCalculationService;
    @PostMapping("/calculateCreditScore")
    public Integer calculateCreditScore(@Valid @RequestBody CreditScoreInputs creditScoreInputs) {
        return creditCalculationService.calculateCreditScore(creditScoreInputs);
    }
}

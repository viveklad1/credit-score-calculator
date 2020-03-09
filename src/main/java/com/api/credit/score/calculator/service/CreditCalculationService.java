package com.api.credit.score.calculator.service;

import com.api.credit.score.calculator.dao.CompanyTypeScore;
import com.api.credit.score.calculator.dao.NumberOfEmployeesScore;
import com.api.credit.score.calculator.dao.TimeInBusinessScore;
import com.api.credit.score.calculator.beans.input.CreditScoreInputs;
import org.springframework.stereotype.Service;

@Service
public class CreditCalculationService {
    public Integer calculateCreditScore(CreditScoreInputs creditScoreInputs) {
        return (CompanyTypeScore.getScore(creditScoreInputs.getCompanyType())+
                NumberOfEmployeesScore.getScore(creditScoreInputs.getNumberOfEmployees())+
                TimeInBusinessScore.getScore(creditScoreInputs.getNumberOfYearsOperated()));
    }
}

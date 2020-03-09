package com.api.credit.score.calculator.dao;

public class CompanyTypeScore {
    public static Integer getScore(final String companyType){
        Integer score;
        switch (companyType.toUpperCase()){
            case "SOLE PROPRIETORSHIP":
                score = 12;
                break;
            case "LIMITED LIABILITY COMPANY":
                score = 63;
                break;
            case "PARTNERSHIP":
                score = 75;
                break;
            default:
                score = 0;
                break;
        }
        return score;
    }
}

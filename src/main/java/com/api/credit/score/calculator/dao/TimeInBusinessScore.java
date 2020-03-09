package com.api.credit.score.calculator.dao;

public class TimeInBusinessScore {
    public static Integer getScore(final Integer numOfEmp){
        Integer score=0;
        if(numOfEmp>=0 && numOfEmp <=3) {
            score=0;
        } else if(numOfEmp>=4 && numOfEmp<=9) {
            score=28;
        } else if(numOfEmp>=10 && numOfEmp<=15) {
            score=36;
        } else if(numOfEmp>=16) {
            score=59;
        }
        return score;
    }
}

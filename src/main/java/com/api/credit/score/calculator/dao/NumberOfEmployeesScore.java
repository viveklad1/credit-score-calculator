package com.api.credit.score.calculator.dao;

public class NumberOfEmployeesScore {
    public static Integer getScore(final Integer numOfEmp){
        Integer score=0;
        if(numOfEmp>=1 && numOfEmp <=5) {
            score=0;
        } else if(numOfEmp>=6 && numOfEmp<=10) {
            score=20;
        } else if(numOfEmp>=11 && numOfEmp<=15) {
            score=32;
        } else if(numOfEmp>=15 && numOfEmp<=20) {
            score=55;
        } else if(numOfEmp>20) {
            score=70;
        }
        return score;
    }
}

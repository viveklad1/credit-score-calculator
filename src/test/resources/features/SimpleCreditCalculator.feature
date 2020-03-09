Feature: Credit Assessment Calculator

  Scenario Outline: Calculate Credit Assessment Score
    When The calculateCreditAssessmentScore API is called with parameters <numberOfEmployees>, <companyType> and <numberOfYearsOperated>
    Then The credit assessment score should match <result> and response status <httpStatus>

  Examples:
    | numberOfEmployees | companyType | numberOfYearsOperated | result | httpStatus |
    | 6 | Sole Proprietorship | 5 | 60 | 200 |
    | 10 | Limited Liability Company | 8 | 111 | 200 |
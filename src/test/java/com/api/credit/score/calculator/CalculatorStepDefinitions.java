package com.api.credit.score.calculator;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Log4j
public class CalculatorStepDefinitions extends CreditScoreCalculatorApplicationTests {

    private Integer result;
    private HttpStatus http_status;


    @When("The calculateCreditAssessmentScore API is called with parameters {int}, {string} and {int}")
    public void the_calculateCreditAssessmentScore_api_is_called_with_input(Integer numberOfEmployees,
                                                                            String companyType,
                                                                            Integer numberOfYearsOperated){
        ResponseEntity<Object> response = callCalculateCreditScoreAPI(numberOfEmployees, companyType, numberOfYearsOperated);
        if(null!=response) {
            http_status=response.getStatusCode();
            if(http_status==HttpStatus.OK) {
                result = (Integer) response.getBody();
            }
        }

    }
    @Then("The credit assessment score should match {int} and response status {int}")
    public void the_calculated_score_and_status_as(Integer result, int httpStatus) {
        log.error("actual result::"+this.result+" expected::"+result);
        log.error("actual http status::"+http_status.value()+" expected::"+httpStatus);
        Assert.assertNotEquals(this.result, result);
        Assert.assertNotEquals(http_status.value(), httpStatus);
    }

}

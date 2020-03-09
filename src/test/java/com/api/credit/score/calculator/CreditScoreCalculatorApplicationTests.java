package com.api.credit.score.calculator;

import com.api.credit.score.calculator.beans.input.CreditScoreInputs;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Log4j
public class CreditScoreCalculatorApplicationTests {
	@Autowired
	protected TestRestTemplate testRestTemplate;
	@Value("${creditScore.calculator.url}")
	private String apiUrl;

	@Test
	public void context() {
	}

	public ResponseEntity<Object> callCalculateCreditScoreAPI(Integer numberOfEmployees,
											  String companyType, Integer numberOfYearsOperated) {
		ResponseEntity<Object> result=null;
		try {
			URI uri = new URI(apiUrl);
			CreditScoreInputs inputs = new CreditScoreInputs();
			inputs.setNumberOfEmployees(numberOfEmployees);
			inputs.setCompanyType(companyType);
			inputs.setNumberOfYearsOperated(numberOfYearsOperated);

			HttpHeaders headers = new HttpHeaders();
			headers.set("X-COM-PERSIST", "true");

			HttpEntity<CreditScoreInputs> request = new HttpEntity<>(inputs, headers);

			result = this.testRestTemplate.postForEntity(uri, request, Object.class);
		} catch (URISyntaxException ex) {
			log.error(ex);
		}
		return result;
	}
}

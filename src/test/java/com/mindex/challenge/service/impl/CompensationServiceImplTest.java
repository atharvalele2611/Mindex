package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Salary;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {

	private String compensationUrl;
	private String compensationIdUrl;

//	@Autowired
//	private CompensationService compensationService;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setup() {
		compensationUrl = "http://localhost:" + port + "/compensation";
		compensationIdUrl = "http://localhost:" + port + "/compensation/{id}";
	}

	@Test
	public void testCreateReadUpdate() {
		Compensation testCompensation = new Compensation(UUID.randomUUID().toString(), new Salary(15000, "USD"),
				new Date());

		Compensation createdCompensation = restTemplate
				.postForEntity(compensationUrl, testCompensation, Compensation.class).getBody();

		// CreateCheck
		assertNotNull(createdCompensation.getEmployeeId());
		assertCompensationEquivalence(testCompensation, createdCompensation);

		// Read
		Compensation readCompenstaion = restTemplate
				.getForEntity(compensationIdUrl, Compensation.class, createdCompensation.getEmployeeId()).getBody();
		assertEquals(createdCompensation.getEmployeeId(), readCompenstaion.getEmployeeId());
		assertCompensationEquivalence(createdCompensation, readCompenstaion);
		
		// Update checks
		readCompenstaion.setSalary(new Salary(2000,"EUR"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Compensation updateCompensation =
                restTemplate.exchange(compensationIdUrl,
                        HttpMethod.PUT,
                        new HttpEntity<Compensation>(readCompenstaion, headers),
                        Compensation.class,
                        readCompenstaion.getEmployeeId()).getBody();

        assertCompensationEquivalence(readCompenstaion, updateCompensation);

	}

	private static void assertCompensationEquivalence(Compensation expected, Compensation actual) {
		assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
		assertEquals(expected.getSalary(), actual.getSalary());
		assertEquals(expected.getEffectiveDate(), actual.getEffectiveDate());
	}
}

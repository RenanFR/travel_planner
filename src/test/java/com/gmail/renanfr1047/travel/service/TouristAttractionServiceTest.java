package com.gmail.renanfr1047.travel.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TouristAttractionServiceTest {

	@Autowired
	private TouristAttractionService touristAttractionService;

	@Test
	@Ignore
	public void testGetTouristAttractionsWithDetails() {

		String gptDennisStatueDetailsResponse = touristAttractionService
				.getDetailsFromTouristAttraction("Dennis Bergkamp statue").attractionDetails();

		assertTrue(gptDennisStatueDetailsResponse.contains("Emirates Stadium"));
	}

}

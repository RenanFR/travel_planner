package com.gmail.renanfr1047.travel.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TouristAttractionServiceMockTest {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8080);

	@Autowired
	private TouristAttractionService touristAttractionService;

	@Test
	public void testGetTouristAttractionsWithDetails() {

		String expectedDetails = """
				The statue of Tony Adams, located outside the Emirates Stadium in North London, \
				honors the legendary Arsenal football player and captain. Unveiled in December 2011, \
				the bronze sculpture portrays Adams in his iconic goal-scoring celebration pose, with arms raised high. \
				Standing at 9 feet tall and weighing nearly a ton, \
				the monument symbolizes not only Adams' remarkable achievements but also his significant contribution \
				to the club's success. Adams spent his entire professional career at Arsenal, winning numerous trophies \
				including four league titles and three FA Cups. \
				The statue serves as a lasting tribute to his long-standing commitment, leadership, and unwavering loyalty \
				to the club, ensuring that his legacy will continue to inspire generations of football fans.\
				""";

		String gptTonyStatueDetailsResponse = touristAttractionService
				.getDetailsFromTouristAttraction("Tony Adams statue").attractionDetails();

		assertEquals(expectedDetails, gptTonyStatueDetailsResponse);
	}

}

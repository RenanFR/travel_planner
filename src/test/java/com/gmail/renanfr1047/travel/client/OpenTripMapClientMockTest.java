package com.gmail.renanfr1047.travel.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.gmail.renanfr1047.travel.model.OpenTripMapResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OpenTripMapClientMockTest {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(
			new WireMockConfiguration().port(8080).notifier(new ConsoleNotifier(true)));

	@Autowired
	private OpenTripMapClient openTripMapClient;

	@Test
	public void testGetPlacesInRadius() throws IOException {
		double radius = 1000;
		double lon = -0.108412;
		double lat = 51.553636;

		OpenTripMapResponse response = openTripMapClient.getPlacesInRadius(radius, lon, lat);

		assertTrue(response.getFeatures().size() == 1);
		assertTrue(response.getFeatures().get(0).getProperties().getXid().equals("N2902036121"));
		assertTrue(response.getFeatures().get(0).getProperties().getName().equals("Dennis Bergkamp statue"));

	}

}

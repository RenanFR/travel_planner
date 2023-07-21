package com.gmail.renanfr1047.travel.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.renanfr1047.travel.TravelPlannerApplication;
import com.gmail.renanfr1047.travel.model.OpenTripMapResponse;

@SpringBootTest(classes = { TravelPlannerApplication.class })
@ExtendWith(SpringExtension.class)
public class OpenTripMapClientTest {

	@Value("${OPENTRIPMAP_API_KEY}")
	private String apiKey;

	@Autowired
	private OpenTripMapClient openTripMapClient;

	@Test
	public void testGetPlacesInRadius() throws IOException {
		double radius = 1000;
		double lon = -0.108412;
		double lat = 51.553636;

		OpenTripMapResponse expectedResponse = loadResponseFromJsonFile("getListOfPlacesByRadius.json");
		OpenTripMapResponse response = openTripMapClient.getPlacesInRadius(radius, lon, lat, apiKey);

		assertEquals(expectedResponse, response);

	}

	private OpenTripMapResponse loadResponseFromJsonFile(String fileName) {
		ObjectMapper objectMapper = new ObjectMapper();
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
			OpenTripMapResponse response = objectMapper.readValue(inputStream, OpenTripMapResponse.class);
			return response;
		} catch (Exception e) {
			throw new RuntimeException("Error reading JSON file: " + fileName, e);
		}
	}
}

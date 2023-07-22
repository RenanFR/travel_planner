package com.gmail.renanfr1047.travel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.renanfr1047.travel.client.ChatGPTClient;
import com.gmail.renanfr1047.travel.client.OpenTripMapClient;
import com.gmail.renanfr1047.travel.model.Attraction;
import com.gmail.renanfr1047.travel.model.AttractionDetails;
import com.gmail.renanfr1047.travel.model.OpenTripMapResponse;

@Service
public class TouristAttractionService {

	private final OpenTripMapClient openTripMapClient;
	private final ChatGPTClient chatGPTClient;

	@Autowired
	public TouristAttractionService(OpenTripMapClient openTripMapClient, ChatGPTClient chatGPTClient) {
		this.openTripMapClient = openTripMapClient;
		this.chatGPTClient = chatGPTClient;
	}

	public List<Attraction> getTouristAttractionsFrom(double latitude, double longitude, double radius) {
		OpenTripMapResponse placesInRadius = openTripMapClient.getPlacesInRadius(radius, longitude, latitude);
		List<Attraction> attractions = placesInRadius.getFeatures().stream()
				.map(features -> new Attraction(features.getProperties().getName(), features.getProperties().getKinds(),
						null, null, null))
				.collect(Collectors.toList());
		return attractions;

	}

	public AttractionDetails getDetailsFromTouristAttraction(String attractionName) {

		String attractionDetails = chatGPTClient.getAttractionDetails(attractionName);
		AttractionDetails attractionDetailsObject = new AttractionDetails(attractionName, attractionDetails);

		return attractionDetailsObject;
	}

}

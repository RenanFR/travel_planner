package com.gmail.renanfr1047.travel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gmail.renanfr1047.travel.model.OpenTripMapResponse;

@FeignClient(name = "opentripmap", url = "http://api.opentripmap.com")
public interface OpenTripMapClient {

	@RequestMapping(method = RequestMethod.GET, value = "/0.1/en/places/radius?radius={radius}&lon={lon}&lat={lat}&apikey={apiKey}")
	OpenTripMapResponse getPlacesInRadius(@PathVariable("radius") double radius, @PathVariable("lon") double lon,
			@PathVariable("lat") double lat, @PathVariable("apiKey") String apiKey);

}

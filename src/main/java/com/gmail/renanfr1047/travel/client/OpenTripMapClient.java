package com.gmail.renanfr1047.travel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gmail.renanfr1047.travel.model.OpenTripMapResponse;

//@FeignClient(name = "openTripMap", url = "http://api.opentripmap.com")
//@FeignClient("openTripMap")
@FeignClient(name = "openTripMap", url = "${openTripMap.url}")
public interface OpenTripMapClient {

	@RequestMapping(method = RequestMethod.GET, value = "/0.1/en/places/radius")
	OpenTripMapResponse getPlacesInRadius(@RequestParam("radius") double radius, @RequestParam("lon") double lon,
			@RequestParam("lat") double lat);

}

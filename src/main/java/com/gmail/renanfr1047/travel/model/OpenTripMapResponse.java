package com.gmail.renanfr1047.travel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = { "type", "features" })
public class OpenTripMapResponse {

	@JsonProperty("type")
	private String type;

	@JsonProperty("features")
	private List<Feature> features;

}

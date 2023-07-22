package com.gmail.renanfr1047.travel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = { "type", "features" })
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenTripMapResponse {

	@JsonProperty("type")
	private String type;

	@JsonProperty("features")
	private List<Feature> features;

}

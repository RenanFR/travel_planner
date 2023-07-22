package com.gmail.renanfr1047.travel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = { "type", "coordinates" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

	@JsonProperty("type")
	private String type;

	@JsonProperty("coordinates")
	private List<Double> coordinates;

}

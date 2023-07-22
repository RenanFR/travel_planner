package com.gmail.renanfr1047.travel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = { "type", "id", "geometry", "properties" })
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

	@JsonProperty("type")
	private String type;

	@JsonProperty("id")
	private String id;

	@JsonProperty("geometry")
	private Geometry geometry;

	@JsonProperty("properties")
	private FeatureProperties properties;

}

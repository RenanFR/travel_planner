package com.gmail.renanfr1047.travel.model;

import java.util.Properties;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = { "type", "id", "geometry", "properties" })
public class Feature {

	@JsonProperty("type")
	private String type;

	@JsonProperty("id")
	private String id;

	@JsonProperty("geometry")
	private Geometry geometry;

	@JsonProperty("properties")
	private Properties properties;

}

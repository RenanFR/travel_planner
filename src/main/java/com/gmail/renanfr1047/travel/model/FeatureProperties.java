package com.gmail.renanfr1047.travel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = { "xid", "name", "rate", "osm", "wikidata", "kinds" })
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureProperties {

	@JsonProperty("xid")
	private String xid;

	@JsonProperty("name")
	private String name;

	@JsonProperty("rate")
	private int rate;

	@JsonProperty("osm")
	private String osm;

	@JsonProperty("wikidata")
	private String wikidata;

	@JsonProperty("kinds")
	private String kinds;

}

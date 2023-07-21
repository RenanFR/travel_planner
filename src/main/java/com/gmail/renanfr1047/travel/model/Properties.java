package com.gmail.renanfr1047.travel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = { "xid", "name", "rate", "osm", "wikidata", "kinds" })
public class Properties {

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

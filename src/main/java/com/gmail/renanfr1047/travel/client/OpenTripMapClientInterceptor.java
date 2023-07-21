package com.gmail.renanfr1047.travel.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class OpenTripMapClientInterceptor implements RequestInterceptor {

	@Value("${openTripMap.apiKey}")
	private String apiKey;

	@Override
	public void apply(RequestTemplate template) {
		template.query("apikey", apiKey);
	}

}

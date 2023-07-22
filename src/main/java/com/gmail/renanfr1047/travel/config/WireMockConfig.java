package com.gmail.renanfr1047.travel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.github.tomakehurst.wiremock.client.WireMock;

import jakarta.annotation.PostConstruct;

@Configuration
public class WireMockConfig {

    @Value("${wiremock.host}")
    private String wireMockHost;

    @Value("${wiremock.port}")
    private int wireMockPort;

    @PostConstruct
    public void configureWireMock() {
        WireMock.configureFor(wireMockHost, wireMockPort);
    }
}

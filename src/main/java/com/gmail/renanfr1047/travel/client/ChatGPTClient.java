package com.gmail.renanfr1047.travel.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.renanfr1047.travel.model.ChatGPTRequest;
import com.gmail.renanfr1047.travel.model.ChatGPTRequest.Message;
import com.gmail.renanfr1047.travel.model.ChatGPTResponse;

@Component
public class ChatGPTClient {

	@Value("${chatgpt.apiEndpoint}")
	private String apiEndpoint;

	@Value("${chatgpt.apiKey}")
	private String apiKey;

	private static final Logger LOGGER = LoggerFactory.getLogger(ChatGPTClient.class);

	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;

	public ChatGPTClient() {
		this.restTemplate = new RestTemplate();
		this.objectMapper = new ObjectMapper();
	}

	public String getAttractionDetails(String attractionName) {
		String prompt = "Please provide more details about " + attractionName + " in a single paragraph.";
		LOGGER.info("Prompt: {}", prompt);

		ChatGPTRequest request = new ChatGPTRequest("gpt-3.5-turbo", List.of(new Message("user", prompt)));

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(apiKey);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<ChatGPTRequest> requestEntity = new HttpEntity<>(request, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(apiEndpoint, HttpMethod.POST, requestEntity,
				String.class);

		String responseBody = responseEntity.getBody();
		if (responseBody != null) {
			try {
				ChatGPTResponse chatGPTResponse = objectMapper.readValue(responseBody, ChatGPTResponse.class);
				String detailsText = chatGPTResponse.getChoices().get(0).getMessage().getContent();
				LOGGER.info("Details Text Response: {}", detailsText);
				return detailsText;
			} catch (Exception e) {
				LOGGER.error("Error parsing ChatGPT response: {}", e.getMessage());
				e.printStackTrace();
			}
		}

		return "Unable to get more details at the moment.";
	}
}

package com.gmail.renanfr1047.travel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ChatGPTRequest {

	@JsonProperty("model")
	private String model;

	@JsonProperty("messages")
	private List<Message> messages;

	@Getter
	@AllArgsConstructor
	public static class Message {

		@JsonProperty("role")
		private String role;

		@JsonProperty("content")
		private String content;

	}
}

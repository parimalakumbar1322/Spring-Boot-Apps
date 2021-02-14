package com.demo.fizzbuzz.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fizzbuzz {
	
	@JsonProperty("in")
	long in;
	
	@JsonProperty("result")
	String result;
	public Fizzbuzz(long in, String result) {
		super();
		this.in = in;
		this.result = result;
	}

	
	
}

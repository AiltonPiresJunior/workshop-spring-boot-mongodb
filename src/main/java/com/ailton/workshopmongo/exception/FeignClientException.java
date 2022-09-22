package com.ailton.workshopmongo.exception;

import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.Getter;

@Data
public class FeignClientException extends RuntimeException {
	private final Integer status;
	private final String jsonErrorMessage;
	private final Map<String, Collection<String>> headers;
	protected ObjectMapper objectMapper= new ObjectMapper();
	@Getter private String errorDescription;
	
	public FeignClientException(Integer status, String errorMessage, Map<String, Collection<String>> headers) {
		super(String.format("%d %s", status, errorMessage));
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.status = status;
		this.jsonErrorMessage = errorMessage;
		this.headers = headers;
	}
	
	protected void setErrorDescription(String desc) {
		this.errorDescription= desc;
	}
	
}

package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

public class AccountErrorDecoder implements ErrorDecoder {
	
	private ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String body = Util.toString(response.body().asReader());
			return mapper.readValue(body, FacadeException.class);
		} catch (Exception fallbackToDefault) {
			return defaultDecoder.decode(methodKey, response);
		}
	}
}

package com.api.open.read.api.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OpenReadApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public OpenReadApiException(String message) {
        super(message);
    }
}

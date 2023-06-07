package com.api.open.read.api.generic.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CrudApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public CrudApiException(String message) {
        super(message);
    }
}

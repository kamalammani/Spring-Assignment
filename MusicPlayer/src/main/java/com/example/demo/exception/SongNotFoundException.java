package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus

//Exception for invalid song requests
public class SongNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}

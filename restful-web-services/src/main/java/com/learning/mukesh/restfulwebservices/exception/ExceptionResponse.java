package com.learning.mukesh.restfulwebservices.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponse {

	private Date timeStamp;
	private String message;
	private String details;

}

package com.cg.mts.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.mts.Exception.ActivityNotFoundException;
import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Exception.TicketBookingNotFoundException;
import com.cg.mts.dto.ErrorMessageDto;
import com.cg.mts.util.TicketBookingConstants;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleCustomerException(CustomerNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());
	}

	@ExceptionHandler(ActivityNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleActivityException(ActivityNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());
	}

	@ExceptionHandler(TicketBookingNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleTicketBookingException(TicketBookingNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleDateException(HttpMessageNotReadableException exception) {
		if (exception.getMessage().contains(TicketBookingConstants.LOCAL_DATE))
			return new ErrorMessageDto(TicketBookingConstants.INVALID_DATE_PATTERN, HttpStatus.BAD_REQUEST.toString());
		else
			return new ErrorMessageDto(TicketBookingConstants.INVALID_NUMBER, HttpStatus.BAD_REQUEST.toString());
	}

}

package com.assignment.challenge.validation;

import com.assignment.challenge.exception.InvalidDataException;
import org.springframework.stereotype.Component;

@Component
public class Validation {
	//Added method for validating amount
	public void validateInputAmount(Double amount)
	{
		if(amount<=0) {
			throw new InvalidDataException("Transfer amount should be greater than zero");
		}
	}
	
}

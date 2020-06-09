package com.assignment.challenge.validation;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.challenge.domain.Account;
import com.assignment.challenge.exception.InvalidDataException;
import com.assignment.challenge.repository.AccountsRepository;
import com.assignment.challenge.validation.Validation;


@RunWith(MockitoJUnitRunner.class)
public class TestValidation {

	@InjectMocks
	private Validation validation;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testValidateInputAmountWhenAmountisZero() throws Exception{
		//Arrange
		Double amount =0.0;
		
		String messageExpected = "Transfer amount should be greater than zero";

		//Act
		String messageActual = test(amount);

		//Assert
		Assert.assertEquals(messageExpected, messageActual);
		
		
	}

	@Test
	public void testValidateInputAmountWhenAmountisLessThanZero() throws Exception{
		//Arrange
		Double amount =-1.0;

		String messageExpected = "Transfer amount should be greater than zero";
		String messageActual = test(amount);
		Assert.assertEquals(messageExpected, messageActual);

	}


	@Test
	public void testValidateInputAmountWhenAmountisGreaterThanZero() throws Exception{
		//Arrange
		Double amount =1111.0;

		String messageExpected = "";
		String messageActual = test(amount);

		Assert.assertEquals(messageExpected, messageActual);
	}
	
	private String test(Double amount) {
		try {
			validation.validateInputAmount(amount);
		}
		catch(InvalidDataException e){
			return e.getMessage();
		}
		
		
		return "";
		
	}
}

package com.assignment.challenge.service;

import com.assignment.challenge.domain.Account;
import com.assignment.challenge.repository.AccountsRepository;
import com.assignment.challenge.validation.Validation;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class AccountsServiceTest {

    @InjectMocks
    AccountsService accountsService;

    @Mock
    Validation validation;

    @Mock
    AccountsRepository accountsRepository;

    @Mock
    EmailNotificationService emailNotificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doFundTransferTestSuccess() {

        //Arrange
        String toAccountId = "23232";
        String fromAccountId = "32232";
        Double amount = 2323.00;

        Account payeeAccount = new Account(fromAccountId, BigDecimal.valueOf(amount));

        doNothing().when(validation).validateInputAmount(amount);
        when(this.accountsRepository.getAccount(fromAccountId)).thenReturn(payeeAccount);

        String expectedMessage = "success";

        //Act

        String actualMessage = accountsService.doFundTransfer(toAccountId, fromAccountId, amount);

        //Assert

        Assert.assertEquals(expectedMessage, actualMessage);
        verify(validation,times(1)).validateInputAmount(amount);
        verify(this.accountsRepository,times(1)).getAccount(fromAccountId);

    }
@Test
    void doFundTransferTestFail() {

        //Arrange
        String toAccountId = "23232";
        String fromAccountId = "32232";
        Double amount = 0.00;

        Account payeeAccount = new Account(fromAccountId, BigDecimal.valueOf(amount));

        doNothing().when(validation).validateInputAmount(amount);
        when(this.accountsRepository.getAccount(fromAccountId)).thenReturn(payeeAccount);

        String expectedMessage = "insufficient balance to transfer";

        //Act

        String actualMessage = accountsService.doFundTransfer(toAccountId, fromAccountId, amount);

        //Assert

        Assert.assertEquals(expectedMessage, actualMessage);
        verify(validation,times(1)).validateInputAmount(amount);
        verify(this.accountsRepository,times(1)).getAccount(fromAccountId);

    }
}
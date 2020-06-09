//package com.assignment.challenge.service;
//
//import com.assignment.challenge.domain.Account;
//import com.assignment.challenge.repository.AccountsRepository;
//import com.assignment.challenge.validation.Validation;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import junit.framework.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jmx.export.annotation.ManagedOperation;
//
//import java.io.File;
//import java.math.BigDecimal;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TestAccountService {
//
//
//
//
//    @InjectMocks
//    private AccountsService accountsService;
//    @Mock
//    private Validation validation;
//
//    @Mock
//    private AccountsRepository accountsRepository;
//
//
//    @Mock
//    private EmailNotificationService emailNotificationService;
//
//    ObjectMapper objectMapper = new ObjectMapper();
////    private AccountsService accountsService = new AccountsService(accountsRepository,emailNotificationService);
//
//
//    @Before
//    public void setup() throws Exception {
//        MockitoAnnotations.initMocks(this);
//
////        accountsService = mock(EmployeeDAOImpl.class)
//    }
//
//    @Test
//    public void testDoFundTransfer() throws Exception {
//        // Arrange
//
//        String toAccountId = "23232";
//        String fromAccountId = "32232";
//        Double amount = 2323.00;
//
//        Account payeeAccount = new Account(fromAccountId, BigDecimal.valueOf(amount));
////        Account payeeAccount =objectMapper.readValue(new File("src/test/resources/account.json"), Account.class);
//
//        Account benefeciaryAccount = new Account(toAccountId, BigDecimal.valueOf(amount));
//        doNothing().when(validation).validateInputAmount(amount);
//        when(accountsRepository.getAccount(fromAccountId)).thenReturn(payeeAccount);
//        doNothing().when(accountsRepository).updateAccountBalance(payeeAccount,amount,false);
//        doNothing().when(emailNotificationService).notifyAboutTransfer(payeeAccount, "Deducted");
//
//        when(accountsRepository.getAccount(toAccountId)).thenReturn(benefeciaryAccount);
//        doNothing().when(accountsRepository).updateAccountBalance(benefeciaryAccount,amount,fa);
//        doNothing().when(emailNotificationService).notifyAboutTransfer(payeeAccount, "Recieved");
//
////Act
//        String messageActual = accountsService.doFundTransfer(toAccountId, fromAccountId, amount);
//        // Assert
//
//        String messageExpected = "success";
//        Assert.assertEquals(messageExpected, messageActual);
//
//    }
//
//    @Test
//    public void testDoFundTransferFails() throws Exception {
//        // Arrange
//
//        String toAccountId = "23232";
//        String fromAccountId = "32232";
//        Double amount = 00.00;
//        Account payeeAccount = new Account(fromAccountId, BigDecimal.valueOf(amount));
//        when(accountsRepository.getAccount(fromAccountId)).thenReturn(payeeAccount);
//
//
//        // Act
//        String messageActual = accountsService.doFundTransfer(toAccountId, fromAccountId, amount);
//
//        // Assert
//
//        String messageExpected = "insuffiecient balance to transfer";
//        Assert.assertEquals(messageExpected, messageActual);
//
//    }
//
//}

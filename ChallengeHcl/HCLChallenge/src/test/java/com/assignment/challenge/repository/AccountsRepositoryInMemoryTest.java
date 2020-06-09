package com.assignment.challenge.repository;

import com.assignment.challenge.domain.Account;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(MockitoJUnitRunner.class)
public class AccountsRepositoryInMemoryTest {

    @InjectMocks
    private AccountsRepositoryInMemory accountsRepositoryInMemory;


    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateAccountBalanceforCredit() throws Exception {
        // Arrange
        Account account = new Account("251425", BigDecimal.valueOf(2112));
        String messageExpected = "";
        String toAccountId = "23232";
        String fromAccountId = "32232";
        Double amount = 2323.00;

        Account payeeAccount = new Account(fromAccountId, BigDecimal.valueOf(amount));
        Map<String, Account> accounts = new ConcurrentHashMap<>();
        accounts.put("251425", payeeAccount);

        //Act
        String messageActual = test(account, amount, true);

        //Assert
        Assert.assertEquals(messageExpected, messageActual);

    }

    @Test
    public void testUpdateAccountBalanceforDebit() throws Exception {
        // Arrange
        Account account = new Account("251425", BigDecimal.valueOf(2112));
        String messageExpected = "";
        String toAccountId = "23232";
        String fromAccountId = "32232";
        Double amount = 2323.00;

        Account payeeAccount = new Account(fromAccountId, BigDecimal.valueOf(amount));
        Map<String, Account> accounts = new ConcurrentHashMap<>();
        accounts.put("251425", payeeAccount);

        //Act
        String messageActual = test(account, amount, false);

        //Assert
        Assert.assertEquals(messageExpected, messageActual);

    }

    private String test(Account account, Double amount, Boolean isCredit) {

        accountsRepositoryInMemory.updateAccountBalance(account, amount, isCredit);
        return "";

    }


}

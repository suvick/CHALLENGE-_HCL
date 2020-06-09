package com.assignment.challenge.repository;

import com.assignment.challenge.domain.Account;
import com.assignment.challenge.exception.DuplicateAccountIdException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccountsRepositoryInMemory implements AccountsRepository {

    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    @Override
    public void createAccount(Account account) throws DuplicateAccountIdException {
        Account previousAccount = accounts.putIfAbsent(account.getAccountId(), account);
        if (previousAccount != null) {
            throw new DuplicateAccountIdException(
                    "Account id " + account.getAccountId() + " already exists!");
        }
    }

    @Override
    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    @Override
    public void clearAccounts() {
        accounts.clear();
    }

    @Override
    public void updateAccountBalance(Account account, Double amount, Boolean isCredit) {

        BigDecimal balance = account.getBalance();
        //Added logic for adding or subtracting amount from account on the basis of a flag
        if (isCredit) {
            //Adding amount to the beneficiary account
            balance = balance.add((BigDecimal.valueOf(amount)));
        } else {
            //Subtracting amount from the payee account
            balance = balance.subtract(BigDecimal.valueOf(amount));
        }

        //setting the updated balance to the corresponding accounts
        account.setBalance(balance);
    }

}

package com.assignment.challenge.repository;

import com.assignment.challenge.domain.Account;
import com.assignment.challenge.exception.DuplicateAccountIdException;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface AccountsRepository {

  void createAccount(Account account) throws DuplicateAccountIdException;

  Account getAccount(String accountId);

  //Adding method for updating account balance after transfer
  void updateAccountBalance(Account account, Double amount , Boolean isCredit);

  void clearAccounts();
}

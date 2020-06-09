package com.assignment.challenge.service;

import com.assignment.challenge.domain.Account;
import com.assignment.challenge.repository.AccountsRepository;
import com.assignment.challenge.validation.Validation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountsService {

    @Getter
    private final AccountsRepository accountsRepository;

    @Autowired
    private final EmailNotificationService emailNotificationService;

    @Autowired
    private final Validation validation;

    public AccountsService(AccountsRepository accountsRepository, EmailNotificationService emailNotificationService, Validation validation) {
        this.accountsRepository = accountsRepository;
        this.emailNotificationService = emailNotificationService;
        this.validation = validation;
    }

    public void createAccount(Account account) {
        this.accountsRepository.createAccount(account);
    }

    public Account getAccount(String accountId) {
        return this.accountsRepository.getAccount(accountId);
    }

    public String doFundTransfer(String toAccountId, String fromAccountId, Double amount) {
        //Validating amount whether it is greater than zero or not
        validation.validateInputAmount(amount);
        //Getting account details for the payee account
        Account payeeAccount = this.accountsRepository.getAccount(fromAccountId);
        //Getting account details for beneficiaryAccount
        Account beneficiaryAccount = this.accountsRepository.getAccount(toAccountId);

        //Checking the payee's balance whether it is greater than the desired amount or not
        if (payeeAccount.getBalance().compareTo(BigDecimal.valueOf(amount)) > 0) {
            //Method for Updating Beneficiary account
            updateBeneficiaryAccount(beneficiaryAccount, amount);
            //Method for updating  payee account
            updatePayeeAccount(payeeAccount, amount);
            return "success";
        } else {
            return "insufficient balance to transfer";
        }

    }

    private void updatePayeeAccount(Account account, Double amount) {
        //Calling repository method for updating the payee account balance
        this.accountsRepository.updateAccountBalance(account, amount, false);
        //Sending the notification to the customer whose account is being deducted
        emailNotificationService.notifyAboutTransfer(account, "Amount has been deducted" + amount);

    }

    private void updateBeneficiaryAccount(Account account, Double amount) {
       //Calling repository method for updating the beneficiary account balance
        this.accountsRepository.updateAccountBalance(account, amount, true);
        //sending notification to the beneficiary account
        emailNotificationService.notifyAboutTransfer(account, "Amount has been sent" + amount);


    }
}

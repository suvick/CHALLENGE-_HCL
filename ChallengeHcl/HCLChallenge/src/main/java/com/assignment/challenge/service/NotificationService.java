package com.assignment.challenge.service;

import com.assignment.challenge.domain.Account;

public interface NotificationService {

  void notifyAboutTransfer(Account account, String transferDescription);
}

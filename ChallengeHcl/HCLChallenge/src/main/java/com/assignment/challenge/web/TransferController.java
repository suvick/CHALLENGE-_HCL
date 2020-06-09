package com.assignment.challenge.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.challenge.domain.FundTransferDetails;
import com.assignment.challenge.service.AccountsService;
@RestController
@RequestMapping("/v1/accounts/fundTransfer")
public class TransferController {
	@Autowired
	private final AccountsService accountsService;
	
	public TransferController(AccountsService accountsService) {
	    this.accountsService = accountsService;
	  }
	
	 @PatchMapping("consumes = MediaType.APPLICATION_JSON_VALUE")
	  public String doFundTransfer(@RequestBody FundTransferDetails fundTransferDetails) {
		 String fromAccountId =fundTransferDetails.getPayeeAccount().getAccountId();
		 String toAccountId = fundTransferDetails.getBeneficiaryAccount().getAccountId();
		 Double amount = fundTransferDetails.getAmount();
		  //Calling service class for business logic
		 return this.accountsService.doFundTransfer(fromAccountId,toAccountId,amount);
	  }
	
}

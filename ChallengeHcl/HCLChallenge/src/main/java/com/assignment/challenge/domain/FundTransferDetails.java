package com.assignment.challenge.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FundTransferDetails {
	
	private Account payeeAccount;
	private Account beneficiaryAccount;
	private Double amount;
	
	
	@JsonCreator
	  public FundTransferDetails(@JsonProperty("payeeAccount") Account payeeAccount,@JsonProperty("beneficiaryAccount") Account beneficiaryAccount,
	    @JsonProperty("amount") Double amount) {
	    this.payeeAccount = payeeAccount;
	    this.beneficiaryAccount = beneficiaryAccount;
	    this.amount=amount;
	  }




}

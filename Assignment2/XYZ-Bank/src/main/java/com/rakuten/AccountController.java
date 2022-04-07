package com.rakuten;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService service;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	int saveAccount(@RequestBody Account account) {
		System.out.println(account.getAccountHolderName());
		System.out.println(account.getAccountNumber());
		System.out.println(account.getAddress());
		System.out.println(account.getCity());
		System.out.println(account.getPin());
		System.out.println(account.getPhoneNumber());
		System.out.println(account.getBalanceAmount());
		System.out.println(account.getStatus());
		System.out.println(account.getType());
		System.out.println("\n");
		

		return service.saveAccount(account);
	}

	@GetMapping
	List<Account> getAccount() {
		return service.getAccounts();
	}
}

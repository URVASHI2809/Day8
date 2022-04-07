package com.rakuten;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	AccountRepository repository;
	
	int saveAccount(Account account) {
		repository.save(account);
		return account.getId();
	}
	
	List<Account> getAccounts() {
		return repository.findAll();
	}
}

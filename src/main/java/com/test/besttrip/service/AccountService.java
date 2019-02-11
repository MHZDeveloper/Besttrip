package com.test.besttrip.service;

import com.test.besttrip.model.Account;
import com.test.besttrip.model.repository.AccountRepository;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Iterable<Account> getAccounts(){
        return accountRepository.findAll();
    }
}

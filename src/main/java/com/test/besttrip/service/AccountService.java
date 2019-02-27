package com.test.besttrip.service;

import com.test.besttrip.model.Account;
import com.test.besttrip.model.AccountType;
import com.test.besttrip.model.Experience;
import com.test.besttrip.model.repository.AccountRepository;
import com.test.besttrip.service.exception.BadRequestException;
import com.test.besttrip.service.exception.ExistingLoginException;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Iterable<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccount(String login){
        return accountRepository.findByLogin(login);
    }

    public void createAccount(Account account){
        if(getAccount(account.getLogin()) == null){
            accountRepository.save(account);
        }
        else{
            throw new ExistingLoginException("Existing Login");
        }
    }


    public void updateAccount(String login, Account account) {
        if (login.equals(account.getLogin())) {
            accountRepository.save(account);
        }
        else {
            throw new BadRequestException("Bad Request");
        }
    }

    public void deleteAccount(String Login, Account account) {
        accountRepository.delete(account);
    }


}

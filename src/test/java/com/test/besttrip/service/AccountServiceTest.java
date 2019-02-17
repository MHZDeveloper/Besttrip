package com.test.besttrip.service;

import com.test.besttrip.model.Account;
import com.test.besttrip.model.AccountType;
import com.test.besttrip.model.Experience;
import com.test.besttrip.model.repository.AccountRepository;
import com.test.besttrip.service.exception.ExistingLoginException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class AccountServiceTest {

    AccountService accountService;
    AccountRepository accountRepository;

    @Before
    public void before(){
        accountRepository = Mockito.mock(AccountRepository.class);
        accountService = Mockito.mock(AccountService.class);
    }

    @Test
    public void should_return_all_accounts(){
        //given
        Account account = new Account("login","password", AccountType.USER);
        List<Account> accounts = Arrays.asList(account);
        Mockito.doReturn(accounts).when(accountRepository).findAll();

        //when
        List<Account> result = (List<Account>) accountRepository.findAll();

        //then
        Assert.assertEquals(1,result.size());
        Assert.assertEquals("login",result.get(0).getLogin());
    }


    

}
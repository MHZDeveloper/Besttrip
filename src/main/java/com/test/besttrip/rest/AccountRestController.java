package com.test.besttrip.rest;


import com.test.besttrip.model.Account;
import com.test.besttrip.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/accounts",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Account> getAccounts(){
        return accountService.getAccounts();
    }
}

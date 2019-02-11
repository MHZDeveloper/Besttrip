package com.test.besttrip.model.repository;

import com.test.besttrip.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,String> {

}
package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    public Account findOneById(String  id);
    public boolean existsById(String id);
}

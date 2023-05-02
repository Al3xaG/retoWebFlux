package com.retoWebFlux.nttData.repository;

import com.retoWebFlux.nttData.domain.entities.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account,Long> {
    //Account findByAccountNumber(String number);
}

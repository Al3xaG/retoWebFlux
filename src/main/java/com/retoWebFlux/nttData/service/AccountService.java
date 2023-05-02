package com.retoWebFlux.nttData.service;


import com.retoWebFlux.nttData.domain.dto.AccountDTO;
import com.retoWebFlux.nttData.domain.entities.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AccountService {
    Mono<AccountDTO> saveNewAccount(AccountDTO accountDTO);
    Flux<Account> getAll();
    Mono<AccountDTO> getAccount(String id);
    Mono<AccountDTO> updateAccount(AccountDTO accountDTO, String id);
    Mono<Void> deleteAccount(String id);
}

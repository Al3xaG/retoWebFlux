package com.retoWebFlux.nttData.service.impl;


import com.retoWebFlux.nttData.domain.dto.AccountDTO;
import com.retoWebFlux.nttData.domain.entities.Account;
import com.retoWebFlux.nttData.domain.entities.Client;
import com.retoWebFlux.nttData.repository.AccountRepository;
import com.retoWebFlux.nttData.service.AccountService;
import com.retoWebFlux.nttData.util.MapperAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    private final MapperAccount mapperAccount;

    @Override
    public Mono<AccountDTO> saveNewAccount(AccountDTO accountDTO) {
        Account a = mapperAccount.accountDtoToAccount(accountDTO);
        a.setAsNew();
        Mono<Account> account =  accountRepository.save(a);
        return account
                .map(mapperAccount::accountToAccountDto);
    }

    @Override
    public Flux<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Mono<AccountDTO> getAccount(String id) {
        return accountRepository.findById(Long.valueOf(id))
                .map(mapperAccount:: accountToAccountDto);
    }

    @Override
    public Mono<AccountDTO> updateAccount(AccountDTO accountDTO, String id) {
        return accountRepository.findById(Long.valueOf(id))
                .flatMap(client -> accountRepository.save(mapperAccount.accountDtoToAccount(accountDTO))
                        .map(mapperAccount::accountToAccountDto));
    }

    @Override
    public Mono<Void> deleteAccount(String id) {
        return accountRepository.findById(Long.valueOf(id))
                .flatMap(client -> accountRepository.deleteById(Long.valueOf(id)));
    }
}

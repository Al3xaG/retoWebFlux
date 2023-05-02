package com.retoWebFlux.nttData.controller;

import com.retoWebFlux.nttData.domain.dto.AccountDTO;
import com.retoWebFlux.nttData.domain.entities.Account;
import com.retoWebFlux.nttData.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public Mono<AccountDTO> saveNewAccount(@RequestBody AccountDTO accountDTO){
        return accountService.saveNewAccount(accountDTO);
    }
    @GetMapping
    public Flux<Account> getAll(){
        return accountService.getAll();
    }


    @GetMapping("/{id}")
    public Mono<AccountDTO> getAccount(@PathVariable String id){
        return accountService.getAccount(id);
    }
    @PutMapping("/{id}")
    public Mono<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO, @PathVariable String id){
        return accountService.updateAccount(accountDTO, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAccount(@PathVariable String id){
        return accountService.deleteAccount(id);
    }
}

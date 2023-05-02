package com.retoWebFlux.nttData.controller;


import com.retoWebFlux.nttData.domain.dto.TransactionDTO;
import com.retoWebFlux.nttData.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public Mono<TransactionDTO> saveNewClient(@RequestBody TransactionDTO transactionDTO){

        return transactionService.saveNewTransaction(transactionDTO);
    }

    @GetMapping("/{id}")
    public Mono<TransactionDTO> getClient(@PathVariable String id){

        return transactionService.getTransaction(id);
    }

    @PutMapping("/{id}")
    public Mono<TransactionDTO> updateClient(@RequestBody TransactionDTO transactionDTO, @PathVariable String id){
        return transactionService.updateTransaction(transactionDTO, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteClient(@PathVariable String id){
        return transactionService.deleteTransaction(id);
    }
}

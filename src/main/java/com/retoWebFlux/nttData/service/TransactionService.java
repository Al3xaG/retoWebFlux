package com.retoWebFlux.nttData.service;


import com.retoWebFlux.nttData.domain.dto.TransactionDTO;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<TransactionDTO> saveNewTransaction(TransactionDTO transactionDTO);

    Mono<TransactionDTO> getTransaction(String id);
    Mono<TransactionDTO> updateTransaction(TransactionDTO transactionDTO, String id);
    Mono<Void> deleteTransaction(String id);
}

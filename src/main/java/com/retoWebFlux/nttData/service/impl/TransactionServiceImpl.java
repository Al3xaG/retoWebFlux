package com.retoWebFlux.nttData.service.impl;

import com.retoWebFlux.nttData.domain.dto.TransactionDTO;
import com.retoWebFlux.nttData.domain.entities.Account;
import com.retoWebFlux.nttData.domain.entities.Transaction;
import com.retoWebFlux.nttData.exceptions.NotFoundException;
import com.retoWebFlux.nttData.repository.AccountRepository;
import com.retoWebFlux.nttData.repository.TransactionRepository;
import com.retoWebFlux.nttData.service.TransactionService;
import com.retoWebFlux.nttData.util.MapperAccount;
import com.retoWebFlux.nttData.util.MapperTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final MapperTransaction mapperTransaction;

    @Override
    public Mono<TransactionDTO> saveNewTransaction(TransactionDTO transactionDTO) {
        Date date = new Date();
        transactionDTO.setDate(date);
        Transaction t = mapperTransaction.transactionDtoToTransaction(transactionDTO);
        t.setAsNew();
        Mono<Transaction> transaction =  transactionRepository.save(t);
        return transaction
                .map(mapperTransaction::transactionToTransactionDto);
    }

    @Override
    public Mono<TransactionDTO> getTransaction(String id) {
        return transactionRepository.findById(Long.valueOf(id))
                .map(mapperTransaction:: transactionToTransactionDto)
                .switchIfEmpty(Mono.error(new NotFoundException("Transacción no existe")));
    }

    @Override
    public Mono<TransactionDTO> updateTransaction(TransactionDTO transactionDTO, String id) {

        return transactionRepository.findById(Long.valueOf(id))
                .map(mapperTransaction::transactionToTransactionDto)
                .switchIfEmpty(Mono.error(new NotFoundException("Transacción no existe")))
                .flatMap(client -> transactionRepository.save(mapperTransaction.transactionDtoToTransaction(transactionDTO))
                        .map(mapperTransaction::transactionToTransactionDto));
    }

    @Override
    public Mono<Void> deleteTransaction(String id) {
        return transactionRepository.findById(Long.valueOf(id))
                .map(mapperTransaction::transactionToTransactionDto)
                .switchIfEmpty(Mono.error(new NotFoundException("Transacción no existe")))
                .flatMap(client -> transactionRepository.deleteById(Long.valueOf(id)));
    }
}

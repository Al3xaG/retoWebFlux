package com.retoWebFlux.nttData.util;


import com.retoWebFlux.nttData.domain.dto.AccountDTO;
import com.retoWebFlux.nttData.domain.dto.TransactionDTO;
import com.retoWebFlux.nttData.domain.entities.Account;
import com.retoWebFlux.nttData.domain.entities.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperTransaction {
    Transaction transactionDtoToTransaction(TransactionDTO transactionDTO);
    TransactionDTO transactionToTransactionDto(Transaction transaction);
}

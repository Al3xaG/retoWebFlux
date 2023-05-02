package com.retoWebFlux.nttData.domain.dto;

import com.retoWebFlux.nttData.domain.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionDTO {
    private Long id;
    private Long accountId;
    private AccountDTO accountDTO;
    private Date date;
    private String transactionType;
    private long amount;
    private long balance;
}

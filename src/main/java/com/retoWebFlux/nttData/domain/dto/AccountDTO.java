package com.retoWebFlux.nttData.domain.dto;


import com.retoWebFlux.nttData.domain.enums.AccountType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private String accountType;
    private Long initialBalance;
    private Boolean status;
    private Long clientId;
    private ClientDTO client;
    private List<TransactionDTO> transactions;
}

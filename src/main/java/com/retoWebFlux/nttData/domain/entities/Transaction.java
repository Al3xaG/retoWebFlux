package com.retoWebFlux.nttData.domain.entities;


import com.retoWebFlux.nttData.domain.enums.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table("transactions")
public class Transaction implements Persistable<Long> {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ManyToOne
    //@JoinColumn(name = "account_id")
    private Long accountId;

    //private Account account;
    private LocalDateTime date;
    private String transactionType;
    private Double amount;
    private Double balance;

    @Transient
    private boolean newTransaction;

    @Override
    public boolean isNew()
    {
        return this.newTransaction || id == null;
    }

    public Transaction setAsNew()
    {
        this.newTransaction = true;
        return this;
    }

}

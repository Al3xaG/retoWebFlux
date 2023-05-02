package com.retoWebFlux.nttData.domain.entities;

import com.retoWebFlux.nttData.domain.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("accounts")
public class Account implements Persistable<Long> {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String accountType;
    private Double initialBalance;
    private Boolean status;
    //duda la relacion
   // @ManyToOne
   // @JoinColumn(name = "client_id")

    private Long clientId;

    //private Client client;

    //@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    //private List<Transaction> transactions;

    @Transient
    private boolean newAccount;

    @Override
    public boolean isNew()
    {
        return this.newAccount || id == null;
    }

    public Account setAsNew()
    {
        this.newAccount = true;
        return this;
    }
}

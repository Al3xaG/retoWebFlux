package com.retoWebFlux.nttData.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("clients")
public class Client extends Person implements Persistable<Long> {
    @Id
    @Column("client_id")
    private Long clientId;
    private String password;
    private Boolean status;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    //private List<Account> accounts;

    @Transient
    private boolean newClient;


    @Override
    public Long getId() {
        return this.clientId;
    }

    @Override
    public boolean isNew()
    {
        return this.newClient || clientId == null;
    }

    public Client setAsNew()
    {
        this.newClient = true;
        return this;
    }
}

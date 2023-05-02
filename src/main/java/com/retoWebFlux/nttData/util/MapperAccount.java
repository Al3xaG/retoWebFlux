package com.retoWebFlux.nttData.util;

import com.retoWebFlux.nttData.domain.dto.AccountDTO;
import com.retoWebFlux.nttData.domain.dto.ClientDTO;
import com.retoWebFlux.nttData.domain.entities.Account;
import com.retoWebFlux.nttData.domain.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MapperClient.class)
public interface MapperAccount {

    @Mapping(target = "clientId", source = "clientId")
    Account accountDtoToAccount(AccountDTO accountDTO);
    AccountDTO accountToAccountDto(Account account);

}

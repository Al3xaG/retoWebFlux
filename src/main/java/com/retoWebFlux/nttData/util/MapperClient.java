package com.retoWebFlux.nttData.util;

import com.retoWebFlux.nttData.domain.dto.ClientDTO;
import com.retoWebFlux.nttData.domain.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperClient {

    @Named("clientDtoToClient")
    Client clientDtoToClient(ClientDTO clientDTO);

    ClientDTO clientToClientDto(Client client);

    Client map(ClientDTO clientDTO);
}

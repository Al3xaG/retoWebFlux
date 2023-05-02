package com.retoWebFlux.nttData.service;


import com.retoWebFlux.nttData.domain.dto.ClientDTO;
import com.retoWebFlux.nttData.domain.entities.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Mono<ClientDTO> saveNewClient(ClientDTO clientDTO);

    Mono<ClientDTO> getClient(String id);
    Flux<Client> getAllClient();
    Mono<ClientDTO> updateClient(ClientDTO clientDTO, String id);
    Mono<Void> deleteClient(String id);
}

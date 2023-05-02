package com.retoWebFlux.nttData.service.impl;

import com.retoWebFlux.nttData.domain.dto.ClientDTO;
import com.retoWebFlux.nttData.domain.entities.Client;
import com.retoWebFlux.nttData.repository.ClientRepository;
import com.retoWebFlux.nttData.service.ClientService;
import com.retoWebFlux.nttData.util.MapperClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final MapperClient mapperClient;

    @Override
    public Mono<ClientDTO> saveNewClient(ClientDTO clientDTO) {
        Client c = mapperClient.clientDtoToClient(clientDTO);
        c.setAsNew();
        Mono<Client> client =  clientRepository.save(c);
        return client
                .map(mapperClient::clientToClientDto);
    }

    @Override
    public Mono<ClientDTO> getClient(String id) {
        return clientRepository.findByClientId(Long.valueOf(id))
                .map(mapperClient:: clientToClientDto);
    }

    @Override
    public Flux<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<ClientDTO> updateClient(ClientDTO clientDTO, String id) {
        return clientRepository.findByClientId(Long.valueOf(id))
                .flatMap(client -> clientRepository.save(mapperClient.clientDtoToClient(clientDTO))
                        .map(mapperClient::clientToClientDto));
    }

    @Override
    public Mono<Void> deleteClient(String id) {
        return clientRepository.findByClientId(Long.valueOf(id))
                .flatMap(client -> clientRepository.deleteById(Long.valueOf(id)));
    }
}

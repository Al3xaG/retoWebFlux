package com.retoWebFlux.nttData.repository;

import com.retoWebFlux.nttData.domain.entities.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends ReactiveCrudRepository<Client,Long> {
    Mono<Client> findByClientId(Long clientId);
}

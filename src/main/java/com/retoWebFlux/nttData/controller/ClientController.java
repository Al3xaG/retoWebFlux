package com.retoWebFlux.nttData.controller;

import com.retoWebFlux.nttData.domain.dto.ClientDTO;
import com.retoWebFlux.nttData.domain.entities.Client;
import com.retoWebFlux.nttData.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Mono<ClientDTO> saveNewClient(@RequestBody ClientDTO clientDTO){
        return clientService.saveNewClient(clientDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ClientDTO>> getClient(@PathVariable String id){
        return ResponseEntity.ok(clientService.getClient(id));
    }

    @GetMapping
    public Flux<Client> getAllClient(){
        return clientService.getAllClient();
    }

    @PutMapping("/{id}")
    public Mono<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO, @PathVariable String id){
        return clientService.updateClient(clientDTO, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteClient(@PathVariable String id){
        return clientService.deleteClient(id);
    }

}

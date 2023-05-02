package com.retoWebFlux.nttData.responses;


import com.retoWebFlux.nttData.domain.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ClientResponse {
    private String message;
    private Boolean statusOK;
    private Optional<ClientDTO> client;
}

package com.retoWebFlux.nttData.domain.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDTO {
    private Long clientId;
    private String name;
    private String gender;
    private Integer age;
    //private String identification;
    private String address;
    //private String phone;
    private String password;
    private boolean status;
    //private List<AccountDTO> accounts;
}

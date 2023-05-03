package com.retoWebFlux.nttData.domain.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportDTO {

    private LocalDateTime date;
    private String client;
    private String numberAccount;
    private String typeAccount;
    private Double initialBalance;
    private Boolean status;
    private Double amount;
    private Double availableBalance;
}

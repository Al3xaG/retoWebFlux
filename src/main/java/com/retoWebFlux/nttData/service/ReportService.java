package com.retoWebFlux.nttData.service;

import com.retoWebFlux.nttData.domain.dto.ReportDTO;
import com.retoWebFlux.nttData.domain.dto.TransactionDTO;
import com.retoWebFlux.nttData.domain.entities.Transaction;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReportService {
    Flux<TransactionDTO> getReportByDateAndClient(Date initDate, Date endDate, String clientId);
}

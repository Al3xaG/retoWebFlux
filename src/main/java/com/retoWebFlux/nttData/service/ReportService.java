package com.retoWebFlux.nttData.service;

import com.retoWebFlux.nttData.domain.dto.ReportDTO;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.List;

public interface ReportService {
    Flux<ReportDTO> getReportByDateAndClient(Date initDate, Date endDate, String clientId);
}

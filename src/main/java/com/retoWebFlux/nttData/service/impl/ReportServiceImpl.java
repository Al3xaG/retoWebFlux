package com.retoWebFlux.nttData.service.impl;

import com.retoWebFlux.nttData.domain.dto.ReportDTO;
import com.retoWebFlux.nttData.repository.TransactionRepository;
import com.retoWebFlux.nttData.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final TransactionRepository transactionRepository;

    @Override
    public Flux<ReportDTO> getReportByDateAndClient(Date initDate, Date endDate, String clientId) {
        Flux<Object[]> objects = transactionRepository.findAllTransactionByDate(initDate, endDate, Long.valueOf(clientId));
        Flux<ReportDTO> reports= objects.map(object -> {
            return new ReportDTO((Date)object[0],(String) object[1],(String) object[2],(String) object[3],(Double) object[5] - (Double) object[6],(Boolean) object[4],(Double) object[6],(Double) object[5]);
        });
        return reports;
    }

}
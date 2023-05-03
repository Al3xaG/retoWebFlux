package com.retoWebFlux.nttData.service.impl;

import com.retoWebFlux.nttData.domain.dto.ReportDTO;
import com.retoWebFlux.nttData.domain.dto.TransactionDTO;
import com.retoWebFlux.nttData.domain.entities.Transaction;
import com.retoWebFlux.nttData.repository.TransactionRepository;
import com.retoWebFlux.nttData.service.ReportService;
import com.retoWebFlux.nttData.util.MapperTransaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final TransactionRepository transactionRepository;
    private final MapperTransaction mapperTransaction;

    @Override
        public Flux<TransactionDTO> getReportByDateAndClient(Date initDate, Date endDate, String clientId) {
        Flux<Transaction> objects = transactionRepository.findAllTransactionByDate(initDate, endDate, Long.valueOf(clientId));
        //log.info(String.valueOf(objects));
        /*List<Object[]> list = new ArrayList<>();
        objects.collectList().subscribe(list::addAll);
        list.forEach(objects1 -> {
            log.info("data:", objects1[0]);
        });*/
        //Flux<ReportDTO> reports= objects.map(object -> new ReportDTO((LocalDateTime) object[0],(String) object[1],(String) object[2],(String) object[3],(Double) object[5] - (Double) object[6],(Boolean) object[4],(Double) object[6],(Double) object[5]));
        return objects.map(transaction -> mapperTransaction.transactionToTransactionDto(transaction));
    }

}
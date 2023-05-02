package com.retoWebFlux.nttData.controller;


import com.retoWebFlux.nttData.domain.dto.ReportDTO;
import com.retoWebFlux.nttData.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reportes")
public class ReportController {
    private final ReportService reportService;
    @GetMapping
    public Flux<ReportDTO> getReportByClient(@RequestParam("initDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date initDate,
                                             @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate,
                                             @RequestParam String clientId){
        return reportService.getReportByDateAndClient(initDate, endDate, clientId);
    }
}

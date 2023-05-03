package com.retoWebFlux.nttData.repository;

import com.retoWebFlux.nttData.domain.entities.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Repository
public interface TransactionRepository extends ReactiveCrudRepository<Transaction,Long> {

 /*   @Query(value = "SELECT T.DATE, C.NAME, AC.ACCOUNT_NUMBER, AC.ACCOUNT_TYPE, AC.STATUS, T.BALANCE, " +
            " T.AMOUNT * CASE WHEN T.TRANSACTION_TYPE = 'DEBIT' THEN -1 ELSE 1 END AS AMOUNT" +
            " FROM TRANSACTIONS T " +
            " INNER JOIN ACCOUNTS AC ON T.ACCOUNT_ID = AC.ID " +
            " INNER JOIN CLIENTS C ON C.CLIENT_ID = AC.CLIENT_ID " +
            " WHERE T.DATE BETWEEN :initDate AND :endDate " +
            " AND C.CLIENT_ID = :clientId ")
    Flux<Object[]> findAllTransactionByDate(@Param("initDate") Date initDate, @Param("endDate") Date endDate, @Param("clientId") Long clientId);*/

    @Query(value = "SELECT *" +
            " FROM TRANSACTIONS T " +
            " INNER JOIN ACCOUNTS AC ON T.ACCOUNT_ID = AC.ID " +
            " INNER JOIN CLIENTS C ON C.CLIENT_ID = AC.CLIENT_ID " +
            " WHERE T.DATE BETWEEN :initDate AND :endDate " +
            " AND C.CLIENT_ID = :clientId ")
    Flux<Transaction> findAllTransactionByDate(@Param("initDate") Date initDate, @Param("endDate") Date endDate, @Param("clientId") Long clientId);
}

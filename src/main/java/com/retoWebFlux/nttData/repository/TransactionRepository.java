package com.retoWebFlux.nttData.repository;

import com.retoWebFlux.nttData.domain.entities.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveCrudRepository<Transaction,Long> {
}

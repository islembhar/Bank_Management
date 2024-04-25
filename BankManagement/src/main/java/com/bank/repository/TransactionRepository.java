package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

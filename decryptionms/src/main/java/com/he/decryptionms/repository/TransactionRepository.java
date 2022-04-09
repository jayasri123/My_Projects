package com.he.decryptionms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.he.decryptionms.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}

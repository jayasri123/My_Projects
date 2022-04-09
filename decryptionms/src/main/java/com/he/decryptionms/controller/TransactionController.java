package com.he.decryptionms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.he.decryptionms.entity.Transaction;
import org.springframework.web.bind.annotation.RestController;

import com.he.decryptionms.service.TransactionService;

@RestController
@RequestMapping("transaction")
@CrossOrigin
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
		Transaction transactionResponse = transactionService.addTransaction(transaction);
		if(transactionResponse != null) {
			return new ResponseEntity<Transaction>(transactionResponse, HttpStatus.CREATED);
		}
		return new ResponseEntity<Transaction>(transactionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

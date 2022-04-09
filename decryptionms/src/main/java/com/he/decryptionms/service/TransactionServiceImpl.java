package com.he.decryptionms.service;

import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.he.decryptionms.entity.Transaction;
import com.he.decryptionms.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;
	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepo.saveAndFlush(decryptTransaction(transaction));
	}
	
	private static Transaction decryptTransaction(Transaction transaction) {
		Transaction decryptedTransaction = new Transaction();
		Decoder decoder = Base64.getDecoder();
		byte[] decodedBytes = decoder.decode(transaction.getAccountNumber());
		decryptedTransaction.setAccountNumber(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getType());
		decryptedTransaction.setType(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getAmount());
		decryptedTransaction.setAmount(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getCurrency());
		decryptedTransaction.setCurrency(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getAccountFrom());
		decryptedTransaction.setAccountFrom(new String(decodedBytes));
		return decryptedTransaction;
	}

}

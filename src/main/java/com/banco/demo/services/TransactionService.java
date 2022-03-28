package com.banco.demo.services;

import java.util.ArrayList;
import java.util.Calendar;


import com.banco.demo.models.AccountModel;
import com.banco.demo.models.TransactionModel;
import com.banco.demo.repositories.AccountRepository;
import com.banco.demo.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountRepository accountRepository;

    public ArrayList<TransactionModel> getTransactions(){
        return (ArrayList<TransactionModel>) transactionRepository.findAll();
    }
    

    public String saveTransaction(TransactionModel transaction,Long id){
        Double balance;
        Double balanceTrx=0.0;
        ArrayList<TransactionModel> trx;
        AccountModel account;

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        account=accountRepository.findBy_accountNumber(id);
        
        transaction.set_balance(account.get_initialBalance());
        if (transaction.get_transactionType().equals("Debito"))  {
            if(transaction.get_value()> 1000.0 ){
                return "Cupo diario Excedido";
            }
           
            trx = transactionRepository.findBy_date(date);

            for (TransactionModel t : trx) {
                balanceTrx += t.get_balance();
            }
            if(balanceTrx>1000.0){
                return "Cupo diario Excedido";
            }

            if(transaction.get_balance() == 0.0 ||transaction.get_balance()<transaction.get_value()){
                return "Saldo no disponible";
            }

           
            transaction.setAccount(account);
            transaction.set_date(date);
            balance = transaction.get_balance()-transaction.get_value();
            transaction.set_balance(balance);
            transactionRepository.save(transaction);
            account.set_initialBalance(balance);
            accountRepository.save(account);
        } 
        if (transaction.get_transactionType().equals("Credito"))  {
            transaction.set_date(date);
            balance = transaction.get_balance()+transaction.get_value();
            transaction.set_balance(balance);
            transaction.setAccount(account);
            account.set_initialBalance(balance);
            transactionRepository.save(transaction);
            accountRepository.save(account);
        }

        return "";
    }
}

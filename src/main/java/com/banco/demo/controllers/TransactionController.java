package com.banco.demo.controllers;

import java.util.ArrayList;

import com.banco.demo.models.TransactionModel;
import com.banco.demo.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimientos")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public ArrayList<TransactionModel> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping("/{id}")
    public String savetransaction(@RequestBody TransactionModel transaction,@PathVariable("id") Long id) {
        String ok = this.transactionService.saveTransaction(transaction,id);
        if (ok == "") {
            return "Transaccion exitosa";
        } else {
            return ok;
        }
    }
}

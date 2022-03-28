package com.banco.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.banco.demo.models.AccountModel;
import com.banco.demo.models.ClientModel;
import com.banco.demo.repositories.AccountRepository;
import com.banco.demo.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;

    public ArrayList<AccountModel> getAccounts() throws Exception {
        try {
            return (ArrayList<AccountModel>) accountRepository.findAll();
        } catch (Exception err) {
            throw new Exception(err.getMessage());
        }
    }

    public AccountModel saveAccount(AccountModel account) throws Exception {

        try {
            Optional<ClientModel> op = clientRepository.findById(account.get_clientId());
            if (op.isPresent()) {
                account.setClient(op.get());
            }

            return accountRepository.save(account);
        } catch (Exception err) {
            throw new Exception(err.getMessage());
        }
    }

    public boolean deleteAccount(Long id) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}

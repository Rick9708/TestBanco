package com.banco.demo.controllers;

import java.util.ArrayList;

import com.banco.demo.models.AccountModel;
import com.banco.demo.services.AccountService;
import com.banco.demo.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    ClientService clientService;

    @GetMapping()
    public ArrayList<AccountModel> getAccounts() throws Exception{
        return accountService.getAccounts();
    }

    @PostMapping()
    public AccountModel saveAccount(@RequestBody AccountModel account) throws Exception{
        return this.accountService.saveAccount(account);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteByID(@PathVariable("id") Long id){
        boolean ok = this.accountService.deleteAccount(id);
        if(ok){
            return "Se elimino el usuario con id: "+ id;
        }else{
            return "No se elimino el usuario con id: "+ id;
        }
    }
}

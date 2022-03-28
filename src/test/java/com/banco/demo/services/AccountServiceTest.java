package com.banco.demo.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.banco.demo.models.AccountModel;
import com.banco.demo.repositories.AccountRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AccountServiceTest {
    
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Iterable<AccountModel> acc;


    private long accountNumber = 55;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);        
        AccountModel acc = new AccountModel();

        acc.set_accountNumber(new Long(12222));
        acc.set_accountType("Ahorros");
        acc.set_initialBalance(1000.0);
        acc.set_state("True");
        acc.set_id(new Long(12222));
        
    }


    @Test
    void findBy_accountNumberHappyPath() throws Exception{
        when(accountRepository.findBy_accountNumber(accountNumber)).thenReturn((AccountModel) acc);

        assertNotNull((ArrayList<AccountModel>)accountService.getAccounts());
    }
}

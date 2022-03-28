package com.banco.demo.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import com.banco.demo.models.AccountModel;
import com.banco.demo.models.ClientModel;
import com.banco.demo.repositories.ClientRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Optional<ClientModel> cl ;
    

    

    private long accountNumber = 55;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);        
    
        ClientModel cl = new ClientModel();

        cl.set_id(new Long(12222));
        cl.set_age(21);
        cl.set_name("test");
        cl.set_password("123");
        cl.set_state("true");
        
    }


    @Test
    void findByIdHappyPath() throws Exception{
        when(clientRepository.findById(accountNumber)).thenReturn(cl);

        assertNotNull(clientService.getClients());
    }

}

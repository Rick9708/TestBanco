package com.banco.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.banco.demo.models.ClientModel;
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
@RequestMapping("/api/clientes")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping()
    public ArrayList<ClientModel> getClients() throws Exception{
        return clientService.getClients();
    }

    @PostMapping()
    public ClientModel saveClient(@RequestBody ClientModel client) throws Exception{
        return this.clientService.saveClient(client);
    }

    @GetMapping(path = "/{id}")
    public Optional<ClientModel> getClientByID(@PathVariable("id") Long id) throws Exception{
        return this.clientService.getClientByID(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteByID(@PathVariable("id") Long id){
        boolean ok = this.clientService.deleteClient(id);
        if(ok){
            return "Se elimino la cuenta con id: "+ id;
        }else{
            return "No se elimino la cuenta  con id: "+ id;
        }
    }
}

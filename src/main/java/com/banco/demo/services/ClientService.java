package com.banco.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.banco.demo.models.ClientModel;
import com.banco.demo.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ArrayList<ClientModel> getClients() throws Exception {
        try {
            return (ArrayList<ClientModel>) clientRepository.findAll();
        } catch (Exception err) {
            throw new Exception(err.getMessage());
        }

    }

    public ClientModel saveClient(ClientModel client) throws Exception {
        try {
            return clientRepository.save(client);
        } catch (Exception err) {
            throw new Exception(err.getMessage());
        }
    }

    public Optional<ClientModel> getClientByID(Long id) throws Exception {
        try {
            return clientRepository.findById(id);
        } catch (Exception err) {
            throw new Exception(err.getMessage());
        }
    }

    public boolean deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}

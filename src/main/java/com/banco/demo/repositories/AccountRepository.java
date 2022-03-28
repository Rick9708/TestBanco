package com.banco.demo.repositories;

import com.banco.demo.models.AccountModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountModel, Long>{
    public abstract AccountModel findBy_accountNumber(Long accountNumber);
}

package com.banco.demo.repositories;

import java.sql.Date;
import java.util.ArrayList;

import com.banco.demo.models.TransactionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionModel, Long>{
    public abstract ArrayList<TransactionModel> findBy_date(Date date);
    public abstract ArrayList<TransactionModel> findBy_dateBetween(Date dateStart,Date dateEnd);
}